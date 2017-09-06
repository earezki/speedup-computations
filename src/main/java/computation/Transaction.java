package computation;

import java.util.UUID;

class Transaction {

    String uuid;
    double amount;
    String debitAccountNo;
    String creditAccountNo;
    int failureAttempts;

    Transaction(double amount) {
        this.failureAttempts = 0;
        this.creditAccountNo = UUID.randomUUID().toString();
        this.debitAccountNo = UUID.randomUUID().toString();
        this.amount = amount;
        this.uuid = UUID.randomUUID().toString();
    }
}
