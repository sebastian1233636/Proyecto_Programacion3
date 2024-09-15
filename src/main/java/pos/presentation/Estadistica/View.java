package pos.presentation.Estadistica;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class View {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTable table1;
    public JPanel PanelGrafico;


    public View() {
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }
        });
    }
}
