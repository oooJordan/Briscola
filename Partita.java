import java.util.List;
import java.util.Scanner;

public class Partita {
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private MazzoCarte mazzoCarte;
    private Carta.seme_carta SemeDiBriscola;
    private Carta CartaBriscola;
    private Giocatore PrimoGiocatore;

    public Partita(String nomegiocatore1, String nomegiocatore2){
        this.mazzoCarte = new MazzoCarte();
        this.giocatore1 = new Giocatore(nomegiocatore1);
        this.giocatore2 = new Giocatore(nomegiocatore2);

        //Peschiamo la briscola
        this.CartaBriscola = mazzoCarte.pescaCarta();
        this.SemeDiBriscola = CartaBriscola.ottieni_seme_carta();
        System.out.println("La briscola è: " + CartaBriscola);

        mazzoCarte.BriscolaInFondo(CartaBriscola);

        for(int i=0; i<3; i++){
            giocatore1.pescaCarta(mazzoCarte);
            giocatore2.pescaCarta(mazzoCarte);
        }

        this.PrimoGiocatore = giocatore1;
    }


    public void giocaPartita(){
        while(mazzoCarte.fineMazzo() != true){
            Giocatore secondoGiocatore = (PrimoGiocatore == giocatore1) ? giocatore2 : giocatore1;
            System.out.println(PrimoGiocatore.getNomeGiocatore() + " ha: " + PrimoGiocatore.getCarteGiocatore());
            System.out.println(secondoGiocatore.getNomeGiocatore() + " ha: " + secondoGiocatore.getCarteGiocatore());

            Carta carta1 = sceltaCarta(PrimoGiocatore);
            Carta carta2 = sceltaCarta(secondoGiocatore);

            System.out.println("Mano: " + carta1 + " vs " + carta2);

            Giocatore vincitore = VincitoreMano(PrimoGiocatore, secondoGiocatore, carta1, carta2);

            System.out.println(vincitore.getNomeGiocatore() + " vince la mano!");

            if(mazzoCarte.fineMazzo() != true){
                vincitore.pescaCarta(mazzoCarte);
            }
            if(mazzoCarte.fineMazzo() != true){
                (vincitore == PrimoGiocatore ? secondoGiocatore : PrimoGiocatore).pescaCarta(mazzoCarte);
            }

            PrimoGiocatore = vincitore;

        }
 
    }

    private Giocatore VincitoreMano(Giocatore gioc1, Giocatore gioc2, Carta carta1, Carta carta2){
        if (carta1.ottieni_seme_carta() == carta2.ottieni_seme_carta()){
                return carta1.getPunti() > carta2.getPunti() ? gioc1 : gioc2;
            } else if(carta1.ottieni_seme_carta() == SemeDiBriscola){
                return gioc1;
            } else if(carta2.ottieni_seme_carta() == SemeDiBriscola){
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
