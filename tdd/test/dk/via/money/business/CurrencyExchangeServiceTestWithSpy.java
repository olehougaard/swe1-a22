package dk.via.money.business;

import dk.via.money.model.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyExchangeServiceTestWithSpy {
    private Money eur100;
    private Money usd120;
    private CurrencyExchangeService service;
    private ExchangeRateDataSpy data;

    @BeforeEach
    public void setUp() {
        eur100 = new Money(100, "EUR");
        usd120 = new Money(120, "USD");
        data = new ExchangeRateDataSpy();
        service = new CurrencyExchangeService(data);
    }

    @Test
    public void hundredEuroIsHundredFiftyDollars() throws SQLException {
        Money converted = service.exchange(eur100, "USD");
        assertEquals(usd120, converted);
        assertEquals(1, data.fromCurrencies.size());
        assertEquals("EUR", data.fromCurrencies.get(0));
        assertEquals(1, data.toCurrencies.size());
        assertEquals("USD", data.toCurrencies.get(0));
    }
}
