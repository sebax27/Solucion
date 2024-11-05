

import java.util.LinkedList;
import java.util.Scanner;



public class GestionPrestamos {
    private LinkedList<EstudianteIngenieria> Ingenieros;
    private LinkedList<EstudianteDiseño> Diseñadores;
    private Importar im = new Importar();
    private Exportar ex = new Exportar();
    private Scanner scanner;
    
   

    public GestionPrestamos() {
        Ingenieros = new LinkedList<>();
        Diseñadores = new LinkedList<>();
        im = new Importar();
        ex = new Exportar();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE PRÉSTAMOS ===");
            System.out.println("1. ESTUDIANTES DE INGENIERÍA");
            System.out.println("2. ESTUDIANTES DE DISEÑO");
            System.out.println("3. IMPRIMIR INVENTARIO TOTAL");
            System.out.println("4. SALIR DEL PROGRAMA");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    menuIngenieria();
                    break;
                case 2:
                    menuDiseno();
                    break;
                case 3:
                    imprimirInventarioTotal();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);
        scanner.close();
    }

    private int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void menuIngenieria() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ INGENIERÍA ===");
            System.out.println("1. Registrar préstamo de equipo");
            System.out.println("2. Modificar préstamo de equipo (Por serial o cédula)");
            System.out.println("3. Devolución de equipo (Por serial o cédula)");
            System.out.println("4. Buscar equipo (Por serial o cédula)");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarPrestamoComputador();
                    break;
                case 2:
                    modificarPrestamoComputador();
                    break;
                case 3:
                    devolverEquipoComputador();
                    break;
                case 4:
                    buscarEquipoComputador();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    private void menuDiseno() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ DISEÑO ===");
            System.out.println("1. Registrar préstamo de equipo");
            System.out.println("2. Modificar préstamo de equipo (Por serial o cédula)");
            System.out.println("3. Devolución de equipo (Por serial o cédula)");
            System.out.println("4. Buscar equipo (Por serial o cédula)");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarPrestamoTableta();
                    break;
                case 2:
                    modificarPrestamoTableta();
                    break;
                case 3:
                    devolverEquipoTableta();
                    break;
                case 4:
                    buscarEquipoTableta();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public void registrarPrestamoComputador() {
        scanner.nextLine(); // Limpiar el buffer

        // Ingenieros = im.leerArchivoIngenieria("EstudiantesIngenieria");

      
        String cedula;
        System.out.print("Ingrese la cédula del estudiante: ");
        cedula = scanner.nextLine();
       
        // gp.buscarEstudianteIngenieria(cedula);

        if(cedula == null){
            
            
        }

     
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el teléfono del estudiante: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el número de semestre: ");
        int numeroSemestre = scanner.nextInt();
        System.out.print("Ingrese el promedio acumulado: ");
        float promedioAcumulado = scanner.nextFloat();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el serial del computador: ");
        String serial = scanner.nextLine();

        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, numeroSemestre, promedioAcumulado, serial);
        Ingenieros.add(estudiante);

        ex.exportarArchivoIngenieria(Ingenieros);

        System.out.println("Préstamo de equipo registrado para " + nombre + " " + apellido);
    }

    public void modificarPrestamoComputador() {
        System.out.print("Ingrese el serial o cédula para buscar el préstamo: ");
        String identificador = scanner.next();
        EstudianteIngenieria estudiante = buscarEstudianteIngenieria(identificador);

        if (estudiante != null) {
            System.out.print("Ingrese el nuevo número de semestre: ");
            estudiante.setNumeroSemestre(scanner.nextInt());
            System.out.print("Ingrese el nuevo promedio acumulado: ");
            estudiante.setPromedioAcumulado(scanner.nextFloat());
            System.out.println("Préstamo modificado correctamente.");
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado.");
        }
    }

    public void devolverEquipoComputador() {
        System.out.print("Ingrese el serial o cédula para eliminar el préstamo: ");
        String identificador = scanner.next();
        EstudianteIngenieria estudiante = buscarEstudianteIngenieria(identificador);

        if (estudiante != null) {
            Ingenieros.remove(estudiante);
            System.out.println("Equipo devuelto y registro eliminado.");
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado.");
        }
    }

    public void buscarEquipoComputador() {
        System.out.print("Ingrese el serial o cédula para buscar el equipo: ");
        String identificador = scanner.next();
        EstudianteIngenieria estudiante = buscarEstudianteIngenieria(identificador);

        if (estudiante != null) {
            System.out.println("Equipo encontrado: " + estudiante);
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado.");
        }
    }

    private EstudianteIngenieria buscarEstudianteIngenieria(String identificador) {
        for (EstudianteIngenieria estudiante : Ingenieros) {
            if (estudiante.getCedula().equals(identificador) || estudiante.getSerial().equals(identificador)) {
                return estudiante;
            }
        }
        return null;
    }

    public void registrarPrestamoTableta() {

        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la cédula del estudiante: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el teléfono del estudiante: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la modalidad de estudio: ");
        String modalidadEstudio = scanner.nextLine();
        System.out.print("Ingrese la cantidad de asignaturas: ");
        int cantidadAsignaturas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el serial de la tableta: ");
        String serial = scanner.nextLine();

        EstudianteDiseño estudiante = new EstudianteDiseño(cedula, nombre, apellido, telefono, modalidadEstudio, cantidadAsignaturas, serial);
        Diseñadores.add(estudiante);

        ex.exportarArchivoDiseño(Diseñadores);

        System.out.println("Préstamo de equipo registrado para " + nombre + " " + apellido);
    }

    public void modificarPrestamoTableta() {
        System.out.print("Ingrese el serial o cédula para buscar el préstamo: ");
        String identificador = scanner.next();
        EstudianteDiseño estudiante = buscarEstudianteDiseño(identificador);

        if (estudiante != null) {
            System.out.print("Ingrese la nueva modalidad de estudio: ");
            estudiante.setModalidadEstudio(scanner.next());
            System.out.print("Ingrese la nueva cantidad de asignaturas: ");
            estudiante.setCantidadAsignaturas(scanner.nextInt());

            ex.exportarArchivoDiseño(Diseñadores);

            System.out.println("Préstamo modificado correctamente.");
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado.");
        }
    }
    public void devolverEquipoTableta() {
        System.out.print("Ingrese el serial o cédula para eliminar el préstamo: ");
        String identificador = scanner.next();
        EstudianteDiseño estudiante = buscarEstudianteDiseño(identificador);

        if (estudiante != null) {
            Diseñadores.remove(estudiante);

            ex.exportarArchivoDiseño(Diseñadores);

            System.out.println("Equipo devuelto y registro eliminado.");
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado.");
        }
    }

    public void buscarEquipoTableta() {
        System.out.print("Ingrese el serial o cédula para buscar el equipo: ");
        String identificador = scanner.next();
        EstudianteDiseño estudiante = buscarEstudianteDiseño(identificador);

        if (estudiante != null) {
            System.out.println("Equipo encontrado: " + estudiante);
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado.");
        }
    }

    private EstudianteDiseño buscarEstudianteDiseño(String identificador) {
        for (EstudianteDiseño estudiante : Diseñadores) {
            if (estudiante.getCedula().equals(identificador) || estudiante.getSerial().equals(identificador)) {
                return estudiante;
            }
        }
        return null;
    }

    public void imprimirInventarioTotal() {
        System.out.println("\n=== INVENTARIO TOTAL ===");
        System.out.println("Préstamos para Estudiantes de Ingeniería:");
        Ingenieros = im.leerArchivoIngenieria("EstudiantesIngenieria");
        for (EstudianteIngenieria estudiante : Ingenieros) {
            System.out.println(estudiante);
        }
        System.out.println("\nPréstamos para Estudiantes de Diseño:");
        Diseñadores = im.leerArchivoDiseño("EstudiantesDiseño");
        for (EstudianteDiseño estudiante : Diseñadores) {
            System.out.println(estudiante);
        }
    }

 
}
