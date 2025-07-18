package utils;

import java.util.Random;

public class RandomUtil {

    /**
     * Generates a random alphanumeric string of a specified length.
     *
     * @param length The desired length of the random string.
     * @return A random string containing alphanumeric characters.
     */
    public static String generateRandomAlphaNumeric(int length) {
        // Define the characters allowed in the random string
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomStringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // Get a random index within the allowedChars string
            int randomIndex = random.nextInt(allowedChars.length());
            // Append the character at the random index to the StringBuilder
            randomStringBuilder.append(allowedChars.charAt(randomIndex));
        }
        return randomStringBuilder.toString();
    }

    /**
     * Generates a random numeric string of a specified length.
     *
     * @param length The desired length of the random numeric string.
     * @return A random string containing only digits.
     */
    public static String generateRandomNumeric(int length) {
        String allowedChars = "0123456789";
        StringBuilder randomStringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            randomStringBuilder.append(allowedChars.charAt(randomIndex));
        }
        return randomStringBuilder.toString();
    }

    /**
     * Generates a random alphabetic string of a specified length.
     *
     * @param length The desired length of the random alphabetic string.
     * @return A random string containing only alphabetic characters (both uppercase and lowercase).
     */
    public static String generateRandomAlphabetic(int length) {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomStringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            randomStringBuilder.append(allowedChars.charAt(randomIndex));
        }
        return randomStringBuilder.toString();
    }
}