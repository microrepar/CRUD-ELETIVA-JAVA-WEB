package br.com.eletivajavaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            InvestimentoDAO dao = new InvestimentoDAO();
            
            if(null != request.getParameter("acao")){
                if(request.getParameter("acao").equals("SALVAR")){
                    Investimento inv = new Investimento();
                    inv.setCodigoInvestidor(request.getParameter("codigo_investidor"));
                    inv.setNomeInvestidor(request.getParameter("nome_investidor"));
                    inv.setCodigoEmpresaCorretora(request.getParameter("codigo_corretora"));
                    inv.setQtdAcoes(Integer.parseInt(request.getParameter("qtd_acoes")));
                    inv.setDataHoraCompra(request.getParameter("data_compra"), request.getParameter("hora_compra"));
                    inv.setPrecoAcaoCompra(Double.parseDouble(request.getParameter("preco_compra")));
                    inv.setDataHoraVenda(request.getParameter("data_venda"), request.getParameter("hora_venda"));
                    inv.setPrecoAcaoVenda(Double.parseDouble(request.getParameter("preco_venda")));
                    dao.salvar(inv);
                    response.sendRedirect(request.getContextPath()+"/Servlet");
                    return;
                }
                
            }else{
                List<InvestimentoDTO> dtos = InvestimentoDTO.listaDe(dao.listarTodos());
                request.setAttribute("investimentosDTO", dtos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
