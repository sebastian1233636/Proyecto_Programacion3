package pos.presentation.Estadistica;

import pos.logic.objetoEstadistica;
import pos.presentation.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel<objetoEstadistica> implements javax.swing.table.TableModel {
    private List<String> fechas;

    public TableModel(List<String> fechas, List<objetoEstadistica> rows) {
        super(generateColumnIndices(fechas.size()), rows);
        this.fechas = fechas;
        initColNames();
    }

    private static int[] generateColumnIndices(int numColumns) {
        int[] indices = new int[numColumns];
        for (int i = 0; i < numColumns; i++) {
            indices[i] = i;
        }
        return indices;
    }

    @Override
    protected Object getPropetyAt(objetoEstadistica e, int col) {
        // Aquí deberás adaptar el código según cómo deseas manejar los datos por fecha.
        // Por ejemplo, si deseas contar las fechas, deberás revisar el objeto `objetoEstadistica`
        // para ver si tiene datos para esa fecha específica.
        List<String> fechas = e.getFechas(); // Asume que hay un método getFechas() en objetoEstadistica
        return fechas.contains(this.fechas.get(col)) ? 1 : 0; // Un ejemplo simple, podrías ajustar según tus necesidades
    }

    @Override
    protected void initColNames() {
        colNames = new String[fechas.size()];
        for (int i = 0; i < fechas.size(); i++) {
            colNames[i] = fechas.get(i);
        }
    }
}
