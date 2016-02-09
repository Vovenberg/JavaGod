package server;

import java.io.Serializable;

/**
 * Created by Владимир on 06.02.2016.
 */
public class Calc implements Serializable {
    Double one;
    Double two;
    char z;

    public Calc(String one, String two,char z) {
        this.one = Double.valueOf(one);
        this.two = Double.valueOf(two);
        this.z=z;


    }

    public double schet() {
        Double d=null;
        switch (z){
            case '+': {d= plus();}
            case '-':{d=minus();}
            case '*':{d=umn();}
            case '/':{d=del();}
        }

        return d;
    }

    public double plus (){return one+two;}
    public double minus (){return one-two;}
    public double umn (){return one*two;}
    public double del (){return one/two;}

}
