/**
 * Clase que representa al dealer en el juego de Blackjack.
 * Incluye una mano de cartas para el dealer y proporciona métodos
 * para gestionar las cartas en la mano del dealer.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class Dealer {
    private Mano mano;

    /**
     * Constructor que inicializa un nuevo dealer con una mano vacía.
     */
    public Dealer() {
        this.mano = new Mano();
    }

    /**
     * Obtiene la mano de cartas del dealer.
     * 
     * @return La mano del dealer.
     */
    public Mano getMano() {
        return mano;
    }

    /**
     * Agrega una carta a la mano del dealer.
     * 
     * @param carta La carta a agregar.
     */
    public void pedirCarta(Carta carta) {
        mano.agregarCarta(carta);
    }

    /**
     * Reinicia la mano del dealer, eliminando todas las cartas.
     */
    public void resetMano() {
        mano.reset();
    }

    /**
     * Establece una nueva mano para el dealer.
     * 
     * @param mano La nueva mano del dealer.
     */
    public void setMano(Mano mano) {
        this.mano = mano;
    }
}
