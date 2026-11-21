package src;

public class Producto {
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private int stockMinimo;

    public Producto(String codigo, String nombre, double precioUnitario, int stock, int stockMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = Math.max(0, stock);
        this.stockMinimo = Math.max(0, stockMinimo);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public boolean tieneStockBajo() {
        return stock <= stockMinimo;
    }

    public String reabastecer(int cantidad) {
        if (cantidad <= 0) {
            return "Cantidad invalida para reabastecer " + nombre + ".";
        }
        stock += cantidad;
        return "Entrada de +" + cantidad + " en " + nombre + " (Stock actual: " + stock + ").";
    }

    public String vender(int cantidad) {
        if (cantidad <= 0) {
            return "Cantidad invalida para vender " + nombre + ".";
        }
        if (cantidad > stock) {
            return "Stock insuficiente de " + nombre + " (Disponible: " + stock + ").";
        }
        stock -= cantidad;
        double total = cantidad * precioUnitario;
        return String.format("Venta de %d x %s por $%.2f (Stock restante: %d).", cantidad, nombre, total, stock);
    }

    @Override
    public String toString() {
        String alerta = tieneStockBajo() ? " [STOCK BAJO]" : "";
        return String.format("[%s] %s | Precio: $%.2f | Stock: %d%s", codigo, nombre, precioUnitario, stock, alerta);
    }
}