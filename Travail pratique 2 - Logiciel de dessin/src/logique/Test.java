package logique;

/**
 * Classe qui teste les méthodes de MesDessins
 */

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Test {
	
	/**
	 * Générer un point au hasard
	 * @return Point
	 */
	public static Point genererPoint() {
		int x = (int) Math.floor(Math.random() * 500);
		int y = (int) Math.floor(Math.random() * 300);

		return new Point(x,y);
	}

	/**
	 * Générer une couleur au hasard
	 * @return Color(rouge, vert, bleu, alpha)
	 */
	public static Color genererCouleur() {

		int rouge = (int) Math.floor(Math.random() * 255);
		int vert = (int) Math.floor(Math.random() * 255);
		int bleu = (int) Math.floor(Math.random() * 255);
		int a = (int) Math.floor(Math.random() * 255);

		return new Color(rouge, vert, bleu, a);
	}
	
	/**
	 * Générer une épaisseur au hasard
	 * @return un entier entre 1 et 128;
	 */
	public static int genererEpaisseur() {
		return (int) Math.floor(Math.random() * 128) + 1;
	}

	/**
	 * Générer un dessin libre
	 * @param nbPixels la taille du dessin
	 * @return	une liste de points
	 */
	public static ArrayList<Point> genererDessin(int nbPixels){

		ArrayList<Point> lPoints = new ArrayList<Point>();

		//Ajout du point de départ (au hasard)
		lPoints.add(genererPoint());

		//Simulation du dessin libre
		for(int i = 1; i < nbPixels; i++) {

			//Générer un nombre entre 0 et 3 au hasard
			int hasard = (int) Math.floor(Math.random() * 4);
			int x = lPoints.get(lPoints.size() - 1).x;
			int y = lPoints.get(lPoints.size() - 1).y;

			//Déplacement
			switch(hasard) {
			//vers la gauche
			case 0: lPoints.add(new Point(x - 1, y));break;
			//vers la droite
			case 1: lPoints.add(new Point(x + 1, y));break;
			//vers le haut
			case 2: lPoints.add(new Point(x, y + 1));break;
			//vers le bas	
			case 3: lPoints.add(new Point(x, y - 1));break;
			}

		}

		return lPoints;
	}
	
	/**
	 * Méthode principale
	 * @param args
	 */
	public static void main(String[] args) {

		//Déclaration de MesDessins
		MesDessins lDessins = new MesDessins();

		//Chargement des dessins existants
		JFileChooser dialogueFichier = new JFileChooser();

		try {
			if(dialogueFichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {//si l'utilisateur a cliqué sur "Ouvrir"
				lDessins.charger(dialogueFichier.getSelectedFile().getAbsolutePath());
			}
			else {//Par défaut, ouvrir le dessin de chat
				lDessins.charger("fichiers/chat.xml");
			}
		}

		catch(IOException e){
			System.out.println("Impossible de lire le fichier");
		}

 
		//Dessiner une ligne droite et un arc
		Point pLigne = genererPoint();
		int x = pLigne.x;
		int y = pLigne.y;
		Dessin ligne = new Ligne(new Point(x,y), new Point(x + 100, y - 50));
		ligne.setEpaisseur(genererEpaisseur());
		ligne.setCouleur(genererCouleur());
		ligne.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(ligne);

		Point pArc = genererPoint();
		x = pArc.x;
		y = pArc.y;
		Dessin arc = new Arc(new Point(x,y), new Point(x + 200, y + 100));
		arc.setEpaisseur(genererEpaisseur());
		arc.setCouleur(genererCouleur());
		arc.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(arc);

		//Dessiner des figures
		Point pOvale = genererPoint();
		x = pOvale.x;
		y = pOvale.y;
		Dessin ovale = new Ovale(new Point(x,y), new Point(x + 300, y + 250));
		ovale.setEpaisseur(genererEpaisseur());
		ovale.setPlein(true);
		ovale.setCouleur(genererCouleur());
		ovale.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(ovale);

		Point pRect = genererPoint();
		x = pRect.x;
		y = pRect.y;
		Dessin rect = new Rect(new Point(x,y), new Point(x + 300, y + 300));
		rect.setEpaisseur(genererEpaisseur());
		rect.setCouleur(genererCouleur());
		rect.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(rect);

		Point pRectArr = genererPoint();
		x = pRectArr.x;
		y = pRectArr.y;
		Dessin rectArr = new RectangleArrondi(new Point(x,y), new Point(x + 75, y + 150));
		rectArr.setEpaisseur(genererEpaisseur());
		rectArr.setPlein(true);
		rectArr.setCouleur(genererCouleur());
		rectArr.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(rectArr);
		
		//Effacer une forme
		lDessins.effacer();

		//Faire deux dessins libres
		Dessin dessin1 = new Crayon(genererDessin(600));
		dessin1.setEpaisseur(genererEpaisseur());
		dessin1.setCouleur(genererCouleur());
		dessin1.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(dessin1);

		Dessin dessin2 = new Crayon(genererDessin(1000));
		dessin2.setEpaisseur(genererEpaisseur());
		dessin2.setCouleur(genererCouleur());
		dessin2.setArrierePlan(Color.WHITE);
		lDessins.ajouterDessin(dessin2);
		
		//Effacer un dessin
		lDessins.effacer();
		
		//Affichage de la liste de formes
		System.out.println(lDessins);
		
		
		//Sauvegarde des formes créées
		try {
			if(dialogueFichier.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				lDessins.sauvegarder(dialogueFichier.getSelectedFile().getAbsolutePath());
			}
			else {
				lDessins.sauvegarder("fichiers/chat2.xml");
			}
		}

		catch(IOException e){
			System.out.println("Impossible de sauvegarder le fichier");
		}

	}

}
