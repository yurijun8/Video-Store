import java.util.Enumeration;

public class TextStatement extends Statement {
  private String getInitialText(Customer aCustomer) {
    return "Rental Record for " + aCustomer.getName() +
        "\n";
  }
  
   private String getMovieTitleString(Rental rental) {
    return "\t" + rental.getMovie().getTitle() + "\t" +
        String.valueOf(rental.getCharge()) + "\n";
  }

  private String getFooterLines(Customer aCustomer) {
    String result = "";
    // add footer lines
    result += "Amount owed is " +
        String.valueOf(aCustomer.getTotalCharge()) + "\n";
    result += "You earned " +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        " frequent renter points";
    return result;
  }

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = getInitialText(aCustomer);
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      // show figures for each rental
      result += getMovieTitleString(each);
    }
    // add footer lines
    result += getFooterLines(aCustomer);
    return result;
  }
}