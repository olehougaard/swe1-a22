package dk.via.money.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    private Money usd0, usd100, eur100;

    @BeforeEach
    void setUp() {
        usd0 = new Money(0, "USD");
        usd100 = new Money(100, "USD");
        eur100 = new Money(100, "EUR");
    }

    // Zero dollars - amount
    @Test
    public void zeroDollarsHaveAnAmountOf0() {
        assertEquals(0, usd0.getAmount());
    }

    // 100 dollars - amount
    @Test
    public void hundredDollarsHaveAnAmountOf100() {
        assertEquals(100, usd100.getAmount());
    }

    // Zero dollars - currency
    // 100 Euro - currency
    // Let's not bother - too simple

    // 100 dollars equals 100 dollars
    @Test
    public void hundredDollarsEquals100Dollars() {
        assertEquals(new Money(100, "USD"), usd100);
    }

    // 100 dollars doesn't equals 100 euros
    @Test
    public void hundredDollarsDoesntEqual100Euros() {
        assertNotEquals(new Money(100, "USD"), eur100);
    }

    // 100 dollars doesn't equal 0 dollars
    @Test
    public void hundredDollarsDoesntEqual0Dollars() {
        assertNotEquals(new Money(100, "USD"), usd0);
    }

    // 100 dollars doesn't equal "100USD"
    @Test
    public void hundredDollarsDoesntEqualString100USD() {
        assertNotEquals(new Money(100, "USD"), "USD100");
    }

    // 0 dollars equals 0 euro
    @Test
    public void zeroDollarsEqualsZeroEuro() {
        assertEquals(new Money(0, "USD"), new Money(0, "EUR"));
    }

    // 100 dollars + 100 dollars == 200 dollars
    @Test
    public void hundredDollarsPlusHundredDollarsIs200Dollars() {
        assertEquals(new Money(200, "USD"), usd100.add(usd100));
    }

    // 100 dollars + 100 euro -> Exception
    @Test
    public void hundredDollarsPlusHundredEurosThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> usd100.add(eur100));
    }

    // 100 dollars * .25 == 25 dollars
    @Test
    public void hundredDollarsTimesAQuarterIs25Dollars() {
        assertEquals(new Money(25, "USD"), usd100.multiply(.25));
    }

    // 100 dollars / 4 == 25 dollars
    @Test
    public void hundredDollarsDividedBy4Is25Dollars() {
        assertEquals(new Money(25, "USD"), usd100.divide(4));
    }

    // 100 dollars / 0 -> Exception
    @Test
    public void divideByZeroThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> usd100.divide(0));
    }
}