package AndrDaniel.com.github.exceptions;

   abstract public class CustomException extends RuntimeException {
    public abstract int getCode();

     public CustomException(String message) {
         super(message);
     }
 }
