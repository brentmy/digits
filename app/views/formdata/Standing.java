package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Hey.
 * @author Brent
 *
 */
public class Standing {
  private static String[] types = {"Freshmen", "Sophomore", "Junior", "Senior", "N/A"};
  
  /**
   * 
   * @return typeMap abc.
   */
  public static Map<String, Boolean> types() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * 
   * @return telephoneType asc.
   */
  public static Map<String, Boolean> getTypes(String standing) {
    Map<String, Boolean> typeMap = Standing.types();
    if (isType(standing)){
    typeMap.put(standing, true);
    }
    return typeMap;
  }
  
  /**
   * true if valid type.
   * @param telType asd.
   * @return boolean.
   */
  public static boolean isType(String standing) {
    return Standing.types().keySet().contains(standing);
  }
    


}
