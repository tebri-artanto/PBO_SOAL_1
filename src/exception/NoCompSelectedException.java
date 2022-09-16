package exception;

/**
 *
 * @author Ravelino Sebastian
 */
public class NoCompSelectedException extends Exception{
    public String message() {
        return "Jenis Computer harus dipilih!";
    }
}
