package se.iths.kattis.assignment1;

public class StringArray {
    public static void main(String[] args) {

        // stringArray initieras och metoden printArray anropas, en string array som argument

        String[] stringArray = new String[]{"Hello", "World", "!"};
        printArray(stringArray);

    }


    // metod som inte returnerar något, en string[] som parameter

    private static void printArray(String[] array) {
        String total = "";

        for (int i = 0; i < array.length; i++) {

            // lägger till varje element (string) till stringen total

            total += array[i];

            // om index inte är bland de två sista, pga att det är ett utropstecken
            // if (i < array.length - 2)

            // lägger till ett mellanslag mellan elementen, görs inte på sista elementet
            if (i < array.length - 1) {
                total += " ";
            }
        }
        System.out.println(total);
    }


}

