package Problema1;

public class Parabola {

    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
       return "f(x) = " + a + "x^2" + " + " + b + "x " + " + " +c;
    }

    public double VarfX()
    {
        double X;
        X=(double) (-b)/(double)(2*a);
        return X;
    }

    public double VarfY()
    {
        double Y;
        Y=(double) (-b*b+4*a*c)/ (double)(4*a);
        return Y;
    }

    public double[] MIjlocSegmentDreapta(Parabola p)
    {
        double X=(double) (VarfX()+p.VarfX())/2;
        double Y=(double)(VarfY()+p.VarfY())/2;

        double[] mijloc={X, Y};
        return mijloc;
    }

    public static double[] MijlocSegment(Parabola p1, Parabola p2)
    {
        double X=(double) (p1.VarfX()+p2.VarfX())/2;
        double Y=(double) (p1.VarfY()+p2.VarfY())/2;

        double[] mijloc={X, Y};
        return mijloc;
    }

    public double LungimeSegment(Parabola p)
    {
        double rezultat;
        double X=p.VarfX()-VarfX();
        double Y=p.VarfY()-VarfY();

        rezultat=Math.hypot(X, Y);
        return rezultat;
    }

    public static double LungimeSegmentP2(Parabola p1, Parabola p2)
    {
        double rezultat;
        double X=p2.VarfX()-p1.VarfX();
        double Y=p2.VarfY()-p1.VarfY();

        rezultat=Math.hypot(X, Y);
        return rezultat;
    }
}
