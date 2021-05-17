package ViewModels;

import Conexion.Consult;
import Library.Calendario;
import Library.Objetos;
import Library.Paginador;
import Library.Render_CheckBox;
import Library.Uploadimage;
import Models.TClientes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author isra
 */
public class ClientesVM extends Consult {
    
    private String _acccion = "insert";
    private final ArrayList<JLabel> _label;
    private final ArrayList<JTextField> _textField;
    private JCheckBox _checkBoxCredito;
    private final JTable _tableCliente;
    private DefaultTableModel modelo1;
    private JSpinner _spinnerPaginas;
    private int _idCliente = 0;
    private int _reg_por_pagina = 10;
    private int _num_pagina = 1;
    private int seccion;
    private Paginador<TClientes> _paginadorClientes;
    
    public ClientesVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
        _checkBoxCredito = (JCheckBox) objects[0];
        _tableCliente = (JTable) objects[1];
        _spinnerPaginas = (JSpinner) objects[2];
        restablecer();
    }

    // <editor-fold defaultstate="collapsed" desc="CODIGO DE REGISTRAR CLIENTE">
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
                                    try {
                                        switch (_acccion) {
                                            case "insert":
                                                
                                                if (count == 0) {
                                                    SaveData();
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
                                                
                                                break;
                                            case "update":
                                                if (count == 2) {
                                                    if (listEmail.get(0).getID() == _idCliente && listNid.get(0).getID() == _idCliente) {
                                                        SaveData();
                                                    } else {
                                                        if (listNid.get(0).getID() != _idCliente) {
                                                            _label.get(0).setText("El nid ya esta registrado");
                                                            _label.get(0).setForeground(Color.red);
                                                            _textField.get(0).requestFocus();
                                                        }
                                                        if (listEmail.get(0).getID() != _idCliente) {
                                                            _label.get(3).setText("El email ya esta registrado");
                                                            _label.get(3).setForeground(Color.red);
                                                            _textField.get(3).requestFocus();
                                                        }
                                                    }
                                                } else {
                                                    if (count == 0) {
                                                        SaveData();
                                                    } else {
                                                        if (!listNid.isEmpty()) {
                                                            if (listNid.get(0).getID() != _idCliente) {
                                                                SaveData();
                                                            } else {
                                                                _label.get(0).setText("El nid1 ya esta registrado");
                                                                _label.get(0).setForeground(Color.red);
                                                                _textField.get(0).requestFocus();
                                                            }
                                                        }
                                                        if (!listEmail.isEmpty()) {
                                                            if (listEmail.get(0).getID() != _idCliente) {
                                                                SaveData();
                                                            } else {
                                                                _label.get(3).setText("El email ya esta registrado");
                                                                _label.get(3).setForeground(Color.red);
                                                                _textField.get(3).requestFocus();
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void SaveData() throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner(true);
            getConn().setAutoCommit(false);
            byte[] image = Uploadimage.getImageByte();
            if (image == null) {
                image = Objetos.uploadimage.getTransFoto(_label.get(6));
            }
            switch (_acccion) {
                case "insert":
                    String sqlCliente1 = "INSERT INTO tclientes "
                            + "(Nid,Nombre,Apellido,Email,Telefono,Direccion,Credito,Fecha,Imagen) "
                            + "VALUES (?,?,?,?,?,?,?,?,?)";
                    Object[] dataCliente1 = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(2).getText(),
                        _textField.get(3).getText(),
                        _textField.get(4).getText(),
                        _textField.get(5).getText(),
                        _checkBoxCredito.isSelected(),
                        new Calendario().getFecha(),
                        image
                    };
                    qr.insert(getConn(), sqlCliente1, new ColumnListHandler(), dataCliente1);
                    String sqlReport = "INSERT INTO treportes_clientes "
                            + "(DeudaActutal, FechaDeuda, UltimoPago, FechaPago, Ticket, FechaLimite, IdCliente) "
                            + "VALUES (?,?,?,?,?,?,?)";
                    List<TClientes> clientes = clientes();
                    Object[] dataReport = {
                        0,
                        "--/--/--",
                        0,
                        "--/--/--",
                        "0000000000",
                        "--/--/--",
                        clientes.get(clientes.size() - 1).getID()
                    };
                    qr.insert(getConn(), sqlReport, new ColumnListHandler(), dataReport);
                    break;
                case "update":
                    Object[] dataCliente2 = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(2).getText(),
                        _textField.get(3).getText(),
                        _textField.get(4).getText(),
                        _textField.get(5).getText(),
                        _checkBoxCredito.isSelected(),
                        image
                    };
                    String sqlCliente2 = "UPDATE tclientes SET "
                            + "Nid =  ?, Nombre =  ?, Apellido =  ?, Email =  ?, "
                            + "Telefono =  ?, Direccion =  ?, Credito =  ?, Imagen =  ? "
                            + "WHERE ID =" + _idCliente;
                    qr.update(getConn(), sqlCliente2, dataCliente2);
                    break;
            }
            getConn().commit();
            restablecer();
        } catch (SQLException e) {
            getConn().rollback();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void SearcClientes(String campo) {
        List<TClientes> clienteFilter;
        String[] titulos = {"Id", "Nid", "Nombre", "Apellido", "Email", "Direccion", "Telefono", "Credito", "Image"};
        modelo1 = new DefaultTableModel(null, titulos);
        int inicio = (_num_pagina - 1) * _reg_por_pagina;
        if (campo.isEmpty()) {
            clienteFilter = clientes().stream()
                    .skip(inicio).limit(_reg_por_pagina)
                    .collect(Collectors.toList());
        } else {
            clienteFilter = clientes().stream()
                    .filter(cliente -> cliente.getNid().startsWith(campo) || cliente.getNombre().startsWith(campo)
                    || cliente.getApellido().startsWith(campo))
                    .skip(inicio).limit(_reg_por_pagina)
                    .collect(Collectors.toList());
        }
        if (!clienteFilter.isEmpty()) {
            clienteFilter.forEach(item -> {
                Object[] registros = {
                    item.getID(),
                    item.getNid(),
                    item.getNombre(),
                    item.getApellido(),
                    item.getEmail(),
                    item.getDireccion(),
                    item.getTelefono(),
                    item.isCredito(),
                    item.getImagen()
                };
                modelo1.addRow(registros);
            });
        }
        _tableCliente.setModel(modelo1);
        _tableCliente.setRowHeight(30);;
        _tableCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableCliente.getColumnModel().getColumn(0).setMinWidth(0);
        _tableCliente.getColumnModel().getColumn(0).setPreferredWidth(0);
        _tableCliente.getColumnModel().getColumn(8).setMaxWidth(0);
        _tableCliente.getColumnModel().getColumn(8).setMinWidth(0);
        _tableCliente.getColumnModel().getColumn(8).setPreferredWidth(0);
        _tableCliente.getColumnModel().getColumn(7).setCellRenderer(new Render_CheckBox());
    }
    
    public void GetCliente() {
        _acccion = "update";
        int filas = _tableCliente.getSelectedRow();
        _idCliente = (Integer) modelo1.getValueAt(filas, 0);
        _textField.get(0).setText((String) modelo1.getValueAt(filas, 1));
        _textField.get(1).setText((String) modelo1.getValueAt(filas, 2));
        _textField.get(2).setText((String) modelo1.getValueAt(filas, 3));
        _textField.get(3).setText((String) modelo1.getValueAt(filas, 4));
        _textField.get(5).setText((String) modelo1.getValueAt(filas, 5));
        _textField.get(4).setText((String) modelo1.getValueAt(filas, 6));
        _checkBoxCredito.setSelected((Boolean) modelo1.getValueAt(filas, 7));
        Objetos.uploadimage.byteImage(_label.get(6), (byte[]) modelo1.getValueAt(filas, 8));
    }
    
    public final void restablecer() {
        seccion = 1;
        _acccion = "insert";
        _textField.get(0).setText("");
        _textField.get(1).setText("");
        _textField.get(2).setText("");
        _textField.get(3).setText("");
        _textField.get(4).setText("");
        _textField.get(5).setText("");
        _checkBoxCredito.setSelected(false);
        _checkBoxCredito.setForeground(new Color(102, 102, 102));
        _label.get(0).setText("Nid");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("Nombre");
        _label.get(1).setForeground(new Color(102, 102, 102));
        _label.get(2).setText("Apellido");
        _label.get(2).setForeground(new Color(102, 102, 102));
        _label.get(3).setText("Email");
        _label.get(3).setForeground(new Color(102, 102, 102));
        _label.get(4).setText("Telefono");
        _label.get(4).setForeground(new Color(102, 102, 102));
        _label.get(5).setText("Direccion");
        _label.get(5).setForeground(new Color(102, 102, 102));
        _label.get(6).setIcon(new ImageIcon(getClass().getClassLoader()
                .getResource("Resources/logo-google_1.png")));
        listClientes = clientes();
        if (!listClientes.isEmpty()) {
            _paginadorClientes = new Paginador<>(listClientes, _label.get(7), _reg_por_pagina);
        }
        SpinnerNumberModel model = new SpinnerNumberModel(
                new Integer(10), // Dato visualizado al inicio en el spinner
                new Integer(1), // Limite inferior,
                new Integer(100), // Limite superior
                new Integer(1) // Incremento-decremento
        );
        _spinnerPaginas.setModel(model);
        SearcClientes("");
    }
    // </editor-fold>

    private List<TClientes> listClientes;
    
    public void Paginador(String metodo) {
        switch (metodo) {
            case "Primero":
                switch (seccion) {
                    case 1:
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.primero();
                        }
                        break;
                }
                break;
            case "Anterior":
                switch (seccion) {
                    case 1:
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.anterior();
                        }
                        break;
                }
                break;
            case "Siguiente":
                switch (seccion) {
                    case 1:
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.siguiente();
                        }
                        break;
                }
                break;
            case "Ultimo":
                switch (seccion) {
                    case 1:
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.ultimo();
                        }
                        break;
                }
                break;
        }
        switch (seccion) {
            case 1:
                SearcClientes("");
                break;
        }
    }
    
    public void Registro_Paginas() {
        _num_pagina = 1;
        Number caja = (Number) _spinnerPaginas.getValue();
        _reg_por_pagina = caja.intValue();
        if (!listClientes.isEmpty()) {
            _paginadorClientes = new Paginador<>(listClientes, _label.get(7), _reg_por_pagina);
            SearcClientes("");
        }
    }
}
