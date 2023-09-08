package lk.ijse.hms.bo;


public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum Type {
        STUDENT,
        ROOM,
        RECEPTION,
        USER
    }

}