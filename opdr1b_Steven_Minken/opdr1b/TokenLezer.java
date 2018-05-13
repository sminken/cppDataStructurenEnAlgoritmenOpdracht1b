package opdr1b;

import java.io.*;

/**
 * Deze klasse splitst een string bestaande uit de operatoren +, -, *, /,
 * positieve gehele getallen en spaties in tokens.
 */

public class TokenLezer {

  private StreamTokenizer tokenlezer;  // de te analyseren expressie

  /**
   * Maak een nieuwe tokenlezer
   * @param expressie de te analyseren expressie; de tokenlezer begint vooraan.
   */
  public TokenLezer(String expressie){
    tokenlezer = new StreamTokenizer(new StringReader(expressie));
    tokenlezer.ordinaryChar('-');
    tokenlezer.ordinaryChar('/');
  }

  /**
   * Leest het volgende token uit de expressie en geeft dit terug.
   * Er worden vijf soorten token herkend, namelijk vier operatoren (+,-,*,/)
   * en (positieve, gehele) getallen. Een onbekend symbool lever een token
   * met type ONBEKEND
   * @return het volgende betekenisvolle token in de te analyseren expressie,
   *         of null als de expressie geheel geanalyseerd is.
   */
  public Token volgendeToken(){
    try {
      tokenlezer.nextToken();
      if (tokenlezer.ttype == StreamTokenizer.TT_EOF)
        return null;
      else if (tokenlezer.ttype == StreamTokenizer.TT_NUMBER) {
        return new Token(Token.GETAL, (int) tokenlezer.nval + "");
      }
      else {
        char op = (char) tokenlezer.ttype;
        switch (op) {
          case '+':
            return new Token(Token.PLUS, "+");
          case '-':
            return new Token(Token.MIN, "-");
          case '*':
            return new Token(Token.MAAL, "*");
          case '/':
            return new Token(Token.DELING, "/");
          default:
            return new Token(Token.ONBEKEND, op + "");
        }
      }
    } catch (IOException ex){
       return null;
    }
  }



}