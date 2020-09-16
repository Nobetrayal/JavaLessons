package com.mylesson.stage2.oop.inheritance;

public class Truck extends FuelAuto{

    private int cargonWeight;

    public int getCargonWeight() {
        return cargonWeight;
    }

    public void setCargonWeight(int cargonWeight) {
        this.cargonWeight = cargonWeight;
    }

    public Truck(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int cargonWeight) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.cargonWeight = cargonWeight;
    }

    public void load(){
        System.out.println("Cargo loaded");
    }

    public void unLoad(){
        System.out.println("Cargo unloaded");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePetrol());
    }
}
