import java.math.BigDecimal;

public final class Values{

  /**
  *  Metric units (in m)
  */

  public static final BigDecimal inch = new BigDecimal(0.0254);
  public static final BigDecimal foot = new BigDecimal(0.3048);
  public static final BigDecimal yard = new BigDecimal(0.9144);
  public static final BigDecimal thou = new BigDecimal(0.0000254);
  public static final BigDecimal chain = new BigDecimal(20.1168);
  public static final BigDecimal furlong = new BigDecimal(201.168);
  public static final BigDecimal mile = new BigDecimal(1609.344);
  public static final BigDecimal league = new BigDecimal(4828.032);
  public static final BigDecimal fathom = new BigDecimal(1.852);
  public static final BigDecimal cable = new BigDecimal(185.2);
  public static final BigDecimal nauticalmile = new BigDecimal(1852);
  public static final BigDecimal link = new BigDecimal(0.201168);
  public static final BigDecimal rod = new BigDecimal(5.0292);

  /**
  *   Metric area units (in m²)
  */

  public static final BigDecimal perch = new BigDecimal(5.0292*5.0292);
  public static final BigDecimal rood = new BigDecimal(5.0292*201.168);
  public static final BigDecimal acre = new BigDecimal(201.168*20.1168);

  /**
  *   Volume units (in dm³)
  */

  public static final BigDecimal floz = new BigDecimal(0.0000284130625);
  public static final BigDecimal gill = new BigDecimal(0.0001420653125);
  public static final BigDecimal pint = new BigDecimal(0.00056826125);
  public static final BigDecimal quart = new BigDecimal(0.0011365225);
  public static final BigDecimal gallon = new BigDecimal(0.00454609);

  /**
  *   Mass units (in kg)
  */

  public static final BigDecimal grain = new BigDecimal(0.00006479891);
  public static final BigDecimal drachm = new BigDecimal(0.0017718451953125);
  public static final BigDecimal oz = new BigDecimal(0.028349523125);
  public static final BigDecimal pound = new BigDecimal(0.45359237);
  public static final BigDecimal stone = new BigDecimal(6.35029318);
  public static final BigDecimal quarter = new BigDecimal(12.70058636);
  public static final BigDecimal hundredweight = new BigDecimal(50.80234544);
  public static final BigDecimal ton = new BigDecimal(1016.0469088);
}
