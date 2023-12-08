package Problema2;

import java.time.LocalDate;

public class Produs {

    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_expirari;

    public Produs(String denumire, float pret, int cantitate, LocalDate data_expirari) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirari = data_expirari;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getData_expirari() {
        return data_expirari;
    }

    public void setData_expirari(LocalDate data_expirari) {
        this.data_expirari = data_expirari;
    }

    @Override
    public String toString() {
        return denumire+" "+pret+" "+cantitate+" "+getData_expirari();
    }

    public boolean ProdusExpirat()
    {
        if(data_expirari.isBefore(LocalDate.now()))
            return true;
        return false;
    }

    public void Vanzare()
    {
        cantitate--;
    }
}


