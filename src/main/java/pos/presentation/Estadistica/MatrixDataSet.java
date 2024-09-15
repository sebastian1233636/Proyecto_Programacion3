package pos.presentation.Estadistica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MatrixDataSet  {
    List<String> rowKeys;
    List<String> columnKeys;

    private DatasetGroup group;
    pos.presentation.Estadistica.View view;

    public MatrixDataSet(String[] rows, String[] cols) {
        rowKeys = Arrays.asList(rows);
        columnKeys = Arrays.asList(cols);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //aqui se agregan las varas al grafico


        JFreeChart chart = ChartFactory.createLineChart("Ventas por mes","Mes","Ventas",dataset);
        ChartPanel chartPanel= new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        view.PanelGrafico.setLayout(new BorderLayout());
        view.PanelGrafico.add(chartPanel, BorderLayout.CENTER);
        view.PanelGrafico.validate();

    }



}
