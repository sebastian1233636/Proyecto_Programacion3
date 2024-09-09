package pos.logic;

import pos.data.Data;
import pos.data.XmlPersister;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private static Service theInstance;
    public static Service instance(){
        if (theInstance == null) theInstance = new Service();
        return theInstance;
    }

    private Data data;
    private Service(){
        try{
            data= XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }
    }

    public void stop(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Data getData(){
        return data;
    }
//================= CLIENTES ============
    public void create(Cliente e) throws Exception{
        Cliente result = data.getClientes().stream().filter(i->i.getId().equals(e.getId())).findFirst().orElse(null);
        if (result==null) data.getClientes().add(e);
        else throw new Exception("Cliente ya existe");
    }

    public Cliente read(Cliente e) throws Exception{
        Cliente result = data.getClientes().stream().filter(i->i.getId().equals(e.getId())).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cliente no existe");
    }

    public void update(Cliente e) throws Exception{
        Cliente result;
        try{
            result = this.read(e);
            data.getClientes().remove(result);
            data.getClientes().add(e);
        }catch (Exception ex) {
            throw new Exception("Cliente no existe");
        }
    }

    public void delete(Cliente e) throws Exception{
        data.getClientes().remove(e);
    }

    public List<Cliente> search(Cliente e){
        return data.getClientes().stream()
                .filter(i->i.getNombre().contains(e.getNombre()))
                .sorted(Comparator.comparing(Cliente::getNombre))
                .collect(Collectors.toList());
    }

    //================= Cajero ============
    public void create(Cajero e) throws Exception{
        Cajero result = data.getCajeros().stream().filter(i->i.getID().equals(e.getID())).findFirst().orElse(null);
        if (result==null) data.getCajeros().add(e);
        else throw new Exception("Cajero ya existe");
    }

    public Cajero read(Cajero e) throws Exception{
        Cajero result = data.getCajeros().stream().filter(i->i.getID().equals(e.getID())).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cajero no existe");
    }

    public void update(Cajero e) throws Exception{
        Cajero result;
        try{
            result = this.read(e);
            data.getCajeros().remove(result);
            data.getCajeros().add(e);
        }catch (Exception ex) {
            throw new Exception("Cajero no existe");
        }
    }

    public void delete(Cajero e) throws Exception{
        data.getCajeros().remove(e);
    }

    public List<Cajero> search(Cajero e){
        return data.getCajeros().stream()
                .filter(i->i.getNombre().contains(e.getNombre()))
                .sorted(Comparator.comparing(Cajero::getNombre))
                .collect(Collectors.toList());
    }

    //================= PRODUCTOS ============
    public void create(Producto e) throws Exception{
        Producto result = data.getProductos().stream().filter(i->i.getCodigo().equals(e.getCodigo())).findFirst().orElse(null);
        if (result==null) data.getProductos().add(e);
        else throw new Exception("El producto ya existe");
    }

    public Producto read(Producto e) throws Exception{
        Producto result = data.getProductos().stream().filter(i->i.getCodigo().equals(e.getCodigo())).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("El producto no existe");
    }

    public void update(Producto e) throws Exception{
        Producto result;
        try{
            result = this.read(e);
            data.getProductos().remove(result);
            data.getProductos().add(e);
        }catch (Exception ex) {
            throw new Exception("El producto no existe");
        }
    }

    public void delete(Producto e) throws Exception{
        data.getProductos().remove(e);
    }

    public List<Producto> search(Producto e){
        return data.getProductos().stream()
                .filter(i->(i.getCodigo().contains(e.getCodigo())||i.getDescripcion().contains(e.getDescripcion())))
                .sorted(Comparator.comparing(Producto::getCodigo))
                .sorted(Comparator.comparing(Producto::getDescripcion))
                .collect(Collectors.toList());
    }

    //================= Facturas ============
    public void create(Factura e) throws Exception{
        Factura result = data.getFacturas().stream().filter(i->i.getID().equals(e.getID())).findFirst().orElse(null);;
        if (result==null) data.getFacturas().add(e);
        else throw new Exception("Este numero de factura ya fue utilizado");
    }
    public Factura read(Factura e) throws Exception{
        Factura result = data.getFacturas().stream().filter(i->i.getID().equals(e.getID())).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("No existe ninguna factura asociada a este ID");
    }

    public void update(Factura e) throws Exception{
        Factura result;
        try{
            result = this.read(e);
            data.getFacturas().remove(result);
            data.getFacturas().add(e);
        }catch (Exception ex) {
            throw new Exception("No existe ninguna factura asociada a este ID");
        }
    }

    public void delete(Factura e) throws Exception{
        data.getFacturas().remove(e);
    }

    public List<Factura> search(Factura e){
        return data.getFacturas().stream()
                .filter(i->i.getID().contains(e.getID()))
                .sorted(Comparator.comparing(Factura::getID))
                .collect(Collectors.toList());
    }

    //-------------------------LINEAS--------------------------------------

    public void create(Linea e) throws Exception{
        Linea result = data.getLineas().stream().filter(i->i.getProducto().getCodigo().equals(e.getProducto().getCodigo())).findFirst().orElse(null);;
        if (result==null) data.getLineas().add(e);
        else throw new Exception("Este codigo ya fue utilizado");
    }
    public Linea read(Linea e) throws Exception{
        Linea result = data.getLineas().stream().filter(i->i.getProducto().getCodigo().equals(e.getProducto().getCodigo())).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("No existe ninguna factura asociada a este ID");
    }

    public void update(Linea e) throws Exception{
        Linea result;
        try{
            result = this.read(e);
            data.getLineas().remove(result);
            data.getLineas().add(e);
        }catch (Exception ex) {
            throw new Exception("No existe ninguna Linea asociada a este codigo");
        }
    }

    public void delete(Linea e) throws Exception{
        data.getLineas().remove(e);
    }

    public List<Linea> search(Linea e){
        return data.getLineas().stream()
                .filter(i -> i.getProducto().getCodigo().contains(e.getProducto().getCodigo()))
                .sorted(Comparator.comparing(i -> i.getProducto().getCodigo()))
                .collect(Collectors.toList());
    }

    public double PagoTotal(List<Linea> lineas) {
        double total = 0;
        for (Linea linea : lineas) {
            total += linea.sacarImporte();
        }
        return total;
    }


 }
















