package bueno.vilardi.bruno;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Titulo {
    private double valor;
    private String descrição;
    private LocalDate dataDeVencimento;
    private double jurosAoDia;

    public Titulo(double valor, String descrição, String dataDeVencimento, double jurosAoDia) {
        this.valor = valor;
        this.descrição = descrição;
        this.dataDeVencimento = LocalDate.parse(dataDeVencimento);
        this.jurosAoDia = jurosAoDia;
    }

    public double totalParaPagar(){
        if(!estaAtrasada()){
            return this.valor;
        } else {
            return calcularJuros();
        }
    }

    private double calcularJuros() {
        return this.valor + this.valor * this.jurosAoDia * DAYS.between(LocalDate.now(), this.dataDeVencimento);
    }

    private boolean estaAtrasada() {
        return LocalDate.now().isAfter(this.dataDeVencimento);
    }
}
