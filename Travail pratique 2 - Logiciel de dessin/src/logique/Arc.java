package logique;

import java.awt.BasicStroke;

/**
 * Classe qui définit un type Arc
 * avec un point de départ, un point d'arrivée et une couleur
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

public class Arc extends Forme implements Serializable {
	
	
	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Créer un arc avec deux points reçus en paramètre
	 * @param p1	le point de départ
	 * @param p2	le point d'arrivée
	 */
	public Arc(Point p1, Point p2) {
		super(p1, p2);
		
	}
	
	/**
	 * Créer un arc sans paramètre
	 */
	public Arc() {
		super();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MÉTHODE GÉNÉRALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
     * Méthode qui permet de dessiner un arc
     * @param g	la surface dessinable
     */
	@Override
	public void dessiner(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(epaisseur));
		g2.setColor(couleur);
		g2.drawArc(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y, 0, 180);

	}
	
	
	
	

}
