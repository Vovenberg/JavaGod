package core;

/**
 * Created by Владимир on 06.02.2016.
 */
public class Calc {
    Double one;
    Double two;


    public Calc(String one, String two) {
        this.one = Double.valueOf(one);
        this.two = Double.valueOf(two);

    }

    public double plus (){return one+two;}
    public double minus (){return one-two;}
    public double umn (){return one*two;}
    public double del (){return one/two;}

}
