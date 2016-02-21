package core;

import interfaces.InterfaceCalc;

import java.io.Serializable;

/**
 * Created by Владимир on 06.02.2016.
 */
public class Calc implements Serializable, InterfaceCalc {
    private Double one;
    private Double two;
    private EnamZnak z;

    public Calc(String one, String two, EnamZnak z) {
        this.one = Double.valueOf(one);
        this.two = Double.valueOf(two);
        this.z = z;
    }

    public double schet() {
        Double d = null;
        switch (z) {
            case PLUS: {
                d = plus();
            }
            break;
            case MINUS: {
                d = minus();
            }
            break;
            case MULT: {
                d = umn();
            }
            break;
            case DIVIDE: {
                d = del();
            }
        }

        return d;
    }


    public double plus() {
        return one + two;
    }

    public double minus() {
        return one - two;
    }

    public double umn() {
        return one * two;
    }

    public double del() {
        return one / two;
    }

}
