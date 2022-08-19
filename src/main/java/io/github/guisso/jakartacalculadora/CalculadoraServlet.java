package io.github.guisso.jakartacalculadora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe responsável por executar serviços relacionados a operações aritméticas
 * para os solicitantes.
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 */
@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/CalculadoraServlet"})
public class CalculadoraServlet
        extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(
            // Objeto de requisição gerado pelo servidor de aplicação
            HttpServletRequest request,
            // Objeto de resposta gerado pelo servidor de aplicação
            HttpServletResponse response)
            throws ServletException, IOException {

        // Definição do tipo de resposta que o navegador interpretará
        response.setContentType("text/html;charset=UTF-8");

        // Recuperação do objeto para escrita da resposta ao cliente
        try ( PrintWriter out = response.getWriter()) {

            // Recuperação dos parâmetros recebidos na requisição
            String operacao = request.getParameter("op");
            String valorA = request.getParameter("a");
            String valorB = request.getParameter("b");

            // Conversão para os tipos numéricos correspondentes
            double a = Double.parseDouble(valorA);
            double b = Double.parseDouble(valorB);

            // Criação do objeto que prestará os serviços
            Calculadora calc = new Calculadora(a, b);

            // Variável auxiliar para reter a resposta
            double resposta;

            // Seleção da operação a ser executada
            switch (operacao) {

                case "-":
                    // Subtração

                    // Durante a aula houve uma indução
                    // (não me recordo sob qual motivo, mas
                    // potencialmente porque a cor vermelha
                    // era exibida pelo projetor como observação
                    // sob o método de Calc que foi aplicado)
                    // para o unboxing do tipo de dado.
                    // A solução a seguir é suficiente:
                    resposta = calc.subtrair();

                    // As duas opções de armazenamento da
                    // resposta são válidas:
                    // resposta = calc.subtrair().doubleValue();
                    break;

                case "*":
                    // Multiplicação
                    resposta = calc.multiplicar();
                    break;

                case "/":
                    // Divisão
                    resposta = calc.dividir();
                    break;

                default:
                    // Soma (operação padrão)
                    resposta = calc.somar();
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculadoraServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<header>\n"
                    + "<h2>Desenvolvimento <i>Web</i> - BCC 2022.1</h2>\n"
                    + "</header>");

            out.println("<main>");

            // Exibição da resposta do cálculo
            out.println("<h1>Resultado: "
                    + a
                    // Solução para apresentação do símbolo "+"
                    // (na submissão dos dados ele é apresentado
                    // na forma '%b20' -- \002B) e que contempla 
                    // as demais operações (símbolos)
                    + String.format(" %s ", operacao)
                    + b + " = " + resposta
                    + "</h1>");

            out.println("<a href=\"calculadora.html\">Voltar</a>");

            out.println("</main>");

            out.println("<footer>\n"
                    + "<p>&copy; 2022 - Luis Guisso</p>\n"
                    + "</footer>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
