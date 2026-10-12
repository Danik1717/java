package org.example;

import org.example.Tariffs.PrepaidTariff;
import org.example.Tariffs.Tariff;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class TariffFactoryTest {

    private final TariffFactory factory = new TariffFactory();

    @Test
    public void testCreateValidPrepaidTariff() {
        Optional<Tariff> tariffOpt = factory.createTariff("PREPAID, Basic Plan, 10.50, 1500, 100");

        Assert.assertTrue(tariffOpt.isPresent());
        Assert.assertTrue(tariffOpt.get() instanceof PrepaidTariff);
        Assert.assertEquals(tariffOpt.get().getName(), "Basic Plan");
        Assert.assertEquals(tariffOpt.get().getSubscriptionFee(), 10.50);
        Assert.assertEquals(tariffOpt.get().getClientCount(), 1500);
    }

    @Test
    public void testCreateTariffWithInvalidFeeSubstitutesDefault() {
        // Строка "invalid_fee" должна быть перехвачена catch-блоком и заменена на 0.0
        Optional<Tariff> tariffOpt = factory.createTariff("CORPORATE, Error Plan, invalid_fee, 500, 0.15");

        Assert.assertTrue(tariffOpt.isPresent());
        Assert.assertEquals(tariffOpt.get().getSubscriptionFee(), 0.0);
        Assert.assertEquals(tariffOpt.get().getClientCount(), 500);
    }

    @Test
    public void testCreateTariffWithMissingDataReturnsEmpty() {
        // Меньше 5 параметров
        Optional<Tariff> tariffOpt = factory.createTariff("PREPAID, Short Plan, 10.0");

        Assert.assertFalse(tariffOpt.isPresent());
    }
}