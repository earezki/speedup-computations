package computation;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Main {

    static final int WARM_UP = 1000;
    static final int STRESS = 10000;
    static final int SIZE = 100000;

    static AmountCalculator[] amountCalculators = {
            new ArrayOfTransactions(SIZE),
            new TransactionsAsArray(SIZE)
    };

    static Map<AmountCalculator, Long> totalRuntime = new HashMap<>();

    static {
        for (AmountCalculator amountCalculator : amountCalculators) {
            totalRuntime.put(amountCalculator, 0L);
        }
    }

    public static void main(String[] args) {
        warmUp(amountCalculators);

        System.out.println(amountCalculators[0].total());
        System.out.println(amountCalculators[1].total());
        for (int i = 0; i < STRESS; i++) {
            System.out.println(format("--- run: %d ----", i));
            for (AmountCalculator amountCalculator : amountCalculators) {
                profileAmountCalculator(amountCalculator);
            }
        }

        totalRuntime.forEach((amountCalculator, runTime) -> {
            System.out.println(String.format("total run time for %s is %d",
                    amountCalculator.getClass().getSimpleName(),
                    runTime));
        });
        System.out.println((totalRuntime.get(amountCalculators[0]) / totalRuntime.get(amountCalculators[1])));
    }

    private static void warmUp(AmountCalculator[] amountCalculators) {
        System.out.println("Warming up...");
        for (int i = 0; i < WARM_UP; i++) {
            for (AmountCalculator amountCalculator : amountCalculators) {
                amountCalculator.total();
            }
        }
    }

    static void profileAmountCalculator(AmountCalculator amountCalculator) {
        long start = System.nanoTime();
        amountCalculator.total();
        long end = System.nanoTime();
        totalRuntime.merge(amountCalculator, end - start, (lhs, rhs) -> lhs + rhs);
        System.out.println(amountCalculator.getClass().getSimpleName() + ": " + (end - start));
    }


}
