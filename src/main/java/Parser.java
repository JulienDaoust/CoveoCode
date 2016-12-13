
/** Cette classe contient le necessaire pour interpreter
 *  et stocker l information du fichier tsv. 
 * @author Julien Daoust
 * @version 1.0 (2016-12-12)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

	private String tsvFile;

	/**
    Le constructeur par parametre de la classe Parser.
    @param path Le chemin du fichier tsv des villes.
    @return void.
	 */
	public Parser(String path)
	{
		tsvFile = path;
	}

	/**
    Lecture du fichier tsv.
    @param lectureFichier Lecture du fichier tsv.
    @return un hmap contenant l information lu.
	 */
	public HashMap<String, ArrayList<String>> lectureFichier()
	{	
		String line = "";
		String cvsSplitBy = "\t";
		HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();

		try (BufferedReader br = new BufferedReader(new FileReader(tsvFile))) {

			while ((line = br.readLine()) != null) {

				String[] city = line.split(cvsSplitBy);
				ArrayList<String> list = new ArrayList<String>();

				list.add(city[4]);
				list.add(city[5]);
				list.add(city[8]);
				list.add(city[10]);	
				list.add(city[14]);
				hmap.put(city[1], list);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return hmap;
	}
}