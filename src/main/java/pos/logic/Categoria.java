package pos.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Categoria {
    private String nombre;

    public Categoria(){nombre = " ";}

    public Categoria(String nom){this.nombre = nom;}

    public String getNombre(){return nombre;}

    @Override
    public String toString() {return nombre;}
}