import java.util.Random;
import java.util.Scanner;

public class GuessMe {
    private static final int LOWER_LIMIT = 1;
    private static final int HIGHER_LIMIT = 100;
    private static final int RETRY_LIMIT = 10;
    private static final int TOTAL_LEVELS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Number Of levels in a series: 3");
        System.out.println("Number of attempts to guess a number in each level: 10\n");

        for (int a = 1; a <= TOTAL_LEVELS; a++) {
            int number = random.nextInt(HIGHER_LIMIT) + LOWER_LIMIT;
            int attempts = 0;

            System.out.printf("LEVEL-%d: Guess the number between %d and %d\n", a, LOWER_LIMIT, HIGHER_LIMIT);
            while (attempts < RETRY_LIMIT) {
                System.out.println("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts++;

                if (guess_number == number) {
                    int score = RETRY_LIMIT - attempts + 1;
                    totalScore += score;
                    System.out.println("\nYou conquered the level!");
                    System.out.printf("Attempts taken to complete level-%d: %d", a, attempts);
                    System.out.printf("\nPoints scored in level-%d: %d\n\n", a, score);
                    break;
                } else if (guess_number < number) {
                    System.out.printf("Pick higher value || Available attempts: %d\n", RETRY_LIMIT - attempts);
                } else {
                    System.out.printf("Pick lower value || Available attempts: %d\n", RETRY_LIMIT - attempts);
                }

                if (attempts == RETRY_LIMIT && guess_number != number) {
                    System.out.println("Sorry, You have reached maximum attempts");
                }

            }
        }

        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();

    }
}
