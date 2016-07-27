/**
 * Created by mf839-005 on 2016. 7. 26..
 */

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CSVConverter {

    private File csvFile;
    private ArrayList<CSVInfo> csvTable;

    public CSVConverter(String filePath) {

        try {

            this.csvFile = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(this.csvFile));
            String str = "";
            String[] token = null;
            this.csvTable = new ArrayList<CSVInfo>();
            CSVInfo csvData;

            while ((str = br.readLine()) != null){

                csvData = new CSVInfo();
                token = str.split(",");
//                System.out.println("\nTOKEN LENGTH: " + token.length);
//
//                for (int i=0; i<token.length; i++){
//                    System.out.print(token[i].toString()+ "    ");
//
//                }

                for (int i=0; i<token.length; i++){

                    switch(i){
                        case 1:
                            csvData.setSENDER_KEY(token[0].toString());
                        case 2:
                            csvData.setCHANNEL(token[1].toString());
                        case 3:
                            csvData.setPHONE_NUM(token[2].toString());
                        case 4:
                            csvData.setTMPL_CD(token[3].toString());
                        case 5:
                            csvData.setSMS_SND_NUM(token[4].toString());
                        case 6:
                            csvData.setREQ_DTM(token[5].toString());
                        case 7:
                            csvData.setSMS_SND_YN(token[6].toString());
                        case 8:
                            csvData.setTRAN_STS(token[7].toString());
                        case 9:
                            csvData.setMEMBER_ID(token[8].toString());
                        case 10:
                            csvData.setCOUPON_NO(token[9].toString());
                        case 11:
                            csvData.setSND_MSG(token[10].toString());
                        case 12:
                            csvData.setUserid(token[11].toString());
                        case 13:
                            csvData.setPre_order_id(token[12].toString());
                        default:
                    }
                }

                System.out.println(csvData.getCHANNEL());
                csvTable.add(csvData);
            }

        } catch (IOException ioExpt){
            System.out.println("** Failure -- File/Directroy Not Found");
        }

    }

    public void queryProcessor(java.sql.Statement st, String dbName) {

        String columns;
        String data;

        if(dbName.equals("alimTalkServer")) {
            try {

                columns = csvTable.get(0).alimTalkColumnFormat();

                st.addBatch("use test");

                for (int i = 1; i<csvTable.size(); i++){
                    data = csvTable.get(i).alimTalkDataFormat();
                    st.addBatch("insert into Test_Alim1 (" + columns + ") values (" + data + ")");
                }
                st.executeBatch();
                st.clearBatch();

            } catch (SQLException sqlExpt) {
                System.out.println("** FAILURE: SQLException --  " + sqlExpt.getMessage());
                System.out.println("            SQLState: " + sqlExpt.getSQLState());
            }

        } else if (dbName.equals("preOrderServer")) {
            try {

                columns = csvTable.get(0).preOrderColumnFormat();

                st.addBatch("use test");

                for (int i = 1; i<csvTable.size(); i++){
                    data = csvTable.get(i).preOrderDataFormat();
                    st.addBatch("insert into Test_PreOrder (" + columns + ") values (" + data + ")");
                }
                st.executeBatch();
                st.clearBatch();

            } catch (SQLException sqlExpt) {
                System.out.println("** FAILURE: SQLException --  " + sqlExpt.getMessage());
                System.out.println("            SQLState: " + sqlExpt.getSQLState());
            }

        } else {
            System.out.println("    ERROR: Unsupported Query Processing");
        }
    }
}
