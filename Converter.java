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
  private Map <String[],BigDecimal> association = new HashMap<String[], BigDecimal>();
  private Pattern p = Pattern.compile("^[0-9]*\\ [a-zA-Z]*$");
  public Converter(){
    this.init();
  }

  public void init(){
    this.association.put(new String[]{"inches","inch","in","m"}, Values.inch);
    this.association.put(new String[]{"foot","feet","ft","m"}, Values.foot);
    this.association.put(new String[]{"yard","yards","yd","m"}, Values.yard);
    this.association.put(new String[]{"thou","mil","th","m"}, Values.thou);
    this.association.put(new String[]{"chain","chains","ch","m"}, Values.chain);
    this.association.put(new String[]{"furlong","m"}, Values.furlong);
    this.association.put(new String[]{"mile","miles","m"}, Values.mile);
    this.association.put(new String[]{"league","leagues","m"}, Values.league);
    this.association.put(new String[]{"fathom","fathoms", "ftm","m"}, Values.fathom);
    this.association.put(new String[]{"cable","cables","m"}, Values.cable);
    this.association.put(new String[]{"nauticalmile","nauticalmiles","nautical miles", "nautical mile","m"}, Values.nauticalmile);
    this.association.put(new String[]{"link","links","m"}, Values.link);
    this.association.put(new String[]{"rod","rods","m"}, Values.rod);
    this.association.put(new String[]{"perch","pole","square rod", "square rods", "square perch", "poles", "square pole", "square poles","m²"}, Values.perch);
    this.association.put(new String[]{"rood", "roods","m²"}, Values.rood);
    this.association.put(new String[]{"acre","acres","m²"}, Values.acre);
    this.association.put(new String[]{"floz","fl oz","fluid ounce", "fluid ounces","m³"}, Values.floz);
    this.association.put(new String[]{"gill","gi","teacup", "tea cup","gills", "teacups", "tea cups","m³"}, Values.gill);
    this.association.put(new String[]{"pint","pt", "pints","m³"}, Values.pint);
    this.association.put(new String[]{"quart","qt","quarts","m³"}, Values.quart);
    this.association.put(new String[]{"gallon","gal", "gallons","m³"}, Values.gallon);
    this.association.put(new String[]{"grain","gr","grains", "kg"}, Values.grain);
    this.association.put(new String[]{"drachm","dr","dram","drams", "drachms", "kg"}, Values.drachm);
    this.association.put(new String[]{"oz","ounce","ounces", "kg"}, Values.oz);
    this.association.put(new String[]{"pound","lb","lbs", "pounds", "kg"}, Values.pound);
    this.association.put(new String[]{"stone","stones","st", "kg"}, Values.stone);
    this.association.put(new String[]{"quarter","qr","qtr","quarters", "kg"}, Values.quarter);
    this.association.put(new String[]{"hundredweight","hundred weight","hundredweights", "hundred weights", "cwt", "kg"}, Values.hundredweight);
    this.association.put(new String[]{"ton","tons","t", "kg"}, Values.ton);
  }

  public String reader(String valeur) throws FormatSaisieException{
      String[] valeurs = valeur.split("\\ ");
      Matcher m = this.p.matcher(valeur);
      if(valeurs.length != 2 || !m.matches()){
        throw new FormatSaisieException();
      }
      else{
        double val = Double.parseDouble(valeurs[0]);
        String key = new String(valeurs[1]);
        BigDecimal convertion = this.convert(val, getval(key));
        int puissance = 0;
        while (convertion.compareTo(new BigDecimal(1000)) > 0){
          puissance+=3;
          convertion = convertion.divide(new BigDecimal(1000));
        }
        convertion = convertion.setScale(10,BigDecimal.ROUND_UP);
        return (valeur + " = " + convertion.toString() + "x10^"+ puissance +"\t" +this.getNewUnit(key));
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

  public String getNewUnit(String clay){
    Set<Entry<String[], BigDecimal>> setAssoc = this.association.entrySet();
    Iterator<Entry<String[], BigDecimal>> it = setAssoc.iterator();
    while(it.hasNext()){
      Entry<String[], BigDecimal> entry = it.next();
      for(int i = 0; i < entry.getKey().length-1; i++){
        if(entry.getKey()[i].equals(clay)){
          return entry.getKey()[entry.getKey().length-1];
        }
      }
    }
    return "unit wrong wallah";
  }

  public BigDecimal getval(String clay) {
    clay = clay.trim();
    clay = clay.toLowerCase();
    Set<Entry<String[], BigDecimal>> setAssoc = this.association.entrySet();
    Iterator<Entry<String[], BigDecimal>> it = setAssoc.iterator();
    while(it.hasNext()){
      Entry<String[], BigDecimal> entry = it.next();
      for(int i = 0; i < entry.getKey().length-1; i++){
        if(entry.getKey()[i].equals(clay)){
          return entry.getValue();
        }
      }
    }
    return new BigDecimal(0);
  }

}
