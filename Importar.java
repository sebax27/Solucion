import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Importar {
    
    public LinkedList<EstudianteIngenieria> leerArchivoIngenieria(String nombreArchivo) {
        LinkedList<EstudianteIngenieria> estudiantes = new LinkedList<>();
        String rutaArchivo = nombreArchivo + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            EstudianteIngenieria estudiante = null;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Quita espacios en blanco innecesarios al inicio y final

                if (line.isEmpty()) {
                    // Línea vacía, estudiante completo, añadir a la lista y reiniciar el objeto
                    if (estudiante != null) {
                        estudiantes.add(estudiante);
                        estudiante = null;
                    }
                    continue;
                }

                // Inicializar un nuevo estudiante si no está en curso
                if (estudiante == null) {
                    estudiante = new EstudianteIngenieria();
                }

                // Procesar cada línea de datos
                if (line.startsWith("Cedula: ")) {
                    estudiante.setCedula(line.substring(8).trim());
                } else if (line.startsWith("Nombre: ")) {
                    estudiante.setNombre(line.substring(8).trim());
                } else if (line.startsWith("Apellido: ")) {
                    estudiante.setApellido(line.substring(10).trim());
                } else if (line.startsWith("Telefono: ")) {
                    estudiante.setTelefono(line.substring(10).trim());
                } else if (line.startsWith("Semestre actual: ")) {
                    estudiante.setNumeroSemestre(Integer.parseInt(line.substring(17).trim()));
                } else if (line.startsWith("Promedio acumulado: ")) {
                    estudiante.setPromedioAcumulado(Float.parseFloat(line.substring(19).trim()));
                } else if (line.startsWith("Serial: ")) {
                    estudiante.setSerial(line.substring(8).trim());
                }
            }

            // Agregar el último estudiante si el archivo no termina con una línea en blanco
            if (estudiante != null) {
                estudiantes.add(estudiante);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en el archivo: " + e.getMessage());
        }

        return estudiantes;
    }
 
    public LinkedList<EstudianteDiseño> leerArchivoDiseño(String nombreArchivo) {
        LinkedList<EstudianteDiseño> estudiantes = new LinkedList<>();
        String rutaArchivo = nombreArchivo + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            EstudianteDiseño ed = null;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Eliminar espacios en blanco al inicio y al final

                if (line.isEmpty()) {
                    // Línea vacía, lo que indica que no se debe hacer nada
                    continue;
                }

                // Inicializar un nuevo estudiante si no existe
                if (ed == null) {
                    ed = new EstudianteDiseño();
                }

                // Procesar cada línea de datos
                if (line.startsWith("Cedula: ")) {
                    ed.setCedula(line.substring(8).trim());
                } else if (line.startsWith("Nombre: ")) {
                    ed.setNombre(line.substring(8).trim());
                } else if (line.startsWith("Apellido: ")) {
                    ed.setApellido(line.substring(10).trim());
                } else if (line.startsWith("Telefono: ")) {
                    ed.setTelefono(line.substring(10).trim());
                } else if (line.startsWith("Modalidad: ")) {
                    ed.setModalidadEstudio(line.substring(11).trim());
                } else if (line.startsWith("Asignaturas: ")) {
                    ed.setCantidadAsignaturas(Integer.parseInt(line.substring(13).trim()));
                } else if (line.startsWith("Serial: ")) {
                    ed.setSerial(line.substring(8).trim());
                    estudiantes.add(ed); // Añadir estudiante completo a la lista
                    ed = null; // Reiniciar para el siguiente estudiante
                }
            }

            // Agregar el último estudiante si no fue añadido
            if (ed != null) {
                estudiantes.add(ed);
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo, por favor inténtelo de nuevo.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato en el archivo: " + e.getMessage());
        }

        return estudiantes;
    }

    public LinkedList<ComputadorPortatil> leerArchivoComputadorPortatil(String nombreArchivo) {
        LinkedList<ComputadorPortatil> computadores = new LinkedList<>();
        String rutaArchivo = nombreArchivo + ".txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            ComputadorPortatil com = null;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Limpiar espacios en blanco innecesarios

                if (line.isEmpty()) {
                    // Línea vacía, simplemente continuar
                    continue;
                }

                // Inicializar un nuevo computador si es necesario
                if (com == null) {
                    com = new ComputadorPortatil();
                }

                // Procesar cada línea de datos
                if (line.startsWith("Serial: ")) {
                    com.setSerial(line.substring(6).trim());
                } else if (line.startsWith("Marca: ")) {
                    com.setMarca(line.substring(6).trim());
                } else if (line.startsWith("Tamaño: ")) {
                    com.setTamaño(Float.parseFloat(line.substring(8).trim()));
                } else if (line.startsWith("Precio: ")) {
                    com.setPrecio(Float.parseFloat(line.substring(8).trim()));
                } else if (line.startsWith("Sistema operativo: ")) {
                    com.setSistemaOperativo(line.substring(18).trim());
                } else if (line.startsWith("Procesador: ")) {
                    com.setProcesador(line.substring(12).trim());
                    computadores.add(com); // Añadir computador completo a la lista
                    com = null; // Reiniciar para el siguiente computador
                }
            }

            // Agregar el último computador si no fue añadido
            if (com != null) {
                computadores.add(com);
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo, por favor inténtelo de nuevo.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato en el archivo: " + e.getMessage());
        }

        return computadores;
    }
 
    public LinkedList<TabletaGrafica> leerArchivoTabletaGrafica(String nombreArchivo) {
        LinkedList<TabletaGrafica> tabletas = new LinkedList<>();
        String rutaArchivo = nombreArchivo + ".txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            TabletaGrafica ta = null;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Limpiar espacios en blanco innecesarios

                if (line.isEmpty()) {
                    // Línea vacía, simplemente continuar
                    continue;
                }

                // Inicializar un nuevo objeto TabletaGrafica si es necesario
                if (ta == null) {
                    ta = new TabletaGrafica();
                }

                // Procesar cada línea de datos
                if (line.startsWith("Serial: ")) {
                    ta.setSerial(line.substring(6).trim());
                } else if (line.startsWith("Marca: ")) {
                    ta.setMarca(line.substring(6).trim());
                } else if (line.startsWith("Tamaño: ")) {
                    ta.setTamaño(Float.parseFloat(line.substring(8).trim()));
                } else if (line.startsWith("Precio: ")) {
                    ta.setPrecio(Float.parseFloat(line.substring(8).trim()));
                } else if (line.startsWith("Almacenamiento: ")) {
                    ta.setAlmacenamiento(line.substring(16).trim());
                } else if (line.startsWith("Peso: ")) {
                    ta.setPeso(Float.parseFloat(line.substring(6).trim()));
                    tabletas.add(ta); // Añadir tableta completa a la lista
                    ta = null; // Reiniciar para el siguiente objeto TabletaGrafica
                }
            }

            // Agregar la última tableta si no fue añadida
            if (ta != null) {
                tabletas.add(ta);
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al procesar el archivo, por favor inténtelo de nuevo.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato en el archivo: " + e.getMessage());
        }

        return tabletas;
    }
 

}

