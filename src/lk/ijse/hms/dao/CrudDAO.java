package lk.ijse.hms.dao;

import java.util.ArrayList;

public interface CrudDAO<T> {
    public ArrayList<T> getData();

    public boolean delete(String id);

    public boolean add(T entity);

    public boolean update(T entity);

    public String getCurrentID();
}
