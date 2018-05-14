package lotonga.e.dev.ives.fr.mmi.TelechargerFichierICS;

import org.json.JSONArray;

/**
 * Created by bfortoul on 24/03/16.
 */
interface IAsyncResponseJSON {
    void processFinishJSON(JSONArray output);

    void processFinishJSON(JSONArray output, RequestIdentifier requestIdentifier);

    void processJSONError(String p_error);

    void processFinishSuccess(RequestIdentifier p_requestIdentifier);

    void processFinishError(RequestIdentifier p_requestIdentifier);

    void processFinishErrorHashTemp(RequestIdentifier p_requestIdentifier);

    void processFinishSuccessHashTemp(RequestIdentifier p_requestIdentifier);
}
