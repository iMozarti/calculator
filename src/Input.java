
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public static final class QuadraticEq {
        private static final Pattern EQN1 = Pattern.compile("([+-]?\\d+)[Xx]2\\s*([+-]?\\d+)[Xx]\\s*([+-]?\\d+)\\s*=\\s*([+-]?\\d)");//2x2-2x+1=0
        private static final Pattern EQN2 = Pattern.compile("([+-]?\\d+)[Xx]2\\s*([+-]?\\d+)[Xx]\\s*=\\s*([+-]?\\d)");//2x2+3x=0
        private static final Pattern EQN3 = Pattern.compile("([+-]?\\d+)[Xx]2\\s*=\\s*([+-]?\\d)");//2x2=0
        private static final Pattern EQN4 = Pattern.compile("([+-]?\\d+)[Xx]2\\s*([+-]?\\d+)\\s*=\\s*([+-]?\\d)");//2x2+2=0
        private static final Pattern ELN1 = Pattern.compile("([+-]?\\d+)[Xx]\\s*([+-]?\\d+)\\s*=\\s*([+-]?\\d)");//3x-20=0
        private static final Pattern ELN2 = Pattern.compile("([+-]?\\d+)[Xx]\\s*=\\s*([+-]?\\d)");//3x=9


        public static void parseString(final String inputScan) {
            int check1 = inputScan.indexOf("x2");
            if (check1 < 0){
                final Matcher matcher = ELN1.matcher(inputScan);
                if (!matcher.matches()) {
                    final Matcher matcher1 = ELN2.matcher(inputScan);
                    if (!matcher1.matches()) {
                        System.out.println("-----------Error-------------");
                        System.out.println("|||||Check the equation||||||");
                        System.out.println("-----------------------------");


                    }else{
                        final int a = 0;
                        final int b = Integer.parseInt(matcher1.group(1));
                        final int c = 0;
                        final int e = Integer.parseInt(matcher1.group(2));

                        Calc.metodicSimple(b,e);
                    }
                }else{
                    final int a = 0;
                    final int b = Integer.parseInt(matcher.group(1));
                    final int c = Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(3));
                    final int e = Integer.parseInt(matcher.group(3));

                    Calc.methodCalc(a,b,c);
                }
            }else{
                final Matcher matcher2 = EQN1.matcher(inputScan);
                if (!matcher2.matches()) {
                    final Matcher matcher3 = EQN2.matcher(inputScan);
                    if (!matcher3.matches()){
                        final Matcher matcher4 = EQN3.matcher(inputScan);
                        if (!matcher4.matches()){
                            final Matcher matcher5 = EQN4.matcher(inputScan);
                                if (!matcher5.matches()){
                                    System.out.println("-----------Error-------------");
                                    System.out.println("|||||Check the equation||||||");
                                    System.out.println("-----------------------------");
                                }else {//for eqn4
                                    final double a = Integer.parseInt(matcher5.group(1));
                                    final double b = Integer.parseInt(matcher5.group(2));

                                    Calc.metodicSimpleSq(a,b,0);
                                }
                        }else {//for eqn3
                            final double a = Integer.parseInt(matcher4.group(1));
                            final double b = Integer.parseInt(matcher4.group(2));

                            Calc.metodicSimpleSq(a,b,1);
                        }
                    }else{// for eqn2
                        final int a = Integer.parseInt(matcher3.group(1));
                        final int b = Integer.parseInt(matcher3.group(2));
                        final int c = 0;
                        final int e = -
                                Integer.parseInt(matcher3.group(3));
                        System.out.println(e);

                        Calc.methodCalc(a,b,e);
                    }
                }else{// for eqn1
                    final int a = Integer.parseInt(matcher2.group(1));
                    final int b = Integer.parseInt(matcher2.group(2));
                    final int c = Integer.parseInt(matcher2.group(3)) + Integer.parseInt(matcher2.group(4));
                    final int e = Integer.parseInt(matcher2.group(4));

                    Calc.methodCalc(a, b, c);
                }
            }
        }

        public static void main(String[] args){
            String inputScan =  JOptionPane.showInputDialog("Укажите уравнение в общем виде со всеми коэффицентами и знаками");
            QuadraticEq.parseString(inputScan);


//            System.out.println("Укажите уравнение в общем виде со всеми коэффицентами и знаками");
//            Scanner scan = new Scanner(System.in);
//            String inputScan = scan.nextLine();
//            QuadraticEq.parseString(inputScan);
        }
    }
}
