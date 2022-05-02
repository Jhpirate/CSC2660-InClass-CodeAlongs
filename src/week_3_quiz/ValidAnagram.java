package week_3_quiz;

public class ValidAnagram {
    public static void main(String[] args) {
        String anagram1 = "racecar";
        String anagram2 = "anagram";
        String anagram3 = "dad";

        System.out.println(isValidPalindrome(anagram1));
        System.out.println(isValidPalindrome(anagram2));
        System.out.println(isValidPalindrome(anagram3));
    }

    public static boolean isValidPalindrome(String input) {
        String newString = input.toLowerCase().replaceAll("[^a-zA-Z0-9\\S]", "");
        char[] arr = newString.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i] == arr[arr.length - i - 1])) {
                return false;
            }
        }
        return true;
    }


}
