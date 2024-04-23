package etc;

import java.sql.*;




public class MySQL{

    // SINGLETON

    private static MySQL instance = null;

    public static MySQL getInstance(){

        if(instance == null){
            instance = new MySQL();
        }

        return instance;
    }



    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.151:3306/vmapp";
    public static String USER = "rootDB";
    public static String PASS = "";
    static private Connection conex ;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData meta;

    private MySQL() {


    }

    public void waitForConnection(){
       while (conex == null){
           try {
               System.out.println("Esperando conexión");
               Thread.sleep(3000);

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }



    public boolean conectar() {

        try {

            System.out.println("En el try de conectar()");

            Class.forName(JDBC_DRIVER);

            System.out.println("Conectando a la base de datos... Driver Get Connection");

            conex = DriverManager.getConnection(DB_URL, USER, PASS);

            return true;


        } catch (Exception e) {
            //Handle errors for Class.forName

            System.out.println("Error en la conexión");

            e.printStackTrace();



        }

        return false;

    }



    public Connection getConex() {
        return conex;
    }

    public void cierra_conexion() {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void cierraSentencia(){
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void cierraResultSet(){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public  boolean ejecutaConsulta(String sql) {
        try {
//            SI EL CONTENIDO DEL RESULTSET NO SE VA A MODIFICAR
//            stmt = conex.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

//            SI EL CONTENIDO DEL RESULTSET SE VA A MODIFICAR
//            stmt = conex.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt = conex.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            meta = rs.getMetaData();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }

    }

    // Usamos el siguiente método para ejecutar las consultas de tipo acción,
    // es decir, INSERT, UPDATE o DELETE
    // Devuelve el número de filas afectadas por la sentencia

    public static int ejecutaConsultaAccion(String sql) {

        try {

            Statement stmt = conex.createStatement();
            int filas = 0;

            filas = stmt.executeUpdate(sql);
            return filas;

        } catch (SQLException se) {
            se.printStackTrace();
            return -1;
        }

    }

    public  void seleccionaBD(String baseDatos) {
        String queryUse = "use " + baseDatos;
        try {
//            stmt = conex.createStatement();
            stmt.executeUpdate(queryUse);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }



}
