package logique;

/**
 * Classe qui d�finit un type Crayon (dessin libre)
 * un dessin libre est compos� d'une multitude de points
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;


public class Crayon extends Dessin implements Serializable {
	
	/*------------------------------------------------------------------------------------------------------
	 * ATTRIBUTS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	private ArrayList<Point> lPoints = new ArrayList<Point>();
	
	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Cr�er un dessin libre avec une liste de points re�us en param�tre
	 * @param lPoints	la liste de points
	 */
	public Crayon(ArrayList<Point> lPoints) {
		super();
		this.lPoints = lPoints;
		
	}
	
	/**
	 * Cr�er un dessin libre sans param�tres
	 */
	public Crayon() {
		
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * ACCESSEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	public ArrayList<Point> getLPoints() {
		return lPoints;
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MUTATEURS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	public void setLPoints(ArrayList<Point> lPoints) {
		this.lPoints = lPoints;
	}

	
	/*------------------------------------------------------------------------------------------------------
	 * M�THODES G�N�RALES
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Afficher les informations du dessin libre
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString() + ": p1=(" + lPoints.get(0).x + ", " + lPoints.get(0).y +
				"), p2=("+ lPoints.get(lPoints.size() -1).x + ", " + lPoints.get(lPoints.size() -1).y + "), de "+ epaisseur +" pixel(s) d'�paisseur, de couleur " + couleur;
	}

	/**
	 * M�thode qui permet de faire un dessin libre
	 * @param g	la surface dessinable
	 */
	@Override
	public void dessiner(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(epaisseur));
		g2.setColor(couleur);
		for(int i = 0; i < lPoints.size() - 1; i++) {
			g2.drawLine(lPoints.get(i).x, lPoints.get(i).y, lPoints.get(i + 1).x, lPoints.get(i + 1).y);
		}
	}
	

	

	
	
	

}
