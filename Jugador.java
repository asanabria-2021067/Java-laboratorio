/**
 * Clase que representa a un jugador en el juego de Blackjack.
 * Incluye atributos para el nombre del jugador, su mano de cartas y el
 * número de partidas ganadas. Proporciona métodos para gestionar cartas
 * en la mano, incrementar el número de partidas ganadas y otras operaciones
 * relacionadas con el jugador.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    private int partidasGanadas;

    /**
     * Constructor que inicializa un nuevo jugador con un nombre dado.
     * 
     * @param nombre El nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new Mano();
        this.partidasGanadas = 0;
    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la mano de cartas del jugador.
     * 
     * @return La mano del jugador.
     */
    public Mano getMano() {
        return mano;
    }

    /**
     * Agrega una carta a la mano del jugador.
     * 
     * @param carta La carta a agregar.
     */
    public void pedirCarta(Carta carta) {
        mano.agregarCarta(carta);
    }

    /**
     * Incrementa el número de partidas ganadas por el jugador en 1.
     */
    public void incrementarPartidasGanadas() {
        partidasGanadas++;
    }

    /**
     * Obtiene el número de partidas ganadas por el jugador.
     * 
     * @return El número de partidas ganadas.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Reinicia la mano del jugador, eliminando todas las cartas.
     */
    public void resetMano() {
        mano.reset();
    }

    /**
     * Establece el nombre del jugador.
     * 
     * @param nombre El nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece una nueva mano para el jugador.
     * 
     * @param mano La nueva mano del jugador.
     */
    public void setMano(Mano mano) {
        this.mano = mano;
    }

    /**
     * Establece el número de partidas ganadas por el jugador.
     * 
     * @param partidasGanadas El nuevo número de partidas ganadas.
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }
}
