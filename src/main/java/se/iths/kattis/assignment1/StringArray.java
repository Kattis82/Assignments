package se.iths.kattis.assignment1;

public class StringArray {
    public static void main(String[] args) {

        // string array initieras och metoden printArray anropas, en string array som argument
        String[] stringArray = new String[]{"Hello", "World", "!"};
        printArray(stringArray);

    }
    

    // metod som inte returnerar något, en string[] som parameter
    private static void printArray(String[] array) {
        String total = "";

        for (int i = 0; i < array.length; i++) {
            total += array[i];
            if (i < array.length - 1 && i < array.length - 2) {
                total += " ";
            }
        }
        System.out.println(total);
    }


}

