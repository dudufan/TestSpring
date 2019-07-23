package df.validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
 
public class PayRequestDto {
     
    /**
     * 支付完成时间
     **/
    @NotBlank(message="支付完成时间不能空")
    @Size(max=3,message="支付完成时间长度不能超过{max}位")
    private String payTime;

    @NotNull
    @Positive
    private Long uaId;

    public Long getUaId() {
        return uaId;
    }

    public void setUaId(Long uaId) {
        this.uaId = uaId;
    }

    public String getPayTime() {
        return payTime;
    }
 
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
 
}