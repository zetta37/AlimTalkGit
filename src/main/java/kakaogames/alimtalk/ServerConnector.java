

/**
 * Created by mf839-005 on 2016. 7. 26..
 */

package kakaogames.alimtalk;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ServerConnector {

    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        Connection conn;
        CSVConverter cvt;

        System.out.println( "   =========================================" +
                          "\n    AlimTalk Module v.1.0.0               "+
                          "\n    KakaoGamesCorp                        "+
                          "\n    PC Platform Dev. Team                 "+
                          "\n   =========================================");

        System.out.println();
        System.out.print("Enter \"사전알림신청내역\" Server Connection Info (SYNTAX: url id pw)\n    -> ");
        String input = userInput.nextLine();
        String[] serverInfo = input.split(" ");

        final ConnectionInfo preOrderServer
                  = new ConnectionInfo("jdbc:mysql://"+serverInfo[0], serverInfo[1], serverInfo[2]);

        System.out.print("Enter \"알림톡\" Server Connection Info (SYNTAX: url id pw)\n    -> ");
        input = userInput.nextLine();
        serverInfo = input.split(" ");

        final ConnectionInfo alimTalkServer
                 = new ConnectionInfo("jdbc:mysql://"+serverInfo[0], serverInfo[1], serverInfo[2]);

        try {

            cvt = new CSVConverter(new File (System.getProperty("user.dir") + "/csvTestFile.csv"));

            // 사전알림신청내역 연결 및 쿼리 INSERT
            conn = DriverManager.getConnection( preOrderServer.getIP(),
                                                        preOrderServer.getID(),
                                                        preOrderServer.getPwd());
            System.out.println("# CONNECTED: 사전알림신청내역 Server");

            java.sql.Statement state = conn.createStatement();
            cvt.queryProcessor(state, "preOrderServer");
            System.out.println("# COMPLETE: 사전알림신청내역 Server Query INSERT");

            // 알림톡 연결 및 쿼리 INSERT
            conn = DriverManager.getConnection( alimTalkServer.getIP(),
                                                    alimTalkServer.getID(),
                                                    alimTalkServer.getPwd());
            System.out.println("# CONNECTED: 알림톡 Server");
            state = conn.createStatement();
            cvt.queryProcessor(state, "alimTalkServer");
            System.out.println("# COMPLETE: 사전알림신청내역 Server Query INSERT");

            System.out.println("\nTerminating Process... Bye");


        } catch (SQLException sqlExpt) {
            System.out.println("** FAILURE: SQLException --  " + sqlExpt.getMessage());
            System.out.println("            SQLState: " + sqlExpt.getSQLState());
        }
    }
}
