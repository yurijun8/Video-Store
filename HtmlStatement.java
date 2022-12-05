import java.util.Enumeration;

public class HtmlStatement extends Statement {
  
  private String getInitialText(Customer aCustomer) {
    return "<H1>Rentals for <EM>" + aCustomer.getName() +
        "</EM></H1><P>\n";
  }

  private String getMovieTitleString(Rental rental) {
    return rental.getMovie().getTitle() + ": " +
        String.valueOf(rental.getCharge()) + "<BR>\n";
  }

  private String getFooterLines(Customer aCustomer) {
    String result = "";
    result += "<P>You owe <EM>" +
        String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        "</EM> frequent renter points<P>";
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