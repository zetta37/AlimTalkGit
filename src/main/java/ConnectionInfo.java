/**
 * Created by mf839-005 on 2016. 7. 26..
 */
public class ConnectionInfo {

    private String ipAddr;
    private String usrID;
    private String usrPwd;

    public ConnectionInfo(String ip, String id, String pwd) {
        this.ipAddr = ip;
        this.usrID = id;
        this.usrPwd = pwd;
    }

    public String getIP() { return ipAddr; }
    public String getID() { return usrID; }
    public String getPwd() { return usrPwd; }
}
