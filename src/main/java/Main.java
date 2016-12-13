
/** Cette classe est la class Main
 * @author Julien Daoust
 * @version 1.0 (2016-12-12)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import static spark.Spark.*;
import static spark.Spark.get;

public class Main {

	public static void main(String[] args) throws Exception{

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

		get("/suggestions", (req, res) -> {

			//Parametres entre dans l'URL

			String q = req.queryParams("q");
			String latitudeParam = req.queryParams("latitude");
			String longitudeParam = req.queryParams("longitude");
			String qParam = q.substring(0, 1).toUpperCase() + q.substring(1);
			
			//Si les parametres entres sont vide
			if (latitudeParam == null || latitudeParam.isEmpty()) 
			{
				latitudeParam = "0.0";
			}

			if (longitudeParam == null || longitudeParam.isEmpty()) 
			{
				longitudeParam = "0.0";
			}

			//Fichier contenant les villes 
			String tsvFile = "src/main/resources/file/cities_canada-usa.tsv";
			Parser hmap = new Parser(tsvFile);

			//Resultats de la lecture stocke
			ArrayList<Resultat> resultatsArray = new ArrayList<Resultat>();

			for (Map.Entry<String, ArrayList<String>> entry : hmap.lectureFichier().entrySet()) {
				String key = entry.getKey();
				ArrayList<String> value = entry.getValue();

				if(key.startsWith(qParam))
				{
					Resultat resultat = new Resultat();

					resultat.setNom(key + ", " + value.get(3) + ", " + value.get(2));
					resultat.setPopulation(Integer.parseInt(value.get(4)));
					resultat.setLatitude(Double.parseDouble(value.get(0)));
					resultat.setLongitude(Double.parseDouble(value.get(1)));

					Double latDoubleParam = Double.parseDouble(latitudeParam);
					Double lonDoubleParam = Double.parseDouble(longitudeParam);

					Calculs distance = new Calculs(latDoubleParam, lonDoubleParam, resultat.getLatitude(), resultat.getLongitude());
					Double score = distance.calculScore(distance.calculDistance());				
					resultat.setScore(score);

					resultatsArray.add(resultat);
				}
			}

			//Triage des resulats en fonction du score obtenu. Ordre croissant
			Collections.sort(resultatsArray, new Comparator<Resultat>() {
				@Override
				public int compare(Resultat resultat1, Resultat resultat2)
				{   
					return  resultat1.getScore().compareTo(resultat2.getScore());
				}
			});

			//Inversion pour avoir le score le plus haut en premier
			Collections.reverse(resultatsArray);
			CreateurJSON json = new CreateurJSON(resultatsArray);

			return json.getJSON();
		});

		get("/", (req, res) -> {

			return "Coveo Backend Coding Challenge / Julien Daoust";
		});
	}
}