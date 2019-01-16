package logique;

/**
 * Classe qui définit un type MesFormes
 * qui est une liste de formes et de dessins libres
 */

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MesDessins implements Iterable<Dessin>, Serializable {
	
	/*------------------------------------------------------------------------------------------------------
	 * ATTRIBUT
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	private ArrayList<Dessin> lDessins;
	

	/*------------------------------------------------------------------------------------------------------
	 * CONSTRUCTEUR
	 * ------------------------------------------------------------------------------------------------------
	 */
	public MesDessins() {
		lDessins = new ArrayList<Dessin>();
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * ACCESSEUR ET MUTATEUR
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	public ArrayList<Dessin> getLDessins() {
		return lDessins;
	}

	public void setLDessins(ArrayList<Dessin> lDessins) {
		this.lDessins = lDessins;
	}
	
	
	/*------------------------------------------------------------------------------------------------------
	 * MÉTHODES GÉNÉRALES
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Méthode qui lit un fichier XML reçu en paramètre et remplit la liste de dessins
	 * @param fichier	le fichier à lire
	 * @throws IOException	en cas de problème de lecture
	 */
	public void charger(String fichier) throws IOException{
		XMLDecoder entree = new XMLDecoder(new FileInputStream (fichier));
		boolean eof = false;
		Object o;
		Dessin d;
		
		while(!eof) {
			try {
				o = entree.readObject();
				d = (Dessin) o;
				lDessins.add(d);
				
			}
			catch (Exception e) {
				eof = true;
			}
		}
		entree.close();
		
	}
	
	/**
	 * Méthode qui calcule la taille de la liste de dessins
	 * @return le nombre d'éléments de la liste
	 */
	public int size() {
		return lDessins.size();
	}
	
	/**
	 * Méthode qui valide si la liste est vide
	 * @return true (vide) or false (non-vide)
	 */
	public boolean isEmpty() {
		return lDessins.isEmpty();
	}
	
	/**
	 * Méthode qui retourne un dessin
	 * @param index	la position dans la liste
	 * @return un objet de type Forme ou Crayon
	 */
	public Dessin getDessin(int index) {
		return lDessins.get(index);
	}
	
	
	/**
	 * Méthode qui ajoute dans la liste un dessin
	 * @param dessin	le dessin reçu en paramètre
	 */
	public void ajouterDessin(Dessin dessin) {
		lDessins.add(dessin);
	}
	
	/**
	 * Méthode qui efface le dernier élément de la liste
	 */
	public void effacer() {
		if(!lDessins.isEmpty()) {
			lDessins.remove(lDessins.size() -1);
		}
	}
	
	/**
	 * Méthode qui efface tout le contenu de la liste
	 */
	public void effacerTout() {
		if(!lDessins.isEmpty()) {
			lDessins.removeAll(lDessins);
		}
	}
	
	/**
	 * Méthode qui définit l'itérateur de dessins
	 */
	@Override
	public Iterator<Dessin> iterator() {
		return lDessins.iterator();
	}
	
	
	/**
	 * Méthode qui affiche le contenu de la liste de dessins
	 */
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		for(Dessin dessin: lDessins){
			 sb.append("\n" + dessin.toString());
		}
		return sb.toString();
	}
	
	/**
	 * Méthode qui permet de sauvegarder la liste de dessins dans un fichier XML
	 * @param fichier	le fichier qui sera créé
	 * @throws IOException	en cas d'erreur de sauvegarde du fichier
	 */
	public void sauvegarder(String fichier) throws IOException{
		XMLEncoder sortie = new XMLEncoder(new FileOutputStream(fichier));
		
		for(Dessin d : lDessins) {
			sortie.writeObject(d);
		}
		sortie.close();
	}

	
	
	
	
	

	

	
	
	
	
	

	
	
	

}
