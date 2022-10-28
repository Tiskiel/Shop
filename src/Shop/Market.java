package Shop;


import com.sun.source.tree.LiteralTree;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Market {

    private static Market instance;
    public String value;

    public static Market getInstance(String value) {
        if (instance == null)
            instance = new Market(value);
        return instance;
    }

    private Market(String value) {
        try {
            Thread.sleep(1000);
        }  catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public String ticket(int ageCustomer, Products... products) {

        List<String> basket = new ArrayList<String>();

        int total = 0;

        for (Products product : products) {

            if (product instanceof IPerishable) {

                if (((IPerishable) product).getDatePeremtion().isBefore(LocalDate.now())) {

                    if (product instanceof Beers
                            && ((Beers) product).isAuthorized(ageCustomer)) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice() + "€"
                                        + " perishable date : "
                                            + ((IPerishable) product).getDatePeremtion()
                                                + "\n");

                    }

                    if (product instanceof Beers
                            && !((Beers) product).isAuthorized(ageCustomer)
                                && ((Beers) product).getRateAlcool() == 0) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice() + "€"
                                        + " perishable date : "
                                            + ((IPerishable) product).getDatePeremtion()
                                                + "\n");

                    }

                    basket.add("Product : "
                            + product.getBrand() + " : "
                                + product.getPrice() + "€"
                                    + " perishable date : "
                                        + ((IPerishable) product).getDatePeremtion()
                                            + "\n");

                } else {

                    if (product instanceof Beers
                            && ((Beers) product).isAuthorized(ageCustomer)) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice() + "€"
                                        + "\n");

                        total += product.getPrice();
                    }

                    if (product instanceof Beers
                            && !((Beers) product).isAuthorized(ageCustomer)
                                && ((Beers) product).getRateAlcool() == 0) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice() + "€"
                                        + " : free alcool beer "
                                            + "\n");

                        total += product.getPrice();
                    }

                    if(product instanceof Tomatos) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice() + "€"
                                        + "\n");

                        total += product.getPrice();
                    }


                }
            }

            if(product instanceof CigarettesPacks
                    && !((CigarettesPacks) product).isAuthorized(ageCustomer)) {

                basket.add("You can't buy cigarets pack cause you don't have age !");

            }

            if(product instanceof CigarettesPacks
                    && ((CigarettesPacks) product).isAuthorized(ageCustomer)) {

                basket.add("Product : "
                        + product.getBrand() + " : "
                            + product.getPrice() + "€"
                                + "\n");

                total += product.getPrice();

            }


        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-->                           TICKET                          <--");
        System.out.println("-----------------------------------------------------------------");
        for (String product : basket) {
            System.out.println("--> " + product);
        }
        System.out.println("--> "+total+"€"+"                                                       <--");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-->                    Thank you for your visit               <--");
        System.out.println("--> "+LocalDate.now()+" : "+LocalTime.now()+"                           <--");
        System.out.println("-----------------------------------------------------------------");
        return "Here you are, your ticket !";

    }
}