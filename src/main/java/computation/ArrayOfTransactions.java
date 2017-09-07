package computation;

class ArrayOfTransactions implements AmountCalculator {

    Transaction[] transactions;

    ArrayOfTransactions(int size) {
        transactions = new TransactionsFactory().arrayOfTransactions(size);
    }

    @Override
    public double sumAmount() {
        double result = 0.0;
        for (int i = 0; i < transactions.length; i++) {
            result += transactions[i].amount;
        }
        return result;
    }
}
