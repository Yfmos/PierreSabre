package personnages;

public class Samourai extends Humain {
	
	private String seigneur;

	public Samourai(String seigneur, String nom, String boissonPreference, int argent) {
        super(nom, boissonPreference, argent); 
        this.seigneur = seigneur;
    }
	
	@Override
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + getNom() + " et j’aime boire du " + getBoissonFavorite() + ".");
		parler("Je suis fier de servir le seigneur " + seigneur);
	}
	
	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson + ".");
	}
}