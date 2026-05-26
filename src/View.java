import java.util.Scanner;

/**
 * Clase encargada de la interaccion directa con el usuario por medio de la consola.
 * Muestra los menus, recoge las entradas de datos y pinta los resultados en pantalla.
 */
public class View {

    /**
     * Muestra el menu principal del gestor de coches en un bucle interactivo.
     * Captura las opciones del usuario y delega las acciones en el Controlador.
     */
    public void menu() {
        Controller c = new Controller();
        int opcion = 0;
        do {
            System.out.println("\n--- XESTOR COCHES ---");
            System.out.println("1. Engadir Coche");
            System.out.println("2. Cambiar velocidad");
            System.out.println("3. Avanzar coche");
            System.out.println("4. Añadir gasolina");
            System.out.println("5. Salir");
            System.out.print("Selecciona unha opción: ");

            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Modelo: ");
                    String modelo = new Scanner(System.in).next();
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    boolean a = c.añadirCoche(modelo, matricula);
                    if (a) {
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Algo ha fallado");
                    }
                }

                case 2 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Nueva velocidad: ");
                    int velocidad = new Scanner(System.in).nextInt();
                    boolean a = c.newVelocidad(matricula, velocidad);
                    if (a) {
                        System.out.println("Se ha cambiado correctamente");
                    } else {
                        System.out.println("Algo ha fallado");
                    }
                }

                case 3 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Metros a avanzar: ");
                    double metros = new Scanner(System.in).nextInt();
                    boolean a = c.avanzar(matricula, metros);
                    if (!a) {
                        System.out.println("Error: No se pudo hacer avanzar el coche (¿Matrícula incorrecta?)");
                    }
                }

                case 4 -> {
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Litros a repostar: ");
                    int litros = new Scanner(System.in).nextInt();
                    boolean a = c.ponerGasolina(matricula, litros);
                    if (!a) {
                        System.out.println("Error: No se pudo poner gasolina (¿Matrícula incorrecta?)");
                    }
                }

                case 5 -> {
                    System.out.println("Chao hasta luego....");
                }
            }
        } while (opcion != 5);
    }

    /**
     * Imprime en pantalla la velocidad actual de un vehiculo con su formato de unidad.
     */
    public boolean muestraVelocidad(String matricula, Integer v) {
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    /**
     * Muestra en la consola los kilometros totales acumulados por el coche.
     */
    public void mostrarKilometros(String matricula, double kms) {
        System.out.println("El coche con matrícula " + matricula + " lleva recorridos: " + kms + " Kms.");
    }

    /**
     * Muestra en la consola el estado actual del tanque de gasolina de un coche.
     */
    public void mostrarGasolina(String matricula, int litros) {
        System.out.println("El coche con matrícula " + matricula + " ahora tiene: " + litros + " litros de gasolina.");
    }
}