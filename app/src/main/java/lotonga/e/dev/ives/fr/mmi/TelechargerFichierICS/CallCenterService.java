package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.text.Html;
import android.util.Log;

import org.doubango.imsdroid.Screens.ScreenWidgets;
import org.doubango.imsdroid.Utils.AppConfigurationSingleton;
import org.doubango.imsdroid.Utils.IAsyncResponseJSON;
import org.doubango.imsdroid.Utils.RenewHashTemp;
import org.doubango.imsdroid.Utils.RequestIdentifier;
import org.doubango.imsdroid.Utils.TaskHttpConnection;
import org.doubango.ngn.services.INgnConfigurationService;
import org.doubango.ngn.utils.NgnConfigurationEntry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import fr.ives.djanah.Engine;

/**
 * Created by bfortoul on 08/04/16.
 */
public class CallCenterService extends Service implements IAsyncResponseJSON {

    private static String TAG = CallCenterService.class.getCanonicalName();
    private Timer mTimer;
    private TimerTask mTimerTask;
    private RequestIdentifier mRequestIdentifierCallCenter;
    private TaskHttpConnection getCallCenterAvailabilityHttpConnection;     // AsyncTask to get Call Center availability.
    private TaskHttpConnection getCallCenterOpeningHoursHttpConnection;     // AsyncTask to get Call Center opening hours.
    private boolean openingHoursRequestTerminated = false;
    private static int CALL_CENTER_REQUEST_SCHEDULE = 5000;                 // (= 5s) Time between 2 requests to get Call Center availability
    private RenewHashTemp mRenewHashTemp;                                   // AsyncTask to retrieve new HashTemp to identify user.
    private final Handler mHandler = new Handler();
    private final INgnConfigurationService mConfigurationService = Engine.getInstance().getConfigurationService();
    private int processFinishErrorHashTempCount = 0;
    private static int MAX_ERROR_HASHTEMP_RETRY = 5;
    private Boolean isCallCenterOpen = false;
    private int callCenterStatus = 0; //callCenterStatus = 0 => RED / callCenterStatus = 1 => ORANGE / callCenterStatus = 2 => GREEN
    ScreenWidgets mWidget;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.d(TAG, "onStartCommand");
        processFinishErrorHashTempCount = 0;
        mWidget = ScreenWidgets.getInstance();
        startBackgroundPerform();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (mTimer != null) {
            mTimer.cancel();
        }
        super.onDestroy();
    }

    // Use an AsyncTask to get Call Center availability :
    // Scheduled every 'CALL_CENTER_REQUEST_SCHEDULE' milliseconds
    public void startBackgroundPerform()
    {
        Log.d(TAG, "startBackgroundPerform");
        if (mTimer != null)
        {
            mTimer.cancel();
        }

        mTimer = new Timer();

        mTimerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            // Call Center Availability :
                            mRequestIdentifierCallCenter =  new RequestIdentifier(RequestIdentifier.RequestType.GET_CALL_CENTER);
                            String hashTemp = mConfigurationService.getString(NgnConfigurationEntry.IVES_HASHTEMP, "");

                            StringBuilder urlCallCenterRequest = new StringBuilder(((Engine)Engine.getInstance()).getScreenService().getWebViewHome());
                            urlCallCenterRequest.append("&page=ajax/callCenterAvailability.php");
                            String appendice = String.format("?hashTemp=%s", hashTemp);
                            String mStringUrl = URLEncoder.encode(appendice, "UTF-8");
                            urlCallCenterRequest.append(mStringUrl);

                            /*
                            StringBuilder urlCallCenterRequest = new StringBuilder("http://cavuser.dev.ives.fr/");
                            urlCallCenterRequest.append("/ajax/callCenterAvailability.php?hashTemp="+hashTemp);
                            */
                            //StringBuilder urlCallCenterRequest = new StringBuilder("http://cavuser.dev.ives.fr/ajax/callCenterAvailability.php?hashTemp=bd656736b370ad5f3fc01f0303db3000d12860f8");

                            URI mSourceUri = new URI(urlCallCenterRequest.toString());

                            getCallCenterAvailabilityHttpConnection = new TaskHttpConnection(mSourceUri, mRequestIdentifierCallCenter);
                            getCallCenterAvailabilityHttpConnection.delegate = CallCenterService.this;
                            getCallCenterAvailabilityHttpConnection.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

                            // Horaires Call Center :
                            if (AppConfigurationSingleton.getInstance().getCallCenterOpeningHours())
                            {
                                // On effectue la requete qu'une seule fois, tant que le booleen est false :
                                if (!openingHoursRequestTerminated)
                                {
                                    RequestIdentifier requestIdentifierCallCenterOpeningHours =  new RequestIdentifier(RequestIdentifier.RequestType.GET_CALL_CENTER_OPENING_HOURS);
                                    StringBuilder urlCallCenterOpeningHoursRequest = new StringBuilder(((Engine)Engine.getInstance()).getScreenService().getWebViewHome());

                                    // On recupere la competence de l'utilisateur en Shared Preferences :
                                    String competenceUser = mConfigurationService.getString(NgnConfigurationEntry.IVES_DJANAH_COMMUNICATION_MODE, NgnConfigurationEntry.DEFAULT_IVES_DJANAH_COMMUNICATION_MODE);
                                    //Log.d(TAG, "competenceUser: "+competenceUser);

                                    if (competenceUser.length() > 0)
                                    {
                                        urlCallCenterOpeningHoursRequest.append("&page=ajaxService/horaires.php");
                                        String appendiceOpeningHours = String.format("?hashTemp=%s&usercomp=%s", hashTemp, competenceUser);

                                        String mStringUrlOpeningHours = URLEncoder.encode(appendiceOpeningHours, "UTF-8");
                                        urlCallCenterOpeningHoursRequest.append(mStringUrlOpeningHours);

                                        URI mSourceUriOpeningHours = new URI(urlCallCenterOpeningHoursRequest.toString());
                                        getCallCenterOpeningHoursHttpConnection = new TaskHttpConnection(mSourceUriOpeningHours, requestIdentifierCallCenterOpeningHours);
                                        getCallCenterOpeningHoursHttpConnection.delegate = CallCenterService.this;
                                        getCallCenterOpeningHoursHttpConnection.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                                    }
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            Log.e(TAG, "Exception : "+e);
                        }
                    }
                });
            }
        };
        mTimer.scheduleAtFixedRate(mTimerTask, 0, CALL_CENTER_REQUEST_SCHEDULE);
    }

    @Override
    public void processFinishJSON(JSONArray output) {
        Log.d(TAG, "processFinishJSON output: " + output);
    }

    @Override
    public void processFinishJSON(JSONArray output, RequestIdentifier requestIdentifier)
    {
        try
        {
            if (output != null)
            {
                switch (requestIdentifier.getRequestType())
                {
                    case GET_CALL_CENTER:
                        // Call Center Availability :
                        callCenterStatus = 0; // RED
                        isCallCenterOpen = false;
                        int waiting_users_count = 0;
                        int available_agents_count = 0;

                        JSONObject obj = output.getJSONObject(0);
                        ArrayList<String> listQueues = new ArrayList<String>();
                        //Log.d(TAG, "object json: " + obj.toString());

                        Iterator<String> iter = obj.keys();
                        while (iter.hasNext())
                        {
                            String key = iter.next();
                            //Log.d(TAG, "key: " + key);

                            Object currentObj = obj.get(key);
                            //Log.d(TAG, "currentObj: " + currentObj);

                            // Si on recoit une reponse {"ASL":"CLOSED"}, currentObj est une instance de String et pas JSONObject,
                            // donc la condition ci-dessous n'est pas remplie.
                            if (currentObj instanceof JSONObject)
                            {
                                isCallCenterOpen = true;
                                JSONObject value = (JSONObject) obj.get(key);
                                //Log.d(TAG, "value: " + value);

                                Iterator<String> iter2 = value.keys();
                                while (iter2.hasNext())
                                {
                                    String key2 = iter2.next();
                                    JSONObject value2 = (JSONObject) value.get(key2);
                                    //Log.d(TAG, "key2: " + key2);
                                    //Log.d(TAG, "value2: " + value2);

                                    if (!listQueues.contains(key2))
                                    {
                                        listQueues.add(key2);
                                        if (value2.getString("availableagentcount") != null)
                                        {
                                            //Log.d(TAG, "availableagentcount: " + value2.getString("availableagentcount"));
                                            available_agents_count = available_agents_count + Integer.valueOf(value2.getString("availableagentcount"));
                                        }
                                        if (value2.getString("waitingusers") != null)
                                        {
                                            //Log.d(TAG, "waitingusers: " + value2.getString("waitingusers"));
                                            waiting_users_count = waiting_users_count + Integer.valueOf(value2.getString("waitingusers"));
                                        }
                                    }
                                }
                            }
                        }

                        if (isCallCenterOpen)
                        {
                            if (available_agents_count > 0)
                            {
                                callCenterStatus = 2; // GREEN
                            }
                            else
                            {
                                callCenterStatus = 1; // ORANGE
                            }
                        }
                        setCallCenterAvailability(callCenterStatus, waiting_users_count);

                        if (AppConfigurationSingleton.getInstance().getCallCenterOpeningHours())
                        {
                            // Mettre a jour l'affichage de la PopupWindow dans ScreenWidgets :
                            ScreenWidgets.getInstance().displayCallCenterStatus();
                            ScreenWidgets.getInstance().displayCallCenterAwaitingUsers();
                        }
                        break;
                    case GET_CALL_CENTER_OPENING_HOURS:
                        // Call Center opening hours :
                        if (output.length() > 0)
                        {
                            //Log.d(TAG, "Opening hours: "+output);
                            JSONObject jsonObjectHours = output.getJSONObject(0);
                            if (jsonObjectHours != null && jsonObjectHours.getString("horaires").length() > 0)
                            {
                                String horairesOuverture = Html.fromHtml(jsonObjectHours.getString("horaires")).toString() ;
                                //Log.d(TAG, "Texte: "+horairesOuverture);
                                // On enregistre la phrase contenant les horaires d'ouverture en SharedPreferences :
                                mConfigurationService.putString(NgnConfigurationEntry.IVES_DJANAH_CALL_CENTER_SCHEDULE, horairesOuverture, true);

                                // Mettre a jour l'affichage de la PopupWindow dans ScreenWidgets :
                                ScreenWidgets.getInstance().displayCallCenterSchedule();
                            }
                        }


                        openingHoursRequestTerminated = true;
                        break;
                    default:
                        break;
                }
            }
        }
        catch (Exception e)
        {
            Log.e(TAG, "Error parsing JSON: "+e);
        }
    }

    @Override
    public void processFinishSuccess(RequestIdentifier p_requestIdentifier) {
        //Log.d(TAG, "processFinishSuccess ");
    }

    @Override
    public void processFinishError(RequestIdentifier p_requestIdentifier) {
        Log.d(TAG, "processFinishError: "+p_requestIdentifier.getRequestType().toString());
        if (mWidget != null)
        {
            mWidget.hideCallCenterAvailability();
        }
    }

    @Override
    public void processFinishErrorHashTemp(RequestIdentifier p_requestIdentifier) {
        Log.d(TAG, "processFinishErrorHashTemp ");
        try
        {
            processFinishErrorHashTempCount++;
            stopHttpConnection();

            if (processFinishErrorHashTempCount < MAX_ERROR_HASHTEMP_RETRY) {
                mRenewHashTemp = new RenewHashTemp(mConfigurationService.getString(NgnConfigurationEntry.PROVISIONING_LOGIN, ""), mConfigurationService.getString(NgnConfigurationEntry.PROVISIONING_PWD, ""), mRequestIdentifierCallCenter);
                mRenewHashTemp.delegate = this;
                mRenewHashTemp.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
            else
            {
                Log.d(TAG, "Renewing HashTemp failed "+ processFinishErrorHashTempCount+ " times. Stop retrying now.");
            }
        }
        catch (Exception e)
        {
            Log.e(TAG, "renewHashTemp failed :" + e.getMessage());
        }
    }

    @Override
    public void processFinishSuccessHashTemp(RequestIdentifier p_requestIdentifier) {
        Log.d(TAG, "processFinishSuccessHashTemp");
        startBackgroundPerform();
    }

    @Override
    public void processJSONError(String p_error)
    {

    }

    private void stopHttpConnection()
    {
        if (mTimer != null) {
            mTimer.cancel();
        }

        if (mTimerTask != null) {
            mTimerTask.cancel();
        }

        if (mRenewHashTemp != null)
        {
            mRenewHashTemp.cancel(true);
        }

        if (getCallCenterAvailabilityHttpConnection != null)
        {
            getCallCenterAvailabilityHttpConnection.cancel(true);
        }
    }

    private void setCallCenterAvailability(int p_status, int p_count)
    {
        mConfigurationService.putInt(NgnConfigurationEntry.IVES_CALL_CENTER_AVAILABILITY, p_status, true);
        mConfigurationService.putInt(NgnConfigurationEntry.IVES_CALL_CENTER_WAITING_USERS, p_count, true);

        if (mWidget != null)
        {
            mWidget.updateCallCenterAvailability();
        }
    }
}
