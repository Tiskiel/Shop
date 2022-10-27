package Shop;

import java.time.LocalDate;

public class Tomatos extends Products implements IPerishable{

    private String varietys;
    private LocalDate perishableDate;

    public Tomatos(String brand, int price) {
        super(brand, price);
        LocalDate today = LocalDate.now();
        this.perishableDate = today.plusDays(5);
    }

    public String getVarietys() {
        return varietys;
    }

    public void setVarietys(String varietys) {
        if(varietys == "") return;
        this.varietys = varietys;
    }

    public LocalDate getPerishableDate() {
        return perishableDate;
    }

    @Override
    public LocalDate getDatePeremtion() {
        return getPerishableDate();
    }
}
