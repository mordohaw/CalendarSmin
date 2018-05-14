package lotonga.e.dev.ives.fr.mmi.modeles;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Semestre2C extends SousSemestre {


    private ArrayList<Cours> s2c1;
    private ArrayList<Cours> s2c2;

    public Semestre2C(Semaine semaine)
    {
        super();
        this.setS2c1(semaine.getS2c1());
        this.setS2c2(semaine.getS2c2());
        this.emplois_du_temps.put("s2c1", this.getS2c1());
        this.emplois_du_temps.put("s2c2", this.getS2c2());

    }

    public ArrayList<Cours> getS2c1() {
        return s2c1;
    }

    public void setS2c1(ArrayList<Cours> s2c1) {
        this.s2c1 = s2c1;
    }

    public ArrayList<Cours> getS2c2() {
        return s2c2;
    }

    public void setS2c2(ArrayList<Cours> s2c2) {
        this.s2c2 = s2c2;
    }


    @Override
    public void addCours(Cours c)
    {

        if(c.getGroupe().equalsIgnoreCase("s2c1") && !this.s2c1.contains(c))
        {
            this.s2c1.add(c);
        }
        else if( c.getGroupe().equalsIgnoreCase("s2c2") && !this.s2c2.contains(c))
        {
            this.s2c2.add(c);
        }

    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s2c1":
                for ( Cours c1 : this.s2c1 )
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2c1.remove(c1);
                    }
                }
                break;
            case "s2c2":
                for (Cours c1 : this.s2c2 )
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2c2.remove(c1);
                    }
                }
        }
    }
}
