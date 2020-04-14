package com.bridgelabz.quantitymeasurementspringapi.enumerations;

public enum SubQuantities {
    FEET(Quantities.LENGTH), INCH(Quantities.LENGTH), YARD(Quantities.LENGTH), CENTIMETER(Quantities.LENGTH),

    LITER(Quantities.VOLUME), GALLON(Quantities.VOLUME), MILLILITRE(Quantities.VOLUME),

    KILOGRAM(Quantities.WEIGHT), GRAM(Quantities.WEIGHT), TONNE(Quantities.WEIGHT),

    CELSIUS(Quantities.TEMPERATURE), FAHRENHEIT(Quantities.TEMPERATURE);

    public Quantities mainQuantityType;

    SubQuantities(Quantities mainQuantityType) {
        this.mainQuantityType = mainQuantityType;
    }
}
