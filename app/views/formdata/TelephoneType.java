package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Hey.
 * @author Brent
 *
 */
public class TelephoneType {
  private static String[] types = {"Home", "Work", "Mobile"};
  
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
   * @param telephoneType s.
   * @return telephoneType asc.
   */
  public static Map<String, Boolean> getTypes(String telephoneType) {
    Map<String, Boolean> typeMap = TelephoneType.types();
    if (isType(telephoneType)) {
    typeMap.put(telephoneType, true);
    }
    return typeMap;
  }
  
  /**
   * true if valid type.
   * @param telType asd.
   * @return boolean.
   */
  public static boolean isType(String telType) {
    return TelephoneType.types().keySet().contains(telType);
  }
    


}
