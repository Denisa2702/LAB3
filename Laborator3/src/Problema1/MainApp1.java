package Problema1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp1 {

    public static void main(String[] args) throws IOException {

        List<Parabola> lista = new ArrayList<Parabola>();
        Scanner my_scanner = new Scanner(System.in);
        Parabola p1 = new Parabola(1, 2, 3);
        Parabola p2 = new Parabola(1, 2, 4);
        Parabola p3 = new Parabola(2, 3, 5);

        int index;

        while (true) {
            System.out.println("0. Iesire");
            System.out.println("1. Citirea din fisier");
            System.out.println("2. Afisare lista parabole+varf");
            System.out.println("3. Afisare Mijloc segment");
            System.out.println("4. Afisare mijloc segment (2 parabole");
            System.out.println("5. Afisare lungime segment");
            System.out.println("6. Afisare lungime segment (2 parabole");

            System.out.print("Introduceti optiunea dorita:");
            index = my_scanner.nextInt();

            switch (index) {
                case 0:
                    System.exit(0);

                case 1: {
                    BufferedReader flux_in = new BufferedReader(new FileReader("in.txt"));
                    String linie;
                    String[] valori;

                    while ((linie = flux_in.readLine()) != null) {
                        valori = linie.split(" ");
                        int a, b, c;
                        a = Integer.parseInt(valori[0]);
                        b = Integer.parseInt(valori[1]);
                        c = Integer.parseInt(valori[2]);
                        Parabola P = new Parabola(a, b, c);
                        lista.add(P);
                    }

                    break;
                }

                case 2: {
                    for (Parabola p : lista)
                        System.out.println(p.toString() + " " + p.VarfX() + " " + p.VarfY());

                    break;
                }

                case 3: {
                    System.out.println("Introdu valorile parabolei: ");
                    int a, b, c;
                    double[] mijloc;
                    System.out.print("a= ");
                    a = my_scanner.nextInt();
                    System.out.print("b= ");
                    b = my_scanner.nextInt();
                    System.out.print("c= ");
                    c = my_scanner.nextInt();
                    Parabola p4 = new Parabola(a, b, c);

                    int nr = 0;
                    Parabola P = lista.get(nr);

                    mijloc = P.MIjlocSegmentDreapta(p4);
                    System.out.println(mijloc[0] + " " + mijloc[1]);
                    break;
                }

                case 4: {
                    int nr1 = 0, nr2 = 1;
                    double[] mijloc;
                    Parabola P1 = lista.get(nr1);
                    Parabola P2 = lista.get(nr2);

                    mijloc = Parabola.MijlocSegment(P1, P2);
                    System.out.println("Mijlocul segmentului dintre p1 si p2: ");
                    System.out.println(mijloc[0] + " " + mijloc[1]);
                    break;
                }

                case 5: {
                    System.out.println("Introdu valorile parabolei: ");
                    int a, b, c;
                    double[] mijloc;
                    System.out.print("a= ");
                    a = my_scanner.nextInt();
                    System.out.print("b= ");
                    b = my_scanner.nextInt();
                    System.out.print("c= ");
                    c = my_scanner.nextInt();
                    Parabola p = new Parabola(a, b, c);

                    int nr = 0;
                    Parabola P = lista.get(nr);
                    System.out.println(P.LungimeSegment(p));
                    break;
                }

                case 6: {
                    int nr1 = 0, nr2 = 1;   

                    Parabola P1 = lista.get(nr1);
                    Parabola P2 = lista.get(nr2);
                    System.out.println(Parabola.LungimeSegmentP2(P1, P2));
                    break;
                }
            }
        }
    }
}
