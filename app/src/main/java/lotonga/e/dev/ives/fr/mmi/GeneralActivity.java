package lotonga.e.dev.ives.fr.mmi;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentList;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by William on 16/05/2018.
 */

public abstract class GeneralActivity extends AppCompatActivity {


    public ComponentList getData(){
        //essai recup
        AssetManager assetManager = getAssets();

        try {
            //InputStream files = assetManager.open("lpSmin.ics");
            InputStream files = assetManager.open("s3.ics");
            //FileInputStream fin = new FileInputStream("mycalendar.ics");
            CalendarBuilder builder = new CalendarBuilder();
            //CALENDAR
            Calendar calendar = builder.build(files);

            ComponentList cl = calendar.getComponents();
            Log.d("READ ICS FILE", "onCreate() called with: savedInstanceState = [" + "]");
            return cl;
        } catch (IOException e) {
            Log.d("READ ICS FILE CATCH", "onCreate() called with: savedInstanceState = ["  + "]");
            e.printStackTrace();
            return null;
        } catch (ParserException e) {
            e.printStackTrace();
            return null;
        }
    }

}
