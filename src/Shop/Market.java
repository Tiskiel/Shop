package Shop;


import com.sun.source.tree.LiteralTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Market {

    private static Market instance;

    public static Market getInstance() {
        if (instance == null)
            instance = new Market();
        return instance;
    }

    private Market() {

    }

    public String ticket(int ageCustomer, Products... products) {

        List<String> basket = new ArrayList<String>();

        int total = 0;

        for (Products product : products) {

            if (product instanceof IPerishable) {

                if ((((IPerishable) product).getDatePeremtion().getDayOfMonth() < LocalDate.now().getDayOfMonth())
                        && (((IPerishable) product).getDatePeremtion().getMonth() != LocalDate.now().getMonth())) {

                    if (product instanceof Beers
                            && ((Beers) product).isAuthorized(ageCustomer)) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice()
                                        + " perishable date : "
                                            + "<--"
                                                + ((IPerishable) product).getDatePeremtion()
                                                    + "\n");

                    }

                    if (product instanceof Beers
                            && !((Beers) product).isAuthorized(ageCustomer)
                                && ((Beers) product).getRateAlcool() == 0) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice()
                                        + " perishable date : "
                                            + ((IPerishable) product).getDatePeremtion()
                                                + "<--"
                                                    + "\n");

                    }

                    basket.add("Product : "
                            + product.getBrand() + " : "
                                + product.getPrice()
                                    + " perishable date : "
                                        + "<--"
                                            + ((IPerishable) product).getDatePeremtion()
                                                + "\n");

                } else {

                    if (product instanceof Beers
                            && ((Beers) product).isAuthorized(ageCustomer)) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice()
                                        + "<--"
                                            + "\n");

                        total += product.getPrice();
                    }

                    if (product instanceof Beers
                            && !((Beers) product).isAuthorized(ageCustomer)
                                && ((Beers) product).getRateAlcool() == 0) {

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice()
                                        + " : free alcool beer "
                                            + "<--"
                                                + "\n");

                        total += product.getPrice();
                    }

                        basket.add("Product : "
                                + product.getBrand() + " : "
                                    + product.getPrice()
                                        + "<--"
                                            + "\n");

                        total += product.getPrice();
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
                            + product.getPrice()
                                + "<--"
                                    + "\n");

                total += product.getPrice();

            }


        }
        System.out.println("--------------------------------------------------");
        System.out.println("-->                   TICKET                   <--");
        System.out.println("--------------------------------------------------");
        for (String product : basket) {
            System.out.println("--> " + product);
        }
        System.out.println("--> "+total+"                                      <--");
        System.out.println("--------------------------------------------------");
        System.out.println("-->          Thank you for your visit          <--");
        System.out.println("--> "+LocalDate.now()+"                            <--");
        System.out.println("--------------------------------------------------");
        return "Here you are, your ticket !";
    }
}