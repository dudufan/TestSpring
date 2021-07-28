package df.tomcat;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
public class CheckReq {
    @NotEmpty(message = "日期格式不正确")
    private String startTime;

    public void setStartTime(String startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            sdf.parse(startTime);
            this.startTime = startTime;
        } catch (ParseException e) {
            e.printStackTrace();
            this.startTime = null;
        }
    }
}
