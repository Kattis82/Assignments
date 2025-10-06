package se.iths.kattis.assignment2;

import javax.swing.*;

public class GraphicDialogue implements UserInterface {


    // implementering av metoderna i interfacet
    // metod ber om inmatning och returnerar texten som skrivs in

    @Override
    public String prompt(String message) {
        return JOptionPane.showInputDialog(null, message);
    }


    // metod visar meddelande på skärmen - används för information och bekräftelser

    @Override
    public void info(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


    // metod visar meny och returnerar användarens val

    @Override
    public int menu() {
        String input = JOptionPane.showInputDialog(null, "\n Stockholms sminkfabrik - administration\n " +
                " \n 1. Lägg till produkt \n 2. Lista alla produkter \n 3. Visa info om produkter \n 4. Ta bort alla produkter " +
                "\n 5. Avsluta \n --------------------------------------------------- \n Val: ");

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    // tom implementering av metod som används i klassen Console

    @Override
    public void scanClose() {

    }


}
