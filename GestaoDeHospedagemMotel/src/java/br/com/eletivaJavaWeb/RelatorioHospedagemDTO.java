package br.com.eletivaJavaWeb;

public class RelatorioHospedagemDTO {
    private String tipo;
    private int numHospedagens;
    private double receitaTotal;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumHospedagens() {
        return numHospedagens;
    }

    public void setNumHospedagens(int numHospesgem) {
        this.numHospedagens = numHospesgem;
    }

    public double getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(double receitaTotal) {
        this.receitaTotal = receitaTotal;
    }
}
