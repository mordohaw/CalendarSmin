package lotonga.e.dev.ives.fr.mmi.modeles;


import android.util.Log;

import net.fortuna.ical4j.model.component.VEvent;

import java.util.ArrayList;

/**
 * Cette classe sert à classer les cours selon leur semestre et leur groupe
 * Elle gere une liste de cours pour une ou plusieurs semaines
 */
public class Semaine {

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


    /*
    *   Ajout d'un cours dynamiquement au bon endroit !
    *   @params s Cours le cours à ajouter
    */
    public void ajoutCours(Cours s) throws IllegalAccessException {
        switch ( s.getGroupe().toLowerCase() )
        {
            case "lpsmin":
                this.LPSMIN.add(s);
                break;
            case "s1a1":
                this.s1a1.add(s);
                break;
            case "s1a2":
                this.s1a2.add(s);
                break;
            case "s1b1":
                this.s1b1.add(s);
                break;
            case "s1b2":
                this.s1b2.add(s);
                break;
            case "s1c1":
                this.s1c1.add(s);
                break;
            case "s1c2":
                this.s1c2.add(s);
                break;
            case "s2a1":
                this.s2a1.add(s);
                break;
            case "s2a2":
                this.s2a2.add(s);
                break;
            case "s2b1":
                this.s2b1.add(s);
                break;
            case "s2b2":
                this.s2b2.add(s);
                break;
            case "s2c1":
                this.s2c1.add(s);
                break;
            case "s2c2":
                this.s2c2.add(s);
                break;
            case "s3a1":
                this.s3a1.add(s);
                break;
            case "s3a2":
                this.s3a2.add(s);
                break;
            case "s3b1":
                this.s3b1.add(s);
                break;
            case "s3b2":
                this.s3b2.add(s);
                break;
            case "s3c1":
                this.s3c1.add(s);
                break;
            case "s3c2":
                this.s3c2.add(s);
                break;
            case "s4a1":
                this.s4a1.add(s);
                break;
            case "s4a2":
                this.s4a2.add(s);
                break;
            case "s4b1":
                this.s4b1.add(s);
                break;
            case "s4b2":
                this.s4b2.add(s);
                break;
            case "s4c1":
                this.s4c1.add(s);
                break;
            case "s4c2":
                this.s4c2.add(s);
                break;
            case "s1lv2allemand":
                this.s1LV2Allemand.add(s);
                break;
            case "s1lv2espagnol1":
                this.s1LV2Espagnol1.add(s);
                break;
            case "s1lv2espagnol2":
                this.s1LV2Espagnol2.add(s);
                break;
            case "s1lv2espagnol3":
                this.s1LV2Espagnol3.add(s);
                break;
            case "s1lv2italien":
                this.s1LV2Italien.add(s);
                break;
            case "s2lv2allemand":
                this.s2LV2Allemand.add(s);
                break;
            case "s2lv2espagnol1":
                this.s2LV2Espagnol1.add(s);
                break;
            case "s2lv2espagnol2":
                this.s2LV2Espagnol2.add(s);
                break;
            case "s2lv2espagnol3":
                this.s2LV2Espagnol3.add(s);
                break;
            case "s2lv2italien":
                this.s2LV2Italien.add(s);
                break;
            case "s3lv2allemand":
                this.s3LV2Allemand.add(s);
                break;
            case "s3lv2espagnol1":
                this.s3LV2Espagnol1.add(s);
                break;
            case "s3lv2espagnol2":
                this.s3LV2Espagnol2.add(s);
                break;
            case "s3lv2espagnol3":
                this.s3LV2Espagnol3.add(s);
                break;
            case "s3lv2italien":
                this.s3LV2Italien.add(s);
                break;
            default:
                throw new IllegalAccessException("L'identifiant du cours invalide ! => ******** *"+ s.getGroupe() +"* ********" );
        }
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
