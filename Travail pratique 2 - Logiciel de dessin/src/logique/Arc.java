package logique;

import java.awt.BasicStroke;

/**
 * Classe qui d�finit un type Arc
 * avec un point de d�part, un point d'arriv�e et une couleur
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
	 * Cr�er un arc avec deux points re�us en param�tre
	 * @param p1	le point de d�part
	 * @param p2	le point d'arriv�e
	 */
	public Arc(Point p1, Point p2) {
		super(p1, p2);
		
	}
	
	/**
	 * Cr�er un arc sans param�tre
	 */
	public Arc() {
		super();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * M�THODE G�N�RALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
     * M�thode qui permet de dessiner un arc
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
