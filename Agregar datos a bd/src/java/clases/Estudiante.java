/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BDJ
 * 
 */
public class Estudiante extends Persona {
    private Conexion clsConectar;
    private String carne;
    private int idEstudiante;
    DefaultTableModel tblModelo;
    PreparedStatement parametro;

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getidEstudiante() {
        return idEstudiante;
    }

    public void setidEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    
    

    public DefaultTableModel llenarEstudiante(){
           try
            {
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           
           String query;
             query = "SELECT     Estudiantes.idEstudiante as id, Estudiantes.Carne, Estudiantes.Nombre, Estudiantes.Apellido, Estudiantes.Direccion, Estudiantes.Telefono, Estudiantes.Correo,  " +
                   "concat(TiposSangre.idtipoSangre,') ',TiposSangre.tipoSangre) as tipoSangre , Estudiantes.FechaNacimiento as FechaNacimiento FROM         Estudiantes INNER JOIN TiposSangre ON Estudiantes.idTipoSangre = TiposSangre.idTipoSangre order by Estudiantes.idEstudiante;";
            ResultSet consulta =  clsConectar.conexionBd.createStatement().executeQuery(query);
            
            String encabezado [] = {"id","Carne","Nombre","Apellido","Direccion","Telefono","Correo","TipoSangre","FechaNacimiento"};
            tblModelo = new DefaultTableModel();
            tblModelo.setColumnIdentifiers(encabezado);
            
            String datos[]= new String[9];      
            while (consulta.next())
                    {           
                      datos[0] = consulta.getString("id");
                      datos[1] = consulta.getString("Carne");
                      datos[2] = consulta.getString("Nombre");
                      datos[3] = consulta.getString("Apellido");
                      datos[4] = consulta.getString("Direccion");
                      datos[5] = consulta.getString("Telefono");
                      datos[6] = consulta.getString("Correo");
                      datos[7] = consulta.getString("tipoSangre");
                      datos[8] = consulta.getString("FechaNacimiento");
                      tblModelo.addRow(datos);
                    }
              clsConectar.cerrarConexion();
              
              return  tblModelo;            
                 }
                 
        catch(Exception ex)
            {
                  clsConectar.cerrarConexion();
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
                    return  tblModelo;
            }
           
   }
     
    public List<List<String>> listaTipoSangre(){
        List<List<String>> lista = new ArrayList<List<String>>();
         
            try{
                lista.add(new ArrayList<String>());
                lista.add(new ArrayList<String>());
                clsConectar = new Conexion();
                clsConectar.abrirConexion();
               String query;
            query = "Select idTipoSangre,TipoSangre from TiposSangre" ;
            ResultSet consulta =  clsConectar.conexionBd.createStatement().executeQuery(query); 
            lista.get(0).add("0");
            lista.get(1).add("--Elija--");
            while(consulta.next()){
                lista.get(0).add(consulta.getString("idTipoSangre"));
                  lista.get(1).add(consulta.getString("TipoSangre"));
            }
            clsConectar.cerrarConexion();
            }
            catch(Exception ex)
            {
            lista.get(0).add("0");
            lista.get(1).add("<<Elija>>"); 
            }
            
        return lista;
    } 
     public int ingresar(){
         int retorno;
            try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           String query;
           query = "INSERT INTO Estudiantes(Carne,Nombre,Apellido,Direccion,Telefono,Correo,idTipoSangre,FechaNacimiento) " +
                                            "Values(?,?,?,?,?,?,?,?)";
           parametro = (PreparedStatement) clsConectar.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getCarne());
           parametro.setString(2, getNombre());
           parametro.setString(3, getApellido());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getCorreo());
           parametro.setInt(7, getTipoSangre());
           parametro.setString(8, getFechaNacimiento());
           int executar =  parametro.executeUpdate();
             clsConectar.cerrarConexion();
           retorno = executar;
           //JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Ingresado","Conexion Exitosa",JOptionPane.INFORMATION_MESSAGE);          
            }
        catch(SQLException ex)
            {
                  clsConectar.cerrarConexion();
                  retorno=0;
                  System.out.println(ex.getMessage());
                //    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
            }
           
           return retorno;
        }
   protected void Modificar(){
            try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           String query;
           query = "update Estudiantes set Carne = ?,Nombre= ?,Apellido= ?,Direccion= ?,Telefono= ?,Correo= ?,idTipoSangre= ?,FechaNacimiento= ? " +
                                            "where idEstudiante=?";
           parametro = (PreparedStatement) clsConectar.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getCarne());
           parametro.setString(2, getNombre());
           parametro.setString(3, getApellido());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getCorreo());
           parametro.setInt(7, getTipoSangre());
           parametro.setString(8, getFechaNacimiento());
           parametro.setInt(9, getidEstudiante());
                  
           int executar =  parametro.executeUpdate();
             clsConectar.cerrarConexion();
         
           JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Actualizado","Conexion Exitosa",JOptionPane.INFORMATION_MESSAGE);          
            }
        catch(Exception ex)
            {
                  clsConectar.cerrarConexion();
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
            }
           
        }
   protected void Eliminar(){
            try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
                      String query;
           query = "delete from  Estudiantes where idEstudiante=? " ;                                 
           parametro = (PreparedStatement) clsConectar.conexionBd.prepareStatement(query);
           parametro.setInt(1, getidEstudiante());
           

           int executar =  parametro.executeUpdate();
           clsConectar.cerrarConexion();
         
           JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Eliminado","Conexion Exitosa",JOptionPane.WARNING_MESSAGE);          
            }
        catch(Exception ex)
            {
                  clsConectar.cerrarConexion();
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
            }
           
           
        }
   protected void mostratTipoSangre(JComboBox combo){
      try{
           clsConectar = new Conexion();
           clsConectar.abrirConexion();
           DefaultComboBoxModel comboModelo = new DefaultComboBoxModel();
           String query;
           query = "Select idTipoSangre,TipoSangre from TiposSangre" ;
            ResultSet consulta =  clsConectar.conexionBd.createStatement().executeQuery(query);
                  while (consulta.next())
                    {            
                      comboModelo.addElement(consulta.getString("idtipoSangre")+") "+consulta.getString("tipoSangre"));
                    }
              clsConectar.cerrarConexion();
              combo.setModel(comboModelo);
           }
                 
        catch(Exception ex)
            {
                  clsConectar.cerrarConexion();
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
            }
           
   }
   
   
}
