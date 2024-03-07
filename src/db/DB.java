package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    //Connection - objeto de conexão com banco de dados do jdbc
    // conectar a um banco de dados jdbc é instanciar um objeto do tipo Connection
    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();
                // procura a propriedade com o nome do parâmetro
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            //load -> faz a leitura do arquivo properties apontado pelo fs
            props.load(fs);
            return props;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st){
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

}
