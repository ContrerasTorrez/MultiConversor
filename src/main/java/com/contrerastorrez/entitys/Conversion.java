package com.contrerastorrez.entitys;

public class Conversion {
   public static final String [] TIPOS = {"MONEDAS","TEMPERATURA","LONGITUDES"};
   public static final String [] MONEDAS = {"DOP","USD","EUR","JPY","KRW"};
   public static final String [] TEMPERATURA = {"°C","°F","K"};
   public static final String [] LONGITUDES = {"CM","KM","FT","LEGUA"};


   double measureFrom;
   double measureTo;
   String type;
   double value;

   public double getMeasureFrom() {
      return measureFrom;
   }

   public void setMeasureFrom(double measureFrom) {
      this.measureFrom = measureFrom;
   }

   public double getMeasureTo() {
      return measureTo;
   }

   public void setMeasureTo(double measureTo) {
      this.measureTo = measureTo;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public double getValue() {
      return value;
   }

   public void setValue(double value) {
      this.value = value;
   }
}
