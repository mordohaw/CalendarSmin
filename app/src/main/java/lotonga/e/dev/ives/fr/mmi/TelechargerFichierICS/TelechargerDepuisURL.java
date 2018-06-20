package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
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
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.Date;

public class TelechargerDepuisURL extends AsyncTask<Object, String, String> {

    int count;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... objects) {

        String url =(String) objects[0];
        File nuevaCarpeta = new File(Environment.getExternalStorageDirectory(), "CalendarSMIN");

        if(nuevaCarpeta.exists())
        {

        }
        else
        {
            nuevaCarpeta.mkdirs();
        }

        File chemin = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"CalendarSMIN", "ADE.ics");

        try{
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            String line = "";
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(chemin), "utf-8") );

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
        return "Download, "+fileWasCreated();
    }

    @Override
    protected void onProgressUpdate(String ... value) {
        super.onProgressUpdate(value);
    }

    @Override
    protected void onPostExecute(String message) {
        super.onPostExecute(message);



    }


    public String fileWasCreated()
    {
        File fichier = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"CalendarSMIN"+File.separator+"ADE.ics");

        if (fichier.isFile())
        {

            return afficherFichier();
        }
        else
        {
            return "Fichier n'a pas été crée";
        }
    }

    public String afficherFichier() {
        String cadena;
        try {
            File fichier = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"CalendarSMIN"+File.separator+"ADE.ics");

            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;


                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                //archivo = new File (String.valueOf(fichier));
                fr = new FileReader (fichier);
                br = new BufferedReader(fr);

                StringBuffer ics = new StringBuffer();

                // Lectura del fichero
                String linea;
                while((linea=br.readLine())!=null)
                {
                    //Log.i("READ FICHIER ", linea);
                    ics.append(linea+"\r\n");
                    //Log.i("READ FICHIER ", ics.toString());
                }
            String myCalendarString = ics.toString();

            StringReader sin = new StringReader(myCalendarString);

            CalendarBuilder builder = new CalendarBuilder();

            Calendar calendar = builder.build(sin);

            String toto = "toto";

            ComponentList cl = calendar.getComponents();

            Log.i("COMPONENTS ICS ", cl.toString());

            return "Succesful Calendar ICS";

            } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return "Error 1 Calendar ICS";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "Error 2 Calendar ICS";
        } catch (ParserException e) {
            e.printStackTrace();
            return "Error 3Calendar ICS";
        }
    }
}
