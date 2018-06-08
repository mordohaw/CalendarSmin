package lotonga.e.dev.ives.fr.mmi.modeles;


import android.util.Log;

import net.fortuna.ical4j.model.component.VEvent;

import java.util.ArrayList;

/**
 * Cette classe sert à classer les cours selon leur semestre et leur groupe
 * Elle gere une liste de cours pour une ou plusieurs semaines
 */
public class Semaine {

    /**
     * Groupe Amphi
     */
    private ArrayList<Cours> s1;
    private ArrayList<Cours> s2;
    private ArrayList<Cours> s3;
    private ArrayList<Cours> s4;

    /**
     * Groupe TP
     */
    private ArrayList<Cours> s1a;
    private ArrayList<Cours> s1b;
    private ArrayList<Cours> s1c;
    private ArrayList<Cours> s2a;
    private ArrayList<Cours> s2b;
    private ArrayList<Cours> s2c;
    private ArrayList<Cours> s3a;
    private ArrayList<Cours> s3b;
    private ArrayList<Cours> s3c;
    private ArrayList<Cours> s4a;
    private ArrayList<Cours> s4b;
    private ArrayList<Cours> s4c;

    /**
     * Groupe TD
     */
    private ArrayList<Cours> s1a1;
    private ArrayList<Cours> s1a2;
    private ArrayList<Cours> s1b1;
    private ArrayList<Cours> s1b2;
    private ArrayList<Cours> s1c1;
    private ArrayList<Cours> s1c2;
    private ArrayList<Cours> s2a1;
    private ArrayList<Cours> s2a2;
    private ArrayList<Cours> s2b1;
    private ArrayList<Cours> s2b2;
    private ArrayList<Cours> s2c1;
    private ArrayList<Cours> s2c2;
    private ArrayList<Cours> s3a1;
    private ArrayList<Cours> s3a2;
    private ArrayList<Cours> s3b1;
    private ArrayList<Cours> s3b2;
    private ArrayList<Cours> s3c1;
    private ArrayList<Cours> s3c2;
    private ArrayList<Cours> s4a1;
    private ArrayList<Cours> s4a2;
    private ArrayList<Cours> s4b1;
    private ArrayList<Cours> s4b2;
    private ArrayList<Cours> s4c1;
    private ArrayList<Cours> s4c2;
    private ArrayList<Cours> LPSMIN;

    /**
     * Cours de langue
     */
    private ArrayList<Cours> s1LV2Allemand;
    private ArrayList<Cours> s1LV2Espagnol1;
    private ArrayList<Cours> s1LV2Espagnol2;
    private ArrayList<Cours> s1LV2Espagnol3;
    private ArrayList<Cours> s1LV2Italien;
    private ArrayList<Cours> s2LV2Allemand;
    private ArrayList<Cours> s2LV2Espagnol1;
    private ArrayList<Cours> s2LV2Espagnol2;
    private ArrayList<Cours> s2LV2Espagnol3;
    private ArrayList<Cours> s2LV2Italien;
    private ArrayList<Cours> s3LV2Allemand;
    private ArrayList<Cours> s3LV2Espagnol1;
    private ArrayList<Cours> s3LV2Espagnol2;
    private ArrayList<Cours> s3LV2Espagnol3;
    private ArrayList<Cours> s3LV2Italien;

