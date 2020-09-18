package AndrDaniel.com.github.exceptions;

public class WrongOptionException extends CustomException {
    private int code = 101;


    public WrongOptionException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
