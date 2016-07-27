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

        final ConnectionInfo preOrderServer
                = new ConnectionInfo("jdbc:mysql://10.30.143.54", "gametest", "gametestpw");
        final ConnectionInfo alimTalkServer
                = new ConnectionInfo("jdbc:mysql://10.28.162.153", "cuser", "cuserpw");
        Connection alimConn;
        Connection preOrderConn;
        ResultSet rs;
        String csvFileDirectory;
        CSVConverter cvt;

        try {
//            cvt = new CSVConverter(args[0]);
            cvt = new CSVConverter("/Users/mf839-005/Desktop/workspace/AlimTalk/csvTestFile.csv");


            alimConn = DriverManager.getConnection( alimTalkServer.getIP(),
                                                    alimTalkServer.getID(),
                                                    alimTalkServer.getPwd());


            preOrderConn = DriverManager.getConnection( preOrderServer.getIP(),
                                                        preOrderServer.getID(),
                                                        preOrderServer.getPwd());

            java.sql.Statement state = alimConn.createStatement();
            cvt.queryProcessor(state, "alimTalkServer");

            state = preOrderConn.createStatement();
            cvt.queryProcessor(state, "preOrderServer");


        } catch (SQLException sqlExpt) {
            System.out.println("** FAILURE: SQLException --  " + sqlExpt.getMessage());
            System.out.println("            SQLState: " + sqlExpt.getSQLState());
        }
    }
}
