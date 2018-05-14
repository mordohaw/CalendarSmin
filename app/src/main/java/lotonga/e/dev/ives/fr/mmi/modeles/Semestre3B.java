package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre3B extends SousSemestre {

    private ArrayList<Cours> s3b1;
    private ArrayList<Cours> s3b2;

    public Semestre3B(Semaine semaine)
    {
        super();
        this.setS3b1(semaine.getS3b1());
        this.setS3b2(semaine.getS3b2());
        this.emplois_du_temps.put("s3b1", this.getS3b1());
        this.emplois_du_temps.put("s3b2", this.getS3b2());
    }


    public ArrayList<Cours> getS3b1() {
        return s3b1;
    }

    public void setS3b1(ArrayList<Cours> s3b1) {
        this.s3b1 = s3b1;
    }

    public ArrayList<Cours> getS3b2() {
        return s3b2;
    }

    public void setS3b2(ArrayList<Cours> s3b2) {
        this.s3b2 = s3b2;
    }


    @Override
    public void addCours(Cours c)
    {
        if (c.getGroupe().equalsIgnoreCase("s3a1") && !this.s3b1.contains(c))
        {
            this.s3b1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s3a2") && !this.s3b2.contains(c))
        {
            this.s3b2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s3b1":
                for (Cours c1 :this.s3b1)
                {
                    if( c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3b1.remove(c1);
                    }
                }
                break;
            case "s3b2":
                for(Cours c1 : this.s3b2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3b1.remove(c1);
                    }
                }
                break;
        }
    }
}
