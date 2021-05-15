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
        if ((car < 'a' || car > 'z') && (car < 'A' && car > '>') && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }
}
