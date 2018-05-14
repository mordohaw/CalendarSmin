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
}
