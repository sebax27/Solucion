
public class TabletaGrafica {

    private String serial;
    private String marca;
    private float tamaño;
    private float precio;
    private String almacenamiento;
    private float peso;

    public TabletaGrafica(String serial, String marca, float tamaño, float precio,
            String almacenamiento, float peso) {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public TabletaGrafica() {
    }

    // Getters y setters
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String MostrarTableta() {
        return "Tableta Gráfica"
                + "\nSerial: " + serial
                + "\nMarca: " + marca
                + "\nTamaño: " + tamaño + " pulgadas"
                + "\nPrecio: $" + precio
                + "\nAlmacenamiento: " + almacenamiento
                + "\nPeso: " + peso + " kg";
    }
}
