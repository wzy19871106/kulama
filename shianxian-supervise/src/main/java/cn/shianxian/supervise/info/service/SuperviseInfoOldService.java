package cn.shianxian.supervise.info.service;

import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SuperviseInfoOldService {

    /**
     * 导入线下监管信息导入线下监管信息
     */
    ResponseEntity<Result> importSuperviseInfoOld(MultipartFile file) throws IOException;


    /**
     * selectSuperviseInfoOld
     * @param queryPojo
     * @param pages
     * @return
     */
    Result selectSuperviseInfoOld(QueryPojo queryPojo, Pages pages);
}
