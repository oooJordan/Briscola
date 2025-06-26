import java.util.*;


public class MazzoCarte {

    private final List<Carta> carteMazzo;

    public MazzoCarte() {
        // inizializza il mazzo come una lista vuota
        carteMazzo = new ArrayList<>();
        // per ogni combinazione di seme e valore, aggiunge una carta al mazzo
        for (Carta.seme_carta s : Carta.seme_carta.values()) {
            for (Carta.valore_carta v : Carta.valore_carta.values()) {
                carteMazzo.add(new Carta(s, v));
            }
        }
        // mescola tutti gli elementi del mazzo
        Collections.shuffle(carteMazzo);
    }
    
    // Pesca una carta dal mazzo e la rimuove
    public Carta getCarta() {
        return carteMazzo.remove(0);
    }

    // Ritorna il numero di carte rimaste nel mazzo
    public int getNumeroCarte() {
        return carteMazzo.size();
    }

    public void briscolaInFondo(Carta briscola){
        carteMazzo.add(briscola);
    }

}
