/**
 * Clase principal que inicia el juego de Blackjack.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class Main {

    /**
     * Método principal que ejecuta el juego de Blackjack.
     * Inicializa la vista del juego, solicita el nombre del jugador,
     * y comienza el juego a través del controlador del juego.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {
        // Inicializa la vista del juego
        JuegoVista vista = new JuegoVista();
        
        // Solicita al usuario que introduzca su nombre
        vista.mostrarMensaje("Introduce tu nombre: ");
        String nombreJugador = vista.obtenerEntradaUsuario();
        
        // Inicializa el controlador del juego con el nombre del jugador
        JuegoControlador juego = new JuegoControlador(nombreJugador);
        
        // Inicia el juego
        juego.iniciarJuego();
    }
}
