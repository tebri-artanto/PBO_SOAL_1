package exception;

/**
 *
 * @author Ravelino Sebastian
 */
public class LaptopKosongException extends Exception{
    public String message() {
        return "Field input baterai tidak boleh kosong!";
    }
}
