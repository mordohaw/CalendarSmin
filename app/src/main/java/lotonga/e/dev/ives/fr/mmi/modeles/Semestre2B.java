package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre2B extends SousSemestre {

    private ArrayList<Cours> s2b1;
    private ArrayList<Cours> s2b2;

    public Semestre2B(Semaine semaine)
    {
        super();
        this.setS2b1(semaine.getS2b1());
        this.setS2b2(semaine.getS2b2());
        this.emplois_du_temps.put("s2b1", this.getS2b1());
        this.emplois_du_temps.put("s2b2", this.getS2b2());
    }


    public ArrayList<Cours> getS2b1() {
        return s2b1;
    }

    public void setS2b1(ArrayList<Cours> s2b1) {
        this.s2b1 = s2b1;
    }

    public ArrayList<Cours> getS2b2() {
        return s2b2;
    }

    public void setS2b2(ArrayList<Cours> s2b2) {
        this.s2b2 = s2b2;
    }

    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s2b1") && !this.s2b1.contains(c))
        {
            this.s2b1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s2b2") && !this.s2b2.contains(c))
        {
            this.s2b2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s2b1":
                for ( Cours c1 : this.s2b1 )
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2b1.remove(c1);
                    }
                }
                break;
            case "s2b2":
                for (Cours c1 : this.s2b2 )
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2b2.remove(c1);
                    }
                }
        }
    }
}
