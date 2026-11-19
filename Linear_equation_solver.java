import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

// Implement the complete Equation and LinearEquation classes here.
class Equation{
    private long a,b;
    public Equation(long a,long b){
        this.a=a;
        this.b=b;
        
    }
    public long getA(){
        return a;
        
    }
    public long getB(){
        return b;
    }
    
}
class LinearEquation extends Equation{
    private long c,d;
    public LinearEquation(long a,long b,long c,long d){
        super(a,b);
        this.c=c;
        this.d=d;
    }
    public int getSolutionType(){
        if(getA()-c!=0) return 1;
        return getB()==d?2:0;
    }
    public double getSolution(){
        return (double)(d-getB())/(getA()-c);
    }
}



public class Linear_equation_solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder out = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();

            LinearEquation eq = new LinearEquation(a, b, c, d);
            int type = eq.getSolutionType();

            if (type == 0) {
                out.append("No solution\n");
            }
            else if (type == 2) {
                out.append("Infinite solutions\n");
            }
            else {
                double x = eq.getSolution();

                String rounded = BigDecimal.valueOf(x)
                        .setScale(2, RoundingMode.HALF_UP)
                        .toPlainString();

                out.append("One solution: ")
                   .append(rounded)
                   .append('\n');
            }
        }

        System.out.print(out);
        sc.close();
    }
}
