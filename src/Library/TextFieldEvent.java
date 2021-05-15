package Library;

import java.awt.event.KeyEvent;

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
}
