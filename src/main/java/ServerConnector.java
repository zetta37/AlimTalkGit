/**
 * Created by mf839-005 on 2016. 7. 26..
 */

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerConnector {

    public static void main(String[] args){

        //final String driver = "org.mariadb.jdbc.Driver";
        final ConnectingInfo earlyBirdServer
                = new ConnectingInfo("jdbc:mysql://10.30.143.54", "gametest", "gametestpw");
        final ConnectingInfo alimTalkServer
                = new ConnectingInfo("jdbc:mysql://10.28.162.153", "cuser", "cuserpw");
        Connection dbConn = null;
        File csvFile;

        try {

            //Class.forName(driver);

            dbConn = DriverManager.getConnection(alimTalkServer.getIP(),
                                                 alimTalkServer.getID(),
                                                 alimTalkServer.getPwd());

            //dbConn = DriverManager.getConnection(earlyBirdServer.getIP(),
            //                                     earlyBirdServer.getID(),
            //                                     earlyBirdServer.getPwd());
            java.sql.Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery("SHOW databases");

            if (st.execute("SHOW databases")){
                rs= st.getResultSet();
            }

            while (rs.next()){
                //String
                String str = rs.getString(1);
                System.out.println(str);
            }

        } catch (SQLException sqlExpt){
            System.out.println("** FAILURE: SQLException --  " + sqlExpt.getMessage());
            //System.out.println("SQLState: "+ sqlExpt.getSQLState());
        }
        /*catch (ClassNotFoundException cnfExpt){
            System.out.println("** FAILURE: ClassNotFoundException -- Driver Loading");
        }*/

    }
}
