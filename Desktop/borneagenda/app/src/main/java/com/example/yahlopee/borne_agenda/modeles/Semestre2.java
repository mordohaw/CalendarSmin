package com.example.yahlopee.borne_agenda.modeles;

import java.util.ArrayList;

public class Semestre2 extends Semestre {

    private SousSemestre s2a, s2b, s2c;
    public Semestre2( Semaine semaine )
    {
        super();
        this.s2a = new Semestre2A( semaine );
        this.s2b = new Semestre2B( semaine );
        this.s2c = new Semestre2C( semaine );
        this.emplois_du_temps.put("s2a", s2a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s2b", s2b.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s2c", s2c.getEmplois_Du_Temps());
    }

    public Semestre2A getS2a() {
        return (Semestre2A)this.s2a;
    }

    public void setS2a(Semestre2A s2a) {
        this.s2a = s2a;
    }

    public Semestre2B getS2b() {
        return (Semestre2B)this.s2b;
    }

    public void setS2b(Semestre2B s2b) {
        this.s2b = s2b;
    }

    public Semestre2C getS2c() {
        return (Semestre2C)this.s2c;
    }

    public void setS2c(Semestre2C s2c) {
        this.s2c = s2c;
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_2A ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

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

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_2B ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

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


    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_2C ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

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

}
