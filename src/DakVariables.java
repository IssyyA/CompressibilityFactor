import java.util.Scanner;

public class DakVariables {
    //This Class contains all variables
    static double A1 = 0.3265;
    static double A2 = -1.0700;
    static double A3 = -0.5339;
    static double A4 = 0.01569;
    static double A5 = -0.05165;
    static double A6 = 0.5475;
    static double A7 = -0.7361;
    static double A8 = 0.1844;
    static double A9 = 0.1056;
    static double A10 = 0.6134;
    static double A11 = 0.7210;
    static double specificGravity = 0.64;
    static double specificGravity2 = Math.pow(0.64, 2);
    static double pcPressure = (4.6 + (0.1 * specificGravity) - (0.258 * specificGravity2)) * 10.1325 * 14.7;
    static double pcTemp = (99.3 + (180 * specificGravity) - (6.94 * specificGravity2)) * 1.8;

    static double pPR;
    static double tPR;
    double c1;
    double c2;
    double c3;

    public void computerVariables(){
        //Input value of Pressure
        Scanner input = new Scanner(System.in);
    // Input value of Pressure
     System.out.print("Input the Pressure: ");
        double pressure = input.nextDouble();
    //Input value of Temperature
     System.out.print("Input the Temperature: ");
        double temperature = input.nextDouble();

        double pPR = (pressure / pcPressure);
        //System.out.println(pPR);

        double tPR = (temperature / pcTemp);
        // System.out.println(tPR);

        double c1 = (A1 + (A2 / tPR) + (A3 / Math.pow(tPR, 3)) + (A4 / Math.pow(tPR, 4)) + (A5 / Math.pow(tPR, 5)));
        //System.out.println(c1);

        double c2 = (A6 + (A7 / tPR) + (A8 / Math.pow(tPR, 2)));
        // System.out.println(c2);

        double c3 = (A9 * (A7 / tPR) + (A8 / Math.pow(tPR, 2)));
        //  System.out.println(c3);

    }

      // This calculates for the variable pr i.e Reduced density
    public double reducedDensity(double Ppr , double Tpr, double z){
        double d = ((0.27 * Ppr)/(z * Tpr));
        return d;
    }

    // This calculates for the variable c4
    public double newtonVariable4(double pr,double tPR, double z){
        double e1 = ((2 * A10 * Math.pow(pr, 2))/ (z * Math.pow(tPR, 3)));
        double g1 = A11 * Math.pow(pr,2);
        double g2 = Math.pow(A11* Math.pow(pr,2),2);
        double g3 = Math.exp((-A11) * Math.pow(pr,2));
        double d4 = e1 *(1+g1-g2)*3;
        return d4;
    }

}










