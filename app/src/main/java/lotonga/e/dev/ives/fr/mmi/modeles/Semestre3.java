package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public class Semestre3 extends Semestre {


    public Semestre3(Semestre3A s3a, Semestre3B s3b, Semestre3C s3c )
    {
        super();
        this.emplois_du_temps.put("s3a", s3a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s3b", s3b.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s3c", s3c.getEmplois_Du_Temps());
    }
}
