package computation;

import computation.transaction.Money;
import computation.transaction.Transaction;
import computation.transactions.Moneys;
import computation.transactions.Transactions;

class TransactionsFactory {
    static final double MULTIPLIER = 1.00001;

    Transaction[] arrayOfTransactions(int size) {
        Transaction[] transactions = new Transaction[size];
        double amount = 1;
        for (int i = 0; i < size; i++) {
            transactions[i] = new Transaction(new Money(amount));
            amount *= MULTIPLIER;
        }
        return transactions;
    }

    Transactions transactionsAsArray(int size) {
        double amounts[] = new double[size];
        double amount = 1;
        for (int i = 0; i < size; i++) {
            amounts[i] = amount;
            amount *= MULTIPLIER;
        }
        return new Transactions(new Moneys(amounts));
    }
}