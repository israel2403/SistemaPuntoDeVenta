/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapuntodeventa;

import Views.Sistema;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author isra
 */
public class SistemaPuntoDeVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(SistemaPuntoDeVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sistema sistema = new Sistema();
        sistema.setExtendedState(Frame.MAXIMIZED_BOTH);
        sistema.setVisible(true);
    }

}
