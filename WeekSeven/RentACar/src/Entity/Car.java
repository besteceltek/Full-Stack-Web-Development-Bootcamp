package Entity;

import Core.ComboItem;

public class Car {
    private int carId, carModelId, carKm;
    private String carPlate;
    private Car.Color carColor;
    private Model model;

    public enum Color {
        RED,
        BLUE,
        WHITE,
        GREEN,
        GREY,
        BLACK
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

    public Car.Color getCarColor() {
        return carColor;
    }

    public void setCarColor(Car.Color carColor) {
        this.carColor = carColor;
    }

    public int getCarKm() {
        return carKm;
    }

    public void setCarKm(int carKm) {
        this.carKm = carKm;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ComboItem getComboItem() {
        return new ComboItem(this.getCarId(), this.getModel().getBrand().getBrandName() + " - " +
                this.getModel().getModelName() + " - " + this.getCarPlate());
    }
}
