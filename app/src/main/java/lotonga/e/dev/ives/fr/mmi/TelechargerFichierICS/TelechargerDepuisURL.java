package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Date;

public class TelechargerDepuisURL {


    private static String base_url= "http://ade6-ujf-ro.grenet.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=5946,5945,5944,4592,7357,7836,7350,7335,7334,7326,4907,4898,7385,7384,7317,7265,7390,7389,7387,7380,7395,7394,5055,5057,5029,5028,5024,5023,7373,7369,7367,7364,2650,7360,7377,7396,7375,7338,7399,7398&projectId=2&calType=ical&";
    //private static String destination = "";
    private static String reponseDowload = "";

    private static String getCurrentDate()
    {
        int year, month, day;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime date = LocalDateTime.now();
            year = date.getYear();
            month = date.getMonthValue();
            day = date.getDayOfMonth();
            //ZonedDateTime zdt = ZonedDateTime.now();
        }
        else
        {

            Date date = new Date();
            year = date.getYear();
            month = date.getMonth();
            day = date.getDay();
        }
        String ch = String.format("%d-%d-%d",year,month, day );
        return ch;
    }

    /**
     *
     * @param dateFin => format yyyy-mm-jj
     * @return
     */
    public static BufferedReader getContent(String dateFin)
    {
        base_url += "firstDate="+getCurrentDate()+"&lastDate="+dateFin;
        try
        {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(base_url);
            // add request header
            //request.addHeader("User-Agent", USER_AGENT);
            HttpResponse response = client.execute(request);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            //response.

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            return rd;
        }
        catch(Exception e)
        {}
        return null;
    }

    public static String TelechargerFichier()
    {
        String urlADEics = "http://ade6-ujf-ro.grenet.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=7265&projectId=2&calType=ical&firstDate=2018-05-13&lastDate=2018-05-18";

        new TelechargeADE().execute(urlADEics);

        return reponseDowload;
    }


    static class TelechargeADE extends AsyncTask<String, Integer, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urlADE) {

            String url = urlADE[0];
            File destination = new File(Environment.getExternalStorageDirectory(), "ADE.ics");

            try{
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(url);
                HttpResponse response = client.execute(request);

                String line = "";
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "utf-8") );

                while ((line = rd.readLine()) != null) {

                    writer.append(line);
                    writer.newLine();

                }
                writer.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return "Download Error !";
            }
            return "Download Succes";
        }

        @Override
        protected void onProgressUpdate(Integer... value) {
            super.onProgressUpdate(value);
        }

        @Override
        protected void onPostExecute(String message) {
            super.onPostExecute(message);
            reponseDowload = message;
        }
    }

}
