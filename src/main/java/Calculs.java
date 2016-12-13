
/** Cette classe contient divers calculs utiles 
 * @author Julien Daoust
 * @version 1.0 (2016-12-12)
 */

public class Calculs {

	private Double lat1, lat2, lon1, lon2 ;

	/**
    Le constructeur par parametre de la classe Calculs.
    @param lat1 La premiere latitude pour le calcul de distance.
    @param lat1 La premiere longitude pour le calcul de distance.
    @param lat2 La deuxieme latitude pour le calcul de distance.
    @param lat1 La deuxieme longitude pour le calcul de distance.
    @return void.
	 */
	public Calculs(Double lat1, Double lon1, Double lat2, Double lon2)
	{
		this.lat1 = lat1;
		this.lon1 = lon1;		
		this.lat2 = lat2;
		this.lon2 = lon2;	
	}

	/**
    Cacul de la distance entre deux points geographique.
    @param aucun.
    @return la distance en kilometres.
	 */
	public Double calculDistance() 
	{
		Double theta = lon1 - lon2;
		Double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515 * 1.609344;
		return (dist);
	}

	/**
    Assignation des score en fonction de la distance calcule.
    @param dist La distance calcule plus haut.
    @return un score.
	 */
	public Double calculScore(Double dist)
	{
		if(dist < 30)
		{
			return 1.0;
		}
		else if(dist > 30 && dist < 100)
		{
			return 0.9;
		}
		else if(dist > 100 && dist < 200)
		{
			return 0.8;
		}
		else if(dist > 201 && dist < 300)
		{
			return 0.7;
		}
		else if(dist > 301 && dist < 400)
		{
			return 0.6;
		}
		else if(dist > 401 && dist < 500)
		{
			return 0.5;
		}
		else if(dist > 501 && dist < 600)
		{
			return 0.4;
		}
		else if(dist > 601 && dist < 700)
		{
			return 0.3;
		}
		else if(dist > 701 && dist < 800)
		{
			return 0.2;
		}
		else if(dist > 801 && dist < 900)
		{
			return 0.1;
		}
		else
		{
			return 0.0;
		}
	}
	
	/**
    Conversion de degrses a radians.
    @param deg valeur en degrees
    @return la conversion.
	 */
	private Double deg2rad(Double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	/**
    Conversion de radiansde a degrees.
    @param rad valeur en radians
    @return la conversion.
	 */
	private Double rad2deg(Double rad) {
		return (rad * 180.0 / Math.PI);
	}
}