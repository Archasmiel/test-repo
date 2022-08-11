import java.util.Arrays;
import java.util.Currency;

// https://www.codewars.com/kata/59122604e5bc240817000016

class PrimeGen {

    private static boolean isPrime(int num, int[] primes, int size) {
        double sqrt = Math.sqrt(num);

        for (int i = 0 ; i < size ; i++) {
            if (primes[i] > sqrt) {
                return true;
            }
            if (num % primes[i] == 0) {
                return false;
            }
        }
        
        return true;
    }

    private static int[] primes(int num) {
        int index = 1, current = 3;
        int[] primes = new int[num];
        primes[0] = 2;
        while (index < num) {
            if (isPrime(current, primes, index)) {
                primes[index++] = current;
                current += 2;
            } else {
                current += 1;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        long startTime;
        int[] sizes = {500_000, 1_000_000, 2_000_000, 5_000_000};

        for (int size: sizes) {
            startTime = System.currentTimeMillis();
            primes(size);
            System.out.printf("%dms runtime for %d primes.", (System.currentTimeMillis() - startTime), size);
        }
    }

}