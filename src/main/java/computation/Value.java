package computation;

public abstract class Value<T> {

    protected final T value;

    protected Value(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

}
