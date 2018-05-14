package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre4C extends SousSemestre {

    private ArrayList<Cours> s4c1;
    private ArrayList<Cours> s4c2;

    public Semestre4C(Semaine semaine) {
        super();
        this.setS4c1(semaine.getS4c1());
        this.setS4c2(semaine.getS4c2());
        this.emplois_du_temps.put("s4c1",semaine.getS4c1());
        this.emplois_du_temps.put("s4c2",semaine.getS4c2());
    }

    public ArrayList<Cours> getS4c1() {
        return s4c1;
    }

    public void setS4c1(ArrayList<Cours> s4c1) {
        this.s4c1 = s4c1;
    }

    public ArrayList<Cours> getS4c2() {
        return s4c2;
    }

    public void setS4c2(ArrayList<Cours> s4c2) {
        this.s4c2 = s4c2;
    }

    @Override
    public void addCours(Cours c)
    {
        if(c.getGroupe().equalsIgnoreCase("s4c1") && !this.s4c1.contains(c))
        {
            this.s4c1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s4c2") && !this.s4c2.contains(c))
        {
            this.s4c2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s4c1":

                for (Cours c1: this.s4c1)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s4c1.remove(c1);
                    }
                }
                break;
            case "s4c2":
                for(Cours c1 : this.s4c2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s4c2.remove(c1);
                    }
                }
                break;
        }
    }
}
