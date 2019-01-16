package logique;

/**
 * Classe qui définit un type Forme
 * avec un point de départ et un point d'arrivée
 */

import java.awt.*;
import java.io.Serializable;

public abstract class Forme extends Dessin implements Serializable {

	/*------------------------------------------------------------------------------------------------------
	 * ATTRIBUTS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	protected Point p1;
	protected Point p2;
	

	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Créer une forme avec deux points reçus en paramètre
	 * @param p1	le point de départ
	 * @param p2	le point d'arrivée
	 */
	public Forme(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	/**
	 * Créer une forme sans paramètres
	 */
	public Forme() {
		this(new Point(), new Point());
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * ACCESSEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	public Point getP1() {
		return p1;
	}
	
	public Point getP2() {
		return p2;
	}

	
	/*------------------------------------------------------------------------------------------------------
	 * MUTATEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MÉTHODE GÉNÉRALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
     * Afficher les informations de la forme
     *  @return String
     */
	@Override
	public String toString() {
		String forme = super.toString();
		
		return forme + ": p1=(" + p1.x + ", " +  p1.y +
					") p2=(" + p2.x + ", " +  p2.y +  "), " + ((!forme.equals("LIGNE") && (!forme.equals("ARC") && (plein == true))? "pleine" : "vide")) + ", de " + epaisseur + " pixel(s) d'épaisseur, de couleur " + couleur;
	}

	

	

}
