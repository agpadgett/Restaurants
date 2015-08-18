import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;
import java.util.*;
import java.text.*;

public class RestaurantsVisited {
  public static void main(String[] args) {

  }

  private String mName;
  private SimpleDateFormat mVisited;

  public RestaurantsVisited( String name, SimpleDateFormat visited) {
    mName = name;
    mVisited = visited;
  }

  public String getName(){
    return mName;
  }

  public String getDate(){
    Date date = new Date();
    String stringVisited = mVisited.format(date);
    return stringVisited;
  }

}
