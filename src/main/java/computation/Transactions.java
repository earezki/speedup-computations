package computation;

class Transactions {

    String[] uuid;
    double[] amount;
    String[] debitAccountNo;
    String[] creditAccountNo;
    int[] failureAttempts;
    int length;

    Transactions(int size) {
        this.length = size;
        this.failureAttempts = new int[size];
        this.creditAccountNo = new String[size];
        this.debitAccountNo = new String[size];
        this.amount = new double[size];
        this.uuid = new String[size];
    }
}
