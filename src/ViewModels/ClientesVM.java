package ViewModels;

import Conexion.Consult;
import Library.Objetos;
import Library.Uploadimage;
import Models.TClientes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author isra
 */
public class ClientesVM extends Consult {
    
    private String _acccion = "insert";
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
                                    int count;
                                    List<TClientes> listEmail = clientes().stream()
                                            .filter(u -> u.getEmail().equals(_textField.get(3).getText()))
                                            .collect(Collectors.toList());
                                    count = listEmail.size();
                                    List<TClientes> listNid = clientes().stream()
                                            .filter(u -> u.getNid().equals(_textField.get(0).getText()))
                                            .collect(Collectors.toList());
                                    count += listNid.size();
                                    switch (_acccion) {
                                        case "insert":
                                            try {
                                            if (count == 0) {
                                                Insert();
                                            } else {
                                                if (!listEmail.isEmpty()) {
                                                    _label.get(3).setText("El email ya esta registrado");
                                                    _label.get(3).setForeground(Color.red);
                                                    _textField.get(3).requestFocus();
                                                }
                                                if (!listNid.isEmpty()) {
                                                    _label.get(0).setText("El nid ya esta registrado");
                                                    _label.get(0).setForeground(Color.red);
                                                    _textField.get(0).requestFocus();
                                                }
                                            }
                                        } catch (SQLException e) {
                                            JOptionPane.showMessageDialog(null, e);
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void Insert() throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner(true);
            getConn().setAutoCommit(false);
            byte[] image = Uploadimage.getImageByte();
            if (image == null) {
                image = Objetos.uploadimage.getTransFoto(_label.get(6));
            }
        } catch (Exception e) {
        }
    }
}
