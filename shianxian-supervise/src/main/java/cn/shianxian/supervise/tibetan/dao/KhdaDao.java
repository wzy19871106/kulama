package cn.shianxian.supervise.tibetan.dao;

import cn.shianxian.supervise.tibetan.pojo.Khda;
import org.springframework.stereotype.Repository;

@Repository
public interface KhdaDao {

    /**
     * 根据客户登录名和密码查询
     */
    Khda selectCustomerInfo(Khda khda);
}
