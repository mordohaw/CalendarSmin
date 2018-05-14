package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre2 extends Semestre {

    public Semestre2( Semestre2A s2a, Semestre2B s2b, Semestre2C s2c)

    {
        super();
        this.emplois_du_temps.put("s2a", s2a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s2b", s2b.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s2c", s2c.getEmplois_Du_Temps());
    }
}
