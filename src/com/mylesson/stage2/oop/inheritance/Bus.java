package com.mylesson.stage2.oop.inheritance;

public class Bus extends FuelAuto {

    private int passengerNumber;

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePetrol());
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Bus is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Bus has stopped");
    }

    public Bus(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int passengerNumber) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.passengerNumber = passengerNumber;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public void pickUpPassengers(int passengerNumber) {

        this.passengerNumber += passengerNumber;

    }

    public void releaseUpPassengers() {

        if (isRunning) {
            stop();
        }
        this.passengerNumber = 0;
        System.out.println("passengers released");

    }

    public void fuelUp(){ // overloading
        int volume = getTankVolume() - getAvailablePetrol();
        fuelUp(volume);
    }

    @Override
    public void fuelUp(int petrolVolume) {

        int volume = getAvailablePetrol() + petrolVolume;
        if(volume > getTankVolume()){
            setAvailablePetrol(getTankVolume());
        }

    }
}
