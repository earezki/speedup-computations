package computation;

import computation.transactions.Transactions;

class TransactionsAsArray implements AmountCalculator {

    private Transactions transactions;

    public TransactionsAsArray(int size) {
        transactions = new TransactionsFactory().transactionsAsArray(size);
    }

    @Override
    public double total() {
        return transactions.total().value();
    }

}
