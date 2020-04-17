
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This class will estimate the Compressibility (Z)-factor using Newton's Method recursively
 * f(z1) = z1- (1 + (c1 * pr) + (c2 * Math.pow(pr,2) - (c3 * Math.pow(pr,5) + c4)
 * */

public class NewtonsMethod extends DakVariables {

//    static double pr;
    private double z;

    public NewtonsMethod(double z){
        this.z = z;
    }


    public static double newtonPrime(double c1, double c2, double c3, double c4, double pr, double z, double A11, double A10, double tPR){
        //This method computes for f'(zi)
        double d1 = ((c1 * pr)/z);
        double d2 = ((2*c2*Math.pow(pr,2))/z);
        double d3 = ((5*c3*Math.pow(pr,5))/z);
        double e1 = ((2 * A10 * Math.pow(pr, 2))/ (z * Math.pow(tPR, 3)));
        double g1 = A11 * Math.pow(pr,2);
        double g2 = Math.pow(A11* Math.pow(pr,2),2);
        double g3 = Math.exp((-A11) * Math.pow(pr,2));
        double d4 = e1 *(1+g1-g2)*3;

        double result = 1 + d1 +d2 -d3 + d4;
        return result;
    }
    public double newtonFunct(double c1, double c2, double c3, double c4, double pr, double z){
        //This method computes for f(zi)
        double d1 = z;
        double d2 = c1*pr;
        double d3 = c2*Math.pow(pr,2);
        double d4 = (-c3) * Math.pow(pr, 5);
        double d5 = c4;

        double result = d1 - (1 + d2 + d3 - d4 + d5);
        return result;
    }
    public static double newtonRaphsonEq(double funct1, double funct2, double z){
        double d1 = z;
        double d2 = (funct1/funct2);
        double result = d1 - d2;
        return result;
    }

    public static void main(String[] args) {


// Taking the initial guess of z to be 0.5 for Newton-Raphson method
        NewtonsMethod dark = new NewtonsMethod(0.5);
        dark.computerVariables();
        double pr = dark.reducedDensity(dark.pPR , dark.tPR, dark.z);
        double c4 = dark.newtonVariable4(pr,dark.tPR,dark.z);

        int count = 0;
        double x3 = 0;
        while(count < 200){
            //infinite iteration .No condition yet ,get the object of the class
            System.out.println("Iteration "+count);
            if(count > 0) {
                dark.z = 0.5;
                pr = dark.reducedDensity(dark.pPR, dark.tPR, dark.z);
                c4 = dark.newtonVariable4(pr, dark.tPR, dark.z);
            }
//

            double x2 = dark.newtonPrime(dark.c1,dark.c2,dark.c3,c4,pr,dark.z,dark.A11,dark.A10,dark.tPR);
            double x1 = dark.newtonFunct(dark.c1,dark.c2,dark.c3,c4,pr,dark.z);
            x3 =  newtonRaphsonEq(x1, x2, dark.z);
            System.out.println("Output of Iteration is "+ x3);
            count++;




        }
    }
}














