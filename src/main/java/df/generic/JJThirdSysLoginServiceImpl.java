package df.generic;

//@Service
public class JJThirdSysLoginServiceImpl implements ThirdSysLoginService<BjLoginParams> {

 @Override
 public Login3rdSystemResult login(BjLoginParams loginParams) {
  System.out.println("BjLoginIfaceImpl " + loginParams.getUaId());
  return new Login3rdSystemResult(1,1,true);
 }

}
