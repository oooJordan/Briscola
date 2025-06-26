import java.util.List;
import java.util.Scanner;

public class Partita {
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private MazzoCarte mazzoCarte;
    private Carta.seme_carta semeDiBriscola;
    private Carta cartaBriscola;
    private Giocatore primoGiocatore;

    public Partita(String nomeGiocatore1, String nomeGiocatore2){
        this.mazzoCarte = new MazzoCarte();
        this.giocatore1 = new Giocatore(nomeGiocatore1);
        this.giocatore2 = new Giocatore(nomeGiocatore2);

        //Peschiamo la briscola
        this.cartaBriscola = mazzoCarte.getCarta();
        this.semeDiBriscola = cartaBriscola.ottieni_seme_carta();
        System.out.println("La briscola è: " + cartaBriscola);

        mazzoCarte.briscolaInFondo(cartaBriscola);

        for(int i=0; i<3; i++){
            giocatore1.pescaCarta(mazzoCarte);
            giocatore2.pescaCarta(mazzoCarte);
        }

        this.primoGiocatore = giocatore1;

        giocaPartita();
    }


    private void giocaPartita(){
        while(mazzoCarte.getNumeroCarte() >= 2){
            Giocatore secondoGiocatore = (primoGiocatore == giocatore1) ? giocatore2 : giocatore1;
            System.out.println(primoGiocatore.getNomeGiocatore() + " ha: " + primoGiocatore.getCarteGiocatore());
            System.out.println(secondoGiocatore.getNomeGiocatore() + " ha: " + secondoGiocatore.getCarteGiocatore());

            Carta carta1 = sceltaCarta(primoGiocatore);
            Carta carta2 = sceltaCarta(secondoGiocatore);

            System.out.println("Mano: " + carta1 + " vs " + carta2);

            Giocatore vincitore = vincitoreMano(primoGiocatore, secondoGiocatore, carta1, carta2);

            System.out.println(vincitore.getNomeGiocatore() + " vince la mano!");

            vincitore.pescaCarta(mazzoCarte);
            (vincitore == primoGiocatore ? secondoGiocatore : primoGiocatore).pescaCarta(mazzoCarte);

            primoGiocatore = vincitore;

        }
 
    }

    private Giocatore vincitoreMano(Giocatore gioc1, Giocatore gioc2, Carta carta1, Carta carta2){
        if (carta1.ottieni_seme_carta() == carta2.ottieni_seme_carta()){
            return carta1.getPunti() > carta2.getPunti() ? gioc1 : gioc2;
        } else if(carta1.ottieni_seme_carta() == semeDiBriscola){
            return gioc1;
        } else if(carta2.ottieni_seme_carta() == semeDiBriscola){
            return gioc2;
        } else{
            return gioc1;
        }
    }
    
    private final Scanner scanner = new Scanner(System.in);

    private Carta sceltaCarta(Giocatore g){
        List<Carta> carte = g.getCarteGiocatore();

        System.out.println("\n" + g.getNomeGiocatore() + " gioca la tua carta");

        for(int i=0; i<carte.size(); i++){
            System.out.println(i + ") " + carte.get(i));
        }

        int sceltaeffettuata = -1;
        while(sceltaeffettuata < 0 || sceltaeffettuata > carte.size()){
            System.out.println("\n TICTAC SCEGLI LA CARTA \n");

            if(scanner.hasNextInt()){
                sceltaeffettuata = scanner.nextInt();
            }else{
                scanner.next();
            }
        }
        return g.giocaCarta(sceltaeffettuata);
    }
}
