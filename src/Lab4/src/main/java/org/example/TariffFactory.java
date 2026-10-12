package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Tariffs.CorporateTariff;
import org.example.Tariffs.PrepaidTariff;
import org.example.Tariffs.Tariff;

import java.util.Optional;

public class TariffFactory {
    private static final Logger logger = LogManager.getLogger(TariffFactory.class);

    public Optional<Tariff> createTariff(String line) {
        if (line == null || line.trim().isEmpty()) {
            return Optional.empty();
        }

        String[] parts = line.split(",");
        if (parts.length < 5) {
            logger.warn("Invalid data format, skipping line: {}", line);
            return Optional.empty();
        }

        String type = parts[0].trim();
        String name = parts[1].trim();
        double fee;
        int clients;

        try {
            fee = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            logger.error("Invalid fee for tariff {}. Using default fee: 0.0", name);
            fee = 0.0;
        }

        try {
            clients = Integer.parseInt(parts[3].trim());
        } catch (NumberFormatException e) {
            logger.error("Invalid client count for tariff {}. Using default: 0", name);
            clients = 0;
        }

        return switch (type.toUpperCase()) {
            case "PREPAID" -> {
                int freeMinutes = parseOrDefault(parts[4].trim());
                yield Optional.of(new PrepaidTariff(name, fee, clients, freeMinutes));
            }
            case "CORPORATE" -> {
                double discount = parseDoubleOrDefault(parts[4].trim());
                yield Optional.of(new CorporateTariff(name, fee, clients, discount));
            }
            default -> {
                logger.warn("Unknown tariff type: {}", type);
                yield Optional.empty();
            }
        };
    }

    private int parseOrDefault(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 100;
        }
    }

    private double parseDoubleOrDefault(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.1;
        }
    }
}