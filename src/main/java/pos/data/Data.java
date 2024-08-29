package pos.data;

import pos.logic.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    @XmlElementWrapper(name = "clientes")
    @XmlElement(name = "cliente")
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Factura> facturas;

    public Data() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        facturas = new ArrayList<>();
    }


    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
    public List<Producto> getProductos() {
        return productos;
    }
}
