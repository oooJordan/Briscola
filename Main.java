public class Main {

    public static void main(String[] args) {
        Carta carta1 = new Carta(Carta.seme_carta.DENARA, Carta.valore_carta.UNO);
        Carta carta2 = new Carta(Carta.seme_carta.COPPE, Carta.valore_carta.FANTE);
        
        System.out.println("Carta 1: " + carta1);
        System.out.println("Punti Carta 1: " + carta1.getPunti());
        
        System.out.println("Carta 2: " + carta2);
        System.out.println("Punti Carta 2: " + carta2.getPunti());
    }
}