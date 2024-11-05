import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Exportar {
        public void exportarArchivoIngenieria(LinkedList<EstudianteIngenieria> Registro) {

        try (FileWriter escriba = new FileWriter("EstudiantesIngenieria.txt")) {
            for (EstudianteIngenieria datos : Registro) {
                escriba.write("Cedula: " + datos.getCedula() + "\n");
                escriba.write("Nombre: " + datos.getNombre() + "\n");
                escriba.write("Apellido: " + datos.getApellido() + "\n");
                escriba.write("telefono: " + datos.getTelefono() + "\n");
                escriba.write("Semestre actual: " + datos.getNumeroSemestre() + "\n");
                escriba.write("Promedio acumulado: " + datos.getPromedioAcumulado() + "\n");
                escriba.write("Serial: " + datos.getSerial() + "\n");

                escriba.write("---------------------------------------\n");

            }

            System.out.println("Archivo exportado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo por favor inténtelo de nuevo");
        }
    }

    public void exportarArchivoDiseño(LinkedList<EstudianteDiseño> Registro) {

        try (FileWriter escriba = new FileWriter("EstudiantesDiseño.txt")) {
            for (EstudianteDiseño datos : Registro) {
                escriba.write("Cedula: " + datos.getCedula() + "\n");
                escriba.write("Nombre: " + datos.getNombre() + "\n");
                escriba.write("Apellido: " + datos.getApellido() + "\n");
                escriba.write("telefono: " + datos.getTelefono() + "\n");
                escriba.write("Modalidad: " + datos.getModalidadEstudio() + "\n");
                escriba.write("Asignaturas: " + datos.getCantidadAsignaturas() + "\n");
                escriba.write("Serial: " + datos.getSerial() + "\n");

                escriba.write("---------------------------------------\n");

            }

            System.out.println("Archivo exportado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo por favor inténtelo de nuevo");
        }
    }

    public void exportarArchivoComputadorPortatil(LinkedList<ComputadorPortatil> Registro) {

        try (FileWriter escriba = new FileWriter("ComputadoresPortatiles.txt")) {
            for (ComputadorPortatil datos : Registro) {
                escriba.write("Serial: " + datos.getSerial() + "\n");
                escriba.write("Marca: " + datos.getMarca() + "\n");
                escriba.write("Tamaño: " + datos.getTamaño() + "\n");
                escriba.write("Precio: " + datos.getPrecio() + "\n");
                escriba.write("Sistema operativo: " + datos.getSistemaOperativo() + "\n");
                escriba.write("Procesador: " + datos.getProcesador() + "\n");
              

                escriba.write("---------------------------------------\n");

            }

            System.out.println("Archivo exportado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo por favor inténtelo de nuevo");
        }
    }

    public void exportarArchivoTabletaGrafica(LinkedList<TabletaGrafica> Registro) {

        try (FileWriter escriba = new FileWriter("TabletasGraficas.txt")) {
            for (TabletaGrafica datos : Registro) {
                escriba.write("Serial: " + datos.getSerial() + "\n");
                escriba.write("Marca: " + datos.getMarca() + "\n");
                escriba.write("Tamaño: " + datos.getTamaño() + "\n");
                escriba.write("Precio: " + datos.getPrecio() + "\n");
                escriba.write("Almacenamiento: " + datos.getAlmacenamiento() + "\n");
                escriba.write("Peso: " + datos.getPeso() + "\n");
              

                escriba.write("---------------------------------------\n");

            }

            System.out.println("Archivo exportado correctamente");
        } catch (IOException e) {
           JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo por favor inténtelo de nuevo");
        }
    }

}

