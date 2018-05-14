package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class LPSMIN {
    private ArrayList<Cours> LPSMIN;

    public LPSMIN(Semaine semaine)
    {
        this.LPSMIN = semaine.getLPSMIN();

    }

    public ArrayList<Cours> getEmplois_du_temps() {
        return LPSMIN;
    }
    public void setEmplois_du_temps(ArrayList<Cours> emplois_du_temps)
    {
        this.LPSMIN = emplois_du_temps;
    }

    public void addCours(Cours c)
    {
        if(c.getGroupe().equalsIgnoreCase("lpsmin") && !this.LPSMIN.contains(c))
        {
            this.LPSMIN.add(c);
        }
    }

    public void deleteCours(Cours c)
    {
        for (Cours c1 : this.LPSMIN )
        {
            if(c1.getUid().equalsIgnoreCase(c.getUid()))
            {
                this.LPSMIN.remove(c1);
            }
        }
    }
}
