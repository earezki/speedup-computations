package computation;

class TransactionsFactory {
    static final double MULTIPLIER = 1.00001;

    Transaction[] arrayOfTransactions(int size) {
        Transaction[] transactions = new Transaction[size];
        double amount = 1;
        for (int i = 0; i < size; i++) {
            transactions[i] = new Transaction(amount);
            amount *= MULTIPLIER;
        }
        return transactions;
    }

    Transactions transactionsAsArray(int size) {
        Transactions transactions = new Transactions(size);
        double amount = 1;
        for (int i = 0; i < size; i++) {
            transactions.amount[i] = amount;
            amount *= MULTIPLIER;
        }
        return transactions;
    }
}