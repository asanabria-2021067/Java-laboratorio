import java.util.List;
import java.util.Scanner;
/**
 * Clase que maneja la interfaz de usuario para el juego de Blackjack.
 * Permite mostrar mensajes, obtener entrada del usuario y mostrar
 * las cartas y resultados del juego.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class JuegoVista {

    /**
     * Muestra un mensaje en la consola.
     * 
     * @param mensaje El mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Obtiene la entrada del usuario desde la consola.
     * 
     * @return La entrada del usuario como una cadena de texto.
     */
    public String obtenerEntradaUsuario() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Muestra las cartas del jugador y su total en la consola.
     * 
     * @param cartas Lista de cartas del jugador.
     */
    public void mostrarCartasJugador(List<Carta> cartas) {
        System.out.println("Cartas del jugador:");
        for (Carta carta : cartas) {
            System.out.println(carta.getRepresentacionCompleta());
        }
        int total = cartas.stream().mapToInt(Carta::getValor).sum();
        System.out.println("Total del jugador: " + total);
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Muestra las cartas del dealer en la consola.
     * Si `mostrarTodas` es false, la primera carta del dealer está oculta.
     * 
     * @param cartas Lista de cartas del dealer.
     * @param mostrarTodas Indica si se deben mostrar todas las cartas del dealer.
     */
    public void mostrarCartasDealer(List<Carta> cartas, boolean mostrarTodas) {
        System.out.println("Cartas del dealer:");
        int total = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (!mostrarTodas && i == 0) {
                System.out.println("Carta oculta");
            } else {
                Carta carta = cartas.get(i);
                System.out.println(carta.getRepresentacionCompleta());
                total += carta.getValor();
            }
        }
        if (mostrarTodas) {
            System.out.println("Total del dealer: " + total);
        }
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Muestra el resultado del juego en la consola.
     * 
     * @param resultado El resultado del juego.
     */
    public void mostrarResultado(String resultado) {
        System.out.println(resultado);
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Muestra las manos finales del jugador y del dealer en la consola.
     * 
     * @param cartasJugador Lista de cartas del jugador.
     * @param cartasDealer Lista de cartas del dealer.
     */
    public void mostrarManosFinales(List<Carta> cartasJugador, List<Carta> cartasDealer) {
        System.out.println("Mano final del jugador:");
        mostrarCartasJugador(cartasJugador);
        System.out.println("Mano final del dealer:");
        mostrarCartasDealer(cartasDealer, true);
    }

    /**
     * Muestra el marcador del juego, incluyendo el número de partidas ganadas
     * y el número total de partidas jugadas.
     * 
     * @param partidasGanadas El número de partidas ganadas por el jugador.
     * @param partidasTotales El número total de partidas jugadas.
     */
    public void mostrarMarcador(int partidasGanadas, int partidasTotales) {
        System.out.println("Marcador:");
        System.out.println("Partidas ganadas: " + partidasGanadas);
        System.out.println("Partidas totales: " + partidasTotales);
        System.out.println("---------------------------------------------------------------");
    }
}
