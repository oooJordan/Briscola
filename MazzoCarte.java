import java.util.*;


public class MazzoCarte {

    private List<Carta> carte_mazzo;

    public MazzoCarte() {
        // inizializza il mazzo come una lista vuota
        carte_mazzo = new ArrayList<>();
        // per ogni combinazione di seme e valore, aggiunge una carta al mazzo
        for (Carta.seme_carta s : Carta.seme_carta.values()) {
            for (Carta.valore_carta v : Carta.valore_carta.values()) {
                carte_mazzo.add(new Carta(s, v));
            }
        }
        // mescola tutti gli elementi del mazzo
        Collections.shuffle(carte_mazzo);
    }
    
    // Pesca una carta dal mazzo e la rimuove
    public Carta pescaCarta() {
        return carte_mazzo.remove(0);
    }

    // Ritorna il numero di carte rimaste nel mazzo
    public int getNumeroCarte() {
        return carte_mazzo.size();
    }

    // Ritorna true se il mazzo è finito, false altrimenti
    public boolean fineMazzo() {
        return carte_mazzo.isEmpty();
    }


}
