package View;

import Business.BrandManager;
import Business.CarManager;
import Business.ModelManager;
import Core.ComboItem;
import Core.Helper;
import Entity.Brand;
import Entity.Car;
import Entity.Model;

import javax.swing.*;

public class CarView extends Layout {
    private Car car;
    private CarManager carManager;
    private JPanel container;
    private JLabel lbl_car;
    private JLabel lbl_car_model;
    private JLabel lbl_car_color;
    private JLabel lbl_car_km;
    private JTextField fld_car_km;
    private JLabel lbl_car_plate;
    private JTextField fld_car_plate;
    private JComboBox cmb_car_model;
    private JButton btn_car_save;
    private JComboBox cmb_car_color;
    private ModelManager modelManager;
    private BrandManager brandManager;

    public CarView(Car car) {
        this.add(container);
        this.carManager = new CarManager();
        this.modelManager = new ModelManager();
        this.brandManager = new BrandManager();
        this.car = car;
        this.initializeGui(300, 400);

        this.cmb_car_color.setModel(new DefaultComboBoxModel<>(Car.Color.values()));
        for (Model model : this.modelManager.findAll()) {
            this.cmb_car_model.addItem(model.getComboItem());
        }

        if (this.car.getCarId() != 0) {
            this.fld_car_km.setText(String.valueOf(this.car.getCarKm()));
            this.fld_car_plate.setText(this.car.getCarPlate());
            ComboItem defaultModel = new ComboItem(this.car.getCarId(),
                    this.car.getModel().getBrand().getBrandName() +
                            " - " +
                            this.car.getModel().getModelName() +
                            " - " +
                            this.car.getModel().getModelYear()
            );
            this.cmb_car_model.getModel().setSelectedItem(defaultModel);
        }

        btn_car_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_car_plate, this.fld_car_km}) ||
                    Helper.isComboBoxListEmpty(new JComboBox[]{this.cmb_car_model, this.cmb_car_color})) {
                Helper.showMessage("fill");
            } else {
                boolean result;

                ComboItem selectModel = (ComboItem) cmb_car_model.getSelectedItem();
                this.car.setCarKm(Integer.parseInt(fld_car_km.getText()));
                this.car.setCarPlate(fld_car_plate.getText());
                this.car.setCarColor((Car.Color) cmb_car_color.getSelectedItem());
                this.car.setCarModelId(selectModel.getKey());

                if (this.car.getCarId() != 0) { // Update
                    result = this.carManager.update(this.car);
                } else { // Add
                    result = this.carManager.save(this.car);
                }

                if (result) {
                    Helper.showMessage("done");
                    dispose();
                } else {
                    Helper.showMessage("error");
                }
            }
        });
    }
}
