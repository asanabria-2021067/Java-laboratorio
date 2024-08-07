import java.util.List;

/**
 * Clase que maneja la lógica del juego de Blackjack, 
 * coordinando la interacción entre el jugador, el dealer y la vista.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class JuegoControlador {
    private Jugador jugador;
    private Dealer dealer;
    private Baraja baraja;
    private JuegoVista vista;
    private int partidasTotales;

    /**
     * Constructor que inicializa el controlador del juego con el nombre del jugador.
     * 
     * @param nombreJugador El nombre del jugador.
     */
    public JuegoControlador(String nombreJugador) {
        this.jugador = new Jugador(nombreJugador);
        this.dealer = new Dealer();
        this.baraja = new Baraja();
        this.vista = new JuegoVista();
        this.partidasTotales = 0;
    }

    /**
     * Inicia el ciclo principal del juego, permitiendo jugar múltiples partidas
     * hasta que el jugador decida no continuar.
     */
    public void iniciarJuego() {
        boolean jugarOtraVez = true;
        while (jugarOtraVez) {
            System.out.println("----------------------------------------------------------------");
            vista.mostrarMensaje("Bienvenido al Blackjack, " + jugador.getNombre() + "!");
            repartirCartasIniciales();
            turnoJugador();
            turnoDealer();
            determinarGanador();
            partidasTotales++;
            mostrarMarcador();
            vista.mostrarManosFinales(jugador.getMano().getCartas(), dealer.getMano().getCartas());

            vista.mostrarMensaje("¿Quieres jugar de nuevo? (Si/No)");
            String respuesta = vista.obtenerEntradaUsuario();
            if (!respuesta.equalsIgnoreCase("Si")) {
                jugarOtraVez = false;
            } else {
                System.out.println("Gracias por jugar!!");
            }

            resetJuego();
        }
    }

    /**
     * Reparte las cartas iniciales al jugador y al dealer, y las muestra en la vista.
     */
    private void repartirCartasIniciales() {
        jugador.pedirCarta(baraja.repartirCarta());
        dealer.pedirCarta(baraja.repartirCarta());
        jugador.pedirCarta(baraja.repartirCarta());
        dealer.pedirCarta(baraja.repartirCarta());

        vista.mostrarCartasJugador(jugador.getMano().getCartas());
        vista.mostrarCartasDealer(dealer.getMano().getCartas(), false);
    }

    /**
     * Maneja el turno del jugador, permitiéndole pedir cartas hasta que decida detenerse
     * o supere los 21 puntos.
     */
    private void turnoJugador() {
        boolean continuar = true;
        while (continuar && jugador.getMano().calcularValor() < 21) {
            vista.mostrarMensaje("¿Quieres pedir otra carta? (Si/No)");
            String respuesta = vista.obtenerEntradaUsuario();
            System.out.println("---------------------------------------------------------------");
            if (respuesta.equalsIgnoreCase("Si")) {
                jugador.pedirCarta(baraja.repartirCarta());
                vista.mostrarCartasJugador(jugador.getMano().getCartas());
            } else {
                continuar = false;
            }
        }
    }

    /**
     * Maneja el turno del dealer, pidiendo cartas hasta que su valor total sea al menos 17.
     */
    private void turnoDealer() {
        vista.mostrarCartasDealer(dealer.getMano().getCartas(), true);
        while (dealer.getMano().calcularValor() < 17) {
            dealer.pedirCarta(baraja.repartirCarta());
            vista.mostrarCartasDealer(dealer.getMano().getCartas(), true);
        }
    }

    /**
     * Determina el ganador de la partida y actualiza el marcador.
     */
    private void determinarGanador() {
        int valorJugador = jugador.getMano().calcularValor();
        int valorDealer = dealer.getMano().calcularValor();

        if (valorJugador > 21) {
            vista.mostrarResultado("El jugador se pasó. Dealer gana.");
        } else if (valorDealer > 21) {
            vista.mostrarResultado("Dealer se pasó. El jugador gana.");
            jugador.incrementarPartidasGanadas();
        } else if (valorJugador > valorDealer) {
            vista.mostrarResultado("El jugador gana.");
            jugador.incrementarPartidasGanadas();
        } else if (valorDealer > valorJugador) {
            vista.mostrarResultado("Dealer gana.");
        } else {
            vista.mostrarResultado("Es un empate.");
        }
    }

    /**
     * Muestra el marcador actualizado en la vista.
     */
    private void mostrarMarcador() {
        vista.mostrarMarcador(jugador.getPartidasGanadas(), partidasTotales);
    }

    /**
     * Resetea el estado del juego para una nueva partida.
     */
    private void resetJuego() {
        jugador.resetMano();
        dealer.resetMano();
        baraja.reset();
    }

    /**
     * Obtiene el jugador.
     * 
     * @return El jugador.
     */
    public Jugador getJugador() {
        return this.jugador;
    }

    /**
     * Establece el jugador.
     * 
     * @param jugador El jugador.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Obtiene el dealer.
     * 
     * @return El dealer.
     */
    public Dealer getDealer() {
        return this.dealer;
    }

    /**
     * Establece el dealer.
     * 
     * @param dealer El dealer.
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /**
     * Obtiene la baraja.
     * 
     * @return La baraja.
     */
    public Baraja getBaraja() {
        return this.baraja;
    }

    /**
     * Establece la baraja.
     * 
     * @param baraja La baraja.
     */
    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    /**
     * Obtiene la vista.
     * 
     * @return La vista.
     */
    public JuegoVista getVista() {
        return this.vista;
    }

    /**
     * Establece la vista.
     * 
     * @param vista La vista.
     */
    public void setVista(JuegoVista vista) {
        this.vista = vista;
    }

    /**
     * Obtiene el número total de partidas jugadas.
     * 
     * @return El número total de partidas jugadas.
     */
    public int getPartidasTotales() {
        return this.partidasTotales;
    }

    /**
     * Establece el número total de partidas jugadas.
     * 
     * @param partidasTotales El número total de partidas jugadas.
     */
    public void setPartidasTotales(int partidasTotales) {
        this.partidasTotales = partidasTotales;
    }
}
