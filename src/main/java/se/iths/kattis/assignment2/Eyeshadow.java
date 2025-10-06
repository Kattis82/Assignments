package se.iths.kattis.assignment2;

import java.util.Scanner;

public class Eyeshadow extends Product {

    // klass-attribut, färg och konsistens (flytande/lös/krämig)

    private String color;
    private String texture;


    // konstruktor

    public Eyeshadow(String articleNumber, String title, double price,
                     String description, String color, String texture) {

        super(articleNumber, title, price, description);
        this.color = color;
        this.texture = texture;
    }

    // implementation av abstrakta metoder

    @Override
    public void category() {
        System.out.println("Produkten tillhör kategorin Eyeshadow");
    }

    @Override
    public void categoryUi(UserInterface ui) {
        ui.info("Produkten tillhör kategorin Eyeshadow");
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

        System.out.println("Ange färg (rosa/beige/brun/vit/orange/svart): ");
        String color = input.nextLine().trim();

        System.out.println("Ange konsistens (flytande/lös/krämig): ");
        String texture = input.nextLine().trim();

        return new Eyeshadow(articleNumber, title, price, description, color, texture);
    }


    // egen metod i sub-klasserna till WebShopUi som är static

    public static Product createProductUi(UserInterface ui) {

        String articleNumber = ui.prompt("Ange artikelnummer: ").trim();
        String title = ui.prompt("Ange titel: ").trim();
        double price = Double.parseDouble(ui.prompt("Ange pris: "));
        String description = ui.prompt("Ange beskrivning: ").trim();

        String color = ui.prompt("Ange färg (rosa/beige/brun/vit/orange/svart): ").trim();
        String texture = ui.prompt("Ange konsistens (flytande/lös/krämig): ").trim();

        return new Eyeshadow(articleNumber, title, price, description, color, texture);
    }


    // metod toString för att skriva ut klassens fält snyggt

    @Override
    public String toString() {
        return super.toString() +
                ", specifikation: färg " + color +
                ", konsistens " + texture;
    }


    // implementation av abstrakta metoder, till WebShopUi till filhantering

    @Override
    public String toFileString() {
        return "Eyeshadow;" + getArticleNumber() + ";" + getTitle() + ";" + getPrice() + ";"
                + getDescription() + ";" + color + ";" + texture;
    }

    @Override
    public Eyeshadow fromFileString(String line) {

        String[] parts = line.split(";");
        String articleNumber = parts[1];
        String title = parts[2];
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];
        String color = parts[5];
        String texture = parts[6];
        
        return new Eyeshadow(articleNumber, title, price, description, color, texture);

    }

}







