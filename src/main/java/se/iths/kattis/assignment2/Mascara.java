package se.iths.kattis.assignment2;

import java.util.Scanner;

public class Mascara extends Product {

    // klass-attribut - borste (längd/volym/precision), vattenfast (ja/nej)

    private String brush;
    private boolean waterproof;


    // konstruktor

    public Mascara(String articleNumber, String title, double price,
                   String description, String brush, boolean waterproof) {

        super(articleNumber, title, price, description);
        this.brush = brush;
        this.waterproof = waterproof;

    }

    // implementation av abstrakta metoder

    @Override
    public void category() {
        System.out.println("Produkten tillhör kategorin Mascara");
    }

    @Override
    public void categoryUi(UserInterface ui) {
        ui.info("Produkten tillhör kategorin Mascara");
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

        System.out.println("Ange typ av borste (volym/längd/precision): ");
        String brush = input.nextLine().trim();

        System.out.println("Vattenfast (ja/nej): ");
        String answer = input.nextLine().trim().toLowerCase();
        boolean waterproof = answer.equals("ja");

        return new Mascara(articleNumber, title, price, description, brush, waterproof);
    }


    // egen metod i sub-klasserna till WebShopUi som är static

    public static Product createProductUi(UserInterface ui) {

        String articleNumber = ui.prompt("Ange artikelnummer: ").trim();
        String title = ui.prompt("Ange titel: ").trim();
        double price = Double.parseDouble(ui.prompt("Ange pris: "));
        String description = ui.prompt("Ange beskrivning: ").trim();

        String brush = ui.prompt("Ange typ av borste (volym/längd/precision): ").trim();
        String answer = ui.prompt("Vattenfast (ja/nej): ").trim().toLowerCase();
        boolean waterproof = answer.equals("ja");

        return new Mascara(articleNumber, title, price, description, brush, waterproof);
    }

    // metod toString för att skriva ut klassens fält snyggt

    @Override
    public String toString() {
        return super.toString() +
                ", specifikation: borste " + brush +
                ", vattenfast " + (waterproof ? "ja" : "nej");
    }

    // implementation av abstrakta metoder, till WebShopUi (filhantering)

    // toFileString används för att spara produkten till en textfil

    @Override
    public String toFileString() {
        return "Mascara;"
                + getArticleNumber() + ";" + getTitle() + ";" + getPrice() + ";"
                + getDescription() + ";" + brush + ";" + (waterproof ? "ja" : "nej");
    }


    // metod som används för att skapa en Mascara av strängar

    @Override
    public Mascara fromFileString(String line) {
        
        String[] parts = line.split(";");
        String articleNumber = parts[1];
        String title = parts[2];
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];
        String brush = parts[5];
        boolean waterproof = (parts[6].equalsIgnoreCase("ja"));

        return new Mascara(articleNumber, title, price, description, brush, waterproof);
    }

}


