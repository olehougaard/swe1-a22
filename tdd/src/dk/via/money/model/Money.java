package dk.via.money.model;

public final class Money {
    private final double amount;
    private final String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }
        Money other = (Money) obj;
        if (amount == 0 && other.amount == 0) {
            return true;
        }
        return currency.equals(other.currency) && amount == other.amount;
    }

    public Money add(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Different currencies");
        }
        return new Money(amount + other.amount, currency);
    }

    public Money multiply(double factor) {
        return new Money(amount * factor, currency);
    }

    public Money divide(double dividend) {
        if (dividend == 0) {
            throw new ArithmeticException("/ by 0");
        }
        return new Money(amount / dividend, currency);
    }
}
