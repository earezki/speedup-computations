package computation.transaction;

import computation.accounts.AccountId;

import java.util.UUID;

public class Transaction {

    private TransactionId id;
    private Money amount;
    private AccountId debit;
    private AccountId credit;

    public Transaction(Money amount) {
        this.id = new TransactionId(UUID.randomUUID().toString());
        this.debit = new AccountId(UUID.randomUUID().toString());
        this.credit = new AccountId(UUID.randomUUID().toString());
        this.amount = amount;
    }

    public Money amount() {
        return amount;
    }
}
