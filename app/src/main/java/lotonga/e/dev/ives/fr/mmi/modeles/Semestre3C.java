package lotonga.e.dev.ives.fr.mmi.modeles;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Semestre3C extends SousSemestre {

    private ArrayList<Cours> s3c1;
    private ArrayList<Cours> s3c2;

    public Semestre3C( Semaine semaine)
    {
        super();
        this.setS3c1(semaine.getS3c1());
        this.setS3c2(semaine.getS3c2());
        this.emplois_du_temps.put("s3c1", this.getS3c1());
        this.emplois_du_temps.put("s3c2", this.getS3c2());
    }


    public ArrayList<Cours> getS3c1() {
        return s3c1;
    }

    public void setS3c1(ArrayList<Cours> s3c1) {
        this.s3c1 = s3c1;
    }

    public ArrayList<Cours> getS3c2() {
        return s3c2;
    }

    public void setS3c2(ArrayList<Cours> s3c2) {
        this.s3c2 = s3c2;
    }


    @Override
    public void addCours(Cours c)
    {
        if (c.getGroupe().equalsIgnoreCase("s3c1") && !this.s3c1.contains(c))
        {
            this.s3c1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s3c2") && !this.s3c2.contains(c))
        {
            this.s3c2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe())
        {
            case "s3c1":
                for (Cours c1 :this.s3c1)
                {
                    if( c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3c1.remove(c1);
                    }
                }
                break;
            case "s3c2":
                for(Cours c1 : this.s3c2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3c1.remove(c1);
                    }
                }
                break;
        }
    }
}
