<%-- 
    Document   : formulario_boostrap
    Created on : Sep 18, 2017, 7:47:15 PM
    Author     : Desarrollo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="clases.Estudiante"%>

<jsp:directive.page import="java.util.ArrayList"></jsp:directive.page>
<jsp:directive.page import="javax.swing.table.DefaultTableModel"></jsp:directive.page>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Boostrap</title>
        <link href="./Boostrap/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./Boostrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
        <script src="./Boostrap/js/jquery-3.2.1.min.js" ></script>
        <script src="./Boostrap/js/bootstrap.js" ></script>
       
    </head>
    <body>
        <div class="page-header">
        <h1>Formularios</h1>
        
        <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-md">
                        <!-- Modal content-->
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                          </div>
                          <div class="modal-body">
                            <p>Some text in the modal.</p>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                        <!-- Fin Modal content-->
                    </div>
                </div>
        
        </div>
        <div class="input-group">
         <span class="input-group-addon">http://</span>
        <input type="text" name="txtUrl" class="form-control" placeholder="URL">
        </div>
        <form action="stEstudiante" class="form" method="post">
            <div class="form-group">
            <input type="text" class="form-control"  id="txtid" name="txtid" value="0" placeholder="id" readonly>    
                    <input type="text" class="form-control"  id="txtCarne" name="txtCarne" placeholder="Carne" pattern="[E,e]{1}[0-9]{3}" required>
                        <input type="text" class="form-control" id="txtNombres" name="txtNombres" placeholder="Nombres" required>
                        <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" value="" placeholder="Apellidos" required>
                        <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" value="" placeholder="Direccion" required>
                        <input type="number" class="form-control" id="txtTelefono" name="txtTelefono" value="" placeholder="Telefono">
                        <input type="email" class="form-control" id="txtCorreo" name="txtCorreo" value="" placeholder="Correo Electronico" required>
            <select  name="dropPuesto" class="form-control">
                    <%  Estudiante estudiante = new Estudiante();
                        List<List <String>> lista = estudiante.listaTipoSangre(); 
                        for(int i=0; i <lista.get(0).size(); i++){
                            out.println("<option value='" + lista.get(0).get(i) + "'>" + lista.get(0).get(i)+") " + lista.get(1).get(i) + "</option>");
                        }
                    %>                                                 
                </select>
                        <input type="date" class="form-control"  id="txtFNacimiento" name="txtFNacimiento" value="" placeholder="Feha Nacimiento" required>
                        <input type="submit" id="btnAgregar" name="btnAgregar" value="Agregar" class="btn btn-info btn-lg" >
                        <input type="submit" id="btnModificar" name="btnModificar" value="Modificar" class="btn btn-primary  btn-lg" >
                        <input type="submit" id="btnEliminar" name ="btnEliminar" value="Eliminar" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" class="btn btn-danger btn-lg" >
           
            </form>
            
            </div>
            <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                            <thead>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Direccion</th>
                                <th>Telefono</th>
                                <th>Puesto</th>
                                <th>Dpi</th>
                                <th>Nacimiento</th>
                                <th>Fecha Registro</th>
                            </thead>
                            <tbody id="tbl_estudiante">
                            
                                <%                                 
                                DefaultTableModel tblModelo= new DefaultTableModel();
                                tblModelo = estudiante.llenarEstudiante();
                                for(int a=0;a< tblModelo.getRowCount();a++){
                                    out.println("<tr data-idEstudiante="+ tblModelo.getValueAt(a,0).toString()  +" data-idTiposangre="+ tblModelo.getValueAt(a,9).toString()  +">");
                                    out.println("<td>" + tblModelo.getValueAt(a,1).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,2).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,3).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,4).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,5).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,6).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,7).toString()  + "</td>");
                                    out.println("<td>" + tblModelo.getValueAt(a,8).toString()  + "</td>");                                  
                                    out.println("</tr>");
                                }
                                %>
                            
                            </tbody>
            </table>               
            </div>
       
    </body>
</html>
