package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre3A extends SousSemestre {

    private ArrayList<Cours> s3a1;
    private ArrayList<Cours> s3a2;

    public Semestre3A( Semaine semaine)
    {
        super();
        this.setS3a1(semaine.getS3a1());
        this.setS3a2(semaine.getS3a2());
        this.emplois_du_temps.put("s3a1", semaine.getS3a1());
        this.emplois_du_temps.put("s3a2", semaine.getS3a2());
    }


    public ArrayList<Cours> getS3a1() {
        return s3a1;
    }

    public void setS3a1(ArrayList<Cours> s3a1) {
        this.s3a1 = s3a1;
    }

    public ArrayList<Cours> getS3a2() {
        return s3a2;
    }

    public void setS3a2(ArrayList<Cours> s3a2) {
        this.s3a2 = s3a2;
    }


    @Override
    public void addCours(Cours c)
    {
        if (c.getGroupe().equalsIgnoreCase("s3a1") && !this.s3a1.contains(c))
        {
            this.s3a1.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s3a2") && !this.s3a2.contains(c))
        {
            this.s3a2.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s3a1":
                for (Cours c1 :this.s3a1)
                {
                    if( c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3a1.remove(c1);
                    }
                }
                break;
            case "s3a2":
                for(Cours c1 : this.s3a2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3a1.remove(c1);
                    }
                }
                break;
        }
    }
}
