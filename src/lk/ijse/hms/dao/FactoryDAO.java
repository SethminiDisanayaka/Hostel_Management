package lk.ijse.hms.dao;

import lk.ijse.hms.dao.custom.impl.*;

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

    // factory - Object creation logic eka hide krnna.
    // singleton  - object ekak eka parak hadala eka re use karanna

    public SuperDAO getDAO(Types types) {
        switch (types) {
            case STUDENT:
                return (SuperDAO) new StudentDAOImpl();
            case ROOM:
                return (SuperDAO) new RoomsDAOImpl();
            case RECEPTION:
                return (SuperDAO) new ReservationDAOImpl();
            case JOIN_QUERY:
                return (SuperDAO) new QueryDAOImpl();
            case USER:
                return (SuperDAO) new UserDAOImpl();
            default:
                return null;
        }
    }
}
