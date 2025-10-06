package se.iths.kattis.assignment2;

import java.util.Scanner;

public class Console implements UserInterface {

    // klass-attribut

    private Scanner input = new Scanner(System.in);

    // implementering av metoderna i interfacet
    // metod tar in string och returnerar texten som skrivs in

    @Override
    public String prompt(String message) {
        System.out.println(message);
        return input.nextLine();

    }

    // metod visar meddelande på skärmen - används för information och bekräftelser

    @Override
    public void info(String message) {
        System.out.println(message);
    }


    // metod visar meny och returnerar användarens val

    @Override
    public int menu() {
        System.out.println("\n Administration Stockholms sminkfabrik\n \n 1. Lägg till produkt \n " +
                "2. Lista alla produkter \n 3. Visa info om produkter \n 4. Ta bort alla produkter " +
                "\n 5. Avsluta \n ---------------------------------------------------");
        System.out.print(" Val: ");

        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    // metod som stänger scannern

    @Override
    public void scanClose() {
        input.close();
    }


}




