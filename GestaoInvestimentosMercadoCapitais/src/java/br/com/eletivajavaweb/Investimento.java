package br.com.eletivajavaweb;

import br.com.eletivajavaweb.util.ConverteDataHora;
import java.util.Date;

public class Investimento {

    private int id;
    private String codigoInvestidor;
    private String nomeInvestidor;
    private String codigoEmpresaCorretora;
    private int qtdAcoes;
    private Date dataHoraCompra;
    private Date dataHoraVenda;
    private double precoAcaoCompra;
    private double precoAcaoVenda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoInvestidor() {
        return codigoInvestidor;
    }

    public void setCodigoInvestidor(String codigoInvestidor) {
        this.codigoInvestidor = codigoInvestidor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public void setNomeInvestidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }

    public String getCodigoEmpresaCorretora() {
        return codigoEmpresaCorretora;
    }

    public void setCodigoEmpresaCorretora(String codigoEmpresaCorretora) {
        this.codigoEmpresaCorretora = codigoEmpresaCorretora;
    }

    public int getQtdAcoes() {
        return qtdAcoes;
    }

    public void setQtdAcoes(int qtdAcoes) {
        this.qtdAcoes = qtdAcoes;
    }

    public Date getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(Date dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public Date getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(Date dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public double getPrecoAcaoCompra() {
        return precoAcaoCompra;
    }

    public void setPrecoAcaoCompra(double precoAcaoCompra) {
        this.precoAcaoCompra = precoAcaoCompra;
    }

    public double getPrecoAcaoVenda() {
        return precoAcaoVenda;
    }

    public void setPrecoAcaoVenda(double precoAcaoVenda) {
        this.precoAcaoVenda = precoAcaoVenda;
    }

    void setDataHoraCompra(String data, String hora) {
        this.dataHoraCompra = ConverteDataHora.converteStringData(data + " " + hora);
    }

    void setDataHoraVenda(String data, String hora) {
        this.dataHoraVenda = ConverteDataHora.converteStringData(data + " " + hora);
    }

}
