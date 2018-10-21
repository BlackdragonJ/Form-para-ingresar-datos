<%-- 
    Document   : index
    Created on : Sep 6, 2017, 7:43:23 PM
    Author     : BDJ
--%>

<%@page import="java.util.List"%>
<%@page import="clases.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center>
        <div></div>
         <form action="servlet_simple" method="post">
            <h1>Formulario Estudiante</h1>
            <table>
                <tr>
                   <td>Carne</td>
                    <td><input type="txt" id="txtCarne" name="txtCarne" placeholder="ejemplo: E001"></td>
                </tr>
                <tr>
                <td>Nombre</td>
                <td><input type="txt" id="txtNombre" name="txtNombre" placeholder=""></td>
                   </tr>
                <tr>   
                    <td>Apellido</td>
                    <td><input type="txt" id="txtApellido" name="txtApellido" placeholder=""></td>
                </tr>
                <tr>   
                    <td>Telefono</td>
                    <td><input type="txt" id="txtTelefono" name="txtTelefono" placeholder="ejemplo: 45621345"></td>
                </tr>
                <tr>   
                    <td>Direccion</td>
                    <td><input type="txt" id="txtDireccion" name="txtDireccion" placeholder="ejemplo: 10ma calle 10-7"></td>
                <br></br>
                <tr>   
                    <td>Nacimiento</td>
                    <td><input type="date" id="FechaNacimiento" name="FechaNacimiento" placeholder="dd/mm/yyyy"></td>
                </tr>
                <br></br>
                <tr>   
                    <td>Correo</td>
                    <td><input type="txt" id="txtCorreo" name="txtCorreo" placeholder="ejemplo: ejemplo@gmail.com"></td>
                </tr>
                <tr>
                    <td>Sangre</td>
               <td>     
                   <select id="TipoSangre" name="tipoSangre" placeholder="">
                    <%  
                       Estudiante estudiante = new Estudiante();
                         List<List <String>> lista = estudiante.listaTipoSangre(); 
                            for(int i=0; i <lista.get(0).size(); i++){
                               out.println("<option value='" + lista.get(0).get(i) +"'>" + lista.get(1).get(i) +"</option>");
                             }
                            %>
               </td>  
                </tr>
                <tr>
                    <td><td>
                    <td><input type="Submit" id="Agregar" name="Agregar"></td>
                </tr>
            </table>    
        </form>
    </center>
                            <h1><a href="formulario_boostrap.jsp">Boostrap</a></h1> 
    </body>
</html>
