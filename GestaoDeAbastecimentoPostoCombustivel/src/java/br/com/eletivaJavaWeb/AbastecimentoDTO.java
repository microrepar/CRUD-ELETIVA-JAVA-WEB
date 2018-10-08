package br.com.eletivaJavaWeb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbastecimentoDTO {
    
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
    
    public static AbastecimentoDTO de(Abastecimento ab){
        AbastecimentoDTO dto = new AbastecimentoDTO();
        dto.setId(ab.getId());
        dto.setCodigoFuncionario(ab.getCodigoFuncionario());
        dto.setCpfCliente(ab.getCpfCliente());
        dto.setTipoCombustivel(ab.getTipoCombustivel());
        dto.setQtdCombustivel(ab.getQtdCombustivel());
        dto.setValorTotal(ab.getValorTotal());
        dto.setTipoPagamento(ab.getTipoPagamento());
        dto.setDataHoraAbastecimento(ab.getDataHoraAbastecimento());
              
        return dto;
    }
    
    public static List<AbastecimentoDTO> listaDe(List<Abastecimento> abastecimentos){
        
        List<AbastecimentoDTO> dtos = new ArrayList<>();        
        abastecimentos.forEach(ab -> dtos.add(AbastecimentoDTO.de(ab)));
        
        return dtos;
    }

}
