package br.com.eletivaJavaWeb;

public class RelatorioDeAbastecimentosDTO {
    
    private String codigoFuncionario;
    private Double valorTotalAbastecimento;

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Double getValorTotalAbastecimento() {
        return valorTotalAbastecimento;
    }

    public void setValorTotalAbastecimento(Double valorTotalAbastecimento) {
        this.valorTotalAbastecimento = valorTotalAbastecimento;
    }
}
