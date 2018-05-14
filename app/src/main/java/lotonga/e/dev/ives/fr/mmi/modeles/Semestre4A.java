package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public class Semestre4A extends SousSemestre {

    private ArrayList<Cours> s4a1;
    private  ArrayList<Cours> s4a2;

    public Semestre4A(Semaine semaine) {
        super();
        this.emplois_du_temps.put("s4a1",semaine.getS4a1());
        this.emplois_du_temps.put("s4a2",semaine.getS4a2());
    }


    public ArrayList<Cours> getS4a1() {
        return s4a1;
    }

    public void setS4a1(ArrayList<Cours> s4a1) {
        this.s4a1 = s4a1;
    }

    public ArrayList<Cours> getS4a2() {
        return s4a2;
    }

    public void setS4a2(ArrayList<Cours> s4a2) {
        this.s4a2 = s4a2;
    }

    @Override
    public void addCours(Cours c)
    {
        if(c.getGroupe().equalsIgnoreCase("s4a1") && !this.s4a1.contains(c))
        {
            this.s4a1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s4a2") && !this.s4a2.contains(c))
        {
            this.s4a2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s4a1":

                for (Cours c1: this.s4a1)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s4a1.remove(c1);
                    }
                }
                break;
            case "s4a2":
                for(Cours c1 : this.s4a2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s4a2.remove(c1);
                    }
                }
                break;
        }
    }
}
