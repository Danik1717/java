package org.example;


import org.example.Tariffs.CorporateTariff;
import org.example.Tariffs.PrepaidTariff;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TariffTest {

    @Test
    public void testPrepaidTariffCreation() {
        PrepaidTariff tariff = new PrepaidTariff("Smart", 15.50, 1000, 500);

        Assert.assertEquals(tariff.getName(), "Smart");
        Assert.assertEquals(tariff.getSubscriptionFee(), 15.50);
        Assert.assertEquals(tariff.getClientCount(), 1000);
        Assert.assertEquals(tariff.getFreeMinutes(), 500);
    }

    @Test
    public void testCorporateTariffCreation() {
        CorporateTariff tariff = new CorporateTariff("Business", 50.0, 300, 0.15);

        Assert.assertEquals(tariff.getName(), "Business");
        Assert.assertEquals(tariff.getSubscriptionFee(), 50.0);
        Assert.assertEquals(tariff.getClientCount(), 300);
        Assert.assertEquals(tariff.getRoamingDiscount(), 0.15);
    }
}