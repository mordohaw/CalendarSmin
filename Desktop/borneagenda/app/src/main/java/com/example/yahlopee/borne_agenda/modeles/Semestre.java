package com.example.yahlopee.borne_agenda.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Semestre {
    /*
     *   preview tableau S4
     *   [ ==> HashMap
     *       "s4a"
     *       [ ==> HashMap
     *               "S4a1"
     *               [ ==> ArrayList
     *                   Cours1, Cours2, Cours3 etc...
     *               ]
     *               "S4a2"
     *               [
     *                   Cours1, Cours2, Cours3 etc...
     *               ]
     *       ]
     *       ...
     *
     *   ]
     *
     */
    protected HashMap<String, HashMap<String, ArrayList<Cours> >> emplois_du_temps;

    public Semestre( )
    {
        this.emplois_du_temps = new HashMap<>();
    }

    public HashMap<String, HashMap<String, ArrayList<Cours> >> getEmplois_du_temps()
    {
        return this.emplois_du_temps;
    }

    public void setEmplois_du_temps(HashMap<String, HashMap<String, ArrayList<Cours> >> emplois_du_temps)
    {
        this.emplois_du_temps = emplois_du_temps;
    }
}
