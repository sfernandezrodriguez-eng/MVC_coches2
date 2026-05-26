/**
 * Clase controladora que sirve de puente entre la Vista (interfaz de usuario)
 * y el Modelo (logica de negocio y datos).
 * Coordina el flujo de ejecucion de las operaciones del sistema de gestion de coches.
 * * @author Tu Nombre
 * @version 1.0 (Mayo 2026)
 */
public class Controller {
    static View miView = new View();
    Model miModel = new Model();

    /**
     * Metodo de entrada principal (Main) que arranca la aplicacion delegando
     * el control inicial al menu interactivo de la vista.
     * * @param args Argumentos de la linea de comandos (no utilizados en esta aplicacion).
     */
    public static void main(String[] args) {
        miView.menu();
    }

    /**
     * Solicita al modelo la creacion de un nuevo coche y verifica si se ha
     * insertado correctamente en el sistema de almacenamiento.
     * * @param modelo    El nombre del modelo o marca del vehiculo (ej. "Alpine").
     * @param matricula La matricula unica identificativa del coche.
     * @return true si el coche fue creado y verificado con exito en el modelo;
     * false si ocurrio algun error en la insercion.
     */
    public boolean añadirCoche(String modelo, String matricula) {
        Coche creado = miModel.crearCoche(modelo, matricula);
        if (creado == miModel.getCoche(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Modifica la velocidad actual de un coche registrado y ordena inmediatamente
     * a la vista mostrar el cambio en pantalla.
     * * @param matricula El identificador unico del coche al que se le alterara la velocidad.
     * @param velocidad El nuevo valor de la velocidad en km/h.
     * @return true si la vista logro procesar y mostrar la nueva velocidad con exito;
     * false en caso contrario.
     */
    public boolean newVelocidad(String matricula, int velocidad) {
        int nuevaVelocidad = miModel.cambiarVelocidad(matricula, velocidad);
        boolean hecho = miView.muestraVelocidad(matricula, miModel.getVelocidad(matricula));
        return hecho;
    }

    /**
     * Gestiona el flujo completo para hacer avanzar un coche una distancia determinada,
     * invocando la actualizacion en el modelo y solicitando su posterior visualizacion.
     * * @param matricula La matricula del vehiculo que va a realizar el desplazamiento.
     * @param metros    La distancia recorrida expresada en metros.
     * @return true si el vehiculo existia y sus kilometros acumulados se actualizaron correctamente;
     * false si el coche no pudo ser localizado.
     */
    public boolean avanzar(String matricula, double metros) {
        double totalKms = miModel.avanzarCoche(matricula, metros);
        if (totalKms != -1.0) {
            miView.mostrarKilometros(matricula, totalKms);
            return true;
        }
        return false;
    }

    /**
     * Coordina el proceso de repostaje añadiendo combustible al tanque de un vehiculo especifico.
     * * @param matricula La matricula del coche que acude a la estacion de servicio.
     * @param litros    La cantidad de combustible en litros que se desea suministrar.
     * @return true si el coche fue localizado y el combustible fue sumado satisfactoriamente;
     * false si la matricula no coincide con ningun registro.
     */
    public boolean ponerGasolina(String matricula, int litros) {
        int totalGasolina = miModel.repostarCoche(matricula, litros);
        if (totalGasolina != -1) { // Nota: Corregido a entero para que coincida con tu tipo de dato de retorno habitual
            miView.mostrarGasolina(matricula, totalGasolina);
            return true;
        }
        return false;
    }
}