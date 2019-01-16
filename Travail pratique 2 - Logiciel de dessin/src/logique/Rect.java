package logique;

import java.awt.BasicStroke;

/**
 * Classe qui d�finit un type Rect
 * avec un point de d�part, un point d'arriv�e, une couleur et un remplissage
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

public class Rect extends Forme implements Serializable {

	
	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEURS
	 * ------------------------------------------------------------------------------------------------------
	 */

	/**
	 * Cr�er un rectangle avec deux points re�us en param�tre 
	 * @param p1	le point de d�part
	 * @param p2	le point d'arriv�e
	 */
	public Rect(Point  p1, Point p2){
		super(p1,p2);
	}


	/**
	 * Cr�er un rectangle sans param�tre
	 */
	public Rect() {
		super();
	}

	/*------------------------------------------------------------------------------------------------------
	 * M�THODE G�N�RALE
	 * ------------------------------------------------------------------------------------------------------
	 */

	/**
	 * M�thode qui permet de dessiner un rectangle
	 * @param g	la surface dessinable
	 */

	@Override
	public void dessiner(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(epaisseur));
		g2.setColor(couleur);
		if(this.plein == true) {
			g2.fillRect(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y);
		}
		else {
			g2.drawRect(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y);
		}
	}


}
