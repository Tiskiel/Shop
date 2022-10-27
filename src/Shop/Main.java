package Shop;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Market instance = Market.getInstance("Run");

        Tomatos tomatos1 = new Tomatos("Noir de crimée", 15);
        Tomatos tomatos2 = new Tomatos("Coeur de boeuf", 8);

        Beers beers1 = new Beers("Urine", 3,6);
        Beers beers2 = new Beers("Fat grisou", 4, 9);
        Beers beers3 = new Beers("Kriek 0%", 4, 0);

        CigarettesPacks cp1 = new CigarettesPacks("Malborro", 15);
        CigarettesPacks cp2 = new CigarettesPacks("Gauloise", 18);

        instance.ticket(14, tomatos1, tomatos2, beers2, beers1, beers3, cp1, cp2);


    }
}