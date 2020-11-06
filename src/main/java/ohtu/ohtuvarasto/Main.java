package ohtu.ohtuvarasto;

public class Main {

    static Varasto mehua = new Varasto(100.0);
    static  Varasto olutta = new Varasto(100.0, 20.2);

    public static void main(String[] args) {
        one();
        two();
        three();    
    }

    private static void one() {
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());
        System.out.println("Mehusetterit:");
        
    }

    private static void two() {
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(50.7);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(3.14);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");    
    }

    private static void three() {
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);
        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(100.0, -50.7);
        System.out.println(huono);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(1000.0);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Mehuvarasto: " + mehua);
    }

    private static void four() {
        System.out.println("mehua.lisaaVarastoon(-666.0)");
        mehua.lisaaVarastoon(-666.0);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        double saatiin = olutta.otaVarastosta(1000.0);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        saatiin = mehua.otaVarastosta(-32.9);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);
    }
}
