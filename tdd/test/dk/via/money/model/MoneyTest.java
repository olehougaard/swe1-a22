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

    // 100 dollars - amount

    // Zero dollars - currency

    // 100 Euro - currency

    // 100 dollars equals 100 dollars

    // 100 dollars doesn't equals 100 euros

    // 100 dollars doesn't equal 0 dollars

    // 0 dollars equals 0 euro

    // 100 dollars + 100 dollars == 200 dollars

    // 100 dollars + 100 euro -> Exception

    // 100 dollars * .25 == 25 dollars

    // 100 dollars / 4 == 25 dollars

    // 100 dollars / 0 -> Exception
}