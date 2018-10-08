package br.com.eletivajavaweb;

public class RelatorioInvestimentosDTO {
    private String cogigoInvestidor;
    private String nomeInvestidor;
    private Double lucroPrejuiso;

    public String getCogigoInvestidor() {
        return cogigoInvestidor;
    }

    public void setCogigoInvestidor(String cogigoInvestidor) {
        this.cogigoInvestidor = cogigoInvestidor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public void setNomeInvestidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }

    public Double getLucroPrejuiso() {
        return lucroPrejuiso;
    }

    public void setLucroPrejuiso(Double lucroPrejuiso) {
        this.lucroPrejuiso = lucroPrejuiso;
    }
     
}
