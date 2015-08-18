import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.text.*;

public class RestaurantsVisitedUnitTest {

  @Test
  public void restaurantsVisited_instantiatesCorrectly_true() {
    SimpleDateFormat date = new SimpleDateFormat("2012-12-05");
    RestaurantsVisited myRestaurants = new RestaurantsVisited("McDonalds", date);
    assertEquals(true, myRestaurants instanceof RestaurantsVisited);
  }

  @Test
  public void restaurantsVisited_instantiatsWithDescriptionName_true() {
    SimpleDateFormat date = new SimpleDateFormat("2012-12-05");
    RestaurantsVisited myRestaurants = new RestaurantsVisited("McDonalds", date);
    assertEquals("McDonalds", myRestaurants.getName());
  }

  @Test
  public void restaurantsVisited_instantiatsWithDescriptionDate_true() {
    SimpleDateFormat date = new SimpleDateFormat("2012-12-05");
    RestaurantsVisited myRestaurants = new RestaurantsVisited("McDonalds", date);
    assertEquals("2012-12-05", myRestaurants.getDate());
  }

}
