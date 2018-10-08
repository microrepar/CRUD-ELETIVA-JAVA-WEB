package br.com.eletivaJavaWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAbastecimento extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            AbastecimentoDAO dao = new AbastecimentoDAO();
            if(null != request.getParameter("acao")){
                if(request.getParameter("acao").equals("EXCLUIR")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    AbastecimentoDTO dto = AbastecimentoDTO.de(dao.buscarPorId(id));
                    request.setAttribute("abastecimentoDTO", dto);
                    request.getRequestDispatcher("confirmarExclusao.jsp").forward(request, response);
                    return;                    
                }else if(request.getParameter("acao").equals("SIM")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.excluir(id);
                    response.sendRedirect(request.getContextPath()+"/ServletAbastecimento");
                    return;
                }else if(request.getParameter("acao").equals("SALVAR")){
                    Abastecimento ab = new Abastecimento();
                    ab.setCodigoFuncionario(request.getParameter("codigo_funcionario"));
                    ab.setCpfCliente(request.getParameter("cpf_cliente"));
                    ab.setTipoCombustivel(request.getParameter("tipo"));
                    ab.setQtdCombustivel(Double.parseDouble(request.getParameter("qtd_combustivel")));
                    ab.setValorTotal(Double.parseDouble(request.getParameter("valor_total")));
                    ab.setTipoPagamento(request.getParameter("tipo_pagamento"));
                    ab.setDataHoraAbastecimento(new Date());
                    dao.salvar(ab);
                    response.sendRedirect(request.getContextPath()+"/ServletAbastecimento");
                    return;
                }else if(request.getParameter("acao").equals("ATUALIZAR")){
                    Abastecimento ab = new Abastecimento();
                    ab.setId(Integer.parseInt(request.getParameter("id")));
                    ab.setCodigoFuncionario(request.getParameter("codigo_funcionario"));
                    ab.setCpfCliente(request.getParameter("cpf_cliente"));
                    ab.setTipoCombustivel(request.getParameter("tipo"));
                    ab.setQtdCombustivel(Double.parseDouble(request.getParameter("qtd_combustivel")));
                    ab.setValorTotal(Double.parseDouble(request.getParameter("valor_total")));
                    ab.setTipoPagamento(request.getParameter("tipo_pagamento"));
                    dao.atualizar(ab);
                    response.sendRedirect(request.getContextPath()+"/ServletAbastecimento");
                    return;
                }else if(request.getParameter("acao").equals("EDITAR")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    AbastecimentoDTO dto = AbastecimentoDTO.de(dao.buscarPorId(id));
                    request.setAttribute("abastecimentoDTO", dto);
                    request.getRequestDispatcher("atualizar.jsp").forward(request, response);
                    return;
                }else if(request.getParameter("acao").equals("RELATORIO")){
                    List<RelatorioDeAbastecimentosDTO> relatorioAbastecimentos = dao.relatorio();
                    request.setAttribute("relatorioAbastecimentosDTO", relatorioAbastecimentos);
                    request.getRequestDispatcher("relatorio.jsp").forward(request, response);
                    return;
                }
                
            }else{
                List<AbastecimentoDTO> dtos = AbastecimentoDTO.listaDe(dao.listarTodos());
                request.setAttribute("abastecimentosDTO", dtos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
