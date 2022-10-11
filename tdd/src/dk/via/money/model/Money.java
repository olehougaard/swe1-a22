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
}
