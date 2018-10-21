/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BDJ
 */
public class servlet_simple extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           Estudiante estudiante = new Estudiante(); 
           estudiante.setCarne(request.getParameter("txtCarne"));
           estudiante.setNombre(request.getParameter("txtNombres"));
           estudiante.setApellido(request.getParameter("txtApellidos"));
           estudiante.setDireccion(request.getParameter("txtDireccion"));
           estudiante.setTelefono(request.getParameter("txtTelefono"));
           estudiante.setCorreo(request.getParameter("txtCorreo"));
           estudiante.setTipoSangre( Integer.parseInt(request.getParameter("dropSangre")) );
           estudiante.setFechaNacimiento(request.getParameter("txtNacimiento"));         
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet_simple</title>");            
            out.println("</head>");
            out.println("<body>");
             if (estudiante.ingresar()>0){
            out.println("<p>Carne: " + estudiante.getCarne() + "</p>");
            out.println("<p>Nombres: " + estudiante.getNombre() + "</p>");
            out.println("<p>Apellidos: " + estudiante.getApellido() + "</p>");
            out.println("<p>Direcion: " + estudiante.getDireccion() + "</p>");
            out.println("<p>Telefono: " + estudiante.getTelefono() + "</p>");
            out.println("<p>Correo: " + estudiante.getCorreo()  + "</p>");
            out.println("<p>Sangre: " + estudiante.getTipoSangre() + "</p>");
            out.println("<p>Nacimiento: " + estudiante.getFechaNacimiento() + "</p>");
            
            out.println("<br><p><a href='formulario_bootstrap.jsp'>Inicio...</a></p></br>");
             }
             else{
                 out.println("<p>Error...</p>");
                 out.println("<br><p><a href='formulario_bootstrap.jsp'>Inicio...</a></p></br>");
             }
            
            out.println("</body>");
            out.println("</html>");
if (estudiante.ingresar()>0){           
out.println("<p>Ingresado con exito.</p>");
out.println("<br><p><a href='formulario_bootstrap.jsp'>Inicio...</a></p></br>");
}
    else{
                out.println("<p>Error...</p>");
                out.println("<br><p><a href='formulario_bootstrap.jsp'>Inicio...</a></p></br>");
            }
            
            
        } finally {
            out.close();
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
