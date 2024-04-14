package Business;

import Core.Helper;
import DAO.BrandDao;
import Entity.Brand;
import Entity.Model;
import org.postgresql.util.PSQLException;

import java.util.ArrayList;

public class BrandManager {
    private BrandDao brandDao;
    private ModelManager modelManager;

    public BrandManager() {
        this.brandDao = new BrandDao();
        this.modelManager = new ModelManager();
    }

    public ArrayList<Brand> findAll() {
        return this.brandDao.findAll();
    }

    public boolean save(Brand brand) {
        if (brand.getBrandId() != 0) {
            Helper.showMessage("error");
        }
        return this.brandDao.save(brand);
    }

    public boolean update(Brand brand) {
        if (this.getByID(brand.getBrandId()) == null) {
            Helper.showMessage("notFound");
        }
        return this.brandDao.update(brand);
    }

    public boolean delete(int id) {
        if (this.getByID(id) == null) {
            Helper.showMessage("Brand ID " + id + " is not found");
            return false;
        }
        for (Model model : this.modelManager.getByListBrandId(id)) {
            this.modelManager.delete(model.getModelId());
        }
        return this.brandDao.delete(id);
    }

    public Brand getByID(int id) {
        return this.brandDao.getByID(id);
    }

    public ArrayList<Object[]> getForTable(int colSize) {
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        for (Brand brand : this.findAll()) {
            Object[] rowObject = new Object[colSize];
            int i = 0;
            rowObject[i++] = brand.getBrandId();
            rowObject[i++] = brand.getBrandName();
            brandRowList.add(rowObject);
        }
        return brandRowList;
    }
}
