package computation;

import computation.transaction.Money;
import computation.transaction.Transaction;

import java.util.List;

import static java.util.Arrays.asList;

class ArrayOfTransactions implements AmountCalculator {

    private List<Transaction> transactions;

    ArrayOfTransactions(int size) {
        transactions = asList(new TransactionsFactory().arrayOfTransactions(size));
    }

    @Override
    public double total() {
        return transactions.stream()
                .map(Transaction::amount)
                .reduce(Money.ZERO, Money::add)
                .value();
    }
}
