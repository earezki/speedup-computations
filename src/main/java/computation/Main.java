package computation;

public class Main {

    public static void main(String[] args) {

        TransactionAmountCalculator transactionAmountCalculator = new TransactionAmountCalculator();
        ArrayAmountCalculator arrayAmountCalculator = new ArrayAmountCalculator();

        for (int i = 0; i < 1000; i++) {
            System.out.println("run: " + i);
            System.out.println("----------");
            profileTransactionAmountCalculator(transactionAmountCalculator);
            profileArrayAmountCalculator(arrayAmountCalculator);
        }

    }

    private static void profileArrayAmountCalculator(ArrayAmountCalculator arrayAmountCalculator) {
        long start = System.nanoTime();
        arrayAmountCalculator.sumAmount();
        long end = System.nanoTime();
        System.out.println("ArrayAmountCalculator: " + (end - start));
    }

    private static void profileTransactionAmountCalculator(TransactionAmountCalculator transactionAmountCalculator) {
        long start = System.nanoTime();
        transactionAmountCalculator.sumAmount();
        long end = System.nanoTime();
        System.out.println("TransactionAmountCalculator: " + (end - start));
    }

}
