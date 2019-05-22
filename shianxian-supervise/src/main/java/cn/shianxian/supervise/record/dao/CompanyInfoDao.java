package cn.shianxian.supervise.record.dao;

import cn.shianxian.supervise.record.pojo.CompanyInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CompanyInfoDao extends Mapper<CompanyInfo> {
}
