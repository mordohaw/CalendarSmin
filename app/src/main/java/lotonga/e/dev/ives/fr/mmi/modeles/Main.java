package lotonga.e.dev.ives.fr.mmi.modeles;

import android.util.Log;

import net.fortuna.ical4j.model.component.VEvent;

import java.util.ArrayList;
/**
 * Cette classe servira à gerer l'entrée dans le programme
 */

public class Main {

    public Semaine s;
    public Cours c;
    public SousSemestre s1a, s1b, s1c, s2a, s2b, s2c, s3a, s3b, s3c, s4a, s4b, s4c;
    public SemestreLangue s1lv2, s2lv2, s3lv2 ;
    public Semestre s1, s2, s3, s4;
    public LPSMIN lpsmin;

    public Main(VEvent event)
    {
        this.init(event);
    }
    public Main(ArrayList<VEvent> events)
    {
        this.s = new Semaine();
        for (VEvent ev : events)
        {
            try
            {
                this.c = new Cours(ev);
                this.s.ajoutCours(c);
            }
            catch (Exception e)
            {
                Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
            }
        }
        this.init();
    }

    public Main(VEvent[] events)
    {
        this.s = new Semaine();
        for (VEvent ev : events)
        {
            try
            {
                this.c = new Cours(ev);
                this.s.ajoutCours(c);
            }
            catch (Exception e)
            {
                Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
            }
        }
        this.init();
    }


    private void init(VEvent event)
    {

        try
        {
            this.c = new Cours(event);
            this.s = new Semaine();
            s.ajoutCours(c);
            this.lpsmin = new LPSMIN(this.s);
            this.s1a = new Semestre1A(this.s);
            this.s1b = new Semestre1B(this.s);
            this.s1c = new Semestre1C(this.s);
            this.s2a = new Semestre2A(this.s);
            this.s2b = new Semestre2B(this.s);
            this.s2c = new Semestre2C(this.s);
            this.s3a = new Semestre3A(this.s);
            this.s3b = new Semestre3B(this.s);
            this.s3c = new Semestre3C(this.s);
            this.s4a = new Semestre4A(this.s);
            this.s4b = new Semestre4B(this.s);
            this.s4c = new Semestre4C(this.s);
            this.s1  = new Semestre1( (Semestre1A) this.s1a, (Semestre1B) this.s1b, (Semestre1C) this.s1c);
            this.s2  = new Semestre2( (Semestre2A) this.s2a, (Semestre2B) this.s2b, (Semestre2C) this.s2c);
            this.s3  = new Semestre3( (Semestre3A) this.s3a, (Semestre3B) this.s3b, (Semestre3C) this.s3c);
            this.s4  = new Semestre4( (Semestre4A) this.s4a, (Semestre4B) this.s4b, (Semestre4C) this.s4c);

            this.s1lv2 = new Semestre1LV2(this.s);
            this.s2lv2 = new Semestre2LV2(this.s);
            this.s3lv2 = new Semestre3LV2(this.s);
        }
        catch (Exception e)
        {
            Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
        }

    }

    private void init()
    {
        this.lpsmin = new LPSMIN(this.s);
        this.s1a = new Semestre1A(this.s);
        this.s1b = new Semestre1B(this.s);
        this.s1c = new Semestre1C(this.s);
        this.s2a = new Semestre2A(this.s);
        this.s2b = new Semestre2B(this.s);
        this.s2c = new Semestre2C(this.s);
        this.s3a = new Semestre3A(this.s);
        this.s3b = new Semestre3B(this.s);
        this.s3c = new Semestre3C(this.s);
        this.s4a = new Semestre4A(this.s);
        this.s4b = new Semestre4B(this.s);
        this.s4c = new Semestre4C(this.s);
        this.s1  = new Semestre1( (Semestre1A) this.s1a, (Semestre1B) this.s1b, (Semestre1C) this.s1c);
        this.s2  = new Semestre2( (Semestre2A) this.s2a, (Semestre2B) this.s2b, (Semestre2C) this.s2c);
        this.s3  = new Semestre3( (Semestre3A) this.s3a, (Semestre3B) this.s3b, (Semestre3C) this.s3c);
        this.s4  = new Semestre4( (Semestre4A) this.s4a, (Semestre4B) this.s4b, (Semestre4C) this.s4c);

        this.s1lv2 = new Semestre1LV2(this.s);
        this.s2lv2 = new Semestre2LV2(this.s);
        this.s3lv2 = new Semestre3LV2(this.s);

        /*
            lpsmin.getEmplois_du_temps();
            s1a.getEmplois_Du_Temps();
            s1b.getEmplois_Du_Temps();
            s1.getEmplois_du_temps();
            s1lv2.getEmplois_du_temps();
        */
    }

}
