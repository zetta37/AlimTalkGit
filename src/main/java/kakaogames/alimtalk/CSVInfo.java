package kakaogames.alimtalk;

/**
 * Created by mf839-005 on 2016. 7. 27..
 */


class CSVInfo {

    private String SENDER_KEY;
    private String CHANNEL;
    private String PHONE_NUM;
    private String TMPL_CD;
    private String SMS_SND_NUM;
    private String REQ_DTM;
    private String SMS_SND_YN;
    private String TRAN_STS;
    private String MEMBER_ID;
    private String COUPON_NO;
    private String SND_MSG;
    private String userid;
    private String pre_order_id;

    CSVInfo() {

    }

    //Getter
    /*
    public String getSENDER_KEY() {
        return SENDER_KEY;
    }
    public String getCHANNEL() {
        return CHANNEL;
    }
    public String getPHONE_NUM() {
        return PHONE_NUM;
    }
    public String getTMPL_CD() {
        return TMPL_CD;
    }
    public String getSMS_SND_NUM() {
        return SMS_SND_NUM;
    }
    public String getREQ_DTM() {
        return REQ_DTM;
    }
    public String getSMS_SND_YN() {
        return SMS_SND_YN;
    }
    public String getTRAN_STS() {
        return TRAN_STS;
    }
    public String getMEMBER_ID() {
        return MEMBER_ID;
    }
    public String getCOUPON_NO() {
        return COUPON_NO;
    }
    public String getSND_MSG() {
        return SND_MSG;
    }
    public String getUserid() {
        return userid;
    }
    public String getPre_order_id() {
        return pre_order_id;
    }
    */

    //Setter
    void setSENDER_KEY(String SENDER_KEY) {
        this.SENDER_KEY = SENDER_KEY;
    }
    void setCHANNEL(String CHANNEL) {
        this.CHANNEL = CHANNEL;
    }
    void setPHONE_NUM(String PHONE_NUM) {
        this.PHONE_NUM = PHONE_NUM;
    }
    void setTMPL_CD(String TMPL_CD) {
        this.TMPL_CD = TMPL_CD;
    }
    void setSMS_SND_NUM(String SMS_SND_NUM) {
        this.SMS_SND_NUM = SMS_SND_NUM;
    }
    void setREQ_DTM(String REQ_DTM) {
        this.REQ_DTM = REQ_DTM;
    }
    void setSMS_SND_YN(String SMS_SND_YN) {
        this.SMS_SND_YN = SMS_SND_YN;
    }
    void setTRAN_STS(String TRAN_STS) {
        this.TRAN_STS = TRAN_STS;
    }
    void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }
    void setCOUPON_NO(String COUPON_NO) {
        this.COUPON_NO = COUPON_NO;
    }
    void setSND_MSG(String SND_MSG) {
        this.SND_MSG = SND_MSG;
    }
    void setUserid(String userid) {
        this.userid = userid;
    }
    void setPre_order_id(String pre_order_id) {
        this.pre_order_id = pre_order_id;
    }

    String alimTalkColumnFormat() {
        setMEMBER_ID("MEMBER_ID");
        setCOUPON_NO("COUPON_NO");
        return (SENDER_KEY + ", " + CHANNEL + ", " + PHONE_NUM + ", " + TMPL_CD + ", " + SMS_SND_NUM
                + ", " + REQ_DTM + ", " + SMS_SND_YN + ", " + TRAN_STS + ", " + MEMBER_ID
                + ", " + COUPON_NO + ", " + SND_MSG);

    }

    String alimTalkDataFormat() {
        return ("'" + SENDER_KEY + "', '" + CHANNEL + "', '" + PHONE_NUM + "', '" + TMPL_CD
                + "', '" + SMS_SND_NUM + "', '" + REQ_DTM + "', '" + SMS_SND_YN + "', '"
                + TRAN_STS + "', '" + MEMBER_ID + "', '" + COUPON_NO + "', '" + SND_MSG + "'");
    }

    String preOrderColumnFormat() {
        setMEMBER_ID("memberid");
        setCOUPON_NO("coupon");
        return (pre_order_id + ", " + userid + ", " + COUPON_NO + ", " + MEMBER_ID);
    }

    String preOrderDataFormat() {
        return ("'" + pre_order_id + "', '" + userid + "', '" + COUPON_NO + "', '" + MEMBER_ID+"'");
    }
}
