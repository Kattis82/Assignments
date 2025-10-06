package se.iths.kattis.assignment2;

import java.util.Scanner;

// abstrakt klass som de andra produkterna (smink) ärver av

public abstract class Product {

    // klass-attribut

    private String articleNumber;
    private String title;
    private double price;
    private String description;

    // konstruktor

    public Product(String articleNumber, String title, double price, String description) {

        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }


    // get- och set-metoder

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // abstrakta metoder

    public abstract void category();

    public abstract void categoryUi(UserInterface ui);

    public abstract Product createProduct(Scanner input);

    public abstract String toFileString();

    public abstract Product fromFileString(String line);


    // toString-metod som skriver ut info om produkterna snyggt

    @Override
    public String toString() {
        return title + " (Artikelnr " + articleNumber + ") - " + price + " kr";
    }


}
