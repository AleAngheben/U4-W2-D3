import Elements.Category;
import Elements.Customer;
import Elements.Order;
import Elements.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Category isCategory = (s, p) -> p.getCategory().equals(s);

        // CREO UNA LISTA DI PRODOTTI

        List<Product> productList = new ArrayList<>();

        Product prod1 = new Product("Scarpe Ginnastica", "Boys", 90.8);
        Product prod2 = new Product("Scarpe Calcio", "Boys", 143.4);
        Product prod3 = new Product("Maglietta Juventus", "Baby", 70.5);
        Product prod4 = new Product("Call of Duty IV", "Baby", 30.5);
        Product prod5 = new Product("Scarpe da ballo", "Books", 140.8);
        Product prod6 = new Product("Computer", "Boys", 679.0);
        Product prod7 = new Product("Mouse da gaming", "Informatica", 82.5);
        Product prod8 = new Product("Candela", "Books", 108.7);
        Product prod9 = new Product("Libro cuore", "Baby", 12.5);
        Product prod10 = new Product("Posacenere", "Books", 3.9);


        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);
        productList.add(prod5);
        productList.add(prod6);
        productList.add(prod7);
        productList.add(prod8);
        productList.add(prod9);
        productList.add(prod10);


        //CREO UNA LISTA DI CUSTOMER

        List<Customer> customerList = new ArrayList<>();

        Customer otman = new Customer("Otman", 9);
        Customer luca = new Customer("Luca", 7);
        Customer alessandro = new Customer("Alessandro", 2);
        Customer stefano = new Customer("Stefano", 2);
        Customer antonio = new Customer("Antonio", 1);


        //CREO UNA LISTA DI ORDINI

        List<Order> orderList = new ArrayList<>();

        LocalDate day1 = LocalDate.of(2023, 8, 5);
        LocalDate day2 = LocalDate.of(2021, 4, 17);
        LocalDate day3 = LocalDate.of(2021, 3, 12);
        LocalDate day4 = LocalDate.of(2021, 2, 15);
        LocalDate day5 = LocalDate.of(2020, 7, 15);

        LocalDate deliveryD = LocalDate.of(2024, 1, 17);

        Order order1 = new Order("Cnosegnato", day1, deliveryD, productList, otman);
        Order order2 = new Order("Cnosegnato", day2, deliveryD, productList, luca);
        Order order3 = new Order("Cnosegnato", day3, deliveryD, productList, alessandro);
        Order order4 = new Order("Cnosegnato", day4, deliveryD, productList, stefano);
        Order order5 = new Order("Cnosegnato", day5, deliveryD, productList, antonio);


        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);


        //PRIMO ESERCIZIO

        Predicate<Product> isMoreThanHundred = prd -> prd.getPrice() > 100;

        List<Product> esericizioUno = productList.stream().filter(isMoreThanHundred.and(p -> isCategory.categoryVerify("Books", p))).toList();

        System.out.println("");
        System.out.println("Esercizio 1");
        System.out.println("Elementi della categoria Book che costano più di 100 euro");
        esericizioUno.forEach(elem -> System.out.println(elem));


        //SECONDO ESERCIZIO

        List<Product> esercizioDue = productList.stream().filter(p-> isCategory.categoryVerify("Baby",p)).toList();

        System.out.println("");
        System.out.println("Esercizio 2");
        System.out.println("Elementi della categoria Baby");
        esercizioDue.forEach(elem -> System.out.println(elem));


        //TERZO ESERCIZIO

        List<Product> eserczioTre= productList.stream().filter(p-> isCategory.categoryVerify("Boys",p)).toList();

        System.out.println("");
        System.out.println("Esercizio 3");
        System.out.println("Elementi della categoria Boys scontati al 10%");
        eserczioTre.forEach(p->{
            p.sale();
            System.out.println(p);
        });


        //QUARTO ESERCIZIO

        LocalDate startDate = LocalDate.of(2021,2,1);
        LocalDate finalDate = LocalDate.of(2021,4,1);



        Predicate<Order> getRightTier = p-> p.getCustomer().getTier() == 2;
        Predicate<Order> rightDate = p -> p.getOrderDate().isAfter(startDate) && p.getOrderDate().isBefore(finalDate);

        List<Order> esercizioQuattro = orderList.stream().filter(getRightTier.and(rightDate)).toList();

        System.out.println("");
        System.out.println("Esercizio 4");
        System.out.println("Ordini effettuati dai clienti tier 2 tra 1 febbraio 2021 e 1 aprile 2021");
esercizioQuattro.forEach(e -> System.out.println(e));

    }
}