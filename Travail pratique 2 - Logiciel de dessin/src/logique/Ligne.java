package logique;

import java.awt.BasicStroke;

/**
 * Classe qui définit un type Ligne
 * avec un point de départ, un point d'arrivée et une couleur
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;


public class Ligne extends Forme implements Serializable {

	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Créer une ligne avec deux points reçus en paramètre
	 * @param p1	le point de départ
	 * @param p2	le point d'arrivée
	 */
	public Ligne(Point  p1, Point p2){
		super(p1,p2);
	}
	 
	/**
	 * Créer une ligne sans paramètre
	 */
	public Ligne() {
		super();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MÉTHODE GÉNÉRALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
     * Méthode qui permet de dessiner une ligne
     * @param g	la surface dessinable
     */
	@Override
	public void dessiner(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(epaisseur));
		g2.setColor(couleur);
		g2.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
	
	


}
