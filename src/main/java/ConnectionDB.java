
import java.sql.*;


public class ConnectionDB {


    static final String USER = "sa";
    static final String PASS = "";

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    public void connect(String name , String sname , String fname)throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;

            // STEP 1: Register JDBC driver
            Class.forName(ConnectionDB.JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(ConnectionDB.DB_URL, USER, PASS);
            conn.setAutoCommit(false);
            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

        String sql = "truncate table REGISTRATION";

        stmt.executeUpdate(sql);

        System.out.println("database...");

        sql = "truncate table USERS";

        stmt.executeUpdate(sql);

        Savepoint savepointOne = conn.setSavepoint("SavepointOne");

        try
        {
            sql = "INSERT INTO  REGISTRATION (ID,FIRST, LAST,FATHER )" +
                    "VALUES(?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "1");
            pst.setString(2, name);
            pst.setString(3, sname);
            pst.setString(4, fname);
            pst.addBatch();
            System.out.println("1Created table in given database...");
            pst.executeBatch();

            //STEP 3: Execute a query
            System.out.println("2Creating table in given database...");
            sql = "ISERT INTO  USERS (ID,FIRST, LAST,FATHER )" +
                    "VALUES(?,?,?,?)";

            PreparedStatement pstu = conn.prepareStatement(sql);

            pstu.setString(1, "1");
            pstu.setString(2, name);
            pstu.setString(3, sname);
            pstu.setString(4, fname);
            pstu.addBatch();
            System.out.println("Created table in given database...");
            pstu.executeBatch();
            // STEP 4: Clean-up environment
            conn.commit();
        }
        catch(SQLException se) {
            if (conn != null) {
                try {
                    System.out.print("Transaction is being rolled back");
                    conn.rollback(savepointOne);
                } catch (SQLException e) {}
            }
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                conn.setAutoCommit(true);
            }
            catch(SQLException e){}
        }

        System.out.println("Goodbye!");
        } //end try
    }