    public Semaine()
    {
        this.s1 = new ArrayList<>();
        this.s2 = new ArrayList<>();
        this.s3 = new ArrayList<>();
        this.s4 = new ArrayList<>();

        this.s1a = new ArrayList<>();
        this.s1b = new ArrayList<>();
        this.s1c = new ArrayList<>();
        this.s2a = new ArrayList<>();
        this.s2b = new ArrayList<>();
        this.s2c = new ArrayList<>();
        this.s3a = new ArrayList<>();
        this.s3b = new ArrayList<>();
        this.s3c = new ArrayList<>();
        this.s4a = new ArrayList<>();
        this.s4b = new ArrayList<>();
        this.s4c = new ArrayList<>();

        this.s1a1 = new ArrayList<>();
        this.s1a2 = new ArrayList<>();
        this.s1b1 = new ArrayList<>();
        this.s1b2 = new ArrayList<>();
        this.s1c1 = new ArrayList<>();
        this.s1c2 = new ArrayList<>();
        this.s2a1 = new ArrayList<>();
        this.s2a2 = new ArrayList<>();
        this.s2b1 = new ArrayList<>();
        this.s2b2 = new ArrayList<>();
        this.s2c1 = new ArrayList<>();
        this.s2c2 = new ArrayList<>();
        this.s3a1 = new ArrayList<>();
        this.s3a2 = new ArrayList<>();
        this.s3b1 = new ArrayList<>();
        this.s3b2 = new ArrayList<>();
        this.s3c1 = new ArrayList<>();
        this.s3c2 = new ArrayList<>();
        this.s4a1 = new ArrayList<>();
        this.s4a2 = new ArrayList<>();
        this.s4b1 = new ArrayList<>();
        this.s4b2 = new ArrayList<>();
        this.s4c1 = new ArrayList<>();
        this.s4c2 = new ArrayList<>();
        this.LPSMIN = new ArrayList<>();

        this.s1LV2Allemand = new ArrayList<>();
        this.s1LV2Espagnol1 = new ArrayList<>();
        this.s1LV2Espagnol2 = new ArrayList<>();
        this.s1LV2Espagnol3 = new ArrayList<>();
        this.s1LV2Italien = new ArrayList<>();
        this.s2LV2Allemand = new ArrayList<>();
        this.s2LV2Espagnol1 = new ArrayList<>();
        this.s2LV2Espagnol2 = new ArrayList<>();
        this.s2LV2Espagnol3 = new ArrayList<>();
        this.s2LV2Italien = new ArrayList<>();
        this.s3LV2Allemand = new ArrayList<>();
        this.s3LV2Espagnol1 = new ArrayList<>();
        this.s3LV2Espagnol2 = new ArrayList<>();
        this.s3LV2Espagnol3 = new ArrayList<>();
        this.s3LV2Italien = new ArrayList<>();
    }

