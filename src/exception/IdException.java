package exception;

/**
 *
 * @author Ravelino Sebastian
 */
public class IdException extends Exception{
    
    public String message() {
        return "ID harus terdiri dari 5 - 8 karakter!";
    }
}
