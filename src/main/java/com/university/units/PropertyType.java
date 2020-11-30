package com.university.units;

public enum PropertyType {
    UNKNOWN(false), PRIVATE_UNIVERSITY(true), STATE_UNIVERSITY(true);
    boolean isKnown;

    PropertyType(boolean isKnown){
        this.isKnown = isKnown;
    }

    public boolean isKnown() {
        return isKnown;
    }

    @Override
    public String toString() {
        StringBuilder type = new StringBuilder();
        String[] stringList = super.toString().toLowerCase().split("_");
        for(String i : stringList){
            type.append(i);
            type.append(' ');
        }
        return type.toString().trim();
    }
}

