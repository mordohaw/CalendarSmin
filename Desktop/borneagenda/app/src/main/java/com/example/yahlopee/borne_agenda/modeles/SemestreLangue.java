package com.example.yahlopee.borne_agenda.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SemestreLangue {

    protected HashMap<String, ArrayList<Cours>> emplois_du_temps;

    public SemestreLangue()
    {
        this.emplois_du_temps = new HashMap<>();
    }

    public HashMap<String, ArrayList<Cours>> getEmplois_du_temps()
    {
        return this.emplois_du_temps;
    }

    public abstract void addCours(Cours c);
    public abstract void deleteCours(Cours c);
}
