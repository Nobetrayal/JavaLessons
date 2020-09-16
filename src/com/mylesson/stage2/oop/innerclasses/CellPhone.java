package com.mylesson.stage2.oop.innerclasses;




public class CellPhone {

    private String make;
    private String model;
    private Display display;
    private RadioModule radioModule;
    private AbstractPhoneButton button;

    public interface AbstractPhoneButton{
        void click();
    }

    public CellPhone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void turnOn(){
        initDisplay();
        radioModule = new RadioModule();
        initButton();
    }

    public void initButton(){
        button = new AbstractPhoneButton() {
            @Override
            public void click() {
                System.out.println("Button clicked...");
            }
        };
    }

    public void call(String number){
        button.click();
        radioModule.call(number);
    }

    private void initDisplay(){

        display = new Display();

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }



}
