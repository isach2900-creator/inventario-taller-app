package src;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> obtenerProductosStockBajo() {
        List<Producto> bajoStock = new ArrayList<>();
        for (Producto p : productos) {
            if (p.tieneStockBajo()) {
                bajoStock.add(p);
            }
        }
        return bajoStock;
    }
}