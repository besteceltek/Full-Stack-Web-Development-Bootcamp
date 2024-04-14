package View;

import Business.BrandManager;
import Business.ModelManager;
import Core.ComboItem;
import Core.Helper;
import Entity.Brand;
import Entity.Model;

import javax.swing.*;

public class ModelView extends Layout{
    private JPanel container;
    private JLabel lbl_model;
    private JComboBox<ComboItem> cmb_model_brand;
    private JLabel lbl_model_brand;
    private JLabel lbl_model_name;
    private JTextField fld_model_name;
    private JLabel lbl_model_type;
    private JLabel lbl_model_year;
    private JTextField fld_model_year;
    private JComboBox<Model.Type> cmb_model_type;
    private JLabel lbl_model_fuel;
    private JComboBox<Model.Fuel> cmb_model_fuel;
    private JComboBox<Model.Gear> cmb_model_gear;
    private JButton btn_model_save;
    private JLabel lbl_model_gear;
    private Model model;
    private ModelManager modelManager;
    private BrandManager brandManager;

    public ModelView(Model model) {
        this.add(container);
        this.model = model;
        this.modelManager = new ModelManager();
        this.brandManager = new BrandManager();
        this.initializeGui(300, 400);

        for(Brand brand : this.brandManager.findAll()) {
            this.cmb_model_brand.addItem(new ComboItem(brand.getBrandId(), brand.getBrandName()));
        }
        this.cmb_model_brand.setSelectedItem(null);
        this.cmb_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_model_fuel.setSelectedItem(null);
        this.cmb_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_model_type.setSelectedItem(null);
        this.cmb_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_model_gear.setSelectedItem(null);

        if (this.model.getModelId() != 0) {
            this.fld_model_name.setText(this.model.getModelName());
            this.fld_model_year.setText(this.model.getModelYear());
            this.cmb_model_fuel.getModel().setSelectedItem(this.model.getModelFuel());
            this.cmb_model_gear.getModel().setSelectedItem(this.model.getModelGear());
            this.cmb_model_type.getModel().setSelectedItem(this.model.getModelType());
            ComboItem defaultBrand = new ComboItem(this.model.getModelId(), this.model.getBrand().getBrandName());
            this.cmb_model_brand.getModel().setSelectedItem(defaultBrand);
        }

        btn_model_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_model_name, this.fld_model_year}) ||
                    Helper.isComboBoxListEmpty(new JComboBox[]{this.cmb_model_gear, this.cmb_model_type, this.cmb_model_fuel, this.cmb_model_brand})) {
                Helper.showMessage("fill");
            } else {
                boolean result;

                ComboItem selectBrand = (ComboItem) cmb_model_brand.getSelectedItem();
                this.model.setModelName(fld_model_name.getText());
                this.model.setModelYear(fld_model_year.getText());
                this.model.setModelGear((Model.Gear)cmb_model_gear.getSelectedItem());
                this.model.setModelType((Model.Type)cmb_model_type.getSelectedItem());
                this.model.setModelFuel((Model.Fuel)cmb_model_fuel.getSelectedItem());
                this.model.setModelBrandId(selectBrand.getKey());

                if (this.model.getModelId() != 0) { // Update
                    result = this.modelManager.update(this.model);
                } else { // Add
                    result = this.modelManager.save(this.model);
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
