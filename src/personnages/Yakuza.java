package personnages;

public class Yakuza extends Humain {

    private String clan;
    private int reputation = 4;

    public Yakuza(String nom, String boissonPreference, int argent, String clan) {
        super(nom, boissonPreference, argent);
        this.clan = clan;
    }

    public void extorquer(Commercant victime) {
        parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
        parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
        int argent = victime.seFaireExtorquer();
        gagnerArgent(argent);
        reputation++;
        parler("J’ai piqué les " + argent + " sous de " + victime.getNom() +
               ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi ! Hi !");
    }

    public int perdre() {
        int argentPerdu = getArgent();
        perdreArgent(argentPerdu);
        reputation--;
        parler("J’ai perdu mon duel et mes " + argentPerdu + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
        return argentPerdu;
    }

    public void gagner(int gain) {
        gagnerArgent(gain);
        reputation++;
        parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
    }

    public int getReputation() {
        return reputation;
    }
}
