package Shop;

import java.time.LocalDate;

public class Beers extends Products implements IPerishable, ILegalAge{

    private int rateAlcool;
    private final LocalDate perishableDate;

    public Beers(String brand, int price) {
        super(brand, price);
        LocalDate today = LocalDate.now();
        this.perishableDate = today.plusDays(5);
    }

    public int getRateAlcool() {
        return rateAlcool;
    }

    public void setRateAlcool(int rate) {
        if (rateAlcool >= 0) this.rateAlcool = rate;
    }


    public LocalDate getPerishableDate() {
        return perishableDate;
    }

    @Override
    public LocalDate getDatePeremtion() {
        return getPerishableDate();
    }


    @Override
    public boolean isAuthorized(int age) {
        return age >= 16;
    }
}
