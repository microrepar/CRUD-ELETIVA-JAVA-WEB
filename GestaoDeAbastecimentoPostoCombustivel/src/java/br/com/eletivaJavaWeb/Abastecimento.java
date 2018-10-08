/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eletivaJavaWeb;

import java.util.Date;

/**
 *
 * @author Silvio
 */
public class Abastecimento {
    
    private int id;
    private String codigoFuncionario;
    private String cpfCliente;
    private String tipoCombustivel;
    private Double qtdCombustivel;
    private Double valorTotal;
    private String tipoPagamento;
    private Date dataHoraAbastecimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Double getQtdCombustivel() {
        return qtdCombustivel;
    }

    public void setQtdCombustivel(Double qtdCombustivel) {
        this.qtdCombustivel = qtdCombustivel;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Date getDataHoraAbastecimento() {
        return dataHoraAbastecimento;
    }

    public void setDataHoraAbastecimento(Date dataHoraAbastecimento) {
        this.dataHoraAbastecimento = dataHoraAbastecimento;
    }
    
    
}
