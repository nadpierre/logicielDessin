package logique;

import java.awt.BasicStroke;

/**
 * Classe qui d�finit un type Ligne
 * avec un point de d�part, un point d'arriv�e et une couleur
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
	 * Cr�er une ligne avec deux points re�us en param�tre
	 * @param p1	le point de d�part
	 * @param p2	le point d'arriv�e
	 */
	public Ligne(Point  p1, Point p2){
		super(p1,p2);
	}
	 
	/**
	 * Cr�er une ligne sans param�tre
	 */
	public Ligne() {
		super();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * M�THODE G�N�RALE
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
     * M�thode qui permet de dessiner une ligne
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
