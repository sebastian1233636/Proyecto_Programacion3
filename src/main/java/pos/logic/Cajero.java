package pos.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cajero {

    private String ID;
    private String Nombre;

    public Cajero(String ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public Cajero() {
        this("","");
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String toString() {
        return Nombre;
    }
}