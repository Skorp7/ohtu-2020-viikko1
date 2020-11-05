package paaohjelma;
import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto olutta = new Varasto(100.0, 20.2);
    
        double saatiin = olutta.otaVarastosta(1000.0);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

    }
}
