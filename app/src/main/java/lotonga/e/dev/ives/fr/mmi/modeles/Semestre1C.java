package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre1C extends SousSemestre{

    private ArrayList<Cours> s1c1;
    private ArrayList<Cours> s1c2;

    public Semestre1C(Semaine semaine)
    {
        super();
        this.setS1c1(semaine.getS1c1());
        this.setS1c2(semaine.getS1c2());
        this.emplois_du_temps.put("s1c1", this.getS1c1());
        this.emplois_du_temps.put("s1c2", this.getS1c2());
    }

    public ArrayList<Cours> getS1c1() {
        return s1c1;
    }

    public void setS1c1(ArrayList<Cours> s1c1) {
        this.s1c1 = s1c1;
    }

    public ArrayList<Cours> getS1c2() {
        return s1c2;
    }

    public void setS1c2(ArrayList<Cours> s1c2) {
        this.s1c2 = s1c2;
    }


    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s1c1") && !this.s1c1.contains(c))
        {
            this.s1c1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s1c2") && !this.s1c2.contains(c))
        {
            this.s1c2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s1c1":
                for (Cours c1: this.s1c1) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s1c1.remove(c1);
                        break;
                    }
                }
                break;
            case "s1c2":
                for (Cours c1: this.s1c2) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s1c2.remove(c1);
                        break;
                    }
                }
        }
    }
}
