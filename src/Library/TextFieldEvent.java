package Library;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author isra
 */
public class TextFieldEvent {

    public void textKeyPress(KeyEvent evt) {
        // Declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if (Character.isDigit(evt.getKeyChar()) && !(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public void numberKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
    
    public boolean isEmail(String correo){
        Pattern pat = Pattern.compile("^[A-Z0-9+_.-]+@[A-Z0-9.-]+$");
        Matcher mat = pat.matcher(correo.toUpperCase());
        return mat.find();
    }
}
