/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author BDJ
 */
public class Conexion {
    protected Connection conexionBd;
    
    private final String sgdb = "sqlserver"; // sqlserver,mysql
    private final String servidor=""; //DESARROLLO,localhost || miapodoenmayusculas/SQLEXPRESS
    private final String puerto=":3306";//:3306
    private final String bd = "dbEscuela";
  //  private final String urlConexion = "jdbc:"+sgdb +"://"+servidor+puerto+"/"+bd; //mysql
    private final String urlConexion = "jdbc:"+sgdb +"://"+servidor+puerto+";databaseName="+bd;
    private final String usuario = ""; //mi apodo con la primera mayuscula
    private final String contra = "";  //mi apodo
    private final String jdbc="com.microsoft.sqlserver.jdbc.SQLServerDriver,com.mysql.jdbc.Driver"; 
    // com.microsoft.sqlserver.jdbc.SQLServerDriver,com.mysql.jdbc.Driver
    // com.mysql.jdbc.Driver
    
    protected void abrirConexion()
    {
        try
        {
        Class.forName(jdbc);
        //conexionBd = DriverManager.getConnection("jdbc:sqlserver://DESARROLLO;databaseName=dbEscuela;user=IsEscuela;password=escuela2016;");
        conexionBd= DriverManager.getConnection(urlConexion,usuario,contra);
        
       //JOptionPane.showMessageDialog(null,"EXITO","Conexion Exitosa",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
         
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Conexion :(",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    protected void cerrarConexion()
    {
        try {
            conexionBd.close();
            }
            catch(Exception ex)
        {        
        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Conexion",JOptionPane.ERROR_MESSAGE);
        }

    }
    }

