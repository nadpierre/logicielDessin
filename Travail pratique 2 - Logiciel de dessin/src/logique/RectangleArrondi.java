package logique;

import java.awt.BasicStroke;

/**
 * Classe qui définit un type RectangleArrondi
 * avec un point de départ, un point d'arrivée, une couleur et un remplissage
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;


public class RectangleArrondi extends Forme implements Serializable {
	
	
	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Créer un rectangle arrondi avec deux points reçus en paramètre 
	 * @param p1	le point de départ
	 * @param p2	le point d'arrivée
	 */
	public RectangleArrondi(Point p1, Point p2) {
		super(p1, p2);
	}
	
	/**
	 * Créer un rectangle arrondi sans paramètre
	 */
	public RectangleArrondi() {
		super();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MÉTHODE GÉNÉRALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Méthode qui permet de dessiner un rectangle arrondi
	 * @param g	la surface dessinable
	 */
	@Override
	public void dessiner(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(epaisseur));
		g2.setColor(couleur);
		if(this.plein == true) {
			g2.fillRoundRect(p1.x, p1.y, p2.x - p1.x , p2.y - p1.y, 20, 20);
		}
		else {
			g2.drawRoundRect(p1.x, p1.y, p2.x - p1.x , p2.y - p1.y, 20, 20);
		}

	}
	
	

}