    public boolean supprimerCours(Cours c, boolean coursLangue) throws IllegalArgumentException
    {
        boolean coursSupprimer = false;
        if( c.getGroupe().equalsIgnoreCase("lpsmin"))
        {
            for (Cours c1 : this.LPSMIN)
            {
                if(c1.getUid().equalsIgnoreCase(c.getUid()))
                {
                    this.LPSMIN.remove(c1);
                }
            }
        }
        if(coursLangue) // Traitement du cas d'un cours de langues { Allemand, espagnol et Italien }
        {

            switch (c.getGroupe().toLowerCase())
            {
                case "s1lv2allemand":
                    for (Cours c1 : this.getS1LV2Allemand())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1LV2Allemand().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1lv2espagnol1":
                    for (Cours c1 : this.getS1LV2Espagnol1())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1LV2Espagnol1().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1lv2espagnol2":
                    for (Cours c1 : this.getS1LV2Espagnol2())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1LV2Espagnol2().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1lv2espagnol3":
                    for (Cours c1 : this.getS1LV2Espagnol3())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1LV2Espagnol3().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1lv2italien":
                    for (Cours c1 : this.getS1LV2Italien())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1LV2Italien().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;

                case "s2lv2allemand":
                    for (Cours c1 : this.getS2LV2Allemand())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2LV2Allemand().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2lv2espagnol1":
                    for (Cours c1 : this.getS2LV2Espagnol1())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2LV2Espagnol1().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2lv2espagnol2":
                    for (Cours c1 : this.getS2LV2Espagnol2())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2LV2Espagnol2().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2lv2espagnol3":
                    for (Cours c1 : this.getS2LV2Espagnol3())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2LV2Espagnol3().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2lv2italien":
                    for (Cours c1 : this.getS2LV2Italien())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2LV2Italien().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;

                case "s3lv2allemand":
                    for (Cours c1 : this.getS3LV2Allemand())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3LV2Allemand().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3lv2espagnol1":
                    for (Cours c1 : this.getS3LV2Espagnol1())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3LV2Espagnol1().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3lv2espagnol2":
                    for (Cours c1 : this.getS3LV2Espagnol2())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3LV2Espagnol2().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3lv2espagnol3":
                    for (Cours c1 : this.getS3LV2Espagnol3())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3LV2Espagnol3().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3lv2italien":
                    for (Cours c1 : this.getS3LV2Italien())
                    { // On parcours les cours allemand du semestre 1
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3LV2Italien().remove(c1); // On supprime le cours spécifié en arguments
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Impossible d'identifié le cours de langue ! Identifiant invalide => ******** *" + c.getGroupe()+"* ********");

            }
        }
        else
        { // traitement du cas d'un cours normal
            switch (c.getGroupe().toLowerCase())
            {
                case "s1a":
                    for (Cours c1 : this.getS1a() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1a().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1b":
                    for (Cours c1 : this.getS1b() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1b().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1c":
                    for (Cours c1 : this.getS1c() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1c().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2a":
                    for (Cours c1 : this.getS2a() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2a().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2b":
                    for (Cours c1 : this.getS2b() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2b().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2c":
                    for (Cours c1 : this.getS2c() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2c().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3a":
                    for (Cours c1 : this.getS3a() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3a().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3b":
                    for (Cours c1 : this.getS3b() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3b().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3c":
                    for (Cours c1 : this.getS3c() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3c().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4a":
                    for (Cours c1 : this.getS4a() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4a().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4b":
                    for (Cours c1 : this.getS4b() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4b().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4c":
                    for (Cours c1 : this.getS4c() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4c().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1a1":
                    for (Cours c1 : this.getS1a1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1a1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1a2":
                    for (Cours c1 : this.getS1a2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1a2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1b1":
                    for (Cours c1 : this.getS1b1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1b1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1b2":
                    for (Cours c1 : this.getS1b2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1b2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1c1":
                    for (Cours c1 : this.getS1c1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1c1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s1c2":
                    for (Cours c1 : this.getS1c2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS1c2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2a1":
                    for (Cours c1 : this.getS2a1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2a1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2a2":
                    for (Cours c1 : this.getS2a2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2a2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2b1":
                    for (Cours c1 : this.getS2b1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2b1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2b2":
                    for (Cours c1 : this.getS2b2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2b2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2c1":
                    for (Cours c1 : this.getS2c1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2c1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s2c2":
                    for (Cours c1 : this.getS2c2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS2c2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3a1":
                    for (Cours c1 : this.getS3a1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3a1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3a2":
                    for (Cours c1 : this.getS3a2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3a2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3b1":
                    for (Cours c1 : this.getS3b1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3b1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3b2":
                    for (Cours c1 : this.getS3b2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3b2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3c1":
                    for (Cours c1 : this.getS3c1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3c1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s3c2":
                    for (Cours c1 : this.getS3c2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS3c2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4a1":
                    for (Cours c1 : this.getS4a1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4a1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4a2":
                    for (Cours c1 : this.getS4a2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4a2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4b1":
                    for (Cours c1 : this.getS4b1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4b1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4b2":
                    for (Cours c1 : this.getS4b2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4b2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4c1":
                    for (Cours c1 : this.getS4c1() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4c1().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
                case "s4c2":
                    for (Cours c1 : this.getS4c2() )
                    {
                        if(c1.getUid().equalsIgnoreCase(c.getUid()))
                        {
                            this.getS4c2().remove(c);
                            coursSupprimer = true;
                            break;
                        }
                    }
                    break;
            }
        }
        return coursSupprimer;
    }


    /**
     * Gerer l'ajout d'un cours contenant plusieurs groupes dans des tableau respectifs
     * @param p_groupe le groupe du cours en miniscule
     */
    public void gererAjoutDesCoursAvecPlusieurGroupes(Cours c, String p_groupe)
    {
        String[] groupes = p_groupe.split("-");
        for (String ch: groupes )
        {
            c.setGroupe(ch);
            try
            {
                this.ajoutCours(c);
            }
            catch (Exception e)
            {
                Log.d("DEBUG", "ajoutCours: "+ e.getMessage());
            }
        }
    }
    /*
    *   Ajout d'un cours dynamiquement au bon endroit !
    *   @params s Cours le cours à ajouter
    */
    public void ajoutCours(Cours c) throws IllegalAccessException
    {
        String lower_groupe = c.getGroupe().toLowerCase();
        if(lower_groupe.contains("-"))
        {
            this.gererAjoutDesCoursAvecPlusieurGroupes(c,lower_groupe);
            return;
        }

        switch ( lower_groupe )
        {
            case "lpsmin":
                this.LPSMIN.add(c);
                break;
            case "s1":
                this.s1.add(c);
                break;
            case "s2":
                this.s2.add(c);
                break;
            case "s3":
                this.s3.add(c);
                break;
            case "s4":
                this.s4.add(c);
                break;
            case "s1a":
                this.s1a.add(c);
                break;
            case "s1b":
                this.s1b.add(c);
                break;
            case "s1c":
                this.s1c.add(c);
                break;
            case "s2a":
                this.s2a.add(c);
                break;
            case "s2b":
                this.s2a.add(c);
                break;
            case "s2c":
                this.s2c.add(c);
                break;
            case "s3a":
                this.s3a.add(c);
                break;
            case "s3b":
                this.s3b.add(c);
                Log.d("Success", "ajoutCours:  S3B");
                break;
            case "s3c":
                this.s3c.add(c);
                break;
            case "s4a":
                this.s4a.add(c);
                break;
            case "s4b":
                this.s4b.add(c);
                break;
            case "s4c":
                this.s4c.add(c);
                break;
            case "s1a1":
                this.s1a1.add(c);
                break;
            case "s1a2":
                this.s1a2.add(c);
                break;
            case "s1b1":
                this.s1b1.add(c);
                break;
            case "s1b2":
                this.s1b2.add(c);
                break;
            case "s1c1":
                this.s1c1.add(c);
                break;
            case "s1c2":
                this.s1c2.add(c);
                break;
            case "s2a1":
                this.s2a1.add(c);
                break;
            case "s2a2":
                this.s2a2.add(c);
                break;
            case "s2b1":
                this.s2b1.add(c);
                break;
            case "s2b2":
                this.s2b2.add(c);
                break;
            case "s2c1":
                this.s2c1.add(c);
                break;
            case "s2c2":
                this.s2c2.add(c);
                break;
            case "s3a1":
                this.s3a1.add(c);
                break;
            case "s3a2":
                this.s3a2.add(c);
                break;
            case "s3b1":
                this.s3b1.add(c);
                break;
            case "s3b2":
                this.s3b2.add(c);
                break;
            case "s3c1":
                this.s3c1.add(c);
                break;
            case "s3c2":
                this.s3c2.add(c);
                break;
            case "s4a1":
                this.s4a1.add(c);
                break;
            case "s4a2":
                this.s4a2.add(c);
                break;
            case "s4b1":
                this.s4b1.add(c);
                break;
            case "s4b2":
                this.s4b2.add(c);
                break;
            case "s4c1":
                this.s4c1.add(c);
                break;
            case "s4c2":
                this.s4c2.add(c);
                break;
            case "s1lv2allemand":
                this.s1LV2Allemand.add(c);
                break;
            case "s1lv2espagnol1":
                this.s1LV2Espagnol1.add(c);
                break;
            case "s1lv2espagnol2":
                this.s1LV2Espagnol2.add(c);
                break;
            case "s1lv2espagnol3":
                this.s1LV2Espagnol3.add(c);
                break;
            case "s1lv2italien":
                this.s1LV2Italien.add(c);
                break;
            case "s2lv2allemand":
                this.s2LV2Allemand.add(c);
                break;
            case "s2lv2espagnol1":
                this.s2LV2Espagnol1.add(c);
                break;
            case "s2lv2espagnol2":
                this.s2LV2Espagnol2.add(c);
                break;
            case "s2lv2espagnol3":
                this.s2LV2Espagnol3.add(c);
                break;
            case "s2lv2italien":
                this.s2LV2Italien.add(c);
                break;
            case "s3lv2allemand":
                this.s3LV2Allemand.add(c);
                break;
            case "s3lv2espagnol1":
                this.s3LV2Espagnol1.add(c);
                break;
            case "s3lv2espagnol2":
                this.s3LV2Espagnol2.add(c);
                break;
            case "s3lv2espagnol3":
                this.s3LV2Espagnol3.add(c);
                break;
            case "s3lv2italien":
                this.s3LV2Italien.add(c);
                break;
            default:
                Log.d("ERREUR", "ajoutCours: ERREUR !!!!");
                throw new IllegalAccessException("L'identifiant du cours invalide ! => ******** *"+ c.getGroupe() +"* ********" );
        }
    }


    public ArrayList<Cours> getS1() {
        return s1;
    }

    public void setS1(ArrayList<Cours> s1) {
        this.s1 = s1;
    }

    public ArrayList<Cours> getS2() {
        return s2;
    }

    public void setS2(ArrayList<Cours> s2) {
        this.s2 = s2;
    }

    public ArrayList<Cours> getS3() {
        return s3;
    }

    public void setS3(ArrayList<Cours> s3) {
        this.s3 = s3;
    }

    public ArrayList<Cours> getS4() {
        return s4;
    }

    public void setS4(ArrayList<Cours> s4) {
        this.s4 = s4;
    }

    public ArrayList<Cours> getS1a() {
        return s1a;
    }

    public void setS1a(ArrayList<Cours> s1a) {
        this.s1a = s1a;
    }

    public ArrayList<Cours> getS1b() {
        return s1b;
    }

    public void setS1b(ArrayList<Cours> s1b) {
        this.s1b = s1b;
    }

    public ArrayList<Cours> getS1c() {
        return s1c;
    }

    public void setS1c(ArrayList<Cours> s1c) {
        this.s1c = s1c;
    }

    public ArrayList<Cours> getS2a() {
        return s2a;
    }

    public void setS2a(ArrayList<Cours> s2a) {
        this.s2a = s2a;
    }

    public ArrayList<Cours> getS2b() {
        return s2b;
    }

    public void setS2b(ArrayList<Cours> s2b) {
        this.s2b = s2b;
    }

    public ArrayList<Cours> getS2c() {
        return s2c;
    }

    public void setS2c(ArrayList<Cours> s2c) {
        this.s2c = s2c;
    }

    public ArrayList<Cours> getS3a() {
        return s3a;
    }

    public void setS3a(ArrayList<Cours> s3a) {
        this.s3a = s3a;
    }

    public ArrayList<Cours> getS3b() {
        return s3b;
    }

    public void setS3b(ArrayList<Cours> s3b) {
        this.s3b = s3b;
    }

    public ArrayList<Cours> getS3c() {
        return s3c;
    }

    public void setS3c(ArrayList<Cours> s3c) {
        this.s3c = s3c;
    }

    public ArrayList<Cours> getS4a() {
        return s4a;
    }

    public void setS4a(ArrayList<Cours> s4a) {
        this.s4a = s4a;
    }

    public ArrayList<Cours> getS4b() {
        return s4b;
    }

    public void setS4b(ArrayList<Cours> s4b) {
        this.s4b = s4b;
    }

    public ArrayList<Cours> getS4c() {
        return s4c;
    }

    public void setS4c(ArrayList<Cours> s4c) {
        this.s4c = s4c;
    }

    public void setS1a1(ArrayList<Cours> s1a1) {
        this.s1a1 = s1a1;
    }

    public void setS1a2(ArrayList<Cours> s1a2) {
        this.s1a2 = s1a2;
    }

    public void setS1b1(ArrayList<Cours> s1b1) {
        this.s1b1 = s1b1;
    }

    public void setS1b2(ArrayList<Cours> s1b2) {
        this.s1b2 = s1b2;
    }

    public void setS1c1(ArrayList<Cours> s1c1) {
        this.s1c1 = s1c1;
    }

    public void setS1c2(ArrayList<Cours> s1c2) {
        this.s1c2 = s1c2;
    }

    public void setS2a1(ArrayList<Cours> s2a1) {
        this.s2a1 = s2a1;
    }

    public void setS2a2(ArrayList<Cours> s2a2) {
        this.s2a2 = s2a2;
    }

    public void setS2b1(ArrayList<Cours> s2b1) {
        this.s2b1 = s2b1;
    }

    public void setS2b2(ArrayList<Cours> s2b2) {
        this.s2b2 = s2b2;
    }

    public void setS2c1(ArrayList<Cours> s2c1) {
        this.s2c1 = s2c1;
    }

    public void setS2c2(ArrayList<Cours> s2c2) {
        this.s2c2 = s2c2;
    }

    public void setS3a1(ArrayList<Cours> s3a1) {
        this.s3a1 = s3a1;
    }

    public void setS3a2(ArrayList<Cours> s3a2) {
        this.s3a2 = s3a2;
    }

    public void setS3b1(ArrayList<Cours> s3b1) {
        this.s3b1 = s3b1;
    }

    public void setS3b2(ArrayList<Cours> s3b2) {
        this.s3b2 = s3b2;
    }

    public void setS3c1(ArrayList<Cours> s3c1) {
        this.s3c1 = s3c1;
    }

    public void setS3c2(ArrayList<Cours> s3c2) {
        this.s3c2 = s3c2;
    }

    public void setS4a1(ArrayList<Cours> s4a1) {
        this.s4a1 = s4a1;
    }

    public void setS4a2(ArrayList<Cours> s4a2) {
        this.s4a2 = s4a2;
    }

    public void setS4b1(ArrayList<Cours> s4b1) {
        this.s4b1 = s4b1;
    }

    public void setS4b2(ArrayList<Cours> s4b2) {
        this.s4b2 = s4b2;
    }

    public void setS4c1(ArrayList<Cours> s4c1) {
        this.s4c1 = s4c1;
    }

    public void setS4c2(ArrayList<Cours> s4c2) {
        this.s4c2 = s4c2;
    }

    public void setLPSMIN(ArrayList<Cours> LPSMIN) {
        this.LPSMIN = LPSMIN;
    }

    public void setS1LV2Allemand(ArrayList<Cours> s1LV2Allemand) {
        this.s1LV2Allemand = s1LV2Allemand;
    }

    public void setS1LV2Espagnol1(ArrayList<Cours> s1LV2Espagnol1) {
        this.s1LV2Espagnol1 = s1LV2Espagnol1;
    }

    public void setS1LV2Espagnol2(ArrayList<Cours> s1LV2Espagnol2) {
        this.s1LV2Espagnol2 = s1LV2Espagnol2;
    }

    public void setS1LV2Espagnol3(ArrayList<Cours> s1LV2Espagnol3) {
        this.s1LV2Espagnol3 = s1LV2Espagnol3;
    }

    public void setS1LV2Italien(ArrayList<Cours> s1LV2Italien) {
        this.s1LV2Italien = s1LV2Italien;
    }

    public void setS2LV2Allemand(ArrayList<Cours> s2LV2Allemand) {
        this.s2LV2Allemand = s2LV2Allemand;
    }

    public void setS2LV2Espagnol1(ArrayList<Cours> s2LV2Espagnol1) {
        this.s2LV2Espagnol1 = s2LV2Espagnol1;
    }

    public void setS2LV2Espagnol2(ArrayList<Cours> s2LV2Espagnol2) {
        this.s2LV2Espagnol2 = s2LV2Espagnol2;
    }

    public void setS2LV2Espagnol3(ArrayList<Cours> s2LV2Espagnol3) {
        this.s2LV2Espagnol3 = s2LV2Espagnol3;
    }

    public void setS2LV2Italien(ArrayList<Cours> s2LV2Italien) {
        this.s2LV2Italien = s2LV2Italien;
    }

    public void setS3LV2Allemand(ArrayList<Cours> s3LV2Allemand) {
        this.s3LV2Allemand = s3LV2Allemand;
    }

    public void setS3LV2Espagnol1(ArrayList<Cours> s3LV2Espagnol1) {
        this.s3LV2Espagnol1 = s3LV2Espagnol1;
    }

    public void setS3LV2Espagnol2(ArrayList<Cours> s3LV2Espagnol2) {
        this.s3LV2Espagnol2 = s3LV2Espagnol2;
    }

    public void setS3LV2Espagnol3(ArrayList<Cours> s3LV2Espagnol3) {
        this.s3LV2Espagnol3 = s3LV2Espagnol3;
    }

    public void setS3LV2Italien(ArrayList<Cours> s3LV2Italien) {
        this.s3LV2Italien = s3LV2Italien;
    }

    public ArrayList<Cours> getS1a1() {
        return s1a1;
    }

    public ArrayList<Cours> getS1a2() {
        return s1a2;
    }

    public ArrayList<Cours> getS1b1() {
        return s1b1;
    }

    public ArrayList<Cours> getS1b2() {
        return s1b2;
    }

    public ArrayList<Cours> getS1c1() {
        return s1c1;
    }

    public ArrayList<Cours> getS1c2() {
        return s1c2;
    }

    public ArrayList<Cours> getS2a1() {
        return s2a1;
    }

    public ArrayList<Cours> getS2a2() {
        return s2a2;
    }

    public ArrayList<Cours> getS2b1() {
        return s2b1;
    }

    public ArrayList<Cours> getS2b2() {
        return s2b2;
    }

    public ArrayList<Cours> getS2c1() {
        return s2c1;
    }

    public ArrayList<Cours> getS2c2() {
        return s2c2;
    }

    public ArrayList<Cours> getS3a1() {
        return s3a1;
    }

    public ArrayList<Cours> getS3a2() {
        return s3a2;
    }

    public ArrayList<Cours> getS3b1() {
        return s3b1;
    }

    public ArrayList<Cours> getS3b2() {
        return s3b2;
    }

    public ArrayList<Cours> getS3c1() {
        return s3c1;
    }

    public ArrayList<Cours> getS3c2() {
        return s3c2;
    }

    public ArrayList<Cours> getS4a1() {
        return s4a1;
    }

    public ArrayList<Cours> getS4a2() {
        return s4a2;
    }

    public ArrayList<Cours> getS4b1() {
        return s4b1;
    }

    public ArrayList<Cours> getS4b2() {
        return s4b2;
    }

    public ArrayList<Cours> getS4c1() {
        return s4c1;
    }

    public ArrayList<Cours> getS4c2() {
        return s4c2;
    }

    public ArrayList<Cours> getLPSMIN() {
        return LPSMIN;
    }

    public ArrayList<Cours> getS1LV2Allemand() {
        return s1LV2Allemand;
    }

    public ArrayList<Cours> getS1LV2Espagnol1() {
        return s1LV2Espagnol1;
    }

    public ArrayList<Cours> getS1LV2Espagnol2() {
        return s1LV2Espagnol2;
    }

    public ArrayList<Cours> getS1LV2Espagnol3() {
        return s1LV2Espagnol3;
    }

    public ArrayList<Cours> getS1LV2Italien() {
        return s1LV2Italien;
    }

    public ArrayList<Cours> getS2LV2Allemand() {
        return s2LV2Allemand;
    }

    public ArrayList<Cours> getS2LV2Espagnol1() {
        return s2LV2Espagnol1;
    }

    public ArrayList<Cours> getS2LV2Espagnol2() {
        return s2LV2Espagnol2;
    }

    public ArrayList<Cours> getS2LV2Espagnol3() {
        return s2LV2Espagnol3;
    }

    public ArrayList<Cours> getS2LV2Italien() {
        return s2LV2Italien;
    }

    public ArrayList<Cours> getS3LV2Allemand() {
        return s3LV2Allemand;
    }

    public ArrayList<Cours> getS3LV2Espagnol1() {
        return s3LV2Espagnol1;
    }

    public ArrayList<Cours> getS3LV2Espagnol2() {
        return s3LV2Espagnol2;
    }

    public ArrayList<Cours> getS3LV2Espagnol3() {
        return s3LV2Espagnol3;
    }

    public ArrayList<Cours> getS3LV2Italien() {
        return s3LV2Italien;
    }

}
