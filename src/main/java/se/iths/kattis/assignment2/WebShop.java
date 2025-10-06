package se.iths.kattis.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebShop {
    public static void main(String[] args) {

        // Scanner läser in användarens val

        Scanner input = new Scanner(System.in);

        // Product-lista skapas där alla produkter användaren lägger till sparas

        List<Product> theShop = new ArrayList<>();

        boolean isRunning = true;

        // program-loop visar meny tills användaren avslutar

        while (isRunning) {

            // metod visar huvudmenyn

            showMenu();

            // metod userChoice hanterar användarens input

            int choice = userChoice(input);

            switch (choice) {
                case 1 -> addProduct(theShop, input);
                case 2 -> listProducts(theShop);
                case 3 -> showProduct(theShop, input);
                case 4 -> {
                    System.out.println("Utloggad!");
                    isRunning = false;
                }
                default -> System.out.println("Du behöver göra ett val! Välj en siffra mellan 1 och 4.");
            }
        }

        // stänger Scannern

        input.close();
    }


    // metod som skriver ut huvudmenyn till webshoppen

    private static void showMenu() {
        System.out.println("\n Stockholms sminkfabrik - administration\n \n 1. Lägg till produkt \n " +
                "2. Lista alla produkter \n 3. Visa info om produkter \n 4. Avsluta \n"
                + "---------------------------------------");
        System.out.print(" Val: ");
    }


    // metod returnerar int, Scanner som parameter - tar in val från användaren och felhanterar

    private static int userChoice(Scanner scan) {
        try {
            int choice = Integer.parseInt(scan.nextLine());  //konverterar till int

            if (choice < 1 || choice > 4) {  // kontroll - siffra inom intervall
                System.out.println("Välj en siffra mellan 1 och 4!");
                return -1;    // om något går fel returneras -1, annars siffran
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Ogiltigt val! Skriv in en siffra");
            return -1;
        }
    }


    // metod 1 i huvudmenyn - lägger till produkten i produkt-listan: användaren
    // får följfrågor--> Objekt skapas och läggs till listan med produkter


    public static void addProduct(List<Product> products, Scanner input) {
        boolean keepAdding = true;

        // loop för att fortsätta lägga till om man vill

        while (keepAdding) {
            System.out.println("Vilken typ av produkt vill du lägga till? \n1. Mascara \n" +
                    "2. Eyeliner \n3. Eyeshadow \n4. Lipstick\n ---------------------------------------");
            System.out.print(" Val: ");

            // metod userChoice hanterar användarens input, typ av produkt som ska skapas

            int choice = userChoice(input);

            // MakeUpFactory skapar en produkt med tomma fält som sparas i variabeln template

            Product template = MakeUpFactory.buildProduct(choice);

            if (template != null) {   // om det finns en produkt skapad

                // input tas in och produkten skapas, sparas i variabeln newMakeup

                Product newMakeup = template.createProduct(input);  // polymorfism med createProduct

                // produkten läggs i produkt-listan och produkten skrivs ut

                products.add(newMakeup);
                System.out.println("Produkten har lagts till i webshoppen: " + newMakeup);
            } else {
                System.out.println("Ogiltigt val, ingen produkt skapades.");
            }

            boolean validInput = false;
            while (!validInput) {

                System.out.println("Vill du fortsätta lägga till produkter? (ja/nej)");
                String shop = input.nextLine().trim().toLowerCase();
                if (shop.equals("ja")) {
                    validInput = true;
                } else if (shop.equals("nej")) {
                    validInput = true;
                    keepAdding = false;
                } else {
                    System.out.println("Ogiltigt val! Du måste ange ja eller nej.");
                }

            }
        }
    }


    //metod 2 i huvudmenyn - listar alla produkter som finns i produkt-listan

    private static void listProducts(List<Product> products) {
        System.out.println("I webshoppen: ");
        if (products.isEmpty()) {
            System.out.println("Webshoppen är tom!");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }


    // metod 3 i huvudmenyn, sökning via artikelnr som visar en enskild produkt om den finns

    private static void showProduct(List<Product> products, Scanner input) {
        System.out.println("Vilken produkt söker du efter? Ange artikelnummer: ");
        String article = input.nextLine();

        for (Product product : products) {
            if (product.getArticleNumber().equalsIgnoreCase(article)) {
                System.out.println("Artikeln hittades! (" + product.getArticleNumber() + ")");
                product.category();
                System.out.println(product);
                return;
            }
        }
        System.out.println("Artikeln hittades inte i webshopen.");
    }
}
