package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre1A extends SousSemestre{

    private ArrayList<Cours> s1a1;
    private ArrayList<Cours> s1a2;
    public Semestre1A(Semaine semaine)
    {
        this.setS1a1(semaine.getS1a1());
        this.setS1a2(semaine.getS1a2());
        this.emplois_du_temps.put("s1a1", this.getS1a1());
        this.emplois_du_temps.put("s1a2", this.getS1a2());
    }

    public ArrayList<Cours> getS1a1()
    {
        return this.s1a1;
    }

    public ArrayList<Cours> getS1a2() {
        return s1a2;
    }

    public void setS1a1(ArrayList<Cours> s1a1) {
        this.s1a1 = s1a1;
    }

    public void setS1a2(ArrayList<Cours> s1a2)
    {
        this.s1a2 = s1a2;
    }

    @Override
    public void addCours(Cours c) {

        if(c.getGroupe().equalsIgnoreCase("s1a1") && !this.s1a1.contains(c))
        {
            this.s1a1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s1a2") && !this.s1a2.contains(c))
        {
            this.s1a2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s1a1":
                for (Cours c1: this.s1a1) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s1a1.remove(c1);
                        break;
                    }
                }
                break;
            case "s1a2":
                for (Cours c1: this.s1a2) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s1a2.remove(c1);
                        break;
                    }
                }
        }
    }
}
