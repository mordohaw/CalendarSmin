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

public class TelechargerDepuisURL {

    public static BufferedReader getContentTO(String url)
    {
        try
        {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);

            // add request header
            //request.addHeader("User-Agent", USER_AGENT);
            HttpResponse response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            //System.out.println(response.getEntity().getContent().);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            return rd;
        }
        catch(Exception e)
        {}
        return null;
    }

    public static boolean TelechargerFichier(String url, String destination)
    {
        try{
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
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
    
    public static void main(String[] args) {
    	String url = "http://ade6-ujf-ro.grenet.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=7265&projectId=2&calType=ical&firstDate=2018-05-13&lastDate=2018-05-18";
		TelechargerDepuisURL.TelechargerFichier(url, "C:\Users\mkmkmk\Documents\TravauxSMIN\TestTelechargementIC\ADEICS.ics")
	}
}
