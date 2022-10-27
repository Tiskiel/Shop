package Products;

public class CigarettesPacks extends Products implements ILegalAge{

    private int numberCigarettes;

    public CigarettesPacks(String brand, int price) {
        super(brand, price);
    }

    public int getNumberCigarettes() {
        return numberCigarettes;
    }

    public void setNumberCigarettes(int numberCigarettes) {
        if(numberCigarettes < 0 ) return;
        this.numberCigarettes = numberCigarettes;
    }


    @Override
    public boolean isAuthorized(int age) {
        return age >= 18;
    }
}
