package pos.presentation.Estadistica;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

import java.util.Arrays;
import java.util.List;

public class MatrixDataSet implements CategoryDataset {
    List<String> rowKeys;
    List<String> columnKeys;
    float[][]  data;
    private DatasetGroup group;


    public MatrixDataSet(String[] rows, String[] cols, float[][] data) {
        rowKeys = Arrays.asList(rows);
        columnKeys = Arrays.asList(cols);
        this.data = data;
    }

    @Override
    public Comparable getRowKey(int i) {
        return rowKeys.get(i);
    }

    @Override
    public int getRowIndex(Comparable rowKey) {
        return rowKeys.indexOf(rowKey);
    }

    @Override
    public List getRowKeys() {
        return rowKeys;
    }

    @Override
    public Comparable getColumnKey(int i) {
        return columnKeys.get(i);
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        return columnKeys.indexOf(comparable);
    }

    @Override
    public List getColumnKeys() {
        return columnKeys;
    }

    @Override
    public Number getValue(Comparable rowKey, Comparable columnKey) {
        int rowIndex = getRowIndex(rowKey);
        int columnIndex = getColumnIndex(columnKey);
        if (rowIndex == -1 || columnIndex == -1) {
            return null;  // Si la fila o columna no existe, devolver null
        }
        return data[rowIndex][columnIndex];
    }

    @Override
    public int getRowCount() {
        return rowKeys.size();
    }

    @Override
    public int getColumnCount() {
        return columnKeys.size();
    }

    @Override
    public Number getValue(int row, int column) {
        return data[row][column];
    }

    @Override
    public void addChangeListener(DatasetChangeListener datasetChangeListener) {

    }

    @Override
    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {

    }

    @Override
    public DatasetGroup getGroup() {
        return group;
    }

    @Override
    public void setGroup(DatasetGroup datasetGroup) {
    this.group = datasetGroup;
    }
}
