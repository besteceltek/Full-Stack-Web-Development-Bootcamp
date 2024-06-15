package Business;

import Core.Helper;
import DAO.ModelDao;
import Entity.Car;
import Entity.Model;

import java.util.ArrayList;

public class ModelManager {

    private ModelDao modelDao;
    private final CarManager carManager;

    public ModelManager() {
        this.modelDao = new ModelDao();
        this.carManager = new CarManager();
    }

    public ArrayList<Model> findAll() {
        return this.modelDao.findAll();
    }

    public boolean save(Model model) {
        if (model.getModelId() != 0) {
            Helper.showMessage("error");
        }
        return this.modelDao.save(model);
    }

    public boolean update(Model brand) {
        if (this.getByID(brand.getModelId()) == null) {
            Helper.showMessage("notFound");
        }
        return this.modelDao.update(brand);
    }

    public boolean delete(int id) {
        if (this.getByID(id) == null) {
            Helper.showMessage("Model ID " + id + " is not found");
            return false;
        }
        for (Car car : this.carManager.getByListModelId(id)) {
            this.carManager.delete(car.getCarId());
        }
        return this.modelDao.delete(id);
    }

    public Model getByID(int id) {
        return this.modelDao.getByID(id);
    }

    public ArrayList<Object[]> getForTable(int colSize, ArrayList<Model> modelList) {
        ArrayList<Object[]> modelRowList = new ArrayList<>();
        for (Model model : modelList) {
            Object[] rowObject = new Object[colSize];
            int i = 0;
            rowObject[i++] = model.getModelId();
            rowObject[i++] = model.getBrand().getBrandName();
            rowObject[i++] = model.getModelName();
            rowObject[i++] = model.getModelYear();
            rowObject[i++] = model.getModelType();
            rowObject[i++] = model.getModelFuel();
            rowObject[i++] = model.getModelGear();
            modelRowList.add(rowObject);
        }
        return modelRowList;
    }

    public ArrayList<Model> searchForTable(int brandId, Model.Fuel fuel, Model.Gear gear, Model.Type type) {
        String select = "SELECT * FROM public.model";
        ArrayList<String> whereList = new ArrayList<>();

        if (brandId != 0) {
            whereList.add("model_brand_id = " + brandId);
        }
        if (fuel != null) {
            whereList.add("model_fuel = '" + fuel.toString() + "'");
        }
        if (gear != null) {
            whereList.add("model_gear = '" + gear.toString() + "'");
        }
        if (type != null) {
            whereList.add("model_type = '" + type.toString() + "'");
        }

        String whereStr = String.join(" AND ", whereList);
        String query = select;
        if (whereStr.length() > 0) {
            query += " WHERE " + whereStr;
        }

        return this.modelDao.selectByQuery(query);
    }

    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.modelDao.getByListBrandId(brandId);
    }
}
