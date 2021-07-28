package df.generic;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BjThirdSysLoginServiceImpl implements ThirdSysLoginService<BjLoginParams> {

 @Override
 public Login3rdSystemResult login(BjLoginParams loginParams) {
  System.out.println("BjLoginIfaceImpl " + loginParams.getUaId());
  return new Login3rdSystemResult(1,1,true);
 }

 public static void main(String[] args) {
  byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
//  allocation1 = new byte[32000*1024*20];
  allocation2 = new byte[1000*1024];
  allocation3 = new byte[1000*1024];
  allocation4 = new byte[1000*1024];
  allocation5 = new byte[1000*1024];
 }

}
