import java.util.Arrays;
import java.util.List;

class AverageCalculator {

    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculate the average using streams
        double average = calculateAverage(numbers);

        // Print the result
        System.out.println("Average: " + average);
    }

    private static double calculateAverage(List<Integer> numbers) {
        // Use streams to calculate the average
        return numbers.stream()
                      .mapToDouble(Integer::doubleValue)
                      .average()
                      .orElse(0.0); // Default value if the list is empty
    }
}

