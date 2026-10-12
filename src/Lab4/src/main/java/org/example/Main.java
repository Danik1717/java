package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Tariffs.Tariff;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String DATA_FILE_PATH = "src/main/resources/tariffs_data.txt";

    static void main() {
        logger.info("Application started.");

        try {
            DataReader reader = new DataReader();
            List<String> rawData = reader.readLines(DATA_FILE_PATH);

            TariffFactory factory = new TariffFactory();
            List<Tariff> parsedTariffs = rawData.stream()
                    .map(factory::createTariff)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            MobileNetwork network = new MobileNetwork(parsedTariffs);

            int totalClients = network.calculateTotalClients();
            System.out.println("Total clients in the network: " + totalClients);

            network.sortTariffsBySubscriptionFee();
            System.out.println("\nTariffs sorted by subscription fee:");
            network.tariffs().forEach(System.out::println);

            double minFee = 10.0;
            double maxFee = 25.0;
            List<Tariff> matchingTariffs = network.findTariffsByFeeRange(minFee, maxFee);

            System.out.println("\nTariffs with fee between " + minFee + " and " + maxFee + ":");
            matchingTariffs.forEach(System.out::println);

        } catch (Exception e) {
            logger.fatal("A fatal error occurred during application execution.", e);
        }

        logger.info("Application finished.");
    }
}