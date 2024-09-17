package pos.presentation.Estadistica;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

import java.util.Arrays;
import java.util.List;

public class MatrixDataSet implements CategoryDataset {
    List<String> rowKeys;
    List<String> columnKeys;
    float[][] data;

    // Constructor para inicializar las claves de filas, columnas y los datos
    public MatrixDataSet(String[] row, String[] column, float[][] data) {
        rowKeys = Arrays.asList(row);
        columnKeys = Arrays.asList(column);
        this.data = data;
    }

    // Retorna la clave de fila en el índice dado
    @Override
    public Comparable getRowKey(int rowIndex) {
        return rowKeys.get(rowIndex);
    }

    // Retorna el índice de la clave de fila dada
    @Override
    public int getRowIndex(Comparable rowKey) {
        return rowKeys.indexOf(rowKey);
    }

    // Retorna todas las claves de fila
    @Override
    public List getRowKeys() {
        return rowKeys;
    }

    // Retorna la clave de columna en el índice dado
    @Override
    public Comparable getColumnKey(int columnIndex) {
        return columnKeys.get(columnIndex);
    }

    // Retorna el índice de la clave de columna dada
    @Override
    public int getColumnIndex(Comparable columnKey) {
        return columnKeys.indexOf(columnKey);
    }

    // Retorna todas las claves de columna
    @Override
    public List getColumnKeys() {
        return columnKeys;
    }

    // Retorna el valor en la posición dada por las claves de fila y columna
    @Override
    public Number getValue(Comparable rowKey, Comparable columnKey) {
        int rowIndex = getRowIndex(rowKey);
        int columnIndex = getColumnIndex(columnKey);
        if (rowIndex < 0 || columnIndex < 0) {
            return 0;  // Retorna 0 si los índices son inválidos
        }
        return data[rowIndex][columnIndex];
    }


    // Retorna el número de filas
    @Override
    public int getRowCount() {
        return rowKeys.size();
    }

    // Retorna el número de columnas
    @Override
    public int getColumnCount() {
        return columnKeys.size();
    }

    // Retorna el valor en la posición dada por los índices de fila y columna
    @Override
    public Number getValue(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    // Métodos no implementados relacionados con los eventos de cambio
    @Override
    public void addChangeListener(DatasetChangeListener listener) {
        // No implementado
    }

    @Override
    public void removeChangeListener(DatasetChangeListener listener) {
        // No implementado
    }

    @Override
    public DatasetGroup getGroup() {
        return null;
    }

    @Override
    public void setGroup(DatasetGroup group) {
        // No implementado
    }
}
