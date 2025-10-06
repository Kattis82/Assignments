package se.iths.kattis.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileHandler {

    // klass-attribut, Path representerar en filväg

    private Path pathFile;


    // konstruktor med anrop till metod som kontrollerar om det finns katalog och fil
    // Path.of skapar en fil i applikationen

    public ProductFileHandler(String productFile) {
        this.pathFile = Path.of(productFile);
        checkFileExist();


        //kontrollerar absolut sökväg för att se var filen ligger

        System.out.println(">Filen används här: " + pathFile.toAbsolutePath());

    }

    //metod som kontrollerar om katalog och fil finns

    private void checkFileExist() {

        try {

            // första if kollar om filen finns
            if (Files.notExists(pathFile)) {

                // andra if kollar om katalogen finns
                if (pathFile.getParent() != null && Files.notExists(pathFile.getParent())) {
                    Files.createDirectories(pathFile.getParent());
                }
                Files.createFile(pathFile);
            }

        } catch (IOException e) {
            System.err.println("Fel: " + e.getMessage());
        }
    }


    // metod som sparar produkter till fil

    public void saveProductsToFile(Product product) {

        try {
            // produkten skrivs till fil mha egen metod (toFileString) som finns i resp sub-klass
            Files.writeString(
                    pathFile,
                    product.toFileString() + "\n",
                    StandardOpenOption.CREATE,  // skapar fil om den saknas
                    StandardOpenOption.APPEND  // lägger till text i slutet
            );

        } catch (IOException e) {
            System.err.println("Fel vid skrivning: " + e.getMessage());
        }
    }


    // metod som läser in rader från fil där produkterna är sparade som text
    // returnerar sedan en lista med produkter

    public List<Product> readProductsFromFile() {

        // lista där sminket ska sparas i
        List<Product> products = new ArrayList<>();

        try {

            // öppnar filen och läser in varje rad som en egen sträng, de sparas i lista
            List<String> lines = Files.readAllLines(pathFile);
            for (String line : lines) {

                // raden (text) skickas in i fabriken som skapar smink (objekt)
                Product product = MakeUpFactory.buildFromFileString(line);
                if (product != null) {
                    products.add(product);
                }
            }
        } catch (IOException e) {
            System.err.println("Fel vid läsning: " + e.getMessage());
        }
        return products;
    }


    // metod som tömmer innehållet i filen

    public void clearFile() {

        try {

            Files.writeString(
                    pathFile,
                    "",
                    StandardOpenOption.TRUNCATE_EXISTING // ta bort befintligt innehåll
            );

        } catch (IOException e) {
            System.err.println("Fel vid tömning: " + e.getMessage());
        }
    }


}











