package Library;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author isra
 */
public class Paginador<T> {

    private final List<T> _dataList;
    private final JLabel _label;
    private static int maxReg, _reg_por_pagina, pageCount, numPagi = 1;

    public Paginador(List<T> _dataList, JLabel _label, int reg_por_pagina) {
        this._dataList = _dataList;
        this._label = _label;
        _reg_por_pagina = reg_por_pagina;
        cargarDatos();
    }

    private void cargarDatos() {
    }

}
