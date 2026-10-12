package org.example.Tariffs;

public class PrepaidTariff extends Tariff {
    private final int freeMinutes;

    public PrepaidTariff(String name, double fee, int clients, int freeMinutes) {
        super(name, fee, clients);
        this.freeMinutes = freeMinutes;
    }

    @Override
    public String toString() {
        return super.toString() + " [Prepaid: freeMinutes=" + freeMinutes + "]";
    }

    public int getFreeMinutes() {
        return freeMinutes;
    }
}
