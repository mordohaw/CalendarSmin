package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre4B extends SousSemestre  {

    private ArrayList<Cours> s4b1;
    private ArrayList<Cours> s4b2;

    public Semestre4B(Semaine semaine) {
        super();
        this.setS4b1(semaine.getS4b1());
        this.setS4b2(semaine.getS4b2());
        this.emplois_du_temps.put("s4b1",this.getS4b1());
        this.emplois_du_temps.put("s4b2",this.getS4b2());
    }



    public ArrayList<Cours> getS4b1() {
        return s4b1;
    }

    public void setS4b1(ArrayList<Cours> s4b1) {
        this.s4b1 = s4b1;
    }

    public ArrayList<Cours> getS4b2() {
        return s4b2;
    }

    public void setS4b2(ArrayList<Cours> s4b2) {
        this.s4b2 = s4b2;
    }

    @Override
    public void addCours(Cours c)
    {
        if(c.getGroupe().equalsIgnoreCase("s4b1") && !this.s4b1.contains(c))
        {
            this.s4b1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s4b2") && !this.s4b2.contains(c))
        {
            this.s4b2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s4b1":

                for (Cours c1: this.s4b1)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s4b1.remove(c1);
                    }
                }
                break;
            case "s4b2":
                for(Cours c1 : this.s4b2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s4b2.remove(c1);
                    }
                }
                break;
        }
    }

}
