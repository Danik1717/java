package org.example.Tariffs;

public class CorporateTariff extends Tariff {
    private final double roamingDiscount;

    public CorporateTariff(String name, double fee, int clients, double roamingDiscount) {
        super(name, fee, clients);
        this.roamingDiscount = roamingDiscount;
    }

    @Override
    public String toString() {
        return super.toString() + " [Corporate: roamingDiscount=" + roamingDiscount + "]";
    }

    public double getRoamingDiscount() {
        return roamingDiscount;
    }
}