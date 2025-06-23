public class Carta {

    public enum seme_carta {
        DENARA, COPPE, SPADE, BASTONI
    }

    public enum valore_carta {
        UNO(11), DUE(0), TRE(10), QUATTRO(0), CINQUE(0),
        SEI(0), SETTE(0), FANTE(2), CAVALLO(3), RE(4);

        private final int punti;

        valore_carta(int punti) {
            this.punti = punti;
        }

        public int getPunti() {
            return punti;
        }
    }

    private seme_carta s;
    private valore_carta v;

    public Carta(seme_carta s, valore_carta v) {
        this.s = s;
        this.v = v;
    }

    public seme_carta ottieni_seme_carta() {
        return s;
    }

    public valore_carta ottieni_valore_carta() {
        return v;
    }

    public int getPunti() {
        return v.getPunti();
    }

    @Override
    public String toString() {
        return v + " di " + s;
    }
}
