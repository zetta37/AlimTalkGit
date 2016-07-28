

/**
 * Created by mf839-005 on 2016. 7. 26..
 */

package kakaogames.alimtalk;

import java.util.ArrayList;

class AlimInfo {

    /*
    private String phoneNum;
    private int memberID;
    private String couponNum;
    private String msg;
    */

    private ArrayList<Object> info;

    AlimInfo(){
        info = new ArrayList<Object>();
    }

    void addInfo(Object obj){
        info.add(obj);
    }

    Object getInfo(){
        return info.remove(0);
    }

    /*
    public kakaogames.alimtalk.AlimInfo(String phoneNum, int memberID, String couponNum, String msg){
        this.phoneNum = phoneNum;
        this.memberID = memberID;
        this.couponNum = couponNum;
        this.msg = msg;
    }
    */

    /*
    //Getter
    public String getPhoneNum() { return phoneNum; }
    public int getMemberID() { return memberID; }
    public String getCouponNum() { return couponNum; }
    public String getMsg() { return msg; }

    //Setter
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setMemberID(int memberID) { this.memberID = memberID; }
    public void setCouponNum(String couponNum) { this.couponNum = couponNum; }
    public void setMsg(String msg) { this.msg = msg; }
    */
}
