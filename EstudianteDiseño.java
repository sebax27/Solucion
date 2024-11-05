
public class EstudianteDiseño {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modalidadEstudio;
    private int cantidadAsignaturas;
    private String serial;

    public EstudianteDiseño(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio, int cantidadAsignaturas, String serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidadEstudio = modalidadEstudio;
        this.cantidadAsignaturas = cantidadAsignaturas;
        this.serial = serial;
    }

    public EstudianteDiseño() {
    }

    // Getters y setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

        
        public String mostrarEstudainteDiseño() {
        return "Estudiante Diseño: " + nombre + " " + apellido
                    + "\nCédula: " + cedula
                    + "\nTeléfono: " + telefono
                    + "\nModalidad: " + modalidadEstudio
                    + "\nAsignaturas: " + cantidadAsignaturas
                    + "\nSerial equipo: " + serial;
        }
    }
