package se.iths.kattis.assignment2;

import java.util.Scanner;

public class Eyeliner extends Product {

    // klass-attribut - form (gel/flytande/penna), colorCode (1/13/34/9)

    private String form;
    private int colorCode;


    // konstruktor

    public Eyeliner(String articleNumber, String title, double price,
                    String description, String form, int colorCode) {

        super(articleNumber, title, price, description);
        this.form = form;
        this.colorCode = colorCode;
    }

    // implementation av abstrakta metoder

    @Override
    public void category() {
        System.out.println("Produkten tillhör kategorin Eyeliner");
    }

    @Override
    public void categoryUi(UserInterface ui) {
        ui.info("Produkten tillhör kategorin Eyeliner");
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

        System.out.println("Ange utformning (gel/flytande/penna): ");
        String form = input.nextLine().trim();

        System.out.println("Ange färgnyans (1/9/13/34): ");
        int colorCode = Integer.parseInt(input.nextLine());

        return new Eyeliner(articleNumber, title, price, description, form, colorCode);

    }

    // egen metod i sub-klasserna till WebShopUi som är static

    public static Product createProductUi(UserInterface ui) {

        String articleNumber = ui.prompt("Ange artikelnummer: ").trim();
        String title = ui.prompt("Ange titel: ").trim();
        double price = Double.parseDouble(ui.prompt("Ange pris: "));
        String description = ui.prompt("Ange beskrivning: ").trim();

        String form = ui.prompt("Ange utformning (gel/flytande/penna): ").trim();
        int colorCode = Integer.parseInt(ui.prompt("Ange färgnyans (1/9/13/34): "));

        return new Eyeliner(articleNumber, title, price, description, form, colorCode);
    }

    // metod toString för att skriva ut klassens fält snyggt

    @Override
    public String toString() {
        return super.toString() +
                ", specifikation: utformning " + form +
                ", färgkod " + colorCode;
    }

    // override av abstrakta metoder, till WebShopUi till filhantering

    @Override
    public String toFileString() {
        return "Eyeliner;" + getArticleNumber() + ";" + getTitle() + ";" + getPrice() + ";"
                + getDescription() + ";" + form + ";" + colorCode;
    }

    @Override
    public Eyeliner fromFileString(String line) {

        String[] parts = line.split(";");
        String articleNumber = parts[1];
        String title = parts[2];
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];
        String form = parts[5];
        int colorCode = Integer.parseInt(parts[6]);

        return new Eyeliner(articleNumber, title, price, description, form, colorCode);
    }

}
