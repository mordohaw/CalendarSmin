package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SousSemestre {

    /**
     * le tableau des cours => gerer par la classe Semaine
     * ["S1A"=> [cours1, cours2, cours3],"S2B"=> [cours1, cours2, cours3], "S3C"=> [cours1, cours2, cours3] ]
     */
    protected HashMap<String, ArrayList<Cours> > emplois_du_temps;

    public SousSemestre()
    {
        this.emplois_du_temps = new HashMap<>();
    }

    public HashMap<String, ArrayList<Cours> > getEmplois_Du_Temps()
    {
        return this.emplois_du_temps;
    }

    public abstract void addCours(Cours c);
    public abstract void deleteCours(Cours c);
}
