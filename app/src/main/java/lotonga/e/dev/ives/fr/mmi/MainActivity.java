package lotonga.e.dev.ives.fr.mmi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS.TelechargerDepuisURL;

public class MainActivity extends Activity {

    Button btn;

    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (shouldAskPermissions()) {
            askPermissions();
        }

        btn = (Button) findViewById(R.id.telecharge);
    }

    public void click(View view)
    {
        String urlADEics = "http://ade6-ujf-ro.grenet.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=7265&projectId=2&calType=ical&firstDate=2018-05-13&lastDate=2018-05-18";

        new TelechargeADE().execute(urlADEics);
    }


    public class TelechargeADE extends AsyncTask<String, String, String>
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
        protected void onProgressUpdate(String ... value) {
            super.onProgressUpdate(value);
        }

        @Override
        protected void onPostExecute(String message) {
            super.onPostExecute(message);

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
