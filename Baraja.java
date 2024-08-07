import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa una baraja de cartas en el juego de Blackjack.
 * Incluye métodos para barajar, repartir cartas y reiniciar la baraja.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class Baraja {
    private List<Carta> cartas;

    /**
     * Constructor que inicializa la baraja con las cartas estándar de Blackjack.
     * Baraja las cartas al final de la construcción.
     */
    public Baraja() {
        this.cartas = new ArrayList<>();
        String[] simbolos = {"♠", "♥", "♦", "♣"};
        
        // Añade cartas numeradas (1-9) a la baraja
        for (int i = 1; i <= 9; i++) {
            for (String simbolo : simbolos) {
                cartas.add(new Carta(String.valueOf(i), i, simbolo));
            }
        }
        
        // Añade las cartas de figuras y ases a la baraja
        for (String simbolo : simbolos) {
            cartas.add(new Carta("J", 10, simbolo));
            cartas.add(new Carta("Q", 10, simbolo));
            cartas.add(new Carta("K", 10, simbolo));
            cartas.add(new Carta("A", 1, simbolo));
        }
        barajar();
    }

    /**
     * Baraja las cartas en la baraja usando un generador de números aleatorios.
     */
    public void barajar() {
        Collections.shuffle(cartas, new Random());
    }

    /**
     * Reparte una carta de la baraja.
     * 
     * @return La carta repartida.
     */
    public Carta repartirCarta() {
        return cartas.remove(cartas.size() - 1);
    }

    /**
     * Reinicia la baraja, creando un nuevo conjunto de cartas y barajándolas.
     */
    public void reset() {
        cartas.clear();
        String[] simbolos = {"♠", "♥", "♦", "♣"};
        
        // Añade cartas numeradas (1-9) a la baraja
        for (int i = 1; i <= 9; i++) {
            for (String simbolo : simbolos) {
                cartas.add(new Carta(String.valueOf(i), i, simbolo));
            }
        }
        
        // Añade las cartas de figuras y ases a la baraja
        for (String simbolo : simbolos) {
            cartas.add(new Carta("J", 10, simbolo));
            cartas.add(new Carta("Q", 10, simbolo));
            cartas.add(new Carta("K", 10, simbolo));
            cartas.add(new Carta("A", 1, simbolo));
        }
        barajar();
    }

    /**
     * Obtiene la lista de cartas en la baraja.
     * 
     * @return La lista de cartas en la baraja.
     */
    public List<Carta> getCartas() {
        return this.cartas;
    }

    /**
     * Establece una nueva lista de cartas para la baraja.
     * 
     * @param cartas La nueva lista de cartas.
     */
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
