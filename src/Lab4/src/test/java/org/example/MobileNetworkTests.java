package org.example;

import org.example.Tariffs.CorporateTariff;
import org.example.Tariffs.PrepaidTariff;
import org.example.Tariffs.Tariff;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MobileNetworkTests {

    private MobileNetwork network;

    @BeforeMethod
    public void setUp() {
        List<Tariff> initialTariffs = Arrays.asList(
                new PrepaidTariff("Plan A", 15.0, 100, 50),
                new CorporateTariff("Plan B", 50.0, 200, 0.2),
                new PrepaidTariff("Plan C", 10.0, 50, 20)
        );
        network = new MobileNetwork(initialTariffs);
    }

    @Test
    public void testCalculateTotalClients() {
        Assert.assertEquals(network.calculateTotalClients(), 350);
    }

    @Test
    public void testCalculateTotalClientsEmptyNetwork() {
        MobileNetwork emptyNetwork = new MobileNetwork(new ArrayList<>());
        Assert.assertEquals(emptyNetwork.calculateTotalClients(), 0);
    }

    @Test
    public void testSortTariffsBySubscriptionFee() {
        network.sortTariffsBySubscriptionFee();
        List<Tariff> sorted = network.getTariffs();

        Assert.assertEquals(sorted.get(0).getName(), "Plan C"); // 10.0
        Assert.assertEquals(sorted.get(1).getName(), "Plan A"); // 15.0
        Assert.assertEquals(sorted.get(2).getName(), "Plan B"); // 50.0
    }

    @Test
    public void testFindTariffsByFeeRange() {
        List<Tariff> found = network.findTariffsByFeeRange(12.0, 60.0);

        Assert.assertEquals(found.size(), 2);
        Assert.assertFalse(found.stream().anyMatch(t -> t.getName().equals("Plan C"))); // 10.0 не должно попасть
    }

    @Test
    public void testFindTariffsByFeeRangeNoMatches() {
        List<Tariff> found = network.findTariffsByFeeRange(100.0, 200.0);
        Assert.assertTrue(found.isEmpty());
    }
}