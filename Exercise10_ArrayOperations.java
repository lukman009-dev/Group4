
/**
 * Write a description of class Exercise10_ArrayOperations here.
 *
 * @author LUKMAN KHAMIS MUSSA 24BI009
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Arrays;

public class Exercise10_ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Array Operations==\n");
        // ---- EXTENSION 
        //  User chooses array size ----
        System.out.print("Enter the number of elements:");
        int size = scanner.nextInt();

        int[]numbers = new int[size];

        System.out.println("\nEnter " + size + "numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Number" + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Display array
        System.out.println("\n--- Your Numbers ---");
        System.out.println(Arrays.toString(numbers));

        // Sum and average
        int sum = 0;
        for (int num : numbers) {
            sum += num;}
        double average = (double) sum / size;

        // Maximum and minimum
        int max = numbers[0];
        int min = numbers[0];
        for (int num : numbers) {
            if (num > max) max =num;
            if (num < min) min =num;
        }

        System.out.println("\n--Statistics ---");
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        // To Add search functionality (find if a number exists)
        System.out.print("\nEnter a number to search: ");
        int search = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < size; i++) {if (numbers[i] == search) {
                System.out.println(search + " found at index" + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(search + " not found in the array.");
        }

        // To Sort array ----
        Arrays.sort(numbers);
        System.out.println("\nSorted Array(Ascending):" + Arrays.toString(numbers));

        // To Count even and odd ----
        int evenCount = 0, oddCount = 0;
        for (int num : numbers) {if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("\n--- Even&Odd Count ---");
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);

        scanner.close();
    }
}

