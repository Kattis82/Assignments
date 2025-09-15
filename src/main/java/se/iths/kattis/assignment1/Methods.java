package se.iths.kattis.assignment1;

public class Methods {
    public static void main(String[] args) {

        // intArray initieras och metoden findMaxInt anropas, en int [] som argument
        int[] intArray = new int[]{4, 35, 8, 78, 55, 5, 23};
        System.out.println(findMaxInt(intArray));


        // två double initieras och metoden findMaxDouble anropas, två doubles som argument
        double decimalOne = 3.5, decimalTwo = 6.6;
        System.out.println(findMaxDouble(decimalOne, decimalTwo));


        // två strängar initieras och metoden printFullName anropas, två strängar som argument
        String firstName = "Kattis", lastName = "Calmvik";
        printFullName(firstName, lastName);


    }

    // metoden returnerar en int och har en int [] som parameter
    private static int findMaxInt(int[] intArray) {

        int max = 0;

        for (int number : intArray) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // metoden returnerar en double och har två doubles som parametrar
    private static double findMaxDouble(double one, double two) {

        if (one > two) {
            return one;
        } else {
            return two;
        }
    }


    // metoden returnerar ingenting,men har två strängar som parametrar
    private static void printFullName(String first, String last) {
        System.out.println(first + " " + last);
    }

}
