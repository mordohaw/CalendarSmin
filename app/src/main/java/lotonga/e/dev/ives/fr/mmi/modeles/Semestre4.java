package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public class Semestre4 extends Semestre {

    private SousSemestre s4a, s4b, s4c;
    public Semestre4(Semaine semaine )
    {
        super();
        this.setAmphi(semaine.getS4());
        this.s4a = new Semestre4A( semaine );
        this.s4b = new Semestre4B( semaine );
        this.s4c = new Semestre4C( semaine );
        this.emplois_du_temps.put("s4a", this.s4a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s4b", this.s4b.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s4c", this.s4c.getEmplois_Du_Temps());
    }

    public Semestre4A getS4a() {
        return (Semestre4A)this.s4a;
    }

    public void setS4a(Semestre4A s4a) {
        this.s4a = s4a;
    }

    public Semestre4B getS4b() {
        return (Semestre4B)this.s4b;
    }

    public void setS4b(SousSemestre s4b) {
        this.s4b = s4b;
    }

    public Semestre4C getS4c() {
        return (Semestre4C)this.s4c;
    }

    public void setS4c(SousSemestre s4c) {
        this.s4c = s4c;
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_4A ************************************************
     * ********************************************************************************************
     **********************************************************************************************/

    public class Semestre4A extends SousSemestre {

        private ArrayList<Cours> s4a1;
        private  ArrayList<Cours> s4a2;
        private ArrayList<Cours> s4a;

        public Semestre4A(Semaine semaine) {
            super();
            this.setS4a(semaine.getS4a());
            this.setS4a1(semaine.getS4a1());
            this.setS4a2(semaine.getS4a2());
            this.emplois_du_temps.put("s4a1",this.getS4a1());
            this.emplois_du_temps.put("s4a2",this.getS4a2());
            this.emplois_du_temps.put("s4a",this.getS4a());
        }


        public ArrayList<Cours> getS4a() {
            return s4a;
        }

        public void setS4a(ArrayList<Cours> s4a) {
            this.s4a = s4a;
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
            else if(c.getGroupe().equalsIgnoreCase("s4a") && !this.s4a.contains(c))
            {
                this.s4a.add(c);
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
                case "s4a":
                    for(Cours c1 : this.s4a)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4a.remove(c1);
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
        private ArrayList<Cours> s4b;

        public Semestre4B(Semaine semaine) {
            super();
            this.setS4b(semaine.getS4b());
            this.setS4b1(semaine.getS4b1());
            this.setS4b2(semaine.getS4b2());
            this.emplois_du_temps.put("s4b1",this.getS4b1());
            this.emplois_du_temps.put("s4b2",this.getS4b2());
            this.emplois_du_temps.put("s4b",this.getS4b());
        }


        public ArrayList<Cours> getS4b() {
            return s4b;
        }

        public void setS4b(ArrayList<Cours> s4b) {
            this.s4b = s4b;
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
            else if(c.getGroupe().equalsIgnoreCase("s4b") && !this.s4b.contains(c))
            {
                this.s4b.add(c);
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
                case "s4b":
                    for(Cours c1 : this.s4b)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4b.remove(c1);
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
        private ArrayList<Cours> s4c;

        public Semestre4C(Semaine semaine) {
            super();
            this.setS4c(semaine.getS4c());
            this.setS4c1(semaine.getS4c1());
            this.setS4c2(semaine.getS4c2());
            this.emplois_du_temps.put("s4c1",semaine.getS4c1());
            this.emplois_du_temps.put("s4c2",semaine.getS4c2());
            this.emplois_du_temps.put("s4c",this.getS4c());
        }

        public ArrayList<Cours> getS4c() {
            return s4c;
        }

        public void setS4c(ArrayList<Cours> s4c) {
            this.s4c = s4c;
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
            else if(c.getGroupe().equalsIgnoreCase("s4c") && !this.s4c.contains(c))
            {
                this.s4c.add(c);
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
                case "s4c":
                    for(Cours c1 : this.s4c)
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.s4c.remove(c1);
                        }
                    }
                    break;
            }
        }
    }

}
