package cn.shianxian.supervise.tibetan.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.pojo.Khda;

public interface KhdaService {
    /**
     * 根据客户登录名和密码查询
     * @param khda
     * @return
     */
    Result selectCustomerInfoByNameAndPass(Khda khda);
}
