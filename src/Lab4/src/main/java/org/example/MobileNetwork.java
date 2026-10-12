package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Tariffs.Tariff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public record MobileNetwork(List<Tariff> tariffs) {
    private static final Logger logger = LogManager.getLogger(MobileNetwork.class);

    public MobileNetwork(List<Tariff> tariffs) {
        this.tariffs = new ArrayList<>(tariffs);
    }

    public List<Tariff> getTariffs() {
        return new ArrayList<>(tariffs);
    }

    public int calculateTotalClients() {
        logger.info("Calculating total number of clients.");
        return tariffs.stream()
                .mapToInt(Tariff::getClientCount)
                .sum();
    }

    public void sortTariffsBySubscriptionFee() {
        logger.info("Sorting tariffs by subscription fee.");
        tariffs.sort(Comparator.comparingDouble(Tariff::getSubscriptionFee));
    }

    public List<Tariff> findTariffsByFeeRange(double minFee, double maxFee) {
        logger.info("Searching for tariffs with subscription fee between {} and {}", minFee, maxFee);
        return tariffs.stream()
                .filter(t -> t.getSubscriptionFee() >= minFee && t.getSubscriptionFee() <= maxFee)
                .collect(Collectors.toList());
    }

}