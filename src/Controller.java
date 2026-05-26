/**
 * Clase controladora que sirve de puente entre la Vista (interfaz) y el Modelo (datos).
 * Contiene el metodo principal para iniciar la ejecucion del programa.
 */
public class Controller {
    static View miView = new View();
    Model miModel = new Model();

    /**
     * Metodo de entrada principal (Main) que arranca la aplicacion mostrando el menu.
     */
    public static void main(String[] args) {
        miView.menu();
    }

    /**
     * Solicita al modelo la creacion de un coche y verifica si se añadio correctamente.
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
     * Modifica la velocidad de un coche y ordena a la vista mostrar el cambio.
     */
    public boolean newVelocidad(String matricula, int velocidad) {
        int nuevaVelocidad = miModel.cambiarVelocidad(matricula, velocidad);
        boolean hecho = miView.muestraVelocidad(matricula, miModel.getVelocidad(matricula));
        return hecho;
    }

    /**
     * Gestiona todo para hacer avanzar un coche calculando sus nuevos kilometros.
     */
    public boolean avanzar(String matricula, double metros) {
        double totalKms = miModel.avanzarCoche(matricula, metros);
        if (totalKms != -1.0) {
            miView.mostrarKilometros(matricula, totalKms);
            return true;
        }
        return false;
    }

    public boolean ponerGasolina(String matricula, int litros) {
        int totalGasolina = miModel.repostarCoche(matricula, litros);
        if (totalGasolina != -1.0) {
            miView.mostrarGasolina(matricula, totalGasolina);
            return true;
        }
        return false;
    }
}