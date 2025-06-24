public class Main {

    public static void main(String[] args) {
        MazzoCarte mazzo = new MazzoCarte(); // crea e mischia il mazzo
        Giocatore giocatore1 = new Giocatore("Matteo");
        Giocatore giocatore2 = new Giocatore("Bot");

        // Entrambi i giocatori pescano 3 carte iniziali
        for (int i = 0; i < 3; i++) {
            giocatore1.pescaCarta(mazzo);
            giocatore2.pescaCarta(mazzo);
        }

        System.out.println("Inizio partita!");

        while (!mazzo.fineMazzo()) {
            System.out.println(giocatore1.getNomeGiocatore() + " ha: " + giocatore1.getCarteGiocatore());
            System.out.println(giocatore2.getNomeGiocatore() + " ha: " + giocatore2.getCarteGiocatore());

            // Giocano la prima carta in mano (indice 0)
            Carta carta1 = giocatore1.giocaCarta(0);
            Carta carta2 = giocatore2.giocaCarta(0);

            System.out.println("Mano: " + carta1 + " vs " + carta2);

            if (carta1.getPunti() > carta2.getPunti()) {
                System.out.println(giocatore1.getNomeGiocatore() + " vince la mano!\n");
            } else if (carta2.getPunti() > carta1.getPunti()) {
                System.out.println(giocatore2.getNomeGiocatore() + " vince la mano!\n");
            } else {
                System.out.println("Pareggio!\n");
            }

            // Ogni giocatore pesca una carta
            giocatore1.pescaCarta(mazzo);
            giocatore2.pescaCarta(mazzo);
        }

        System.out.println("Partita finita! Il mazzo è vuoto.");
    }
}
