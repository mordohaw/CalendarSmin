package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre1B extends SousSemestre{

    private ArrayList<Cours> s1b1;
    private ArrayList<Cours> s1b2;

    public Semestre1B(Semaine semaine)
    {
        this.setS1b1(semaine.getS1b1());
        this.setS1b2(semaine.getS1b2());
        this.emplois_du_temps.put("s1b1", this.getS1b1());
        this.emplois_du_temps.put("s1b2", this.getS1b2());
    }


    public ArrayList<Cours> getS1b1() {
        return s1b1;
    }

    public void setS1b1(ArrayList<Cours> s1b1) {
        this.s1b1 = s1b1;
    }

    public ArrayList<Cours> getS1b2() {
        return s1b2;
    }

    public void setS1b2(ArrayList<Cours> s1b2) {
        this.s1b2 = s1b2;
    }

    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s1b1") && !this.s1b1.contains(c))
        {
            this.s1b1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s1b2") && !this.s1b2.contains(c))
        {
            this.s1b2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s1b1":
                for (Cours c1: this.s1b1) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s1b1.remove(c1);
                        break;
                    }
                }
                break;
            case "s1b2":
                for (Cours c1: this.s1b2) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s1b2.remove(c1);
                        break;
                    }
                }
        }
    }
}
