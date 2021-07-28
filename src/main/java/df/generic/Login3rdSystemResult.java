package df.generic;

import java.io.Serializable;


/**
 * 第三方系统登录返回值
 */
public class Login3rdSystemResult implements Serializable {
    private static final long serialVersionUID = 6748866867304371690L;

    /**
     * 是否为银企通用户
     */
    private int isYqtUser;

    /**
     * 是否为第三方系统用户
     */
    private int is3rdUser;

    /**
     * 是否需要登录银企通系统
     */
    private boolean isNeedLoginYQT;

    /**
     * 用户UAID
     */
    private Long uaId;

    public Login3rdSystemResult() {

    }

    public Login3rdSystemResult(int isYqtUser, int is3rdUser, boolean isNeedLoginYQT) {
        this.isYqtUser = isYqtUser;
        this.is3rdUser = is3rdUser;
        this.isNeedLoginYQT = isNeedLoginYQT;
    }
    public Login3rdSystemResult(int isYqtUser, int is3rdUser, boolean isNeedLoginYQT, String userNo) {
        this.isYqtUser = isYqtUser;
        this.is3rdUser = is3rdUser;
        this.isNeedLoginYQT = isNeedLoginYQT;
    }
    public Login3rdSystemResult(int isYqtUser, int is3rdUser, boolean isNeedLoginYQT, String userNo, Long uaId) {
        this.isYqtUser = isYqtUser;
        this.is3rdUser = is3rdUser;
        this.isNeedLoginYQT = isNeedLoginYQT;
        this.uaId = uaId;
    }

    public int getIsYqtUser() {
        return isYqtUser;
    }

    public void setIsYqtUser(int isYqtUser) {
        this.isYqtUser = isYqtUser;
    }

    public int getIs3rdUser() {
        return is3rdUser;
    }

    public void setIs3rdUser(int is3rdUser) {
        this.is3rdUser = is3rdUser;
    }

    public boolean isNeedLoginYQT() {
        return isNeedLoginYQT;
    }

    public void setNeedLoginYQT(boolean needLoginYQT) {
        isNeedLoginYQT = needLoginYQT;
    }

	public Long getUaId() {
		return uaId;
	}

	public void setUaId(Long uaId) {
		this.uaId = uaId;
	}
}
