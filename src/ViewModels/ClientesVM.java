package ViewModels;

import Conexion.Consult;
import Library.Objetos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author isra
 */
public class ClientesVM extends Consult {

    private String acccion = "insert";
    private final ArrayList<JLabel> _label;
    private final ArrayList<JTextField> _textField;

    public ClientesVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
    }

    public void registrarCliente() {
        if (_textField.get(0).getText().isEmpty()) {
            _label.get(0).setText("Ingrese el nid");
            _label.get(0).setForeground(Color.RED);
            _label.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().isEmpty()) {
                _label.get(1).setText("Ingrese el nombre");
                _label.get(1).setForeground(Color.RED);
                _label.get(1).requestFocus();
            } else {
                if (_textField.get(2).getText().isEmpty()) {
                    _label.get(2).setText("Ingrese el apellido");
                    _label.get(2).setForeground(Color.RED);
                    _label.get(2).requestFocus();
                } else {
                    if (_textField.get(3).getText().isEmpty()) {
                        _label.get(3).setText("Ingrese el email");
                        _label.get(3).setForeground(Color.RED);
                        _label.get(3).requestFocus();
                    } else {
                        if (!Objetos.evetos.isEmail(_textField.get(3).getText())) {
                            _label.get(3).setText("Ingrese un email válido");
                            _label.get(3).setForeground(Color.RED);
                            _label.get(3).requestFocus();
                        } else {
                            if (_textField.get(4).getText().isEmpty()) {
                                _label.get(4).setText("Ingrese el telefono");
                                _label.get(4).setForeground(Color.RED);
                                _label.get(4).requestFocus();
                            } else {
                                if (_textField.get(5).getText().isEmpty()) {
                                    _label.get(5).setText("Ingrese la direccion");
                                    _label.get(5).setForeground(Color.RED);
                                    _label.get(5).requestFocus();
                                } else {
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
