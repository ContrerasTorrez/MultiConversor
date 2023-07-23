package com.contrerastorrez.entitys;

import java.text.DecimalFormat;

public enum MONEDAS {
    DOP (0.017836379),
    USD(1.0),
    EUR(1.1131816),
    JPY(0.007052705),
    KRW(0.00077717734);

    private final double value;
    MONEDAS(double value){
        this.value = value;
    }
    public double getValue(){
        return this.value;
    }
    public static double getResult(double valueFrom, double valueTo, double coinsFrom){
        double result = 0;
        // FORMULA DE CONVERSION Y FORMAT (MONEDAS)
        result = (coinsFrom * valueFrom) / valueTo;
        return result;
    }
}
