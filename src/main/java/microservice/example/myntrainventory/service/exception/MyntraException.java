package microservice.example.myntrainventory.service.exception;

public class MyntraException extends Exception {

    private String errorCode;

    public MyntraException(String message, String errorCode) {
        super(message);
        this.errorCode=errorCode;
    }

    public MyntraException() {
        super();
    }

    public MyntraException(String message) {
        super(message);
    }

    public MyntraException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyntraException(Throwable cause) {
        super(cause);
    }

    protected MyntraException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
