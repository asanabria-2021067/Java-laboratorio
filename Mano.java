import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una mano de cartas en el juego de Blackjack.
 * Incluye métodos para agregar cartas, calcular el valor total de la mano
 * y gestionar las cartas en la mano.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class Mano {
    private List<Carta> cartas;

    /**
     * Constructor que inicializa una nueva mano de cartas vacía.
     */
    public Mano() {
        this.cartas = new ArrayList<>();
    }

    /**
     * Agrega una carta a la mano.
     * 
     * @param carta La carta a agregar.
     */
    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    /**
     * Calcula el valor total de las cartas en la mano.
     * 
     * Los Ases se cuentan inicialmente como 11, y si el valor total supera
     * 21, los Ases se convierten en 1 para ajustar el total.
     * 
     * @return El valor total de la mano.
     */
    public int calcularValor() {
        int total = 0;
        int aces = 0;

        for (Carta carta : cartas) {
            int valor = carta.getValor();
            if (valor == 1) {
                aces++;
                total += 11; // Contar el As como 11 inicialmente
            } else if (valor >= 10) {
                total += 10; // Las cartas J, Q y K valen 10
            } else {
                total += valor; // Cartas del 2 al 9 valen su valor nominal
            }
        }

        // Ajustar el valor si el total supera 21 y hay Ases en la mano
        while (total > 21 && aces > 0) {
            total -= 10; // Convertir un As de 11 a 1
            aces--;
        }

        return total;
    }

    /**
     * Obtiene la lista de cartas en la mano.
     * 
     * @return La lista de cartas en la mano.
     */
    public List<Carta> getCartas() {
        return cartas;
    }

    /**
     * Reinicia la mano, eliminando todas las cartas de la mano.
     */
    public void reset() {
        cartas.clear();
    }

    /**
     * Establece una nueva lista de cartas para la mano.
     * 
     * @param cartas La nueva lista de cartas.
     */
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
