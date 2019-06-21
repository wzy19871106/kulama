package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.IndustryDao;
import cn.shianxian.supervise.sys.pojo.Industry;
import cn.shianxian.supervise.sys.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {


    @Autowired
    private IndustryDao industryDao;


    @Override
    public Result selectIndustry() {
        List<Industry> industries = this.industryDao.selectIndustry();
        return Result.data(industries);
    }
}
