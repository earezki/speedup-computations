package computation.transaction;

import computation.Value;

public class Money extends Value<Double> {
    public static final Money ZERO = new Money(0.0);

    public Money(Double value) {
        super(value);
    }

    public Money add(Money rhs) {
        return new Money(value + rhs.value);
    }

}
