package intefaceGraphique;

import java.awt.BasicStroke;

/**
 * Classe qui d�finit un type PanelCanevas qui est le canevas de dessin
 * Utilise les m�thodes de MesDessins
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Panel;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import logique.Arc;
import logique.Crayon;
import logique.Dessin;
import logique.Forme;
import logique.Ligne;
import logique.MesDessins;
import logique.Ovale;
import logique.Rect;
import logique.RectangleArrondi;


public class PanelCanevas extends Panel {

	/*------------------------------------------------------------------------------------------------------
	 * ATTRIBUTS
	 * ------------------------------------------------------------------------------------------------------
	 */

	private int x;
	private int y;
	private int largeur;
	private int hauteur;
	private int epaisseur;
	private boolean plein;
	private boolean dragging;
	private Point p1 = new Point();
	private Point p2 = new Point();
	private ArrayList<Point> lPoints = new ArrayList<Point>();//pour le dessin libre seulement
	private Dessins dessinChoisi;
	private Graphics canevas;
	private Graphics2D canevas2;
	private Color couleurDessin;
	private Color couleurPanneau;
	private MesDessins lDessins = new MesDessins();//d�claration de la liste de dessins


	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEUR
	 * ------------------------------------------------------------------------------------------------------
	 */
	public PanelCanevas() {
		initialize();
	}


	/*------------------------------------------------------------------------------------------------------
	 * ACCESSEURS
	 * ------------------------------------------------------------------------------------------------------
	 */

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getEpaisseur() {
		return epaisseur;
	}

	public boolean isPlein() {
		return plein;
	}

	public boolean isDragging() {
		return dragging;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}


	public ArrayList<Point> getlPoints() {
		return lPoints;
	}

	public Dessins getDessinChoisi() {
		return dessinChoisi;
	}

	public Graphics getCanevas() {
		return canevas;
	}

	public Color getcouleurDessin() {
		return couleurDessin;
	}

	public Color getCouleurPanneau() {
		return couleurPanneau;
	}

	public MesDessins getLDessins() {
		return lDessins;
	}


	/*------------------------------------------------------------------------------------------------------
	 * MUTATEURS
	 * ------------------------------------------------------------------------------------------------------
	 */

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}

	public void setPlein(boolean plein) {
		this.plein = plein;
	}

	public void setDragging(boolean dragging) {
		this.dragging = dragging;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public void setlPoints(ArrayList<Point> lPoints) {
		this.lPoints = lPoints;
	}

	public void setDessinChoisi(Dessins forme) {
		this.dessinChoisi = forme;
	}

	public void setCanevas(Graphics dessin) {
		this.canevas = dessin;
	}

	public void setCouleurDessin(Color couleurDessin) {
		this.couleurDessin = couleurDessin;
	}

	public void setCouleurPanneau(Color couleurPanneau) {
		this.couleurPanneau = couleurPanneau;
	}

	public void setLDessins(MesDessins lDessins) {
		this.lDessins = lDessins;
	}


	/*------------------------------------------------------------------------------------------------------
	 * M�THODES G�N�RALES
	 * ------------------------------------------------------------------------------------------------------
	 */

	/**
	 * Initialiser le panneau � l'ouverture
	 */
	private void initialize() {
		dragging = false;
		setCouleurPanneau(Color.WHITE);
		setCouleurDessin(Color.BLACK);
		CanevasListener ecouteur = new CanevasListener();
		this.addMouseListener(ecouteur);
		this.addMouseMotionListener(ecouteur);
	}


	/**
	 * M�thode qui r�initialise le canevas de dessin
	 */
	public void nouveau() {
		int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous sauvegarder votre dessin ?", "Nouveau dessin", JOptionPane.YES_NO_OPTION);
		if (choix == JOptionPane.YES_OPTION){
			sauvegarder();
		}
		effacerTout();
	}

	/**
	 * M�thode qui ouvre un dessin existant
	 */
	public void ouvrir() {
		dragging = false;
		JFileChooser dialogueFichier = new JFileChooser();
		Dessin d;

		//Si l'utilisateur a commenc� � dessiner, lui demander s'il veut sauvegarder son travail
		if(!lDessins.isEmpty()) {
			int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous sauvegarder votre dessin ?", "Ouvrir un dessin existant", JOptionPane.YES_NO_OPTION);
			if (choix == JOptionPane.YES_OPTION){
				sauvegarder();
			}
		}

		try {
			if(dialogueFichier.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				effacerTout();//Vider la liste au cas ou l'utilisateur avait d�j� commenc� � dessiner
				lDessins.charger(dialogueFichier.getSelectedFile().getAbsolutePath());

				//R�cup�rer la couleur de fond du dessin enregistr� � l'aide du premier �l�ment de la liste
				d = lDessins.getDessin(0);
				couleurPanneau = d.getArrierePlan();
				repaint();
			}
		}

		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Impossible de lire le fichier");
		}
	}


	/**
	 * M�thode appel�e automatiquement � chaque rafraichissement du panel
	 * On "redessine" l'arri�re plan � chaque fois ainsi que les dessins enregistr�s dans la liste
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);	
		g.setColor(couleurPanneau);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		dessinerForme(g);
		if(dragging == true) {agrandirForme();}//appeler la m�thode pour "agrandir" une forme seulement lorsqu'on est en train de dessiner une forme
	}


	/**
	 * M�thode qui permet de voir la forme �tre dessin�e lorsqu'on garde la souris enfonc�e
	 */
	private void agrandirForme() {
		canevas2 = (Graphics2D) canevas;
		canevas2.setStroke(new BasicStroke(epaisseur));
		canevas2.setColor(couleurDessin);

		if(dessinChoisi == Dessins.LIGNE_DROITE) {
			canevas2.drawLine(p1.x, p1.y, p2.x, p2.y);
		}

		else if(dessinChoisi == Dessins.ARC) {
			canevas2.drawArc(x, y, largeur, hauteur, 0, 180);
		}

		else if(dessinChoisi == Dessins.OVALE) {
			if(plein == true) {
				canevas2.fillOval(x, y, largeur, hauteur);
			}
			else {
				canevas2.drawOval(x, y, largeur, hauteur);
			}
		}

		else if(dessinChoisi == Dessins.RECTANGLE) {
			if(plein == true) {
				canevas2.fillRect(x, y, largeur, hauteur);
			}
			else {
				canevas2.drawRect(x, y, largeur, hauteur);
			}
		}

		else if(dessinChoisi == Dessins.RECTANGLE_ARRONDI) {
			if(plein == true) {
				canevas2.fillRoundRect(x, y, largeur, hauteur, 20, 20);
			}
			else {
				canevas2.drawRoundRect(x, y, largeur, hauteur, 20, 20);
			}
		}

	}


	/**
	 * M�thode qui permet de dessiner un �l�ment enregistr� dans la liste
	 * @param g	la surface dessinable
	 */
	private void dessinerForme(Graphics g) {
		for(Dessin d : lDessins) {
			d.setArrierePlan(couleurPanneau);//appliquer une couleur d'arri�re-plan � chaque dessin (sera utile lors de la sauvegarde du fichier)
			d.dessiner(g);
		}
	}

	/**
	 * M�thode qui efface le dernier �l�ment dessin�
	 */
	public void effacer() {
		dragging = false;
		lDessins.effacer();
		repaint();

	}

	/**
	 * M�thode qui efface tout les �l�ments dessin�s
	 */
	public void effacerTout() {
		dragging = false;
		lDessins.effacerTout();
		setCouleurPanneau(Color.WHITE);
		repaint();
	}


	/**
	 * M�thode qui sauvegarde le dessin cr��
	 */
	public void sauvegarder() { 
		dragging = false;
		JFileChooser dialogueFichier = new JFileChooser();

		try {
			if(dialogueFichier.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				lDessins.sauvegarder(dialogueFichier.getSelectedFile().getAbsolutePath());
			}
		}

		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Impossible de sauvegarder le fichier");
		}
	}


	/**
	 * M�thode qui d�finit le remplissage, l'�paisseur, la couleur du dessin et la couleur d'arri�re-plan. La m�thode permet aussi d'ajouter la forme dans la liste de dessins
	 */
	public void definirDessin(Dessin dessin) {
		dessin.setEpaisseur(epaisseur);
		dessin.setPlein(plein);
		dessin.setCouleur(couleurDessin);
		lDessins.ajouterDessin(dessin);
	}


	/**------------------------------------------------------------------------------------------------------
	 * �COUTEUR D'�V�NEMENTS DE SOURIS
	 * ------------------------------------------------------------------------------------------------------
	 */

	private class CanevasListener extends MouseAdapter {
		/**
		 * Lorsqu'on clique avec la souris, on enregistre la coordonn�e qui sera le point de d�part
		 */
		@Override
		public void mousePressed(MouseEvent me) {
			canevas = getGraphics();

			x = me.getX();
			y = me.getY();

			if(dessinChoisi == Dessins.CRAYON) {
				lPoints.add(new Point(x,y));
			}
			else {
				p1 = new Point(x,y);
			}

			repaint(); 
		}

		/**
		 * Lorsqu'on garde la souris enfonc�e, on affiche le dessin en train de se cr�er
		 */
		@Override
		public void mouseDragged(MouseEvent me) {
			dragging = true;
			if(dessinChoisi == Dessins.CRAYON) {
				lPoints.add(new Point(me.getX(),me.getY()));
				Dessin crayon = new Crayon(lPoints);
				crayon.setEpaisseur(epaisseur);
				crayon.setCouleur(couleurDessin);
				crayon.dessiner(canevas);
			}

			else if(dessinChoisi == Dessins.LIGNE_DROITE){
				p2 = new Point(me.getX(), me.getY());
				repaint();
			}

			else {
				largeur = Math.abs(me.getX() - x);
				hauteur = Math.abs(me.getY() - y);
				x = Math.min(x, me.getX());
				y = Math.min(y, me.getY());
				repaint();
			}

		}


		/**
		 * Lorsqu'on l�che la souris, on enregistre la coordonn�e qui sera le point d'arriv�e, la forme est instanci�e et enregistr�e � la liste de dessins
		 */
		@Override
		public void mouseReleased(MouseEvent me) {
			p2 = new Point(me.getX(), me.getY());

			if(dessinChoisi == Dessins.CRAYON) {
				Dessin crayon = new Crayon(lPoints);
				definirDessin(crayon);
				lPoints = new ArrayList<Point>();//vider la liste de points pour le prochain dessin libre
			}

			else if(dessinChoisi == Dessins.LIGNE_DROITE) {
				Dessin ligne = new Ligne(p1,p2);
				definirDessin(ligne);
			}
			else if(dessinChoisi == Dessins.ARC) {
				Dessin arc = new Arc(p1,p2);
				definirDessin(arc);
			}
			else if(dessinChoisi == Dessins.OVALE) {
				Dessin ovale = new Ovale(p1,p2);
				definirDessin(ovale);
			}
			else if(dessinChoisi == Dessins.RECTANGLE) {
				Dessin rect = new Rect(p1,p2);
				definirDessin(rect);
			}
			else if(dessinChoisi == Dessins.RECTANGLE_ARRONDI) {
				Dessin rectArr = new RectangleArrondi(p1,p2);
				definirDessin(rectArr);
			}
			dragging = false;
			repaint();
		}
	}
}
