package opdr1b;

/**
 * Klasse verantwoordelijk voor het berekenen van de postfixexpressie t.b.v
 * opdracht 1 CPP Java Datastructuren, algoritmen en het Java Collections Framework
 * 
 * @author Steven Minken
 *
 */
public class PostfixExpressieKlasse {

  /**
   * Verantwoordelijk voor het berekenen van de waarde van de postfix expressie
   * 
   * @param expressie
   *          de opgegeven expressie
   * @return String de waarde van de expressie
   * @throws StackFullException
   *           wanneer de array vol is
   * @throws NumberFormatException
   *           wanneer de cijfers niet naar int geconverteert kunnen worden
   * @throws EmptyStackException
   *           wanneer de Stack leeg is
   * @throws PostfixExpressieException
   *           wanneer er problemen zijn met de expressie
   */
  public static String waardeBerekening(String expressie)
      throws StackFullException, EmptyStackException,
      PostfixExpressieException {

    if (expressie.equals("")) {
      throw new PostfixExpressieException("Het expressieveld is nog leeg.");
    }

    ArrayStack<Integer> getalStack = new ArrayStack<>();
    TokenLezer tokenlezer = new TokenLezer(expressie);

    Token token = tokenlezer.volgendeToken();
    try {
      while (token != null) {

        if (token.getType() == 0) {
          getalStack.push(Integer.parseInt(token.getInhoud()));
        }
        else {
          
          int operator = token.getType();
          
          if (operator == 5)  {
          throw new PostfixExpressieException(
              "Gebruik uitsluitend nummers, +, -, / of *");
          }
          int operandEen;
          int operandTwee;
          
          if (getalStack.size() >= 2)  {
            operandTwee = getalStack.pop();
            operandEen = getalStack.pop();
          } else  {
            throw new PostfixExpressieException("Het aantal operatoren of operanden in niet juist");
          }
          
          if (operator == 1) {
            getalStack
                .push(operandEen + operandTwee);
          }
          else if (operator == 2) {
            getalStack
                .push(operandEen - operandTwee);
          }
          else if (operator == 3) {
            getalStack
                .push(operandEen * operandTwee);
          }
          else if (operator == 4) {
            getalStack
                .push(operandEen / operandTwee);
          }
        }
        token = tokenlezer.volgendeToken();
      }
      
      if(getalStack.size() == 1)  {
        return getalStack.pop().toString();
      }  else  {
        throw new PostfixExpressieException("Het aantal operatoren of operanden in niet juist");
      }
    }
    
    catch (StackFullException e) {
      throw new StackFullException(
          "Er is een fout opgetreden: " + e.getMessage());
    }
    catch (NumberFormatException e) {
      throw new PostfixExpressieException(
          "Er was een fout bij het converteren van de cijfers");
    }
    catch (EmptyStackException e) {
      throw new EmptyStackException("Er is een fout opgetreden: " + e.getMessage());
    }
  }
}

