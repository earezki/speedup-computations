package computation;

import static computation.TransactionAmountCalculator.COUNT;

class ArrayAmountCalculator {
    private double[] transactions;

    public ArrayAmountCalculator() {
        transactions = new double[COUNT];
        double amount = 1;
        for (int i = 0; i < COUNT; i++) {
            transactions[i] = amount;
            amount *= 1.00001;
        }
    }

    double sumAmount() {
        double result = 0.0;
        for (int i = 0; i < transactions.length; i++) {
            result += transactions[i];
        }
        return result;
    }

}
