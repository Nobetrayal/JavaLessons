package com.javalesson.oop;

public enum Size {

    VERY_SMALL("XS"), SMALL("S"), AVERAGE("M"), BIG("L"), VERY_BIG("XL"), UNDEFINED("");

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public Size getSizeFromAbbreviation(String abbreviation) {

        Size sizeFromAbbreviation = Size.UNDEFINED;

        for (Size size:Size.values()) {

            if (size.abbreviation == abbreviation){
                sizeFromAbbreviation = size;
                break;
            }

        }

        return sizeFromAbbreviation;

    }
}
