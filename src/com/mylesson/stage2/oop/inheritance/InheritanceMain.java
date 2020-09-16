package com.mylesson.stage2.oop.inheritance;

public class InheritanceMain {

    public static void main(String[] args) {

        Engine truckEngine = new Engine(6, EngineType.DIESEL, 900);
        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 150);
        Truck truck = new Truck("Volvo", "VNL 300", truckEngine, 300, 500, 1000);
//        truck.start();
//        truck.accelerate(40);
//        truck.stop();
//        truck.fuelUp(50);
//        truck.load();
//        truck.unLoad();
//        System.out.println("\n");

        ElectricCar car = new ElectricCar("Tesla", "model 6", 4, 100500);
//        car.start();
//        car.stop();
//        car.charge();
//        System.out.println("\n");


        Bus bus = new Bus("Mercedes", "Sprinter", busEngine, 50, 150, 30);
//        bus.start();
//        bus.stop();
        Bus bus2 = new Bus("Mercedes", "Sprinter", busEngine, 50, 150, 30);
        bus2.fuelUp();
        runCar(bus);
        runCar(truck);
        runCar(car);


//        bus.fuelUp();
//        bus.pickUpPassengers(5);
//        bus.start();
//        bus.releaseUpPassengers();
//
//        Engine engine = bus.getEngine();
//        System.out.println(engine.getEngineType());
//        List<Piston> pistons = engine.getPistons();
//        System.out.println(pistons);
    }

    public static void runCar(Auto auto) {
        auto.start();
        auto.stop();
        auto.energize();
//        if(auto instanceof Truck || auto instanceof Bus) {
//            FuelAuto fAuto = (FuelAuto) auto;
//            fAuto.fuelUp(50);
//        }
    }

}
