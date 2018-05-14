package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre1 extends Semestre {

    private Semestre1A s1a;
    private Semestre1B s1b;
    private Semestre1C s1c;
    public Semestre1(Semestre1A s1a, Semestre1B s1b, Semestre1C s1c)

    {
        super();
        this.s1a = s1a;
        this.s1b = s1b;
        this.s1c = s1c;
        this.emplois_du_temps.put("s1a", s1a.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s1b", s1b.getEmplois_Du_Temps());
        this.emplois_du_temps.put("s1c", s1c.getEmplois_Du_Temps());
    }


    public Semestre1A getS1a()
    {
        return this.s1a;
    }

    public Semestre1B getS1b()
    {
        return this.s1b;
    }

    public Semestre1C getS1c()
    {
        return this.s1c;
    }

    public void setS1a(Semestre1A s1a)
    {
        this.s1a = s1a;
    }

    public void setS1b(Semestre1B s1b)
    {
        this.s1b = s1b;
    }

    public void setS1c(Semestre1C s1c)
    {
        this.s1c = s1c;
    }

}
