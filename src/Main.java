package src;

public class Main {
    public static void main(String[] args) {
        Inventario taller = new Inventario();

        Producto p1 = new Producto("REF-01", "Filtro de Aceite", 250.00, 8, 3);
        Producto p2 = new Producto("REF-02", "Bujía Platino", 120.50, 2, 5);
        Producto p3 = new Producto("REF-03", "Aceite Sintético 5W30", 480.00, 15, 4);

        taller.agregarProducto(p1);
        taller.agregarProducto(p2);
        taller.agregarProducto(p3);

        System.out.println("=== INVENTARIO INICIAL ===");
        for (Producto p : taller.getProductos()) {
            System.out.println(p);
        }

        System.out.println("\n=== REGISTRO DE VENTAS ===");
        System.out.println(p1.vender(3));
        System.out.println(p2.vender(1));

        System.out.println("\n=== PRODUCTOS CON STOCK BAJO ===");
        for (Producto p : taller.obtenerProductosStockBajo()) {
            System.out.println(p);
        }

        System.out.println("\n=== OPERACIONES POR CODIGO ===");
        System.out.println(taller.venderProducto("REF-03", 2));
        System.out.println(taller.reabastecerProducto("REF-02", 6));
        System.out.println(taller.venderProducto("REF-99", 1));

        System.out.println("\n=== INVENTARIO ACTUALIZADO ===");
        for (Producto p : taller.getProductos()) {
            System.out.println(p);
        }

        System.out.printf("\nValor total del inventario: $%.2f%n", taller.calcularValorTotalInventario());
    }
}