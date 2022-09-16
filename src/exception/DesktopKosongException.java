package exception;

/**
 *
 * @author Ravelino Sebastian
 */
public class DesktopKosongException extends Exception{
    public String message() {
        return "Field input daya listrik tidak boleh kosong!";
    }
}
