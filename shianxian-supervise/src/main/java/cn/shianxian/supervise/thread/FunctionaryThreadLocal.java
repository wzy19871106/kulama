package cn.shianxian.supervise.thread;

import cn.shianxian.supervise.record.pojo.Functionary;

/**
 * @Auther: 赵明明
 * @Description: 企业负责人本地线程
 */
public class FunctionaryThreadLocal {


    // 本地线程，存放登录用户信息
    private static ThreadLocal<Functionary> functionaryThreadLocal = new ThreadLocal<>();


    /**
     * 储存企业负责人
     * @param functionary
     */
    public static void setFunctionary(Functionary functionary) {
        functionaryThreadLocal.set(functionary);
    }


    /**
     * 获取企业负责人
     */
    public static Functionary getFunctionary() {
        return functionaryThreadLocal.get();
    }

}
