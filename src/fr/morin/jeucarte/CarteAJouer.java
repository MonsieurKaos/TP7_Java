package fr.morin.jeucarte;

public class CarteAJouer {
    private String couleur = "";
    private String valeur = "";

    private static final String[] Couleurs = {"Pique", "Trefle", "Carreau", "Coeur"};
    private static final String[] Valeurs = {"AS", "DEUX", "TROIS", "QUATRE", "CINQ", "SIX", "SEPT", "HUIT", "NEUF", "DIX", "Valet", "Dame", "Roi"};

    public CarteAJouer(String couleur, String valeur){
        if (isValidCouleur(couleur) && isValidValeur(valeur)) {
            this.couleur = couleur;
            this.valeur = valeur;
        } else if (!isValidCouleur(couleur)) {
            throw new IllegalArgumentException("Couleur invalide : " + couleur);
        } else {
            throw new IllegalArgumentException("Valeur invalide : " + valeur);
        }
    }

    private static boolean isValidCouleur(String couleur) {
        for (String couleurValide : Couleurs) {
            if (couleurValide.equals(couleur)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidValeur(String valeur) {
        for (String valeurValide : Valeurs) {
            if (valeurValide.equals(valeur)) {
                return true;
            }
        }
        return false;
    }
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        if (isValidCouleur(couleur)) {
            this.couleur = couleur;
        } else {
            throw new IllegalArgumentException("Couleur invalide : " + couleur);
        }
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return valeur + " de " + couleur;
    }
}
