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

    @XmlElementWrapper(name = "productos")
    @XmlElement(name = "producto")
    private List<Producto> productos;

    @XmlElementWrapper(name = "facturas")
    @XmlElement(name = "factura")
    private List<Factura> facturas;

    @XmlElementWrapper(name = "cajeros")
    @XmlElement(name = "cajero")
    private List<Cajero> cajeros;

    @XmlElementWrapper(name = "lineas")
    @XmlElement(name = "lineas")
    private List<Linea> lineas;

    public Data() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        facturas = new ArrayList<>();
        cajeros = new ArrayList<>();
        lineas = new ArrayList<>();
    }

    public List<Cliente> getClientes() {return clientes;}
    public List<Factura> getFacturas() { return facturas;}
    public List<Producto> getProductos() {
        return productos;
    }
    public List<Cajero> getCajeros() {return cajeros;}
    public List<Linea> getLineas() {return lineas;}
}