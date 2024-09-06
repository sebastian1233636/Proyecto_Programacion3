package pos;

import pos.logic.Service;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception ex) {};

        window = new JFrame();
        JTabbedPane tabbedPane = new JTabbedPane();
        window.setContentPane(tabbedPane);

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Service.instance().stop();
            }
        });

        pos.presentation.Clientes.Model clientesModel= new pos.presentation.Clientes.Model();
        pos.presentation.Clientes.View clientesView = new pos.presentation.Clientes.View();
        clientesController = new pos.presentation.Clientes.Controller(clientesView,clientesModel);
        Icon clientesIcon= new ImageIcon(Application.class.getResource("/pos/presentation/icons/client.png"));

        pos.presentation.Cajero.Model cajeroModel= new pos.presentation.Cajero.Model();
        pos.presentation.Cajero.View cajeroView = new pos.presentation.Cajero.View();
        cajeroController = new pos.presentation.Cajero.Controller(cajeroView,cajeroModel);
        Icon cajeroIcon= new ImageIcon(Application.class.getResource("/pos/presentation/icons/cajero.png"));

        pos.presentation.Productos.Model productoModel= new pos.presentation.Productos.Model();
        pos.presentation.Productos.View productoView = new pos.presentation.Productos.View();
        productoController = new pos.presentation.Productos.Controller(productoView,productoModel);
        Icon productoIcon= new ImageIcon(Application.class.getResource("/pos/presentation/icons/producto.png"));

        pos.presentation.Historico.Model historicoModel= new pos.presentation.Historico.Model();
        pos.presentation.Historico.view viewHistorico = new pos.presentation.Historico.view();
        historicoController = new pos.presentation.Historico.Controller(viewHistorico,historicoModel);
        Icon historicoIcon = new ImageIcon(Application.class.getResource("/pos/presentation/icons/Historico.png"));


        tabbedPane.addTab("Clientes  ",clientesIcon, clientesView.getPanel());
        tabbedPane.addTab("Cajeros  ",cajeroIcon, cajeroView.getPanel());
        tabbedPane.addTab("Productos  ",productoIcon, productoView.getPanel());
        tabbedPane.addTab("Histórico ",historicoIcon, viewHistorico.getPanel());

        window.setSize(750,450);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setIconImage((new ImageIcon(Application.class.getResource("presentation/icons/icon.png"))).getImage());
        window.setTitle("POS: Point Of Sale");
        window.setVisible(true);
    }

    public static pos.presentation.Clientes.Controller clientesController;
    public static pos.presentation.Cajero.Controller cajeroController;
    public static pos.presentation.Productos.Controller productoController;
    public static pos.presentation.Historico.Controller historicoController;
    public static JFrame window;

    public final static int MODE_CREATE=1;
    public final static int MODE_EDIT=2;

    public static Border BORDER_ERROR = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED);
}
