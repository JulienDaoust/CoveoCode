
/** Cette classe effectue la creation du JSON 
 * @author Julien Daoust
 * @version 1.0 (2016-12-12)
 */

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONArray;

public class CreateurJSON {

	private JSONObject json;

	/**
    Le constructeur par parametre de la classe CreateurJSON.
    @param resultats Les resultats suite a la lecture du fichier tsv.
    @return void.
	 */
	public CreateurJSON(ArrayList<Resultat> resultats) throws JSONException
	{
		json = creationJSON(resultats);
	}

	/**
    Creation du JSON.
    @param resultats Les resultats suite a la lecture du fichier tsv.
    @return un objet JSON.
	 */
	public JSONObject creationJSON(ArrayList<Resultat> resultats) throws JSONException
	{
		JSONObject suggestionsObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		for(int i = 0 ; i < resultats.size() ; i++)
		{
			if (resultats.get(i).getPopulation() > 5000)
			{
				JSONObject villeObj = new JSONObject();

				villeObj.put("nom", resultats.get(i).getNom());
				villeObj.put("latitude", resultats.get(i).getLatitude());
				villeObj.put("longitude", resultats.get(i).getLongitude());
				villeObj.put("score", resultats.get(i).getScore());

				jsonArray.put(villeObj);
			}
		}			
		suggestionsObj.put("suggestions", jsonArray);
		return suggestionsObj;
	}

	/**
    Recupere un objet JSON.
    @param aucun.
    @return un objet JSON.
	 */
	public JSONObject getJSON()
	{
		return json;
	}
}