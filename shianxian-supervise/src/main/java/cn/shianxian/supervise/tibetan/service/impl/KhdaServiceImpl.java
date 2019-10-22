package cn.shianxian.supervise.tibetan.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.tibetan.dao.KhdaDao;
import cn.shianxian.supervise.tibetan.pojo.Khda;
import cn.shianxian.supervise.tibetan.service.KhdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhdaServiceImpl implements KhdaService {

    @Autowired
    private KhdaDao khdaDao;

    @Override
    public Result selectCustomerInfoByNameAndPass(Khda khda) {
        Khda khda1 = this.khdaDao.selectCustomerInfo(khda);
        if (khda1 != null) {
            return Result.data(khda1);
        }
        return Result.msg("登录失败");
    }
}
