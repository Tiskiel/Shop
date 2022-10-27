package Shop;

public abstract class Products {
    private String brand;
    private int price;

    public Products(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    protected void setBrand(String brand) {
        this.brand = brand;
    }

    protected void setPrice(int price) {
        this.price = price;
    }


}
