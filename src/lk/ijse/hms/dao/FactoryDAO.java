package lk.ijse.hms.dao;


public class FactoryDAO {
    private static FactoryDAO factoryDAO;

    private FactoryDAO() {
    }

    public static FactoryDAO getFactoryDAO() {
        return factoryDAO == null ? factoryDAO = new FactoryDAO() : factoryDAO;
    }

    public enum Types {
        STUDENT,
        ROOM,
        RECEPTION,
        JOIN_QUERY,
        USER
    }
}
