package lotonga.e.dev.ives.fr.mmi.modeles;

import net.fortuna.ical4j.model.component.VEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotonga.e.dev.ives.fr.mmi.utilitaires.DateCustom;

public class Cours {

    private String name; // l'intitulé du cours
    private String uid; // Identifiant unique du cours
    private String salle; // la salle où se déroulera ce cours
    private String professeur; // Le professeur responsable du cours
    private String groupe; // Groupe auquel appartient le cours ex: S1A1 ou S2A1 ou  encore S1LV2Allemand etc...
    private DateCustom dateDebut, dateFin; // date de debut de cours et date de fin de cours

    //Pattern qui detecte dans une chaine les chaines suivantes : S1, S2, S3, S4, S1a, S1b, S1c, S1a1, S1b1, S1c1 etc...
    private Pattern patternDUT = Pattern.compile("s[1-4]([lvLV]{2}2[a-z]+|(([abc])([12])?)?)",Pattern.CASE_INSENSITIVE);
    //Pattern qui detecte dans une chaine la chaine suivante : LPSMIN
    private Pattern patternLPSMIN = Pattern.compile("LPSMIN",Pattern.CASE_INSENSITIVE);
    private Matcher matcher;



    //Listes des professeur de l'IUT1 département MMI (Métier du multimédia et de l'internet
    private String[] prof_liste = new String[]{
            "ANDREACOLA Florence", "AUBERT Philippe", "CAYATTE Rémi",

            "COLOMB Dominique", "GAILLARD Francois", "GREMILLARD Jean-Marie",
            "GUIROUX Hugo", "JACQUOT Pierre-Alain", "LAUPIN-SCARPARI Dominique",
            "LBATH Ahmed", "LELONG Laurent", "LESTIDEAU Vincent","MAAROUF Fouad",
            "MERCIER Dominique","MONITEUR Info", "PLASSART Stéphan", "SALAÜN Gwen",
            "VERDILLON Emmanuel"
    };

    public Cours(VEvent event)
    {
        //this.name = event.getName();
        this.name = event.getSummary().getValue();
        this.uid = event.getUid().getValue(); //TODO Implementer => la comparaison de deux cours se fera avec l'uid
        this.salle = event.getLocation().getValue();
        this.groupe = this.extraireGroupe(event);
        this.professeur = this.extraireNomProf(event);
        this.dateDebut = new DateCustom(event.getStartDate().getDate());
        this.dateFin = new DateCustom(event.getEndDate().getDate());
    }

    /**
     * Detecter dans une chaine de caractere le nom du professeur
     * @param event
     * @return String
     */
    private String extraireNomProf(VEvent event)
    {
        if(this.groupe.equals(null) ) // On s'assure que la variable matcher est bien initilisé
        {
            this.extraireGroupe(event);
        }
        String description = event.getDescription().getValue();
        String nomProf = description.substring(this.matcher.end(), description.length()).replaceAll("\\(.+)",""); // On extrait le nom du prof selon le positionnement du nom du groupe
        nomProf.replaceAll("^\\s",""); // On supprime les espaces, les retour à ligne etc ... de la chaine
        return nomProf;
    }



    /**
     * Detecter le groupe du cours ex: LPSMIN, S1A1, S2B1, S3C2 etc ...
     * @param event
     * @return String
     */
    private String extraireGroupe(VEvent event){

        try
        {
            this.matcher = this.patternDUT.matcher(event.getDescription().getValue());
        }
        catch (Exception e)
        {
            try
            {
                this.matcher = this.patternLPSMIN.matcher(event.getDescription().getValue());
            }
            catch(Exception e1)
            {
                return null;
            }
        }
        return this.matcher.group();
    }




    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSalle()
    {
        return this.salle;
    }

    public String getProfesseur()
    {
        return this.professeur;
    }

    public String getGroupe()
    {
        return this.groupe;
    }

    public DateCustom getDateDebut()
    {
        return this.dateDebut;
    }

    public DateCustom getDateFin()
    {
        return this.dateFin;
    }

    public void setSalle(String salle)
    {
        this.salle = salle;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
