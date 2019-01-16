package intefaceGraphique;

/**
 * Interface graphique qui utilise les méthodes de PanneauCanevas
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class FenetrePrincipale extends JFrame {
	
	/*------------------------------------------------------------------------------------------------------
	 * ATTRIBUTS
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	Color couleurPanneau = Color.WHITE;
	Color couleurDessin = Color.BLACK;
	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenuItem mntmNouveau = new JMenuItem("Nouveau");
	private JMenuItem mntmOuvrir = new JMenuItem("Ouvrir");
	private JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
	private JMenuItem mntmQuitter = new JMenuItem("Quitter");
	private JMenu mnAide = new JMenu("Aide");
	private JMenuItem mntmAPropos = new JMenuItem("\u00C0 propos");
	private JPanel panActions = new JPanel();
	private final JPanel panDessin = new JPanel();
	private final JPanel panFormes = new JPanel();
	private final JPanel panCouleurs = new JPanel();
	private final JButton btnCrayon = new JButton("Crayon");
	private final JButton btnEffacerUn = new JButton("Effacer");
	private final JButton btnEffacerTout = new JButton("Effacer tout");
	private final JButton btnLigne = new JButton("");
	private final JButton btnArc = new JButton("");
	private final JButton btnOvale = new JButton("");
	private final JButton btnOvalePlein = new JButton("");
	private final JButton btnRectangle = new JButton("");
	private final JButton btnRectanglePlein = new JButton("");
	private final JButton btnRectArr = new JButton("");
	private final JButton btnRectArrPlein = new JButton("");
	private final JLabel lblArrierePlan = new JLabel("Arri\u00E8re-plan :");
	private final JLabel lblDessin = new JLabel("Dessin :");
	private final JPanel panEpaisseur = new JPanel();
	private final JSlider slider = new JSlider();
	private final JLabel lbl1px = new JLabel("1px");
	private final JLabel lbl128px = new JLabel("128px");
	private JButton btnArrierePlan = new JButton("");
	private JButton btnDessin = new JButton("");
	private JTextField textEpaisseur;

	//Déclaration du panneau personnalisé
	private PanelCanevas panCanevas = new PanelCanevas();
	
	
	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEUR
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	public FenetrePrincipale() {
		initialize();
	}
	
	/**
	 * Initialiser la fenêtre à l'ouverture
	 */
	private void initialize() {
		
		//Placer les éléments dans la fenêtre
		setTitle("Logiciel de dessin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 730);
		menuBar.setBackground(new Color(248, 236, 242)); 
		setJMenuBar(menuBar);
		menuBar.add(mnFichier);
		mntmNouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFichier.add(mntmNouveau);
		mntmOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFichier.add(mntmOuvrir);
		mntmEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFichier.add(mntmEnregistrer);
		mntmQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnFichier.add(mntmQuitter);
		menuBar.add(mnAide);
		mntmAPropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mnAide.add(mntmAPropos);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 236, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panActions.setSize(new Dimension(175, 730));
		panActions.setPreferredSize(new Dimension(175, 730));
		panActions.setLayout(new GridLayout(4, 1, 0, 0));
		contentPane.add(panActions, BorderLayout.WEST);
		contentPane.add(panCanevas, BorderLayout.CENTER);
		panDessin.setSize(new Dimension(175, 200));
		panDessin.setPreferredSize(new Dimension(175, 200));
		panDessin.setBackground(new Color(248, 236, 242));
		panDessin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dessin", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panDessin.setLayout(new GridLayout(0, 1, 15, 0));
		panActions.add(panDessin);
		panFormes.setSize(new Dimension(175, 200));
		panFormes.setPreferredSize(new Dimension(175, 200));
		panFormes.setBackground(new Color(248, 236, 242));
		panFormes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Formes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panFormes.setLayout(new GridLayout(4, 2, 5, 5));
		panActions.add(panFormes);
		panEpaisseur.setBackground(new Color(248, 236, 242));
		panEpaisseur.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u00C9paisseur", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panEpaisseur.setSize(new Dimension(175, 130));
		panEpaisseur.setPreferredSize(new Dimension(175, 130));
		panActions.add(panEpaisseur);
		panEpaisseur.setLayout(null);
		slider.setMinimum(1);
		slider.setMaximum(128);
		slider.setBounds(10, 48, 99, 34);
		slider.setBackground(new Color(248, 236, 242));
		panEpaisseur.add(slider);
		lbl1px.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl1px.setBounds(10, 93, 28, 14);
		panEpaisseur.add(lbl1px);
		lbl128px.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl128px.setBounds(81, 93, 28, 14);
		panEpaisseur.add(lbl128px);
		textEpaisseur = new JTextField();
		textEpaisseur.setEditable(false);
		textEpaisseur.setBounds(115, 55, 50, 20);
		panEpaisseur.add(textEpaisseur);
		textEpaisseur.setColumns(10);
		panCouleurs.setSize(new Dimension(175, 200));
		panCouleurs.setPreferredSize(new Dimension(175, 200));
		panCouleurs.setBackground(new Color(248, 236, 242));
		panCouleurs.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Couleurs", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panCouleurs.setLayout(new GridLayout(0, 2, 5, 5));
		panActions.add(panCouleurs);
		btnCrayon.setBackground(Color.WHITE);
		btnCrayon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCrayon.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/crayon.png")));
		panDessin.add(btnCrayon);
		btnEffacerUn.setBackground(Color.WHITE);
		btnEffacerUn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEffacerUn.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/efface.png")));
		panDessin.add(btnEffacerUn);
		btnEffacerTout.setBackground(Color.WHITE);
		btnEffacerTout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEffacerTout.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/effacer-tout.png")));
		panDessin.add(btnEffacerTout);
		btnLigne.setBackground(Color.WHITE);
		btnLigne.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/ligne.png")));
		panFormes.add(btnLigne);
		btnArc.setBackground(Color.WHITE);
		btnArc.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/arc.png")));
		panFormes.add(btnArc);
		btnOvale.setBackground(Color.WHITE);
		btnOvale.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/cercle.png")));
		panFormes.add(btnOvale);
		btnOvalePlein.setBackground(Color.WHITE);
		btnOvalePlein.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/cercle-plein.png")));
		panFormes.add(btnOvalePlein);
		btnRectangle.setBackground(Color.WHITE);
		btnRectangle.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/rectangle.png")));
		panFormes.add(btnRectangle);
		btnRectanglePlein.setBackground(Color.WHITE);
		btnRectanglePlein.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/rectangle-plein.png")));
		panFormes.add(btnRectanglePlein);
		btnRectArr.setBackground(Color.WHITE);
		btnRectArr.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/rectangle-arrondi.png")));
		panFormes.add(btnRectArr);
		btnRectArrPlein.setBackground(Color.WHITE);
		btnRectArrPlein.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("images/rectangle-arrondi-plein.png")));
		panFormes.add(btnRectArrPlein);
		lblArrierePlan.setHorizontalAlignment(SwingConstants.RIGHT);
		panCouleurs.add(lblArrierePlan);
		btnArrierePlan.setBackground(panCanevas.getCouleurPanneau());
		panCouleurs.add(btnArrierePlan);
		lblDessin.setHorizontalAlignment(SwingConstants.RIGHT);
		panCouleurs.add(lblDessin);
		btnDessin.setBackground(panCanevas.getcouleurDessin());
		panCouleurs.add(btnDessin);
		
		//Placer l'épaisseur à 1px par défaut
		slider.setValue(1);
		textEpaisseur.setText("" + slider.getValue() + " px");
		panCanevas.setEpaisseur(slider.getValue());
		
		//Ajouter les action command pour les boutons sans texte
		btnArrierePlan.setActionCommand("Arrière-plan");
		btnDessin.setActionCommand("Dessin");
		btnLigne.setActionCommand("Ligne");
		btnArc.setActionCommand("Arc");
		btnOvale.setActionCommand("Ovale");
		btnOvalePlein.setActionCommand("Ovale plein");
		btnRectangle.setActionCommand("Rectangle");
		btnRectanglePlein.setActionCommand("Rectangle plein");
		btnRectArr.setActionCommand("Rectangle arrondi");
		btnRectArrPlein.setActionCommand("Rectangle arrondi plein");
		
		//Ajouter l'écouteur d'événements de la barre de menus
		mntmNouveau.addActionListener(new MenuListener());
		mntmOuvrir.addActionListener(new MenuListener());
		mntmEnregistrer.addActionListener(new MenuListener());
		mntmQuitter.addActionListener(new MenuListener());
		mntmAPropos.addActionListener(new MenuListener());
		
		//Ajouter l'écouteur d'événements des boutons
		btnCrayon.addActionListener(new BoutonListener());
		btnEffacerUn.addActionListener(new BoutonListener());
		btnEffacerTout.addActionListener(new BoutonListener());
		btnLigne.addActionListener(new BoutonListener());
		btnArc.addActionListener(new BoutonListener());
		btnOvale.addActionListener(new BoutonListener());
		btnOvalePlein.addActionListener(new BoutonListener());
		btnRectangle.addActionListener(new BoutonListener());
		btnRectanglePlein.addActionListener(new BoutonListener());
		btnRectArr.addActionListener(new BoutonListener());
		btnRectArrPlein.addActionListener(new BoutonListener());
		btnArrierePlan.addActionListener(new BoutonListener());
		btnDessin.addActionListener(new BoutonListener());
		
		//Ajouter l'écouteur d'événements du slider (épaisseur)
		slider.addChangeListener(new SliderListener());
		
	}
	
	/**------------------------------------------------------------------------------------------------------
	 * ÉCOUTEUR DES ÉVÉNEMENTS DE LA BARRE DE MENUS
	 * ------------------------------------------------------------------------------------------------------
	 */
	private class MenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent menu) {
			
			switch(menu.getActionCommand()) {
			case "Nouveau":
				panCanevas.nouveau();break;
			case "Ouvrir":
				panCanevas.ouvrir();break;
			case "Enregistrer":
				panCanevas.sauvegarder();break;
			case "Quitter":
				int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ?", "Quitter", JOptionPane.YES_NO_OPTION);
				if (choix == JOptionPane.YES_OPTION){
					System.exit(0);
				}
				break;
			case "À propos":
				JOptionPane.showMessageDialog(null, 
					"Collège Ahuntsic\n" +
					"Fait par: Nadine Pierre\n" +
					"©2018", 
					"À propos du Logiciel de dessin", 
					2, new ImageIcon(FenetrePrincipale.class.getResource("images/logo.png")));
				break;
			}
		
		}
		
	}
	
	/**------------------------------------------------------------------------------------------------------
	 * ÉCOUTEUR DES ÉVÉNEMENTS DES BOUTONS
	 * ------------------------------------------------------------------------------------------------------
	 */
	private class BoutonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent bouton) {
			switch(bouton.getActionCommand()) {
			case "Crayon":
				panCanevas.setDessinChoisi(Dessins.CRAYON);
				break;
			case "Effacer":
				panCanevas.effacer();
				break;
			case "Effacer tout":
				panCanevas.effacerTout();
				break;
			case "Ligne": 
				panCanevas.setDessinChoisi(Dessins.LIGNE_DROITE); 
				break;
			case "Arc": 
				panCanevas.setDessinChoisi(Dessins.ARC); 
				break;
			case "Ovale": 
				panCanevas.setDessinChoisi(Dessins.OVALE); 
				panCanevas.setPlein(false);
				break;
			case "Ovale plein":
				panCanevas.setDessinChoisi(Dessins.OVALE);
				panCanevas.setPlein(true);
				break;
			case "Rectangle": 
				panCanevas.setDessinChoisi(Dessins.RECTANGLE); 
				panCanevas.setPlein(false);
				break;
			case "Rectangle plein":
				panCanevas.setDessinChoisi(Dessins.RECTANGLE);
				panCanevas.setPlein(true);
				break;
			case "Rectangle arrondi": 
				panCanevas.setDessinChoisi(Dessins.RECTANGLE_ARRONDI); 
				panCanevas.setPlein(false);
				break;
			case "Rectangle arrondi plein":
				panCanevas.setDessinChoisi(Dessins.RECTANGLE_ARRONDI);
				panCanevas.setPlein(true);
				break;
			case "Arrière-plan": 
				couleurPanneau = JColorChooser.showDialog(null, "Couleur de l'arrière-plan", couleurPanneau);
				btnArrierePlan.setBackground(couleurPanneau);
				panCanevas.setCouleurPanneau(couleurPanneau);
				panCanevas.repaint();
				break;
			case "Dessin": 
				couleurDessin = JColorChooser.showDialog(null, "Couleur du dessin", couleurDessin);
				btnDessin.setBackground(couleurDessin);
				panCanevas.setCouleurDessin(couleurDessin);
				panCanevas.repaint();
				break;
			}
		}
		
	}
	
	/**------------------------------------------------------------------------------------------------------
	 * ÉCOUTEUR DES ÉVÉNEMENTS DU SLIDER
	 * ------------------------------------------------------------------------------------------------------
	 */
	private class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent arg0) {
			panCanevas.setEpaisseur(slider.getValue());
			textEpaisseur.setText("" + slider.getValue() + " px");
		}
	}
	

	/**
	 * Méthode principale qui lance le programme
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
