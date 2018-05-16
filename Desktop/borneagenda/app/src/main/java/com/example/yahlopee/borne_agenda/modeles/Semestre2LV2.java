package com.example.yahlopee.borne_agenda.modeles;

import java.util.ArrayList;

public class Semestre2LV2 extends SemestreLangue {

    private ArrayList<Cours> s2lv2allemand;
    private ArrayList<Cours> s2lv2espagnol1;
    private ArrayList<Cours> s2lv2espagnol2;
    private ArrayList<Cours> s2lv2espagnol3;
    private ArrayList<Cours> s2lv2italien;

    public Semestre2LV2(Semaine semaine)
    {
        super();
        this.setS2lv2allemand(semaine.getS2LV2Allemand());
        this.setS2lv2espagnol1(semaine.getS2LV2Espagnol1());
        this.setS2lv2espagnol2(semaine.getS2LV2Espagnol2());
        this.setS2lv2espagnol3(semaine.getS2LV2Espagnol3());
        this.setS2lv2italien(semaine.getS2LV2Italien());

        this.emplois_du_temps.put("s2lv2allemand", this.getS2lv2allemand());
        this.emplois_du_temps.put("s2lv2espagnol1", this.getS2lv2espagnol1());
        this.emplois_du_temps.put("s2lv2espagnol2", this.getS2lv2espagnol2());
        this.emplois_du_temps.put("s2lv2espagnol3", this.getS2lv2espagnol3());
        this.emplois_du_temps.put("s2lv2italien", this.getS2lv2italien());
    }


    public ArrayList<Cours> getS2lv2allemand() {
        return s2lv2allemand;
    }

    public void setS2lv2allemand(ArrayList<Cours> s2lv2allemand) {
        this.s2lv2allemand = s2lv2allemand;
    }

    public ArrayList<Cours> getS2lv2espagnol1() {
        return s2lv2espagnol1;
    }

    public void setS2lv2espagnol1(ArrayList<Cours> s2lv2espagnol1) {
        this.s2lv2espagnol1 = s2lv2espagnol1;
    }

    public ArrayList<Cours> getS2lv2espagnol2() {
        return s2lv2espagnol2;
    }

    public void setS2lv2espagnol2(ArrayList<Cours> s2lv2espagnol2) {
        this.s2lv2espagnol2 = s2lv2espagnol2;
    }

    public ArrayList<Cours> getS2lv2espagnol3() {
        return s2lv2espagnol3;
    }

    public void setS2lv2espagnol3(ArrayList<Cours> s2lv2espagnol3) {
        this.s2lv2espagnol3 = s2lv2espagnol3;
    }

    public ArrayList<Cours> getS2lv2italien() {
        return s2lv2italien;
    }

    public void setS2lv2italien(ArrayList<Cours> s2lv2italien) {
        this.s2lv2italien = s2lv2italien;
    }

    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s1lv2allemand") && !this.s2lv2allemand.contains(c))
        {
            this.s2lv2allemand.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s1lv2espagnol1") && !this.s2lv2espagnol1.contains(c))
        {
            this.s2lv2espagnol1.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s1lv2espagnol2") && !this.s2lv2espagnol2.contains(c))
        {
            this.s2lv2espagnol2.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s1lv2espagnol3") && !this.s2lv2espagnol3.contains(c))
        {
            this.s2lv2espagnol3.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s1lv2italien") && !this.s2lv2italien.contains(c))
        {
            this.s2lv2italien.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s2lv2allemand":
                for (Cours c1 : this.s2lv2allemand)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2lv2allemand.remove(c1);
                    }
                }
                break;
            case "s2lv2espagnol1":
                for (Cours c1 : this.s2lv2espagnol1)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2lv2espagnol1.remove(c1);
                    }
                }
                break;
            case "s2lv2espagnol2":
                for (Cours c1 : this.s2lv2espagnol2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2lv2espagnol2.remove(c1);
                    }
                }
                break;
            case "s2lv2espagnol3":
                for (Cours c1 : this.s2lv2espagnol3)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2lv2espagnol3.remove(c1);
                    }
                }
                break;
            case "s2lv2italien":
                for (Cours c1 : this.s2lv2italien)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s2lv2italien.remove(c1);
                    }
                }
                break;
        }
    }
}
