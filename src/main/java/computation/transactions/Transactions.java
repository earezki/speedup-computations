package computation.transactions;

import computation.accounts.AccountId;
import computation.transaction.Money;
import computation.transaction.TransactionId;

public class Transactions {

    private TransactionId[] id;
    private Moneys amount;
    private AccountId[] debit;
    private AccountId[] credit;

    public Transactions(Moneys amount) {
        this.debit = new AccountId[amount.value().length];
        this.credit = new AccountId[amount.value().length];
        this.id = new TransactionId[amount.value().length];
        this.amount = amount;
    }

    public Money total() {
        return amount.total();
    }
}
