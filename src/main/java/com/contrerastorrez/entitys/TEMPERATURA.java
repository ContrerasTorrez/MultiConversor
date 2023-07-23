package com.contrerastorrez.entitys;

public enum TEMPERATURA {
    F {
        public double to(String type,double value){
            double result = 0;
            if(type.equals("C"))
                result = (value - 32) * 5/9;
            else if(type.equals("K"))
                result = (value - 32) * 5/9 + 273.15;
            return result;
        }
    },
    C {
        public double to(String type,double value){
            double result = 0;
            if(type.equals("F"))
                result =  (value * 9/5) + 32;
            else if(type.equals("K"))
                result = value + 273.15;
            return result;
        }
    },
    K {
        public double to(String type, double value) {
            double result = 0;
            if (type.equals("F"))
                result = (value - 273.15) * 9/5 + 32;
            else if (type.equals("C"))
                result = value - 273.15;
            return result;
        }
    };
    public abstract double to(String type,double value);
}
