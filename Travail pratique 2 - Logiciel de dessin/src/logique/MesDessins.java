package logique;

/**
 * Classe qui d�finit un type MesFormes
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
	 * M�THODES G�N�RALES
	 * ------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * M�thode qui lit un fichier XML re�u en param�tre et remplit la liste de dessins
	 * @param fichier	le fichier � lire
	 * @throws IOException	en cas de probl�me de lecture
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
	 * M�thode qui calcule la taille de la liste de dessins
	 * @return le nombre d'�l�ments de la liste
	 */
	public int size() {
		return lDessins.size();
	}
	
	/**
	 * M�thode qui valide si la liste est vide
	 * @return true (vide) or false (non-vide)
	 */
	public boolean isEmpty() {
		return lDessins.isEmpty();
	}
	
	/**
	 * M�thode qui retourne un dessin
	 * @param index	la position dans la liste
	 * @return un objet de type Forme ou Crayon
	 */
	public Dessin getDessin(int index) {
		return lDessins.get(index);
	}
	
	
	/**
	 * M�thode qui ajoute dans la liste un dessin
	 * @param dessin	le dessin re�u en param�tre
	 */
	public void ajouterDessin(Dessin dessin) {
		lDessins.add(dessin);
	}
	
	/**
	 * M�thode qui efface le dernier �l�ment de la liste
	 */
	public void effacer() {
		if(!lDessins.isEmpty()) {
			lDessins.remove(lDessins.size() -1);
		}
	}
	
	/**
	 * M�thode qui efface tout le contenu de la liste
	 */
	public void effacerTout() {
		if(!lDessins.isEmpty()) {
			lDessins.removeAll(lDessins);
		}
	}
	
	/**
	 * M�thode qui d�finit l'it�rateur de dessins
	 */
	@Override
	public Iterator<Dessin> iterator() {
		return lDessins.iterator();
	}
	
	
	/**
	 * M�thode qui affiche le contenu de la liste de dessins
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
	 * M�thode qui permet de sauvegarder la liste de dessins dans un fichier XML
	 * @param fichier	le fichier qui sera cr��
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
