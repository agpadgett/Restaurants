import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RestaurantsVisitedIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Restaurants List!");
  }

  @Test
  public void titleTest() {
  goTo("http://localhost:4567/");
  assertThat(title()).contains("Restaurants");
  }

  @Test
  public void successsPage() {
  goTo("http://localhost:4567/");
  fill("#name").with("Burger King");
  fill("#dateVisited").with("12/12/1212");
  submit(".btn");
  assertThat(pageSource()).contains("Success");
  }

  @Test
  public void rememberPreviousEntries() {
  goTo("http://localhost:4567/");
  fill("#name").with("Burger King");
  fill("#dateVisited").with("12/12/1212");
  submit(".btn");
  find("a", withText("Go Back")).click();
  assertThat(pageSource()).contains("Burger King on 12/12/1212");
  }

  @Test
  public void rememberPreviousEntries2() {
  goTo("http://localhost:4567/");
  fill("#name").with("Burger King");
  fill("#dateVisited").with("12/12/1212");
  submit(".btn");
  find("a", withText("Go Back")).click();
  fill("#name").with("Mc Donalds");
  fill("#dateVisited").with("12/12/1212");
  submit(".btn");
  find("a", withText("Go Back")).click();
  assertThat(pageSource()).contains("Mc Donalds on 12/12/1212");
  }
}
