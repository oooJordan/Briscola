import java.util.*;

public class Giocatore {
    private String Nome;
    private List<Carta> CarteGiocatore;

    public Giocatore(String Nome){
        this.Nome = Nome;
        this.CarteGiocatore = new ArrayList<>();
    }

    public void pescaCarta(MazzoCarte mazzoCarte){
        if(mazzoCarte.getNumeroCarte() != 0){
            CarteGiocatore.add(mazzoCarte.pescaCarta());
        }
    }

    public Carta giocaCarta(int num){
        return CarteGiocatore.remove(num);
    }

    public List<Carta> getCarteGiocatore(){
        return CarteGiocatore;
    }

    public String getNomeGiocatore(){
        return Nome;
    }

    
}
