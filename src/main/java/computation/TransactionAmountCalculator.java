package computation;

class TransactionAmountCalculator {

    static final int COUNT = 10000;
    Transaction[] transactions;

    TransactionAmountCalculator() {
        transactions = new Transaction[COUNT];
        double amount = 1;
        for (int i = 0; i < COUNT; i++) {
            transactions[i] = new Transaction(amount);
            amount *= 1.00001;
        }
    }

    double sumAmount() {
        double result = 0.0;
        for (int i = 0; i < transactions.length; i++) {
            result += transactions[i].amount;
        }
        return result;
    }

}
