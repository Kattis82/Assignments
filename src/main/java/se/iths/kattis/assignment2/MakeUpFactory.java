package se.iths.kattis.assignment2;

// klass med metoder som sköter skapandet av produkterna (olika typer av smink)

public class MakeUpFactory {


    // statisk metod, skapar en produkt beroende på val i menyn. Resp sub-klass
    // konstruktor sätter "noll"-värden i fälten, skapar en tom mall av resp

    public static Product buildProduct(int choice) {

        return switch (choice) {
            case 1 -> new Mascara("", "", 0, "",
                    "", false);
            case 2 -> new Eyeliner("", "", 0, "",
                    "", 0);
            case 3 -> new Eyeshadow("", "", 0, "",
                    "", "");
            case 4 -> new Lipstick("", "", 0, "",
                    "", "");
            default -> null;
        };
    }


    // statisk metod, skapar en produkt beroende på val i menyn, sub-klasserna har metoden
    // createProductUi som skapar en produkt efter interaktion via ui (frågor som besvaras)

    public static Product buildProductUi(int choice, UserInterface ui) {

        return switch (choice) {
            case 1 -> Mascara.createProductUi(ui);
            case 2 -> Eyeliner.createProductUi(ui);
            case 3 -> Eyeshadow.createProductUi(ui);
            case 4 -> Lipstick.createProductUi(ui);
            default -> null;
        };
    }


    // statisk metod som skapar en produkt genom att läsa in teststräng från fil, sker automatiskt
    // utan interaktion

    public static Product buildFromFileString(String line) {

        Product product = null;

        if (line.startsWith("Mascara")) {

            // tom tillfällig produkt av rätt sort skapas för att kunna komma åt metoden fromFileString
            // som i sin tur skapar en mascara av en sträng
            
            product = new Mascara("", "", 0, "",
                    "", false).fromFileString(line);
        } else if (line.startsWith("Eyeliner")) {
            product = new Eyeliner("", "", 0, "",
                    "", 0).fromFileString(line);
        } else if (line.startsWith("Eyeshadow")) {
            product = new Eyeshadow("", "", 0, "",
                    "", "").fromFileString(line);
        } else if (line.startsWith("Lipstick")) {
            product = new Lipstick("", "", 0, "",
                    "", "").fromFileString(line);
        }
        return product;
    }


}
