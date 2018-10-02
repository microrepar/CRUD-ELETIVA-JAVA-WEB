package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.fatecmogidascruzes.topicos.SolicitacaoDTO;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    List<SolicitacaoDTO> solicitacoes = (List<SolicitacaoDTO>) request.getAttribute("solicitacoes");
    // Se nao tiver vindo da servlet, redireciona para a servlet.
    if (null == solicitacoes) {
        response.sendRedirect(request.getContextPath() + "/ServicoSolicitacao");
        return;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listagem de Solicitações de Documento</title>\n");
      out.write("        <style>\n");
      out.write("            .icone {\n");
      out.write("                width: 40px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Listagem de Solicitações de Documento</h1>\n");
      out.write("        <a href=\"inserir.jsp\">NOVO</a>\n");
      out.write("        <form action=\"index.jsp\">\n");
      out.write("            <input type=\"text\" name=\"filtrar\" placeholder=\"Informe um filtro\" /><input type=\"submit\" name=\"acao\" value=\"Pesquisar\" />\n");
      out.write("        </form>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Editar</th>\n");
      out.write("                    <th>RA</th>\n");
      out.write("                    <th>Nome do Aluno</th>\n");
      out.write("                    <th>Tipo de Documento</th>\n");
      out.write("                    <th>Situação</th>\n");
      out.write("                    <th>Data</th>\n");
      out.write("                    <th>Excluir</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    //ResultSet resultado = (ResultSet) request.getAttribute("solicitacoes");
                    //while (resultado.next()) {
                    for (SolicitacaoDTO solicitacao : solicitacoes) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"ServicoSolicitacao?acao=preAlteracao&id=");
      out.print( solicitacao.getId());
      out.write("\"><img class=\"icone\" src=\"lapis.svg\" alt=\"Imagem de um lápis\"/></a></td>\n");
      out.write("                    <td>");
      out.print( solicitacao.getRaAluno());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( solicitacao.getNomeAluno());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( solicitacao.getTipoDocumento());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( solicitacao.getSituacao());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( solicitacao.getSituacao());
      out.write("</td>\n");
      out.write("                    <td><a href=\"ServicoSolicitacao?acao=excluir&id=");
      out.print( solicitacao.getId());
      out.write("\"><img class=\"icone\" src=\"lata_lixo.svg\" alt=\"Imagem de uma lata de lixo\"/></a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }

                    //resultado.getStatement().getConnection().close();

      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
