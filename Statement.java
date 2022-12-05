import java.util.Enumeration;

public abstract class Statement {
  abstract String getInitialText(Customer aCustomer);

  abstract String getMovieTitleString(Rental rental);

  abstract String getFooterLines(Customer aCustomer);

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