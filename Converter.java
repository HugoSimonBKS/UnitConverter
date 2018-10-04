import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.math.BigDecimal;
import java.io.*;
import java.util.regex.*;
public class Converter{
  private Pattern pattern = Pattern.compile("^[0-9]*.?[0-9]*[a-zA-Z]*$");
  private Matcher matcher;
  private Map <String[],BigDecimal> association = new HashMap<String[], BigDecimal>();

  public Converter(){
    this.init();
  }

  public void init(){
    this.association.put(new String[]{"inches","inch","in"}, Values.inch);
    this.association.put(new String[]{"foot","feet","ft"}, Values.foot);
    this.association.put(new String[]{"yard","yards","yd"}, Values.yard);
    this.association.put(new String[]{"thou","mil","th"}, Values.thou);
    this.association.put(new String[]{"chain","chains","ch"}, Values.chain);
    this.association.put(new String[]{"furlong"}, Values.furlong);
    this.association.put(new String[]{"mile","miles"}, Values.mile);
    this.association.put(new String[]{"league","leagues"}, Values.league);
    this.association.put(new String[]{"fathom","fathoms", "ftm"}, Values.fathom);
    this.association.put(new String[]{"cable","cables"}, Values.cable);
    this.association.put(new String[]{"nauticalmile","nauticalmiles","nautical miles", "nautical mile"}, Values.nauticalmile);
    this.association.put(new String[]{"link","links"}, Values.link);
    this.association.put(new String[]{"inches","inch","in"}, Values.inch);
    this.association.put(new String[]{"rod","rods"}, Values.rod);
    this.association.put(new String[]{"perch","pole","square rod", "square rods", "square perch", "poles", "square pole", "square poles"}, Values.perch);
    this.association.put(new String[]{"rood", "roods"}, Values.rood);
    this.association.put(new String[]{"acre","acres"}, Values.acre);
    this.association.put(new String[]{"floz","fl oz","fluid ounce", "fluid ounces"}, Values.floz);
    this.association.put(new String[]{"gill","gi","teacup", "tea cup","gills", "teacups", "tea cups"}, Values.gill);
    this.association.put(new String[]{"pint","pt", "pints"}, Values.pint);
    this.association.put(new String[]{"quart","qt","quarts"}, Values.quart);
    this.association.put(new String[]{"gallon","gal", "gallons"}, Values.gallon);
    this.association.put(new String[]{"grain","gr","grains"}, Values.grain);
    this.association.put(new String[]{"drachm","dr","dram","drams", "drachms"}, Values.drachm);
    this.association.put(new String[]{"oz","ounce","ounces"}, Values.oz);
    this.association.put(new String[]{"pound","lb","lbs", "pounds"}, Values.pound);
    this.association.put(new String[]{"stone","stones","st"}, Values.stone);
    this.association.put(new String[]{"quarter","qr","qtr","quarters"}, Values.quarter);
    this.association.put(new String[]{"hundredweight","hundred weight","hundredweights", "hundred weights", "cwt"}, Values.hundredweight);
    this.association.put(new String[]{"ton","tons","t"}, Values.ton);
//    System.out.println(this.getval("lb"));
    /*Set<Entry<String[], BigDecimal>> setAssoc = this.association.entrySet();
    Iterator<Entry<String[], BigDecimal>> it = setAssoc.iterator();
    while(it.hasNext()){
      Entry<String[], BigDecimal> e = it.next();
      System.out.println(e.getKey()[0] + "\t\t\t : \t\t" + e.getValue());
    }*/
  }

  public boolean reader(String valeur){
    System.out.println(valeur);
    this.matcher = this.pattern.matcher(valeur);
    if(!matcher.matches()) {
      System.out.println("ca passe pas");
      return false;01
    }
    else{
      String[] valeurs = valeur.split(".");
      for(int i = 0; i < 2; i++){
        System.out.println("val = " + valeurs[i]);
      }
      double val = Double.parseDouble(valeurs[0]);
      String key = new String(valeurs[1]);
      System.out.println(this.convert(val, getval(key)));
      return true;
    }

  }

  public BigDecimal convert(double val, BigDecimal ratio){
    if(ratio != new BigDecimal(0)){
      return (ratio.multiply(new BigDecimal(val)));
    }
    else {
      System.out.println("erreur unite inconnue");
      return new BigDecimal(0);
    }
  }

  public BigDecimal getval(String key) {
    Set<Entry<String[], BigDecimal>> setAssoc = this.association.entrySet();
    Iterator<Ent01ry<String[], BigDecimal>> it = setAssoc.iterator();
    while(it.hasNext()){
      Entry<String[], BigDecimal> entry = it.next();
      for(int i = 0; i < entry.getKey().length; i++){
        if (entry.getKey()[i] == key)
          return entry.getValue();
      }
    }
    return new BigDecimal(0);
  }

}
