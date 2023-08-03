package com.contrerastorrez.entitys;

public class Temperatura {
    public static final String [] TEMPERATURA = {"C","F","K"};
    public double convertFahrenheit(String to,double value){
            double result = 0;
            if(to.equals("C"))
                result = (value - 32) * 5/9;
            else if(to.equals("K"))
                result = (value - 32) * 5/9 + 273.15;
            return result;
        }

    public double convertCelsius(String to,double value){
            double result = 0;
            if(to.equals("F"))
                result =  (value * 9/5) + 32;
            else if(to.equals("K"))
                result = value + 273.15;
            return result;
        }

    public double convertKelvin (String to, double value) {
            double result = 0;
            if (to.equals("F"))
                result = (value - 273.15) * 9/5 + 32;
            else if (to.equals("C"))
                result = value - 273.15;
            return result;
        }
    }


