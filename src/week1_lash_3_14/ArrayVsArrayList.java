package week1_lash_3_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayVsArrayList {

    public static class Book {
        // attributes
        String bookTitle, bookAuthor;
        int date;

        public Book(String bookTitle, String bookAuthor, int date) {
            this.bookTitle = bookTitle;
            this.bookAuthor = bookAuthor;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Book{" + "bookTitle='" + bookTitle + '\'' + ", bookAuthor='" + bookAuthor + '\'' + ", date=" + date + '}';
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Array (fixed size)
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }


        // ArrayList (Dynamic Resize)
        ArrayList<Integer> dynamicArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(rand.nextInt(50));
        }
        System.out.println(Arrays.toString(dynamicArray.toArray()));
        System.out.println("Min Value: " + getMinimumValue(dynamicArray));
        System.out.println("Max Value: " + getMaximumValue(dynamicArray));
        if (dynamicArray.contains(10)) System.out.println("We've got 10!"); // old print if we've got 10 in the list


        // primitive vs reference types (wrapper classes)
        int num1 = 1234;
        Integer num2 = 1234;
        if (num1 == num2) System.out.println("Num 1 & 2 Equal");


        // ArrayList of objects
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("The Jungle", "Upton Sinclair", 1906));
        books.add((new Book("1984", "George Orwell", 1948)));
        for (Book currentBook : books) {
            System.out.println(currentBook);
        } //end enhanced for-loop


        // Return the second-largest value from the given list
        ArrayList<Integer> scores = new ArrayList(Arrays.asList(8, 9, 12, 5, 2, 1, 2, 15));
        System.out.println(getSecondLargest(scores));

    }

    private static int getSecondLargest(ArrayList<Integer> scores) {
        int largest_value = getMaximumValue(scores);

        for(Integer i : scores) {
            if(i > largest_value) largest_value = i;
        }

        return largest_value;

    }

    private static int getMaximumValue(ArrayList<Integer> dynamicArray) {
        int largestValue = Integer.MIN_VALUE;

        for (Integer i : dynamicArray) {
            if (i > largestValue) largestValue = i;
        }
        return largestValue;
    }

    private static int getMinimumValue(ArrayList<Integer> dynamicArray) {
        int minValue = Integer.MAX_VALUE;

        for (int i : dynamicArray) {
            if (i < minValue) minValue = i;
        }
        return minValue;
    }
}
