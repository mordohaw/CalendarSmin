package com.example.yahlopee.borne_agenda.modeles;

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
        try
        {
            this.c = new Cours(event);
            this.s = new Semaine();
            s.ajoutCours(c);
            this.lpsmin = new LPSMIN(this.s);
            this.s1  = new Semestre1( this.s );
            this.s2  = new Semestre2( this.s );
            this.s3  = new Semestre3( this.s );
            this.s4  = new Semestre4( this.s );

            this.s1lv2 = new Semestre1LV2(this.s);
            this.s2lv2 = new Semestre2LV2(this.s);
            this.s3lv2 = new Semestre3LV2(this.s);
        }
        catch (Exception e)
        {
            Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
        }
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

    private void init()
    {
        this.lpsmin = new LPSMIN(this.s);

        this.s1  = new Semestre1( this.s );
        this.s2  = new Semestre2( this.s );
        this.s3  = new Semestre3( this.s );
        this.s4  = new Semestre4( this.s );

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
