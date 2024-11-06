
import java.util.LinkedList;
import java.util.Scanner;

public class GestionPrestamos {

    private Importar im = new Importar();
    private Exportar ex = new Exportar();
    private LinkedList<EstudianteIngenieria> Ingenieros;
    private LinkedList<EstudianteDiseño> Diseñadores;

    private Scanner scanner;

    public GestionPrestamos() {
        Ingenieros = im.leerArchivoIngenieria("EstudiantesIngenieria");
        // Diseñadores = im.leerArchivoDiseño("EstudiantesDiseño");
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

    private String leerCedula() {
        String cedula;
        while ((true)) {
            System.out.println("Ingrese la cedula del estudiante: ");
            cedula = scanner.nextLine();

            if(cedula.matches("[0-9][1,10]")){
                break;
            }else{
                System.out.println("Por favor ingrese solo números entre 1 y 10 dígitos.");
            }
            
        }
        return cedula;
    }

    private String leerTelefono() {
        String telefono;
        while (true) {
            System.out.println("Ingrese el telefono del estudiante: ");
            telefono = scanner.nextLine();

            // Validar que solo contenga números y tenga entre 7 y 10 dígitos
            if (telefono.matches("[0-9]{1,10}")) {
                break; // Salir del bucle si el teléfono es válido
            } else {
                System.out.println("Por favor ingrese solo números entre 7 y 10 dígitos");
            }
        }
        return telefono;
    }

    private String leerTextoSoloLetras(String dato) {
        String texto;
        while (true) {
            System.out.println("Ingrese el " + dato + " del estudiante: ");
            texto = scanner.nextLine();

            // Validar que el texto solo contenga letras y espacios
            if (texto.matches("[a-zA-Z]*")) {
                break; // Salir del bucle si el texto es válido
            } else {
                System.out.println("Por favor ingrese solo letras");
            }
        }
        return texto;
    }

    private int leerNumeroSemestre() {
        int numeroSemestre;
        while (true) {
            System.out.print("Ingrese el número de semestre (1-10): ");
            if (scanner.hasNextInt()) {
                numeroSemestre = scanner.nextInt();
                if (numeroSemestre >= 1 && numeroSemestre <= 10) {
                    scanner.nextLine(); // Limpiar el buffer
                    break; // Salir del bucle si el semestre es válido
                } else {
                    System.out.println("Por favor ingrese un número entre 1 y 10");
                }
            } else {
                System.out.println("Por favor ingrese un número válido ");
                scanner.next(); // Limpiar entrada inválida
            }
        }
        return numeroSemestre;
    }

    private float leerPromedioAcumulado() {
        float promedioAcumulado;
        while (true) {
            System.out.print("Ingrese el promedio acumulado (0.0 a 5.0): ");
            if (scanner.hasNextFloat()) {
                promedioAcumulado = scanner.nextFloat();
                if (promedioAcumulado >= 0.0 && promedioAcumulado <= 5.0) {
                    scanner.nextLine(); // Limpiar el buffer
                    break; // Salir del bucle si el promedio es válido
                } else {
                    System.out.println("Por favor ingrese un promedio entre 0.0 y 5.0");
                }
            } else {
                System.out.println("Por favor ingrese un número válido");
                scanner.next(); // Limpiar entrada inválida
            }
        }
        return promedioAcumulado;
    }

    private String leerSerial() {
        String serial;
        while (true) {
            System.out.print("Ingrese el serial del computador: ");
            serial = scanner.nextLine();

            if (!serial.isEmpty() && serial.matches("[a-zA-Z0-9]+")) {
                break; // Salir del bucle si el serial es válido
            } else {
                System.out.println("Por favor ingrese un serial válido (solo alfanumérico)");
            }
        }
        return serial;
    }

    private String leerModalidadEstudio() {
        String modalidad;
        while (true) {
            System.out.print("Ingrese la modalidad de estudio (virtual/presencial): ");
            modalidad = scanner.nextLine().toLowerCase().trim();
    
            // Validar que la modalidad sea "virtual" o "presencial"
            if (modalidad.equals("virtual") || modalidad.equals("presencial")) {
                break; // Salir del bucle si la modalidad es válida
            } else {
                System.out.println("Por favor ingrese 'virtual' o 'presencial' como modalidad ");
            }
        }
        return modalidad;
    }
    
    private int leerCantidadAsignaturas() {
        int cantidadAsignaturas;
        while (true) {
            System.out.print("Ingrese la cantidad de asignaturas (maximo 6 asignaturas): ");
            if (scanner.hasNextInt()) {
                cantidadAsignaturas = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
    
                // Validar que la cantidad esté entre 1 y 6
                if (cantidadAsignaturas >= 1 && cantidadAsignaturas <= 6) {
                    break; // Salir del bucle si la cantidad es válida
                } else {
                    System.out.println("Por favor, ingrese un número entre 1 y 6.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar la entrada no válida
            }
        }
        return cantidadAsignaturas;
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

        String cedula;

        while (true) {

            cedula = leerCedula();

            // Verificar si la cédula ya está registrada
            EstudianteIngenieria estudianteExistente = buscarEstudianteIngenieria(cedula);
            if (estudianteExistente != null) {
                System.out.println("La cédula ingresada ya está registrada por favor ingrese una cédula diferente");
            } else {
                break; // Salir del bucle si la cédula no está registrada
            }
        }

        String nombre = leerTextoSoloLetras("nombre");
        String apellido = leerTextoSoloLetras("apellido");
        String telefono = leerTelefono();
        int numeroSemestre = leerNumeroSemestre();
        float promedioAcumulado = leerPromedioAcumulado();
        scanner.nextLine(); // Limpiar el buffer

        String serial = leerSerial();

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
            for (EstudianteIngenieria e : Ingenieros) {
                if (estudiante.getCedula().equals(identificador) || estudiante.getSerial().equals(identificador)) {

                    System.out.println("Ingrese el nuevo telefono del estudiante: ");
                    e.setTelefono(scanner.next());
                    System.out.print("Ingrese el nuevo número de semestre: ");
                    e.setNumeroSemestre(scanner.nextInt());
                    System.out.print("Ingrese el nuevo promedio acumulado: ");
                    e.setPromedioAcumulado(scanner.nextFloat());
                    System.out.println("Préstamo modificado correctamente");

                    ex.exportarArchivoIngenieria(Ingenieros);

                }

            }
        } else {
            System.out.println("No se encontro un equipo con el identificador proporcionado");
        }
    }

    public void devolverEquipoComputador() {
        System.out.print("Ingrese el serial o cédula para eliminar el préstamo: ");
        String identificador = scanner.next();
        EstudianteIngenieria estudiante = buscarEstudianteIngenieria(identificador);

        if (estudiante != null) {
            for (EstudianteIngenieria e : Ingenieros) {
                if (e.getCedula().equals(identificador) || e.getSerial().equals(identificador)) {

                    Ingenieros.remove(e);
                    System.out.println("Equipo devuelto y registro eliminado ");

                    ex.exportarArchivoIngenieria(Ingenieros);

                }

            }
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado ");
        }

    }

    public void buscarEquipoComputador() {
        System.out.print("Ingrese el serial o cedula para buscar el equipo: ");
        String identificador = scanner.next();
        EstudianteIngenieria estudiante = buscarEstudianteIngenieria(identificador);

        if (estudiante != null) {
            System.out.println("Equipo encontrado: " + estudiante);

        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado");
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
       
        scanner.nextLine();

        String cedula;

        while (true) {
          
            cedula = leerCedula();

            // Verificar si la cédula ya está registrada
            EstudianteDiseño estudianteExistente = buscarEstudianteDiseño(cedula);
            if (estudianteExistente != null) {
                System.out.println("La cédula ingresada ya está registrada. Por favor, ingrese una cédula diferente ");
            } else {
                break; // Salir del bucle si la cédula no está registrada
            }
        }
 
        String nombre = leerTextoSoloLetras("nombre");
        String apellido = leerTextoSoloLetras("apellido");
        String telefono = leerTelefono();
        String modalidadEstudio = leerModalidadEstudio();
        int cantidadAsignaturas = leerCantidadAsignaturas();
        scanner.nextLine(); // Limpiar el buffer
        String serial = leerSerial();

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
            for (EstudianteDiseño e : Diseñadores) {
                if (estudiante.getCedula().equals(identificador) || estudiante.getSerial().equals(identificador)) {

                    System.out.println("Ingrese el nuevo telefono del estudiante: ");
                    e.setTelefono(scanner.next());
                    System.out.print("Ingrese la nueva modalidad de estudio del estudiante: ");
                    e.setModalidadEstudio(scanner.next());
                    System.out.print("Ingrese la nueva cantidad de asignaturas del estudiante: ");
                    e.setCantidadAsignaturas(scanner.nextInt());
                    System.out.println("Préstamo modificado correctamente ");

                    ex.exportarArchivoDiseño(Diseñadores);

                }

            }
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado ");
        }
    }

    public void devolverEquipoTableta() {
        System.out.print("Ingrese el serial o cédula para eliminar el préstamo: ");
        String identificador = scanner.next();
        EstudianteDiseño estudiante = buscarEstudianteDiseño(identificador);

        if (estudiante != null) {
            for (EstudianteDiseño e : Diseñadores) {
                if (e.getCedula().equals(identificador) || e.getSerial().equals(identificador)) {

                    Diseñadores.remove(e);
                    System.out.println("Equipo devuelto y registro eliminado ");

                    ex.exportarArchivoIngenieria(Ingenieros);

                }

            }
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado ");
        }
    }

    public void buscarEquipoTableta() {
        System.out.print("Ingrese el serial o cédula para buscar el equipo: ");
        String identificador = scanner.next();
        EstudianteDiseño estudiante = buscarEstudianteDiseño(identificador);

        if (estudiante != null) {
            System.out.println("Equipo encontrado: " + estudiante);
        } else {
            System.out.println("No se encontró un equipo con el identificador proporcionado ");
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

        for (EstudianteIngenieria estudiante : Ingenieros) {
            System.out.println(estudiante);
        }
        System.out.println("\nPréstamos para Estudiantes de Diseño:");

        for (EstudianteDiseño estudiante : Diseñadores) {
            System.out.println(estudiante);
        }
    }

}
