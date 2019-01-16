package logique;

/**
 * Classe qui d�finit un type Forme
 * avec un point de d�part et un point d'arriv�e
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
	 * Cr�er une forme avec deux points re�us en param�tre
	 * @param p1	le point de d�part
	 * @param p2	le point d'arriv�e
	 */
	public Forme(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	/**
	 * Cr�er une forme sans param�tres
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
	 * M�THODE G�N�RALE
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
					") p2=(" + p2.x + ", " +  p2.y +  "), " + ((!forme.equals("LIGNE") && (!forme.equals("ARC") && (plein == true))? "pleine" : "vide")) + ", de " + epaisseur + " pixel(s) d'�paisseur, de couleur " + couleur;
	}

	

	

}
