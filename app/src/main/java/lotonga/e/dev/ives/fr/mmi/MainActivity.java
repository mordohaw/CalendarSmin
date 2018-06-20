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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS.TelechargerDepuisURL;
import lotonga.e.dev.ives.fr.mmi.modeles.Main;

public class MainActivity extends GeneralActivity {

    Button btn;
    int count = 0;

    final long TIME_TASK = 900000;

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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (shouldAskPermissions()) {
            askPermissions();
        }

        btn = (Button) findViewById(R.id.telecharge);


    }



    public void click(View view)
    {

        String begimDate, endDate;
        //Date actuelle
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        begimDate = dateFormat.format(date);
        System.out.println("Date debut : "+begimDate);

        //Date après 7 jours
        Date date1 = new Date();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, 7);
        date = cal.getTime();
        endDate = dateFormat1.format(date);

        System.out.println("Date Fin : "+endDate);

        final String urlADEics = "http://ade6-ujf-ro.grenet.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=7265&projectId=2&calType=ical&firstDate="+begimDate+"&lastDate="+endDate;

        System.out.println("URL String ADE  => "+urlADEics);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //new AttemptUpdate().execute();
                        Log.i("tag", "This'll run 15 minutes later");

                        TelechargerDepuisURL telechergaADE = new TelechargerDepuisURL();


                        String response = "";


                        try {
                            response = telechergaADE.execute(urlADEics).get();


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }


                        Toast.makeText(MainActivity.this, response+" "+count, Toast.LENGTH_SHORT).show();

                        count++;
                    }
                });
            }
        }, 0, TIME_TASK);

    }




}
