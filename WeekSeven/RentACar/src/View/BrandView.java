package View;

import Business.BrandManager;
import Core.Helper;
import Entity.Brand;

import javax.swing.*;

public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private Brand brand;
    private BrandManager brandManager;
    public BrandView(Brand brand) {
        this.brandManager = new BrandManager();
        this.add(container);
        this.initializeGui(300, 150);
        this.brand = brand;

        if (brand != null) {
            this.fld_brand_name.setText(brand.getBrandName());
        }
        btn_brand_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_brand_name)) {
                Helper.showMessage("fill");
            } else {
                boolean result;

                if (this.brand == null) { // Add
                    Brand saveBrand = new Brand(fld_brand_name.getText());
                    result = this.brandManager.save(saveBrand);
                } else { // Update
                    this.brand.setBrandName(fld_brand_name.getText());
                    result = this.brandManager.update(this.brand);
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
