package computation.transactions;

import computation.Value;
import computation.transaction.Money;

public class Moneys extends Value<double[]> {

    public Moneys(double[] value) {
        super(value);
    }

    public Money total() {
        double result = 0.0;
        for (int i = 0; i < value.length; i++) {
            result += value[i];
        }
        return new Money(result);
    }
}
