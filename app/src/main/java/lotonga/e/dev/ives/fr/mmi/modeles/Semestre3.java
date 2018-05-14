package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public class Semestre3 extends Semestre {


    private SousSemestre s3a, s3b, s3c;
    public Semestre3(Semaine semaine )
    {
        super();
        this.s3a = new Semestre3A( semaine );
        this.s3b = new Semestre3B( semaine );
        this.s3c = new Semestre3C( semaine );
        this.emplois_du_temps.put("s3a", this.s3a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s3b", this.s3b.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s3c", this.s3c.getEmplois_Du_Temps());
    }


    public Semestre3A getS3a() {
        return (Semestre3A)this.s3a;
    }

    public void setS3a(Semestre3A s3a) {
        this.s3a = s3a;
    }

    public Semestre3B getS3b() {
        return (Semestre3B)this.s3b;
    }

    public void setS3b(Semestre3B s3b) {
        this.s3b = s3b;
    }

    public Semestre3C getS3c() {
        return (Semestre3C)this.s3c;
    }

    public void setS3c(Semestre3C s3c) {
        this.s3c = s3c;
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_3A ************************************************
     * ********************************************************************************************
     **********************************************************************************************/


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

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_3B ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

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


    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_3C ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

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
}
