package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by bfortoul on 24/03/16.
 */
public class TaskHttpConnection extends AsyncTask<String, String, Integer>{

    private static final String	            TAG	                    = TaskHttpConnection.class.getCanonicalName();
    private URI mSourceUri                  = null;
    private static final int    SENDURL2SERVICE_OK              = 1 ;
    private static final int    SENDURL2SERVICE_CONNECT_KO      = 2 ;
    private static final int    SENDURL2SERVICE_REQUEST_KO      = 3 ;
    private static final int    SENDURL2SERVICE_HASHTEMP_KO     = 4 ;
    private Activity mCtx                        = null ;
    public IAsyncResponseJSON delegate = null;
    private JSONArray jsonArray = null;
    private RequestIdentifier mRequestIdentifier;
    private String resultError = null;

    public TaskHttpConnection (Activity p_context, URI p_URI, RequestIdentifier p_requestIdentifier)
    {
        mCtx = p_context;
        mSourceUri = p_URI;
        mRequestIdentifier = p_requestIdentifier;

        Log.v(TAG, "URL TO OPEN = " + mSourceUri);
    }

    public TaskHttpConnection (URI p_URI, RequestIdentifier p_requestIdentifier)
    {
        mSourceUri = p_URI;
        mRequestIdentifier = p_requestIdentifier;

        Log.v(TAG, "URL TO OPEN = " + mSourceUri);
    }


    @Override
    protected Integer doInBackground(String... params) {

        Integer Status = SENDURL2SERVICE_REQUEST_KO;
        // Wait for network
        int ct = 0 ;
        NgnEngine engine = NgnEngine.getInstance();
        if (engine != null)
        {
            /**********************************************
             *  Check if device has access to internet !
             **********************************************/

            INgnNetworkService networkService = NgnEngine.getInstance().getNetworkService();
            Log.d(TAG, "doInBackground : Start http request ");
            // If network not available, retry 20 times each 500ms
            while (ct < 20 && !networkService.IsConnected())
            {
                try
                {
                    if (isCancelled()) return SENDURL2SERVICE_CONNECT_KO;
                    Thread.sleep(500);
                    Log.d(TAG, "doInBackground wait network!");
                } catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ct++;
            }

            if (!networkService.IsConnected())
            {
                Log.d(TAG, "doInBackground no network started !");
                return SENDURL2SERVICE_CONNECT_KO;
            }

            try
            {
                URL urlObj = new URL(mSourceUri.toString());

                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

                conn.setDoOutput(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(15000);

                int firstResponseCode = conn.getResponseCode();
                if (firstResponseCode != HttpURLConnection.HTTP_OK)
                {
                    Log.d(TAG, "firstResponseCode: " + firstResponseCode);
                }

                // ***************** Specifique à IVES **************
                // Redirect (Ex: http://mobile.adj.dj?XXXXX => https://user.djanah.com:444 )
                if (firstResponseCode == HttpURLConnection.HTTP_MOVED_TEMP || firstResponseCode == HttpURLConnection.HTTP_MOVED_PERM)
                {
                    String newUrl = conn.getHeaderField("Location");
                    Log.d(TAG, "newUrl: " + newUrl);

                    conn = (HttpURLConnection) new URL(newUrl).openConnection();
                    conn.setDoOutput(false);
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept-Charset", "UTF-8");
                    conn.setConnectTimeout(15000);
                }

                conn.connect();
                StringBuilder result = new StringBuilder();

                int response = conn.getResponseCode();
                Log.d(TAG, "response code: " + response);

                if (response == HttpStatus.SC_OK)
                {
                    //Receive the response from the server
                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        result.append(line);
                    }

                    if (result != null)
                    {
                        Log.d(TAG, "result: " + result.toString());
                    }
                } else if (response == HttpStatus.SC_UNAUTHORIZED)
                {
                    // ERROR_HASH = 401 -> page php renvoie si hash invalide : les apps relancent un provisionning
                    Log.d(TAG, "response: " + response);
                    return SENDURL2SERVICE_HASHTEMP_KO;
                } else if (response == HttpStatus.SC_BAD_REQUEST || response == HttpStatus.SC_NOT_FOUND
                        || response == HttpStatus.SC_INTERNAL_SERVER_ERROR || response == HttpStatus.SC_SERVICE_UNAVAILABLE)
                {

                    if (response == HttpStatus.SC_SERVICE_UNAVAILABLE)
                    {
                        //Receive the response from the server
                        InputStream in = new BufferedInputStream(conn.getErrorStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder resultErr = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null)
                        {
                            resultErr.append(line);
                        }

                        if (resultErr != null)
                        {
                            //Log.d(TAG, "resultErr: " + resultErr.toString());
                            resultError = resultErr.toString();
                        }
                    }
                    return SENDURL2SERVICE_REQUEST_KO;
                }
                //fermeture de la connexion http
                conn.disconnect();

            } catch (Exception e)
            {
                Log.e(TAG, "TaskHttpConnection [" + mSourceUri + "] error" + e.getMessage());
                Status = SENDURL2SERVICE_REQUEST_KO;
            }
            return Status;
        }
        return SENDURL2SERVICE_REQUEST_KO;
    }

    protected JSONArray getResult()
    {
        return jsonArray;
    }

    @Override
    protected void onPostExecute(Integer result)
    {
        //Log.d(TAG,"onPostExecute result:"+result);
        switch ( result)
        {
            case SENDURL2SERVICE_OK:
                //Log.d(TAG, "TaskHttpConnection success");
                //delegate.processFinishJSON(getResult());
                delegate.processFinishJSON(getResult(), mRequestIdentifier);
                delegate.processFinishSuccess(mRequestIdentifier);
                break;
            case SENDURL2SERVICE_REQUEST_KO:
                Log.d(TAG, "TaskHttpConnection identification failed");
                if (resultError != null)
                {
                    delegate.processJSONError(resultError);
                }
                delegate.processFinishError(mRequestIdentifier);
                break ;
            case SENDURL2SERVICE_CONNECT_KO:
                Log.d(TAG, "TaskHttpConnection network failed");
                delegate.processFinishError(mRequestIdentifier);
                break ;
            case SENDURL2SERVICE_HASHTEMP_KO: // IVes
                Log.d(TAG, "TaskHttpConnection hashtemp failed");
                delegate.processFinishErrorHashTemp(mRequestIdentifier);
                break;
        }
    }
}