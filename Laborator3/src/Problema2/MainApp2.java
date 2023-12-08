package Problema2;

import java.beans.PropertyChangeSupport;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainApp2 {

    public static void main(String[] args) throws IOException {

        PrintStream flux_out=new PrintStream("produse_out.txt");
        Scanner my_scanner = new Scanner(System.in);
        List<Produs> lista = new ArrayList<Produs>();
        String nume_fis = "produse.txt";
        BufferedReader flux_in = new BufferedReader(new FileReader(nume_fis));
        String[] date_produs;
        String linie;

        while ((linie = flux_in.readLine()) != null) {
            date_produs = linie.split(",");
            String den = date_produs[0];
            float pret = Float.parseFloat(date_produs[1]);
            int cantitate = Integer.parseInt(date_produs[2]);
            LocalDate data_expirarii = LocalDate.parse(date_produs[3]);
            Produs p = new Produs(den, pret, cantitate, data_expirarii);
            lista.add(p);
        }

        int opt;

        while (true) {
            System.out.println("0. Iesire");
            System.out.println("1. Afisarea tuturor produselor");
            System.out.println("2. Afisarea produselor expirate");
            System.out.println("3. Vanzarea unui produs");
            System.out.println("4. Afisarea produselor cu pret minim");
            System.out.println("5. Salvarea produselor care au o cantitate mai mica decat o valoare citita de la tastatura intr-un fisier de iesire");
            System.out.print("\nAlegeti optiunea dorita: ");
            opt=my_scanner.nextInt();

            switch (opt)
            {
                case 0:
                    System.exit(0);

                    case 1:
                    {
                        System.out.println("\nProdusele sunt: ");
                        for(Produs p:lista)
                            System.out.println(p.toString());
                        System.out.println("");
                        break;
                    }

                case 2:
                {
                    System.out.println("\nProdusele expirate sunt: ");
                    for(Produs p:lista) {
                        if (p.ProdusExpirat())
                            System.out.println(p.toString());
                    }
                    System.out.println("");
                    break;
                }

                case 3:
                {
                    int ok=0;
                    my_scanner.nextLine();
                    System.out.println("\nCe produs ati dori sa cumparati?");
                    String nume_produs=my_scanner.nextLine();
                    for(Produs p:lista) {
                        if (p.getDenumire().equals(nume_produs)) {
                            ok = 1;
                            if (p.ProdusExpirat() == false) {
                                if (p.getCantitate() != 0) {
                                    System.out.println("Avem acest produs");
                                    p.Vanzare();
                                } else
                                    System.out.println("Din pacate, acest produs nu mai este in stoc!");
                            } else
                                System.out.println("Acest produs este expirat!!!");
                        }
                    }

                    Iterator<Produs> iterator=lista.iterator();
                    while(iterator.hasNext())
                    {
                        Produs sters=iterator.next();
                        if(sters.getCantitate()==0)
                            iterator.remove();
                    }

                    if(ok==0)
                        System.out.println("Din pacate, nu avem acest produs deloc!");
                    System.out.println();
                    break;
                }

                case 4:
                {
                    Produs p1=lista.get(0);
                    float minim=p1.getPret();


                    for(Produs p:lista) {
                        if (p.getPret() < minim)
                            minim = p.getPret();
                    }

                    for(Produs p:lista)
                    {
                        if(p.getPret()==minim)
                            System.out.println(p.toString());
                    }
                    break;
                }

                case 5:
                {
                    System.out.println("\nIntrodu cantitatea: ");
                    int cant=my_scanner.nextInt();
                    my_scanner.nextLine();
                    for(Produs p:lista)
                    {
                        if(p.getCantitate()<cant)
                            flux_out.println(p.toString());
                    }
                    break;
                }



            }


        }
    }
}
