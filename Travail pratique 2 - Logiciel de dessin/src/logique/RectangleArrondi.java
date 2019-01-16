package logique;

import java.awt.BasicStroke;

/**
 * Classe qui d�finit un type RectangleArrondi
 * avec un point de d�part, un point d'arriv�e, une couleur et un remplissage
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
	 * Cr�er un rectangle arrondi avec deux points re�us en param�tre 
	 * @param p1	le point de d�part
	 * @param p2	le point d'arriv�e
	 */
	public RectangleArrondi(Point p1, Point p2) {
		super(p1, p2);
	}
	
	/**
	 * Cr�er un rectangle arrondi sans param�tre
	 */
	public RectangleArrondi() {
		super();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * M�THODE G�N�RALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * M�thode qui permet de dessiner un rectangle arrondi
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
