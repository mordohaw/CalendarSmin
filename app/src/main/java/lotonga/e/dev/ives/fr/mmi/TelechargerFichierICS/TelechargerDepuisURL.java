package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Date;

public class TelechargerDepuisURL {

    private static String base_url= "http://ade6-ujf-ro.grenet.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=5946,5945,5944,4592,7357,7836,7350,7335,7334,7326,4907,4898,7385,7384,7317,7265,7390,7389,7387,7380,7395,7394,5055,5057,5029,5028,5024,5023,7373,7369,7367,7364,2650,7360,7377,7396,7375,7338,7399,7398&projectId=2&calType=ical&";

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


    public static boolean TelechargerFichier( String destination, String dateFin )
    {
        try{
            base_url += "firstDate="+getCurrentDate()+"&lastDate="+dateFin;
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(base_url);
            // add request header
            //request.addHeader("User-Agent", USER_AGENT);
            HttpResponse response = client.execute(request);
            //System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "utf-8") );
            while ((line = rd.readLine()) != null) {
                //System.out.println(line);
                writer.append(line);
                writer.newLine();
            }
            writer.close();
            return true;
        }
            catch(Exception e)
        {
            return false;
        }
    }

}
