package pos.presentation.Estadistica;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import pos.logic.Categoria;
import pos.logic.Rango;
import pos.presentation.AbstractModel;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Model extends AbstractModel {
    List<Categoria> categoriasAll;
    List<Categoria> categorias;
    List<String> anniodesde;
    List<String> annioHasta;
    List<String> mesDesde;
    List<String> mesHasta;
    Rango rango;
    String[] rows;
    String[] cols;
    float[][] data;

    public Model(){}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CATEGORASALL);
        firePropertyChange(CATEGORIAS);
        firePropertyChange(ANNIOD);
        firePropertyChange(ANNIOH);
        firePropertyChange(RANGO);
        firePropertyChange(MESDESDE);
        firePropertyChange(MESHASTA);
    }

    public void Init(List<Categoria> all, List<Categoria> cats) {
        this.categoriasAll = all;
        this.categorias = cats;
    }

    public int getRowCount() {
        return rows.length;
    }

    public int getColumnCount() {
        return cols.length + 1;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return rows[rowIndex];
        } else {
            return data[rowIndex][columnIndex - 1];
        }
    }

    public String columnName(int column) {
        if (column == 0) {
            return "Categoria";
        } else {
            return cols[column - 1];
        }
    }




    public void eliminarTodasCategorias() {
        this.rows = new String[0];
        this.data = new float[0][0];

        firePropertyChange(DATA);
    }

    public void eliminarCategoria(int index) {
        if (index < 0 || index >= rows.length) {
            return;
        }

        String[] newRows = new String[rows.length - 1];
        float[][] newData = new float[data.length - 1][data[0].length];

        for (int i = 0, j = 0; i < rows.length; i++) {
            if (i != index) {
                newRows[j] = rows[i];
                newData[j] = data[i];
                j++;
            }
        }
        this.rows = newRows;
        this.data = newData;

        firePropertyChange(DATA);
    }


    public TableModel getTableModel() {
        return new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return rows.length;
            }

            @Override
            public int getColumnCount() {
                return cols.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if (columnIndex == 0) {
                    return rows[rowIndex];
                } else {
                    return data[rowIndex][columnIndex - 1];
                }
            }

            @Override
            public String getColumnName(int column) {
                if (column == 0) {
                    return "Categoria";
                } else {
                    return cols[column - 1];
                }
            }
        };
    }


    // Método para convertir los datos en un dataset para gráficos
    public CategoryDataset createDataset() {
        return new MatrixDataSet(rows, cols, data);
    }

    // Método para generar el gráfico de líneas usando el dataset
    public ChartPanel createLineChart() {
        // Crear el dataset
        CategoryDataset dataset = createDataset();

        // Crear el gráfico de líneas
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Estadísticas de Categorías", // Título
                "Fechas",                     // Etiqueta del eje X
                "Valores",                    // Etiqueta del eje Y
                dataset,                      // Dataset
                PlotOrientation.VERTICAL,     // Orientación
                true,                         // Incluir leyenda
                true,                         // Herramientas
                false                         // URLs
        );

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        return chartPanel;
    }

    public List<Categoria> getCategoriasAll(){
        return categoriasAll;
    }
    public List<String> getAnniodesde() {
        return anniodesde;
    }
    public List<String> getAnnioHasta() {
        return annioHasta;
    }
    public List<String> getMesDesde() {
        return mesDesde;
    }
    public List<String> getMesHasta() {
        return mesHasta;
    }
    public Rango getRango() {
        return rango;
    }
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categoria) {categorias = categoria;}

    public void setCategoriasAll(List<Categoria> categorias) {
        this.categoriasAll = categorias;
        firePropertyChange(CATEGORASALL);
    }

    public void setAnniodesde(List<String> nuevo) {
        anniodesde = nuevo;
        firePropertyChange(ANNIOD);
    }

    public void setAnnioHasta(List<String> nuevo) {
        annioHasta = nuevo;
        firePropertyChange(ANNIOH);
    }

    public void setMesDesde(List<String> nuevo) {
        mesDesde = nuevo;
        firePropertyChange(MESDESDE);
    }

    public void setMesHasta(List<String> nuevo) {
        mesHasta = nuevo;
        firePropertyChange(MESHASTA);
    }

    public void setData(String[] newRows, String[] newCols, float[][] newData) {
        // Asignar los nuevos valores al modelo
        this.rows = newRows;
        this.cols = newCols;
        this.data = newData;

        // Disparar evento de cambio de datos
        firePropertyChange(DATA);
    }

    public void setRango(Rango rango) {
        this.rango = rango;
        firePropertyChange(RANGO);
    }

    public static final String CATEGORASALL = "CategoriasTodas";
    public static final String CATEGORIAS = "Categorias";
    public static final String RANGO = "rango";
    public static final String ANNIOD = "AnnioDesde";
    public static final String ANNIOH = "AnnioHasta";
    public static final String MESDESDE = "mesdesde";
    public static final String MESHASTA = "meshasta";
    public static final String DATA = "data";
}
