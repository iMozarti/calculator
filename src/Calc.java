import javax.swing.*;

public class Calc {
    public static void methodCalc(double a, double b,  double c){

        double d;
        String x, x1, x2;
        if (a==0) {
            if (b != 0) {
                x = String.format("%.3f", (-c / b));
                JOptionPane.showMessageDialog(null, "x = "+x+";");
                System.out.println("x = "+x+";");

            } else {
                JOptionPane.showMessageDialog(null, "Fail");
                System.out.println("Ошибка");
            }
        }else {
            d = (b*b - 4*a*c);
            if (d<0){
                JOptionPane.showMessageDialog(null, "No roots");
                System.out.println("Нет корней");
            } else{
                if (d==0){
                    x1=String.format("%.3f",(-b/(2*a)));
                    JOptionPane.showMessageDialog(null, "x1=x2= "+x1+";");
                    System.out.println("x1=x2= "+x1+";");
                }else{
                    x1 = String.format("%.3f",(-b + Math.sqrt(d)) / (2 * a));
                    x2 = String.format("%.3f",(-b - Math.sqrt(d)) / (2 * a));
                    JOptionPane.showMessageDialog(null, "x1= "+x1+";\n"+"x2= "+x2+";");
                    System.out.println("x1= "+x1+";\n"+"x2= "+x2+";");
                }
            }
        }
    }

    public static void metodicSimple(double a, double b){
        double z;
        z= b/a;
        JOptionPane.showMessageDialog(null, "x= "+z);
        System.out.println("x= "+z);

    }

    public static void metodicSimpleSq(double a, double b, int c) {
        String Fail = ("----------ERROR----------");
        double z;
        String x1,x2;
        if (c==0){
            z=-b/a;
            if (z < 0) {
                JOptionPane.showMessageDialog(null, Fail);
                System.out.println("----------ERROR----------");
                System.out.println("root of a negative number");
            }else{
                x1 = String.format("%.3f",-Math.sqrt(z));
                x2 = String.format("%.3f",Math.sqrt(z));
                JOptionPane.showMessageDialog(null, "x1=" + x1 + ";\n " +"x2= " + x2+";");
                System.out.println("x1=" + x1 + ";\n " +"x2= " + x2+";");
            }

        }else{
            z= b / a;
            if (z < 0) {
                System.out.println("----------ERROR----------");
                System.out.println("root of a negative number");
            }else{
                x1 = String.format("%.3f",-Math.sqrt(z));
                x2 = String.format("%.3f",Math.sqrt(z));
                JOptionPane.showMessageDialog(null, "x1=" + x1 + "; " + " x2= " + x2+";");
                System.out.println("x1=" + x1 + "; " + " x2= " + x2+";");
            }
        }
    }
}
