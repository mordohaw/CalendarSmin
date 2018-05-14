package lotonga.e.dev.ives.fr.mmi.utilitaires;

import net.fortuna.ical4j.model.Date;

public class DateCustom {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;
    private int seconde;

    /**
     *
     * @param chaine String format =>  jj:mm:yyyy:h:min:s 11:05:2018:14:38:00
     */
    public DateCustom(String chaine)
    {
        String[] tmp_array = chaine.split(":");
        if(tmp_array.length < 6)
        {
            throw new IllegalArgumentException("Chaine Datetime invalide !");
        }
        this.setJour(Integer.parseInt(tmp_array[0]));
        this.setMois(Integer.parseInt(tmp_array[1]));
        this.setAnnee(Integer.parseInt(tmp_array[2]));
        this.setHeure(Integer.parseInt(tmp_array[3]));
        this.setMinute(Integer.parseInt(tmp_array[4]));
        this.setSeconde(Integer.parseInt(tmp_array[5]));
    }

    public DateCustom(Date date)
    {
        this.annee = date.getYear();
        this.mois = date.getMonth();
        this.jour = date.getDay();
        this.heure = date.getHours();
        this.minute = date.getMinutes();
        this.seconde = date.getSeconds();
    }


    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public int getJour()
    {
        return this.jour;
    }

    public int getMois()
    {
        return this.mois;
    }

    public int getAnnee()
    {
        return  this.annee;
    }

    public int getHeure()
    {
        return this.heure;
    }

    public int getMinute()
    {
        return this.minute;
    }

    public int getSeconde()
    {
        return this.seconde;
    }

    /**
     * Compare deux dates. la date de l'objet actuel =>this.date et la date passé en argument => date
     * @param date
     * @return int 1 [Plus grand] 0 [ égalité ] -1 [ Plus petit ]
     */
    public int plusGrandQue(DateCustom date)
    {
        int plusGrand = 1;
        if(this.getAnnee() == date.getAnnee())
        {
            if(this.getMois() == date.getMois())
            {
                if(this.getJour() == date.getJour())
                {
                    if(this.getHeure() == date.getHeure())
                    {
                        if(this.getMinute() == date.getMinute())
                        {
                            if(this.getSeconde() == date.getSeconde())
                            {
                                plusGrand = 0;
                            }
                            else if (this.getSeconde() < date.getSeconde())
                            {
                                plusGrand = -1;
                            }
                        }
                        else if(this.getMinute() < date.getMinute())
                        {
                            plusGrand = -1;
                        }
                    }
                    else if(this.getHeure() < date.getHeure())
                    {
                        plusGrand = -1;
                    }
                }
                else if(this.getJour() < date.getJour())
                {
                    plusGrand = -1;
                }
            }
            else if (this.getMois() < date.getMois())
            {
                plusGrand = -1;
            }

        }
        else if(this.getAnnee() < date.getAnnee())
        {
            plusGrand = -1;
        }
        return plusGrand;

    }

    public String toString()
    {
        String chaine = String.format("%d:%d:%d:%d:%d:%d",this.getJour(),this.getMois(),this.getAnnee(),this.getHeure(),this.getMinute(),this.getSeconde());
        return chaine;
    }
}
