package pos.presentation.Historico;

import pos.Application;
import pos.logic.Factura;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class view implements PropertyChangeListener {
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTable table1;
    private JTable table2;
    private JLabel cliente_lbl;


    public JPanel getPanel() {
        return panel1;
    }

   Model model;
    Controller controller;

    public void setModel(pos.presentation.Historico.Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void setController(pos.presentation.Historico.Controller controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case pos.presentation.Historico.Model.LIST:
                int[] cols = {pos.presentation.Historico.TableModel.ID, pos.presentation.Historico.TableModel.FECHA,pos.presentation.Historico.TableModel.CODIGO,pos.presentation.Historico.TableModel.TOTAL};
                table1.setModel(new TableModel(cols, model.getList()));
                table1.setRowHeight(30);
                TableColumnModel columnModel = table1.getColumnModel();
                columnModel.getColumn(1).setPreferredWidth(150);
                columnModel.getColumn(1).setPreferredWidth(150);
                break;
            case pos.presentation.Historico.Model.CURRENT:
                textArea1.setText(model.getCurrent().getID());
                cliente_lbl.setBorder(null);
                cliente_lbl.setToolTipText(null);
                break;
            case pos.presentation.Historico.Model.FILTER:
                textArea1.setText(model.getFilter().getID());
                break;
        }
        this.panel1.revalidate();
    }
}
