import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;
import java.util.ArrayList;
// import java.text.*;

public class RestaurantsVisited {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("restaurantsFinalList", request.session().attribute("sessionRest"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/restaurant", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<RestaurantsVisited> restaurantsArray = request.session().attribute("sessionRest");

      if ( restaurantsArray == null) {
        restaurantsArray = new ArrayList<RestaurantsVisited>();
        request.session().attribute("sessionRest", restaurantsArray);
      }

      String name = request.queryParams("name");
      String dateVisited = request.queryParams("dateVisited");
      RestaurantsVisited newRestaurant = new RestaurantsVisited(name, dateVisited);
      restaurantsArray.add(newRestaurant);
      //System.out.println(dateVisited);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }

  private String mName;
  private String mVisited;

  public RestaurantsVisited( String name, String visited) {
    mName = name;
    mVisited = visited;
  }

  public String getName(){
    return mName;
  }

  public String getDate(){
  //  Date date = new Date();
  //  String stringVisited = mVisited.format(date);
    //return stringVisited;
    return mVisited;
  }

}
