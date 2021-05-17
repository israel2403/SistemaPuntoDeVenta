package Library;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author isra
 */
public class Render_CheckBox extends JCheckBox implements TableCellRenderer {

    private final JComponent component = new JCheckBox();

    public Render_CheckBox() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        ((JCheckBox) component).setBackground(new Color(0, 200, 0));
        boolean b = ((Boolean) o).booleanValue();
        ((JCheckBox) component).setSelected(b);
        return ((JCheckBox) component);
    }

}
