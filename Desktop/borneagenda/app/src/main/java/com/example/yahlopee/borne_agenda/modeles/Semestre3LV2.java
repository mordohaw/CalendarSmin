package com.example.yahlopee.borne_agenda.modeles;

import java.util.ArrayList;

public class Semestre3LV2 extends SemestreLangue {


    private ArrayList<Cours> s3lv2allemand;
    private ArrayList<Cours> s3lv2espagnol1;
    private ArrayList<Cours> s3lv2espagnol2;
    private ArrayList<Cours> s3lv2espagnol3;
    private ArrayList<Cours> s3lv2italien;

    public Semestre3LV2(Semaine semaine)
    {
        super();
        this.setS3lv2allemand(semaine.getS3LV2Allemand());
        this.setS3lv2espagnol1(semaine.getS3LV2Espagnol1());
        this.setS3lv2espagnol2(semaine.getS3LV2Espagnol2());
        this.setS3lv2espagnol3(semaine.getS3LV2Espagnol3());
        this.setS3lv2italien(semaine.getS3LV2Italien());

        this.emplois_du_temps.put("s3lv2allemand", this.getS3lv2allemand());
        this.emplois_du_temps.put("s3lv2espagnol1", this.getS3lv2espagnol1());
        this.emplois_du_temps.put("s3lv2espagnol2", this.getS3lv2espagnol2());
        this.emplois_du_temps.put("s3lv2espagnol3", this.getS3lv2espagnol3());
        this.emplois_du_temps.put("s3lv2italien", this.getS3lv2italien());

    }


    public ArrayList<Cours> getS3lv2allemand() {
        return s3lv2allemand;
    }

    public void setS3lv2allemand(ArrayList<Cours> s3lv2allemand) {
        this.s3lv2allemand = s3lv2allemand;
    }

    public ArrayList<Cours> getS3lv2espagnol1() {
        return s3lv2espagnol1;
    }

    public void setS3lv2espagnol1(ArrayList<Cours> s3lv2espagnol1) {
        this.s3lv2espagnol1 = s3lv2espagnol1;
    }

    public ArrayList<Cours> getS3lv2espagnol2() {
        return s3lv2espagnol2;
    }

    public void setS3lv2espagnol2(ArrayList<Cours> s3lv2espagnol2) {
        this.s3lv2espagnol2 = s3lv2espagnol2;
    }

    public ArrayList<Cours> getS3lv2espagnol3() {
        return s3lv2espagnol3;
    }

    public void setS3lv2espagnol3(ArrayList<Cours> s3lv2espagnol3) {
        this.s3lv2espagnol3 = s3lv2espagnol3;
    }

    public ArrayList<Cours> getS3lv2italien() {
        return s3lv2italien;
    }

    public void setS3lv2italien(ArrayList<Cours> s3lv2italien) {
        this.s3lv2italien = s3lv2italien;
    }

    @Override
    public void addCours(Cours c) {
        if(c.getGroupe().equalsIgnoreCase("s3lv2allemand") && !this.s3lv2allemand.contains(c))
        {
            this.s3lv2allemand.add(c);
        }
        else if(c.getGroupe().equalsIgnoreCase("s3lv2espagnol1") && !this.s3lv2espagnol1.contains(c))
        {
            this.s3lv2espagnol1.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s3lv2espagnol2") && !this.s3lv2espagnol2.contains(c))
        {
            this.s3lv2espagnol2.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s3lv2espagnol3") && !this.s3lv2espagnol3.contains(c))
        {
            this.s3lv2espagnol3.add(c);
        }
        else if (c.getGroupe().equalsIgnoreCase("s3lv2italien") && !this.s3lv2italien.contains(c))
        {
            this.s3lv2italien.add(c);
        }
    }

    @Override
    public void deleteCours(Cours c) {
        switch (c.getGroupe().toLowerCase())
        {
            case "s3lv2allemand":
                for (Cours c1 : this.s3lv2allemand)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3lv2allemand.remove(c1);
                    }
                }
                break;
            case "s3lv2espagnol1":
                for (Cours c1 : this.s3lv2espagnol1)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3lv2espagnol1.remove(c1);
                    }
                }
                break;
            case "s3lv2espagnol2":
                for (Cours c1 : this.s3lv2espagnol2)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3lv2espagnol2.remove(c1);
                    }
                }
                break;
            case "s3lv2espagnol3":
                for (Cours c1 : this.s3lv2espagnol3)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3lv2espagnol3.remove(c1);
                    }
                }
                break;
            case "s3lv2italien":
                for (Cours c1 : this.s3lv2italien)
                {
                    if(c1.getUid().equalsIgnoreCase(c.getUid()))
                    {
                        this.s3lv2italien.remove(c1);
                    }
                }
                break;
        }
    }
}
