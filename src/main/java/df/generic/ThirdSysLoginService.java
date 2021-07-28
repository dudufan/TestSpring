package df.generic;

/**
 * 和其他系统登录并同步用户信息的接口
 */
public interface ThirdSysLoginService<T> {
 /**
  * 登录第三方系统
  */
 Login3rdSystemResult login(T loginParams);
}
