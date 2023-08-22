import java.util.ArrayList;

class NumberPredictor {
    // Method to find the nearest Fibonacci number to a given number
    public int findNearestFibonacci(int number) {
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0);
        fibonacciNumbers.add(1);

        while (fibonacciNumbers.get(fibonacciNumbers.size() - 1) < number) {
            int nextFib = fibonacciNumbers.get(fibonacciNumbers.size() - 1) + fibonacciNumbers.get(fibonacciNumbers.size() - 2);
            fibonacciNumbers.add(nextFib);
        }

        // Find the closest Fibonacci number
        int closestFibonacci = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
        int secondClosestFibonacci = fibonacciNumbers.get(fibonacciNumbers.size() - 3);

        if (Math.abs(number - closestFibonacci) < Math.abs(number - secondClosestFibonacci)) {
            return closestFibonacci;
        } else {
            return secondClosestFibonacci;
        }
    }
}

class LuckyNumberPredictor {
    private NumberPredictor numberPredictor;

    public LuckyNumberPredictor() {
        this.numberPredictor = new NumberPredictor();
    }

    public int predictLuckyNumber(int dateOfBirth) {
        int nearestFibonacci = numberPredictor.findNearestFibonacci(dateOfBirth);
        return nearestFibonacci;
    }

    // Method to predict unlucky number (to be implemented in the future)
    public int predictUnluckyNumber(int dateOfBirth) {
        // To be implemented later when the formula is available
        return -1;
    }


    public static void main(String[] args) {
        LuckyNumberPredictor luckyNumberPredictor = new LuckyNumberPredictor();

        // Example usage
        int dateOfBirth = 10; // Replace with the person's date of birth
        int luckyNumber = luckyNumberPredictor.predictLuckyNumber(dateOfBirth);

        System.out.println("Your Lucky Number is: " + luckyNumber);
    }
}