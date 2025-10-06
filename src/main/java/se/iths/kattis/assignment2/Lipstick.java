package se.iths.kattis.assignment2;

import java.util.Scanner;

public class Lipstick extends Product {

    // klass-attribut -finish (matt/glansig), form (stift/flytande)

    private String finish;
    private String form;


    // konstruktor

    public Lipstick(String articleNumber, String title, double price,
                    String description, String finish, String form) {

        super(articleNumber, title, price, description);
        this.finish = finish;
        this.form = form;
    }

    // implementation av abstrakta metoder

    @Override
    public void category() {
        System.out.println("Produkten tillhör kategorin Lipstick");
    }

    @Override
    public void categoryUi(UserInterface ui) {
        ui.info("Produkten tillhör kategorin Lipstick");
    }


    @Override
    public Product createProduct(Scanner input) {

        System.out.println("Ange artikelnummer: ");
        String articleNumber = input.nextLine().trim();

        System.out.println("Ange titel: ");
        String title = input.nextLine().trim();

        System.out.println("Ange pris: ");
        double price = Double.parseDouble(input.nextLine());

        System.out.println("Ange beskrivning: ");
        String description = input.nextLine().trim();

        System.out.println("Ange finish (matt/glansig/): ");
        String finish = input.nextLine().trim();

        System.out.println("Ange utformning (stift/flytande): ");
        String form = input.nextLine().trim();

        return new Lipstick(articleNumber, title, price, description, finish, form);
    }


    // egen metod i sub-klasserna till WebShopUi som är static

    public static Product createProductUi(UserInterface ui) {

        String articleNumber = ui.prompt("Ange artikelnummer: ").trim();
        String title = ui.prompt("Ange titel: ").trim();
        double price = Double.parseDouble(ui.prompt("Ange pris: "));
        String description = ui.prompt("Ange beskrivning: ").trim();

        String finish = ui.prompt("Ange finish (matt/glansig/): ").trim();
        String form = ui.prompt("Ange utformning (stift/flytande): ").trim();

        return new Lipstick(articleNumber, title, price, description, finish, form);
    }


    // metod toString för att skriva ut klassens fält snyggt

    @Override
    public String toString() {
        return super.toString() +
                ", specifikation: finish " + finish +
                ", format " + form;
    }


    // implementation av abstrakta metoder, till WebShopUi till filhantering

    @Override
    public String toFileString() {
        return "Lipstick;" + getArticleNumber() + ";" + getTitle() + ";" + getPrice() + ";"
                + getDescription() + ";" + finish + ";" + form;
    }

    @Override
    public Lipstick fromFileString(String line) {

        String[] parts = line.split(";");
        String articleNumber = parts[1];
        String title = parts[2];
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];
        String finish = parts[5];
        String form = parts[6];

        return new Lipstick(articleNumber, title, price, description, finish, form);
    }


}


