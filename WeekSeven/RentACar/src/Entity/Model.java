package Entity;

import Core.ComboItem;

public class Model {
    private int modelId, modelBrandId;
    private String modelName, modelYear;
    private Type modelType;
    private Fuel modelFuel;
    private Gear modelGear;
    private Brand brand;

    private ComboItem comboItem;
    public enum Fuel {
        GASOLINE,
        LPG,
        ELECTRIC,
        DIESEL
    }
    public enum Gear {
        MANUEL,
        AUTO
    }
    public enum Type {
        SEDAN,
        HATCHBACK
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getModelBrandId() {
        return modelBrandId;
    }

    public void setModelBrandId(int modelBrandId) {
        this.modelBrandId = modelBrandId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public Type getModelType() {
        return modelType;
    }

    public void setModelType(Type modelType) {
        this.modelType = modelType;
    }

    public Fuel getModelFuel() {
        return modelFuel;
    }

    public void setModelFuel(Fuel modelFuel) {
        this.modelFuel = modelFuel;
    }

    public Gear getModelGear() {
        return modelGear;
    }

    public void setModelGear(Gear modelGear) {
        this.modelGear = modelGear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ComboItem getComboItem() {
        return new ComboItem(this.getModelId(), this.getBrand().getBrandName() + " - " +
                this.getModelName() + " - " + this.getModelYear());
    }

    public void setComboItem(ComboItem comboItem) {
        this.comboItem = comboItem;
    }
}
