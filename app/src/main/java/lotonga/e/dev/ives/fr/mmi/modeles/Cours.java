package lotonga.e.dev.ives.fr.mmi.modeles;

import android.util.Log;

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
    private Pattern patternDUT = Pattern.compile("s[1-4]([a-c][12]?)?",Pattern.CASE_INSENSITIVE);
    // Pattern qui detecte dans une chaine les chaines suivantes : S3LV2Italien , S3LV2Espagnol1 etc....
    private Pattern patternDUTLangue = Pattern.compile("s[1-3]lv2[a-z]+[1-3]?", Pattern.CASE_INSENSITIVE);
    //Pattern qui detecte dans une chaine la chaine suivante : LPSMIN
    private Pattern patternLPSMIN = Pattern.compile("LPSMIN",Pattern.CASE_INSENSITIVE);
    // Pattern qui detecte la chaine (Exporté le:XX/XX/XX XX:XX)
    Pattern patternDateExportation = Pattern.compile("\\(([a-zé\\s:0-9\\/]+)?\\)",Pattern.CASE_INSENSITIVE);
    private Matcher matcher;


    //Listes des professeur de l'IUT1 département MMI (Métier du multimédia et de l'internet
    private String[] prof_list = new String[]{
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
        this.dateDebut = new DateCustom(event.getStartDate().getValue());
        this.dateFin = new DateCustom(event.getEndDate().getValue());
    }

    /**
     * Detecter le nom du professeur
     * @param event
     * @return String le nom du prof
     */
    private String extraireNomProf(VEvent event)
    {
        String description = event.getDescription().getValue();

        /*****************************************************************************************
        *On check si parmi les noms connus des profs, il en existe un dans la description du cours
        *******************************************************************************************/
        for (String s : prof_list)
        {
            Pattern prof = Pattern.compile(s, Pattern.CASE_INSENSITIVE);
            Matcher tmp_matcher = prof.matcher(description);
            if(tmp_matcher.find())
            {
                return tmp_matcher.group();
            }
        }
        /*************************************************
        * Autrement on essaye d'extraire le nom du prof
        **************************************************/
        this.matcher = this.patternLPSMIN.matcher(description);
        if(this.matcher.find())
        { // On teste tout d'abord de supprimer le groupe dans la description
            description = description.replaceAll(this.matcher.group(), "");
        }
        else
        {
            // On essaye les groupes de langue
            this.matcher = this.patternDUTLangue.matcher(description);
            if(this.matcher.find())
            {
                description = description.replaceAll(this.matcher.group(), "");
            }
            else
            { // Sinon on essaye les groupes DUT S1A1 S1A2 etc ...

                this.matcher = this.patternDUT.matcher(description);
                while(this.matcher.find())
                {
                    description = description.replaceAll(this.matcher.group(), "");
                }
            }
        }
        this.matcher = this.patternDateExportation.matcher(description);
        if(this.matcher.find())
        {// On tente de supprimer egalement la chaine de la date d'exportation
            description = description.replaceAll(this.matcher.group(),"");
        }

        // On supprime les parentheses
        description = description.replaceAll("[\\s\\r\\n]+\\(\\)$", "");

        // On supprime les espaces
        description = description.replaceAll("^\\s|\n|^\\r", "");
        return description;
    }

    /**
     * Detecter le groupe du cours ex: LPSMIN, S1A1, S2B1, S3C2 etc ...
     * @param event
     * @return String
     */
    private String extraireGroupe(VEvent event)
    {
        String tmp_groupe = "";
        this.matcher = this.patternLPSMIN.matcher(event.getDescription().getValue());
        if( this.matcher.find())
        {
            String groupe_avec_espaces = this.matcher.group();
            String[] arr = groupe_avec_espaces.split("\n|\\s|\r");
            for(String ch : arr)
            {
                if(!ch.equals("") || ch.equalsIgnoreCase("\r"))
                {
                    tmp_groupe = ch;
                }
            }
        }
        else
        {
            this.matcher = this.patternDUTLangue.matcher(event.getDescription().getValue());
            if(this.matcher.find()) // Si c'est un cours de langue
            {
                String groupe_avec_espaces = this.matcher.group();
                String[] arr = groupe_avec_espaces.split("\n|\\s|\r");
                for(String ch : arr)
                {
                    if(!ch.equals("") || ch.equalsIgnoreCase("\r"))
                    {
                        tmp_groupe = ch;
                    }
                }
            }
            else
            {
                this.matcher = this.patternDUT.matcher(event.getDescription().getValue());
                while(this.matcher.find())
                {
                    String groupe_avec_espaces = this.matcher.group();
                    String[] arr = groupe_avec_espaces.split("\n|\\s|\r");
                    for(String ch : arr)
                    {
                        if(!ch.equals("") || ch.equalsIgnoreCase("\r"))
                        {
                            tmp_groupe += ch + "-";
                        }
                    }
                }
                if( tmp_groupe.endsWith("-"))
                {
                    tmp_groupe = tmp_groupe.substring(0,tmp_groupe.length() - 1);
                }
            }
        }
        return tmp_groupe;
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
