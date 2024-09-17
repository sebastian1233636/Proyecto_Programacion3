package pos.presentation.Estadistica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MatrixDataSet implements CategoryDataset {
    List<String> rowKeys;
    List<String> columnKeys;
    float [][] data;

    public MatrixDataSet(String[] row, String[] column,float data) {
        rowKeys = Arrays.asList(row);
        columnKeys = Arrays.asList(column);
    }


    @Override
    public Comparable getRowKey(int i) {
        return null;
    }

    @Override
    public int getRowIndex(Comparable comparable) {
        return 0;
    }

    @Override
    public List getRowKeys() {
        return List.of();
    }

    @Override
    public Comparable getColumnKey(int i) {
        return null;
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        return 0;
    }

    @Override
    public List getColumnKeys() {
        return List.of();
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable1) {
        return null;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Number getValue(int i, int i1) {
        return null;
    }

    @Override
    public void addChangeListener(DatasetChangeListener datasetChangeListener) {

    }

    @Override
    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {

    }

    @Override
    public DatasetGroup getGroup() {
        return null;
    }

    @Override
    public void setGroup(DatasetGroup datasetGroup) {

    }
}
