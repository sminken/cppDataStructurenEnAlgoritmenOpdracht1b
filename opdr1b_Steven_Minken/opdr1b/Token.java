package opdr1b;

/**
 * Een token is een 'woord' uit een computerprogramma.
 * Voorbeelden van dergelijke woorden uit de taal Java zijn "public", "if",
 * "9827", "+", "==", "{", ")".
 * Een instantie van Token heeft een type en een inhoud. Deze klasse kent zes
 * typen, één voor Getal, één voor elk van de operetoren, en één voor alle
 * andere symbolen (type is onbekend, voor het geval er een onbekend symbool
 * in de expressie staat).
 */

public class Token {
  /**
   * Constante voor een getal
   */
  public static final int GETAL = 0;

  /**
   * Constante voor operator +
   */
  public static final int PLUS = 1;

    /**
     * Constante voor operator -
     */
  public static final int MIN = 2;

    /**
     * Constante voor operator *
     */
  public static final int MAAL = 3;

    /**
     * Constante voor operator /
     */
  public static final int DELING = 4;

    /**
     * Constante voor een gelezen symbool dat geen getal, operator of spatie is.
     */
  public static final int ONBEKEND = 5;

  private int type;
  private String inhoud;

  /**
   * Maak een nieuw Token
   * @param type het type van het token
   * @param de inhoud van het token als String
   */
  public Token(int type, String inhoud)
  {
    this.type = type;
    this.inhoud = inhoud;
  }

  /**
   * Geeft het type van het token
   */
  public int getType(){
    return type;
  }

  /**
   * Geeft de inhoud van het token als String, bv. “87” als type = GETAL;
   * “+” als type is PLUS.
   */
  public String getInhoud(){
    return inhoud;
  }
}