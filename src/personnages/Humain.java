package personnages;



public class Humain {
    private String nom;
    private String boissonFavorite;
    private int argent;
    protected int nbConnaissance;
    protected Humain[] memoire = new Humain[30];

    public Humain(String nom, String boissonFavorite, int argent) {
        this.nom = nom;
        this.boissonFavorite = boissonFavorite;
        this.argent = argent;   
    }

    public String getNom() {
        return nom;
    }
    
    public String getBoissonFavorite() {
		return boissonFavorite;
	}

    public int getArgent() {
        return argent;
    }

    protected void gagnerArgent(int gain) {
        argent += gain;
    }

    protected void perdreArgent(int perte) {
        argent -= perte;
    }

    protected void parler(String texte) {
        System.out.println("(" + nom + ") - " + texte);
    }

    public void direBonjour() {
        parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite + ".");
    }

    public void boire() {
        parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
    }

    public void acheter(String bien, int prix) {
        if (argent >= prix) {
            parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
            perdreArgent(prix);
        } else {
            parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous.");
        }
    }
    
    public void faireConaissanceAvec(Humain humain) {
    	direBonjour();
    	humain.repondre(this);
    	memoriser(humain);
    }
    
    private void memoriser(Humain humain) {
	if (nbConnaissance==30) {
		for (int i = 1; i < nbConnaissance; i++) {
			memoire[i-1] = memoire[i];
		}
		
		memoire[nbConnaissance] = humain;
	}
	else {
		memoire[nbConnaissance] = humain;
		nbConnaissance++;
	}
	}
    
    private void repondre(Humain humain) {
	direBonjour();
	memoriser(humain);
	}
    
    public void listerConnaissance() {
    	System.out.print("(" + getNom() + ") - J'ai fait la conaissance de ");
		for (int i = 0; i < nbConnaissance; i++) {
			System.out.print(memoire[i].getNom());
			if (i!=30 && memoire[i+1]!=null ) {
				System.out.print(", ");
			}
		}
		System.out.println("");
	}
}
