
/** Cette classe est un conteneur des resultats suite a la 
 * lecture du fichier.
 * @author Julien Daoust
 * @version 1.0 (2016-12-12)
 */

public class Resultat {

	private String nom;
	private Double latitude;
	private Double longitude;
	private Double score;
	private Integer population;

	/**
    Le constructeur par defaut de la classe Resultat.
    @param aucun.
    @return void.
	 */
	public Resultat() {
		nom = "";
		latitude = 0.0;
		longitude = 0.0;
		score = 0.0;
		population = 0;
	}

	/**
    Assigne le nom.
    @param nom Le nom de la ville.
    @return void.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
    Assigne la latitude.
    @param latitude La latitude de la ville.
    @return void.
	 */
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	/**
    Assigne la longtude.
    @param longitude La longitude de la ville.
    @return void.
	 */
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	/**
    Assigne le score.
    @param score Le score de la recherche.
    @return void.
	 */
	public void setScore(Double score)
	{
		this.score = score;
	}

	/**
    Assigne la population.
    @param population La population de la ville.
    @return void.
	 */
	public void setPopulation(Integer population)
	{
		this.population = population;
	}

	/**
    Recupere le nom.
    @param aucun.
    @return le nom.
	 */
	public String getNom()
	{
		return nom;
	}

	/**
    Recupere la latitude.
    @param aucun.
    @return la latitude.
	 */
	public Double getLatitude()
	{
		return latitude;
	}

	/**
    Recupere la longitude.
    @param aucun.
    @return la longitude.
	 */
	public Double getLongitude()
	{
		return longitude;
	}

	/**
    Recupere le score.
    @param aucun.
    @return le score.
	 */
	public Double getScore()
	{
		return score;
	}

	/**
    Recupere le population.
    @param aucun.
    @return la population.
	 */
	public Integer getPopulation()
	{
		return population;
	}
}