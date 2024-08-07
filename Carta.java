/**
 * Clase que representa una carta en el juego de Blackjack.
 * Incluye atributos para el nombre, valor y símbolo de la carta.
 * 
 * @author ANGEL SANABRIA
 * @version 1.0
 * @since 2024-08-07
 */
public class Carta {
    private String nombre;
    private int valor;
    private String simbolo;

    /**
     * Constructor que inicializa una carta con su nombre, valor y símbolo.
     * 
     * @param nombre El nombre de la carta (ej. "As", "Reina").
     * @param valor El valor numérico de la carta.
     * @param simbolo El símbolo de la carta (ej. "♠", "♥").
     */
    public Carta(String nombre, int valor, String simbolo) {
        this.nombre = nombre;
        this.valor = valor;
        this.simbolo = convertirSimbolo(simbolo);
    }

    /**
     * Convierte el símbolo de la carta a su representación textual.
     * 
     * @param simbolo El símbolo de la carta.
     * @return La representación textual del símbolo.
     */
    private String convertirSimbolo(String simbolo) {
        switch (simbolo) {
            case "♠": return " (Picas)";
            case "♥": return " (Corazones)";
            case "♦": return " (Diamantes)";
            case "♣": return " (Tréboles)";
            default: return simbolo;
        }
    }

    /**
     * Obtiene el valor de la carta.
     * 
     * @return El valor de la carta.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene el nombre de la carta.
     * 
     * @return El nombre de la carta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el símbolo de la carta en su representación textual.
     * 
     * @return El símbolo de la carta.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Establece el nombre de la carta.
     * 
     * @param nombre El nuevo nombre de la carta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el valor de la carta.
     * 
     * @param valor El nuevo valor de la carta.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Establece el símbolo de la carta.
     * 
     * @param simbolo El nuevo símbolo de la carta.
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Devuelve una representación en cadena de la carta.
     * 
     * @return Una cadena que representa la carta (nombre, símbolo y valor).
     */
    @Override
    public String toString() {
        return nombre + simbolo + " - Valor: " + valor;
    }
    
    /**
     * Devuelve una representación completa de la carta con su nombre, símbolo y valor.
     * 
     * @return Una cadena que representa la carta (nombre, símbolo y valor).
     */
    public String getRepresentacionCompleta() {
        return nombre + simbolo + " (Valor: " + valor + ")";
    }
}
