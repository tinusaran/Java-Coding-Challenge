package exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String message) {
        super("order not found"+message);
    } }


