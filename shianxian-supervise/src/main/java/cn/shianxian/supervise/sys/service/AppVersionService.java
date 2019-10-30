package cn.shianxian.supervise.sys.service;



public interface AppVersionService {

    /**
     * 查询app版本号,返回更新路径
     */
    String selectAppVersion();

    /**
     * 查询AppPad版本号,返回更新路径
     * @return
     */
    String selectAppPadVersion();
}
