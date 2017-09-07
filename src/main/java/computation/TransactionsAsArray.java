package computation;

class TransactionsAsArray implements AmountCalculator {

    private Transactions transactions;

    public TransactionsAsArray(int size) {
        transactions = new TransactionsFactory().transactionsAsArray(size);
    }

    @Override
    public double sumAmount() {
        double result = 0.0;
        for (int i = 0; i < transactions.length; i++) {
            result += transactions.amount[i];
        }
        return result;
    }

}
