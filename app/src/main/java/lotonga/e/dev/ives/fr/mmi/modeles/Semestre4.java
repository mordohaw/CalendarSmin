package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public class Semestre4 extends Semestre {


    public Semestre4(Semestre4A s4a, Semestre4B s4b, Semestre4C s4c )
    {
        super();
        this.emplois_du_temps.put("s4a", s4a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s4b", s4a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s4c", s4a.getEmplois_Du_Temps());
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_4A ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

    public class Semestre4A extends SousSemestre {

        private ArrayList<Cours> s4a1;
        private  ArrayList<Cours> s4a2;

        public Semestre4A(Semaine semaine) {
            super();
            this.emplois_du_temps.put("s4a1",semaine.getS4a1());
            this.emplois_du_temps.put("s4a2",semaine.getS4a2());
        }


        public ArrayList<Cours> getS4a1() {
            return s4a1;
        }

        public void setS4a1(ArrayList<Cours> s4a1) {
            this.s4a1 = s4a1;
        }

        public ArrayList<Cours> getS4a2() {
            return s4a2;
        }

        public void setS4a2(ArrayList<Cours> s4a2) {
            this.s4a2 = s4a2;
        }

        @Override
        public void addCours(Cours c)
        {
            if(c.getGroupe().equalsIgnoreCase("s4a1") && !this.s4a1.contains(c))
            {
                this.s4a1.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s4a2") && !this.s4a2.contains(c))
            {
                this.s4a2.add(c);
            }
        }

        @Override
        public void deleteCours(Cours c)
        {
            switch (c.getGroupe().toLowerCase())
            {
                case "s4a1":

                    for (Cours c1: this.s4a1)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4a1.remove(c1);
                        }
                    }
                    break;
                case "s4a2":
                    for(Cours c1 : this.s4a2)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4a2.remove(c1);
                        }
                    }
                    break;
            }
        }
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_4B ************************************************
     * ********************************************************************************************
     **********************************************************************************************/
    public class Semestre4B extends SousSemestre  {

        private ArrayList<Cours> s4b1;
        private ArrayList<Cours> s4b2;

        public Semestre4B(Semaine semaine) {
            super();
            this.setS4b1(semaine.getS4b1());
            this.setS4b2(semaine.getS4b2());
            this.emplois_du_temps.put("s4b1",this.getS4b1());
            this.emplois_du_temps.put("s4b2",this.getS4b2());
        }



        public ArrayList<Cours> getS4b1() {
            return s4b1;
        }

        public void setS4b1(ArrayList<Cours> s4b1) {
            this.s4b1 = s4b1;
        }

        public ArrayList<Cours> getS4b2() {
            return s4b2;
        }

        public void setS4b2(ArrayList<Cours> s4b2) {
            this.s4b2 = s4b2;
        }

        @Override
        public void addCours(Cours c)
        {
            if(c.getGroupe().equalsIgnoreCase("s4b1") && !this.s4b1.contains(c))
            {
                this.s4b1.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s4b2") && !this.s4b2.contains(c))
            {
                this.s4b2.add(c);
            }
        }

        @Override
        public void deleteCours(Cours c)
        {
            switch (c.getGroupe().toLowerCase())
            {
                case "s4b1":

                    for (Cours c1: this.s4b1)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4b1.remove(c1);
                        }
                    }
                    break;
                case "s4b2":
                    for(Cours c1 : this.s4b2)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4b2.remove(c1);
                        }
                    }
                    break;
            }
        }
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_4C ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

    public class Semestre4C extends SousSemestre {

        private ArrayList<Cours> s4c1;
        private ArrayList<Cours> s4c2;

        public Semestre4C(Semaine semaine) {
            super();
            this.setS4c1(semaine.getS4c1());
            this.setS4c2(semaine.getS4c2());
            this.emplois_du_temps.put("s4c1",semaine.getS4c1());
            this.emplois_du_temps.put("s4c2",semaine.getS4c2());
        }

        public ArrayList<Cours> getS4c1() {
            return s4c1;
        }

        public void setS4c1(ArrayList<Cours> s4c1) {
            this.s4c1 = s4c1;
        }

        public ArrayList<Cours> getS4c2() {
            return s4c2;
        }

        public void setS4c2(ArrayList<Cours> s4c2) {
            this.s4c2 = s4c2;
        }

        @Override
        public void addCours(Cours c)
        {
            if(c.getGroupe().equalsIgnoreCase("s4c1") && !this.s4c1.contains(c))
            {
                this.s4c1.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s4c2") && !this.s4c2.contains(c))
            {
                this.s4c2.add(c);
            }
        }

        @Override
        public void deleteCours(Cours c)
        {
            switch (c.getGroupe().toLowerCase())
            {
                case "s4c1":

                    for (Cours c1: this.s4c1)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4c1.remove(c1);
                        }
                    }
                    break;
                case "s4c2":
                    for(Cours c1 : this.s4c2)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4c2.remove(c1);
                        }
                    }
                    break;
            }
        }
    }

}
