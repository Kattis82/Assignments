package se.iths.kattis.assignment2;

import java.util.List;

public class WebShopUi {

    // klass-attribut - static så är ett objekt som hör till hela klassen
    // bara en fil till hela programmet

    private static ProductFileHandler fileHandler = new ProductFileHandler("data/products.txt");

    public static void main(String[] args) {

        // --> nedan är två olika userinterface som man kan växla emellan (Scanner/JOptionPane)

        //UserInterface ui = new Console();
        UserInterface ui = new GraphicDialogue();


        boolean isRunning = true;

        // program-loop som gör så att menyn visas tills användaren avslutar

        while (isRunning) {

            // metod som visar huvudmenyn

            int choice = ui.menu();

            // enhanced switch med olika metoder

            switch (choice) {
                case 1 -> addProduct(ui);
                case 2 -> listProducts(ui);
                case 3 -> showProduct(ui);
                case 4 -> clearAllProducts(ui);
                case 5 -> {
                    ui.info("Utloggad!");
                    isRunning = false;
                }
                default -> ui.info("Du behöver göra ett val! Välj en siffra mellan 1 och 5.");
            }
        }

        // stänger Scannern
        ui.scanClose();
    }

    // metod som lägger till produkten som väljs i filen

    private static void addProduct(UserInterface ui) {
        boolean keepAdding = true;

        // loop låter användaren fortsätta lägga till produkter om den vill

        while (keepAdding) {

            try {
                int choice = Integer.parseInt(ui.prompt("Vilken typ av produkt vill du lägga till? \n\n1. Mascara \n" +
                        "2. Eyeliner \n3. Eyeshadow \n4. Lipstick\n ---------------------------------------------------" +
                        "\n Val: "));


                // val görs - vilken typ av smink ska skapas, görs mha MakeUpFactory

                Product newMakeup = MakeUpFactory.buildProductUi(choice, ui);

                // om det finns minst en produkt skapad, den är inte tom (null)

                if (newMakeup != null) {

                    // spara produkten i fil

                    fileHandler.saveProductsToFile(newMakeup);

                    ui.info("Produkten har lagts till i webshoppen: " + newMakeup);
                } else {
                    ui.info("Ogiltigt val, ingen produkt skapades.");
                }

                boolean validInput = false;

                while (!validInput) {
                    String shop = ui.prompt("Vill du fortsätta lägga till produkter? (ja/nej)").trim().toLowerCase();

                    if (shop.equals("ja")) {
                        validInput = true;
                    } else if (shop.equals("nej")) {
                        validInput = true;
                        keepAdding = false;
                    } else {
                        ui.info("Ogiltigt val! Du måste ange ja eller nej.");
                    }
                }
            } catch (NumberFormatException e) {
                ui.info("Du måste skriva en siffra!");
            }
        }
    }


    // metod som skriver ut alla produkter som finns sparade

    private static void listProducts(UserInterface ui) {
        List<Product> products = fileHandler.readProductsFromFile();

        ui.info("I webshoppen: ");

        if (products.isEmpty()) {
            ui.info("Webshoppen är tom!");
            return;
        }
        for (Product product : products) {
            ui.info(product.toString());
        }
    }


    // metod där användaren söker produkt och skriver in artikelnr

    private static void showProduct(UserInterface ui) {
        List<Product> products = fileHandler.readProductsFromFile();

        String article = ui.prompt("Vilken produkt söker du efter? Ange artikelnummer: ");

        for (Product product : products) {
            if (product.getArticleNumber().equalsIgnoreCase(article)) {
                ui.info("Artikeln hittades! (" + product.getArticleNumber() + ")");
                product.categoryUi(ui);
                ui.info(product.toString());
                return;
            }
        }
        ui.info("Artikeln hittades inte i webshopen.");
    }

    // metod som erbjuder administratören att tömma webshoppen (filen) på alla produkter

    private static void clearAllProducts(UserInterface ui) {

        boolean validInput = false;

        while (!validInput) {
            String confirm = ui.prompt("Är du säker på att du vill ta bort alla produkter? (ja/nej)").trim().toLowerCase();

            if (confirm.equals("ja")) {
                fileHandler.clearFile();
                ui.info("Alla produkter är borttagna.");
                validInput = true;
            } else if (confirm.equals("nej")) {
                ui.info("Inga produkter togs bort.");
                validInput = true;
            } else {
                ui.info("Ogiltigt val! Du måste ange ja eller nej.");
            }
        }
    }

}



