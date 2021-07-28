package df.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BjLoginService {
// @Autowired
 ThirdSysLoginService thirdSysLoginService;

 @Autowired
 public void setThirdSysLoginService(ThirdSysLoginService thirdSysLoginService){
  System.out.println("wired thirdSysLoginService");
   this.thirdSysLoginService = thirdSysLoginService;
 }


 public void login() {
  BjLoginParams loginParams = new BjLoginParams("BjUser1", 12L);
  Login3rdSystemResult ret = thirdSysLoginService.login(loginParams);
  System.out.println("BjLoginService " + ret.isNeedLoginYQT());
 }

}
