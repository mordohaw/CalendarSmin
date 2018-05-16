package com.example.yahlopee.borne_agenda.modeles;

import java.util.ArrayList;

public class Semestre1LV2 extends SemestreLangue {

    private ArrayList<Cours> s1lv2allemand;
    private ArrayList<Cours> s1lv2espagnol1;
    private ArrayList<Cours> s1lv2espagnol2;
    private ArrayList<Cours> s1lv2espagnol3;
    private ArrayList<Cours> s1lv2italien;

    public Semestre1LV2 (Semaine semaine)
    {
        super();
        this.setS1lv2allemand(semaine.getS1LV2Allemand());
        this.setS1lv2espagnol1(semaine.getS1LV2Espagnol1());
        this.setS1lv2espagnol2(semaine.getS1LV2Espagnol2());
        this.setS1lv2espagnol3(semaine.getS1LV2Espagnol3());
        this.setS1lv2italien(semaine.getS1LV2Italien());
        this.emplois_du_temps.put("s1lv2allemand", this.getS1lv2allemand());
        this.emplois_du_temps.put("s1lv2espagnol1", this.getS1lv2espagnol1());
        this.emplois_du_temps.put("s1lv2espagnol2", this.getS1lv2espagnol2());
        this.emplois_du_temps.put("s1lv2espagnol3", this.getS1lv2espagnol3());
        this.emplois_du_temps.put("s1lv2italien", this.getS1lv2italien());
    }

    public ArrayList<Cours> getS1lv2allemand() {
        return s1lv2allemand;
    }

    public void setS1lv2allemand(ArrayList<Cours> s1lv2allemand) {
        this.s1lv2allemand = s1lv2allemand;
    }

    public ArrayList<Cours> getS1lv2espagnol1() {
        return s1lv2espagnol1;
    }

    public void setS1lv2espagnol1(ArrayList<Cours> s1lv2espagnol1) {
        this.s1lv2espagnol1 = s1lv2espagnol1;
    }

    public ArrayList<Cours> getS1lv2espagnol2() {
        return s1lv2espagnol2;
    }

    public void setS1lv2espagnol2(ArrayList<Cours> s1lv2espagnol2) {
        this.s1lv2espagnol2 = s1lv2espagnol2;
    }

    public ArrayList<Cours> getS1lv2espagnol3() {
        return s1lv2espagnol3;
    }

    public void setS1lv2espagnol3(ArrayList<Cours> s1lv2espagnol3) {
        this.s1lv2espagnol3 = s1lv2espagnol3;
    }

    public ArrayList<Cours> getS1lv2italien() {
        return s1lv2italien;
    }

    public void setS1lv2italien(ArrayList<Cours> s1lv2italien) {
        this.s1lv2italien = s1lv2italien;
    }


    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s1lv2allemand") && !this.s1lv2allemand.contains(c))
        {
            this.s1lv2allemand.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s1lv2espagnol1") && !this.s1lv2espagnol1.contains(c))
        {
            this.s1lv2espagnol1.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s1lv2espagnol2") && !this.s1lv2espagnol2.contains(c))
        {
            this.s1lv2espagnol2.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s1lv2espagnol3") && !this.s1lv2espagnol3.contains(c))
        {
            this.s1lv2espagnol3.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s1lv2italien") && !this.s1lv2italien.contains(c))
        {
            this.s1lv2italien.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s1lv2allemand":
                for (Cours c1 : this.s1lv2allemand)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s1lv2allemand.remove(c1);
                    }
                }
                break;
            case "s1lv2espagnol1":
                for (Cours c1 : this.s1lv2espagnol1)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s1lv2espagnol1.remove(c1);
                    }
                }
                break;
            case "s1lv2espagnol2":
                for (Cours c1 : this.s1lv2espagnol2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s1lv2espagnol2.remove(c1);
                    }
                }
                break;
            case "s1lv2espagnol3":
                for (Cours c1 : this.s1lv2espagnol3)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s1lv2espagnol3.remove(c1);
                    }
                }
                break;
            case "s1lv2italien":
                for (Cours c1 : this.s1lv2italien)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s1lv2italien.remove(c1);
                    }
                }
                break;
        }
    }
}
