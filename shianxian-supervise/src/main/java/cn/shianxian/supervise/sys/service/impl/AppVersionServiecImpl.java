package cn.shianxian.supervise.sys.service.impl;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dao.AppVersionDao;
import cn.shianxian.supervise.sys.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppVersionServiecImpl implements AppVersionService {

    @Autowired
    private AppVersionDao appVersionDao;


    @Override
    public Result selectAppVersion() {
        String version = this.appVersionDao.selectAppVersion();
        return Result.data(version);
    }
}
