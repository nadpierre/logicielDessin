package logique;

/**
 * Classe qui définit un type Dessin 
 * un dessin possède une épaisseur, un remplissage, une couleur de dessin et une couleur de fond 
 */

import java.awt.Color;
import java.io.Serializable;

public abstract class Dessin implements Dessinable, Serializable {
	
	/*------------------------------------------------------------------------------------------------------
	 * ATTRIBUTS
	 * ------------------------------------------------------------------------------------------------------
	 */
	protected int epaisseur;
	protected boolean plein;
	protected Color couleur;
	protected Color arrierePlan;
	
	
	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEUR VIDE
	 * ------------------------------------------------------------------------------------------------------
	 */
	public Dessin() {
		this.epaisseur = 1;
		this.plein = false;
		this.couleur = Color.BLACK;
		this.arrierePlan = Color.WHITE;
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * ACCESSEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	public int getEpaisseur() {
		return epaisseur;
	}
	

	public boolean getPlein() {
		return plein;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public Color getArrierePlan() {
		return arrierePlan;
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MUTATEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}
	
	public void setPlein(boolean plein) {
		this.plein = plein;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	public void setArrierePlan(Color couleur) {
		this.arrierePlan = couleur;
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MÉTHODE GÉNÉRALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
     * Afficher le nom du dessin
     *  @return String
     */
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	
}
