package cl.inacap.carroproductos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dto.Producto;

public class ProductosDAOLista  implements ProductosDAO {
private List<Producto> productos = new ArrayList<>();
    //Implementar patron singleton para que se ejecute una vez
    //atributo de la clase
    private static ProductosDAOLista instancia;
    //constructor privado
    private ProductosDAOLista(){
        Producto p = new Producto();
        p.setNombre("Coca-Cola Zero");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non mi id magna sodales cursus et ac diam. Praesent in magna venenatis, volutpat mauris et, semper enim. Phasellus eget erat tortor. Etiam efficitur orci sed magna bibendum lobortis. Etiam eget aliquet erat. ");
        p.setPrecio(1000);
        p.setFoto("https://img1.freepng.es/20180629/foh/kisspng-coca-cola-fizzy-drinks-diet-coke-fanta-coca-cola-zero-5b36222872f3c1.5500892715302743444709.jpg");
        productos.add(p);
        p = new Producto();
        p.setNombre("Papas Lays");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non mi id magna sodales cursus et ac diam. Praesent in magna venenatis, volutpat mauris et, semper enim. Phasellus eget erat tortor. Etiam efficitur orci sed magna bibendum lobortis. Etiam eget aliquet erat. ");
        p.setPrecio(2000);
        p.setFoto("https://e7.pngegg.com/pngimages/309/626/png-clipart-lay-s-potato-chip-frito-lay-flavor-grocery-store-potato.png");
        productos.add(p);
        p = new Producto();
        p.setNombre("Helado Savory");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non mi id magna sodales cursus et ac diam. Praesent in magna venenatis, volutpat mauris et, semper enim. Phasellus eget erat tortor. Etiam efficitur orci sed magna bibendum lobortis. Etiam eget aliquet erat. ");
        p.setPrecio(3400);
        p.setFoto("https://www.savory.cl/sites/default/files/mega_manjar-galletas.png");
        productos.add(p);
    }
    //metodo estatico que permita acceso a la instancia
    public static ProductosDAOLista getInstance(){
        if(instancia == null){
            instancia = new ProductosDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Producto> getAll() {
        return productos;
    }

    @Override
    public Producto save(Producto p) {
        return null;
    }
}
