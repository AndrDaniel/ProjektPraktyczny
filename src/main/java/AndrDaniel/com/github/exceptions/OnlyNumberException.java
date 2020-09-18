package AndrDaniel.com.github.exceptions;

public class OnlyNumberException extends CustomException {
    private int code = 102;


    public OnlyNumberException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
