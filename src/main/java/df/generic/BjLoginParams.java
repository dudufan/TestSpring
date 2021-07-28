package df.generic;

import java.io.Serializable;


/**
 * 第三方系统登录返回值
 */
public class BjLoginParams implements Serializable {
    private static final long serialVersionUID = 6748866867304371690L;

    /**
     * 三方用户唯一标识
     */
    private String userNo;
    /**
     * 用户UAID
     */
    private Long uaId;

    public BjLoginParams() {

    }

    public BjLoginParams(String userNo, Long uaId) {
        this.userNo = userNo;
        this.uaId = uaId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Long getUaId() {
        return uaId;
    }

    public void setUaId(Long uaId) {
        this.uaId = uaId;
    }
}
