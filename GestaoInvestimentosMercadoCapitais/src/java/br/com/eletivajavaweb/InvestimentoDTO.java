package br.com.eletivajavaweb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvestimentoDTO {

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

    public void setCodigoEmpresaCorretora(String codigoEmpresaInvestimento) {
        this.codigoEmpresaCorretora = codigoEmpresaInvestimento;
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

    public static InvestimentoDTO de(Investimento investimento) {
        InvestimentoDTO dto = new InvestimentoDTO();
        dto.setId(investimento.getId());
        dto.setCodigoInvestidor(investimento.getCodigoInvestidor());
        dto.setNomeInvestidor(investimento.getNomeInvestidor());
        dto.setCodigoEmpresaCorretora(investimento.getCodigoEmpresaCorretora());
        dto.setQtdAcoes(investimento.getQtdAcoes());
        dto.setDataHoraCompra(investimento.getDataHoraCompra());
        dto.setDataHoraVenda(investimento.getDataHoraVenda());
        dto.setPrecoAcaoCompra(investimento.getPrecoAcaoCompra());
        dto.setPrecoAcaoVenda(investimento.getPrecoAcaoVenda());

        return dto;
    }

    public static List<InvestimentoDTO> listaDe(List<Investimento> investimentos) {

        List<InvestimentoDTO> dtos = new ArrayList<>();
        investimentos.forEach(investimento -> dtos.add(InvestimentoDTO.de(investimento)));

        return dtos;
    }
}
