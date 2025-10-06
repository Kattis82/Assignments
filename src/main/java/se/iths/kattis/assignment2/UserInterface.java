package se.iths.kattis.assignment2;

public interface UserInterface {

    public String prompt(String message);

    public void info(String message);

    public int menu();


    // metod för att kunna stänga scannern när Console-klassen används

    public void scanClose();
}
