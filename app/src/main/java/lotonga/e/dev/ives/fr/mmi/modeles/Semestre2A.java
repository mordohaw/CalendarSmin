package lotonga.e.dev.ives.fr.mmi.modeles;


import java.util.ArrayList;

public class Semestre2A extends SousSemestre {

    private ArrayList<Cours> s2a1;
    private ArrayList<Cours> s2a2;

    public Semestre2A(Semaine semaine)
    {
        super();
        this.setS2a1(semaine.getS2a1());
        this.setS2a2(semaine.getS2a2());
        this.emplois_du_temps.put("s2a1", this.getS2a1());
        this.emplois_du_temps.put("s2a2", this.getS2a2());
    }


    public ArrayList<Cours> getS2a1() {
        return s2a1;
    }

    public void setS2a1(ArrayList<Cours> s2a1) {
        this.s2a1 = s2a1;
    }

    public ArrayList<Cours> getS2a2() {
        return s2a2;
    }

    public void setS2a2(ArrayList<Cours> s2a2) {
        this.s2a2 = s2a2;
    }

    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s2a1") && !this.s2a1.contains(c))
        {
            this.s2a1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s2a2")&& !this.s2a2.contains(c))
        {
            this.s2a2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s2a1":
                for (Cours c1: this.s2a1) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s2a1.remove(c1);
                        break;
                    }
                }
                break;
            case "s2a2":
                for (Cours c1: this.s2a2) {
                    if(c.getUid().equalsIgnoreCase(c1.getUid()))
                    {
                        this.s2a2.remove(c1);
                        break;
                    }
                }
        }
    }
}
