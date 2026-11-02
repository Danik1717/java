package org.example;

import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Builder implements ConfigureDevice {
    private static final Logger builderLogger = (Logger) LogManager.getLogger(Builder.class);

    private final String model;
    private double price = 0.0;
    private int ramGb = 8;
    private String resolution = "1920x1080";
    private String processor = "Standard CPU";
    private final List<String> components = new ArrayList<>();

    public Builder(String model) {
        this.model = model;
        builderLogger.info("Initializing Builder for Computer model: {}", model);
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
        builderLogger.info("[Builder] Setting price to ${}");
    }

    @Override
    public void addRam(int gigabytes) {
        this.ramGb += gigabytes;
        builderLogger.info("[Builder] Adding {}GB RAM", gigabytes);
    }

    @Override
    public void changeResolution(String newResolution) {
        this.resolution = newResolution;
        builderLogger.info("[Builder] Setting resolution to {}", newResolution);
    }

    @Override
    public void changeProcessor(String newProcessor) {
        this.processor = newProcessor;
        builderLogger.info("[Builder] Setting processor to {}", newProcessor);
    }

    @Override
    public void addComponent(String component) {
        this.components.add(component);
        builderLogger.info("[Builder] Adding component: {}", component);
    }

    // Fluent chaining methods that return 'Builder' so you can chain them together
    public Builder withPrice(double price) {
        setPrice(price);
        return this;
    }

    public Builder withRam(int gigabytes) {
        addRam(gigabytes);
        return this;
    }

    public Builder withResolution(String resolution) {
        changeResolution(resolution);
        return this;
    }

    public Builder withProcessor(String processor) {
        changeProcessor(processor);
        return this;
    }

    public Builder withComponent(String component) {
        addComponent(component);
        return this;
    }

    // The build method that wraps everything up and returns the final object
    public Computer build() {
        builderLogger.info("Executing .build() for Computer: {}", model);
        return new Computer(this);
    }
}
}