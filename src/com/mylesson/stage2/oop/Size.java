package com.mylesson.stage2.oop;

public enum Size {

    BIG("L"), AVERAGE("M"), SMALL("S"), VERY_SMALL("XS"), VERY_BIG("XL"), UNDEFINED("");

    Size(String abbreviation){

        this.abbreviation = abbreviation;

    }

    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }
}
