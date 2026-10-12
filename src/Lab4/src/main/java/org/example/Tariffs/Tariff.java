package org.example.Tariffs;

public abstract class Tariff {
    private final String name;
    private final double subscriptionFee;
    private final int clientCount;

    public Tariff(String name, double subscriptionFee, int clientCount) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.clientCount = clientCount;
    }

    public String getName() { return name; }
    public double getSubscriptionFee() { return subscriptionFee; }
    public int getClientCount() { return clientCount; }

    @Override
    public String toString() {
        return "Tariff{name='" + name + "', fee=" + subscriptionFee + ", clients=" + clientCount + "}";
    }
}
