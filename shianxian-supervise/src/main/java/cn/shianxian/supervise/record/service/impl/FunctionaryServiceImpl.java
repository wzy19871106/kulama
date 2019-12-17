package cn.shianxian.supervise.record.service.impl;

import cn.shianxian.supervise.common.constants.Constants;
import cn.shianxian.supervise.common.pojo.Pages;
import cn.shianxian.supervise.common.pojo.QueryPojo;
import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.common.service.RedisService;
import cn.shianxian.supervise.common.utils.UUIDGenerator;
import cn.shianxian.supervise.record.dao.FunctionaryDao;
import cn.shianxian.supervise.record.dao.FunctionaryForaduitDao;
import cn.shianxian.supervise.record.pojo.Functionary;
import cn.shianxian.supervise.record.pojo.FunctionaryForaduit;
import cn.shianxian.supervise.record.service.FunctionaryService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static cn.shianxian.supervise.common.constants.Constants.PIC_FACE;
import static cn.shianxian.supervise.common.constants.Constants.PIC_ID_FONT;

@Service
@Slf4j
public class FunctionaryServiceImpl implements FunctionaryService {


    @Autowired
    private FunctionaryForaduitDao functionaryForaduitDao;


    @Autowired
    private FunctionaryDao functionaryDao;


    @Autowired
    private RedisService redisService;


    @Value("${upload.url}")
    private String uploadUrl;


    @Value("${upload.imgPath}")
    private String imgPath;


    @Override
    public ResponseEntity<Result> appLogin(String id) {
        Functionary functionary = new Functionary();
        functionary.setWeChatId(id);
        List<Functionary> functionaryList = this.functionaryDao.select(functionary);
        if (1 == functionaryList.size()) {
            functionary = functionaryList.get(0);
            log.info("app用户登录：{}", functionary);
        } else {
            functionary.setKeyUsed(0);
        }
        String token = UUIDGenerator.generatorUUID();
        this.redisService.set(Constants.APP_USER + token, JSON.toJSONString(functionary), 14400);
        functionary.setToken(token);
        return ResponseEntity.ok(Result.data(functionary));
    }


    @Transactional
    @Override
    public ResponseEntity<Result> saveFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        String functionaryTag = functionaryForaduit.getFunctionaryTag();
        if (StringUtils.isNotBlank(functionaryTag)) {
            Example e = new Example(FunctionaryForaduit.class);
            Example.Criteria c = e.createCriteria();
            c.andEqualTo("functionaryTag", functionaryTag);
            c.andNotEqualTo("aduitType",0);
            Integer num = functionaryForaduitDao.selectCountByExample(e);
            if (num > 0){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("申请已提交，请勿重复提交！"));
            }
        }
        String flag = this.functionaryForaduitDao.saveFunctionaryForaduit(functionaryForaduit);
        if ("A002".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("该企业的负责人身份证已存在！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> updateFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        this.functionaryForaduitDao.updateFunctionaryForaduit(functionaryForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> checkFunctionaryForaduit(String index) {
        this.functionaryForaduitDao.checkFunctionaryForaduit(index);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Transactional
    @Override
    public ResponseEntity<Result> backFunctionaryForaduit(FunctionaryForaduit functionaryForaduit) {
        this.functionaryForaduitDao.backFunctionaryForaduit(functionaryForaduit);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryForaduitByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.functionaryForaduitDao.selectFunctionaryForaduitByLike(queryPojo, pages);
        return ResponseEntity.ok(Result.data((Long) list.get(2).get(0), list.get(0)));
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryForaduitByNodeTag(String nodeTag, Pages pages) {
        List<List<?>> list = this.functionaryForaduitDao.selectFunctionaryForaduitByNodeTag(nodeTag, pages);
        return ResponseEntity.ok(Result.data((Long) list.get(2).get(0), list.get(0)));
    }


    @Override
    public ResponseEntity<Result> deleteFunctionaryForaduit(String id) {
        String flag = this.functionaryForaduitDao.deleteFunctionaryForaduit(id);
        if ("R003".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("拒绝删除申请！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryByLike(QueryPojo queryPojo, Pages pages) {
        List<List<?>> list = this.functionaryDao.selectFunctionaryByLike(queryPojo, pages);
        return ResponseEntity.ok(Result.data((Long) list.get(2).get(0), list.get(0)));
    }


    @Override
    public ResponseEntity<Result> selectFunctionary(Functionary functionary) {
        if (StringUtils.isNotBlank(functionary.getFunctionaryTag())) {
            functionary = this.functionaryDao.selectFunctionaryByFunctionaryTag(functionary.getFunctionaryTag());
        } else if (null != functionary.getWeChatId()) {
            functionary = this.functionaryDao.selectFunctionaryByWeChatId(functionary.getWeChatId());
        }
        return ResponseEntity.ok(Result.data(functionary));
    }

    @Override
    public ResponseEntity<Result> selectFunctionaryBackUp(Functionary functionary) {
        if (StringUtils.isNotBlank(functionary.getFunctionaryTag())) {
            functionary = this.functionaryDao.selectFunctionaryBackUpByFunctionaryTag(functionary.getFunctionaryTag());
            functionary = setPics(functionary);
        } else if (null != functionary.getWeChatId()) {
            functionary = this.functionaryDao.selectFunctionaryBackUpByWeChatId(functionary.getWeChatId());
            functionary = setPics(functionary);
        }
        return ResponseEntity.ok(Result.data(functionary));
    }

    /**
     * 给负责人添加各种图片
     * @param functionary
     * @return
     */
    private Functionary setPics(Functionary functionary){
        String picTag = functionary.getPicTag();
        if (StringUtils.isNotBlank(picTag))
        {
            String[] pics = picTag.split(",");
            for (String pic : pics) {
                String[] picInfo = pic.split(":");
                String picName = picInfo[0];
                String picAddr = uploadUrl + imgPath + picInfo[1];
                if(PIC_FACE.equals(picName)){
                    functionary.setFacePic(picAddr);
                } else if(PIC_ID_FONT.equals(picName)) {
                    functionary.setIdFont(picAddr);
                } else{
                    functionary.setIdReverse(picAddr);
                }
            }
        }
        return functionary;
    }

    @Transactional
    @Override
    public ResponseEntity<Result> deleteFunctionary(String index) {
        String flag = this.functionaryDao.deleteFunctionary(index);
        if ("R003".equals(flag)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Result.msg("不允许删除！"));
        }
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> saveFunctionary(Functionary functionary) {
        this.functionaryDao.saveFunctionary(functionary);
        return ResponseEntity.ok(Result.successMsg());
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryForaduitByIndex(Long index) {
        List<FunctionaryForaduit> list = this.functionaryForaduitDao.selectFunctionaryForaduitByIndex(index);
        return ResponseEntity.ok(Result.data(list));
    }


    @Override
    public ResponseEntity<Result> selectFunctionaryByNodeTag(String nodeTag, Pages pages) {
        List<List<?>> list = this.functionaryDao.selectFunctionaryByNodeTag(nodeTag, pages);
        return ResponseEntity.ok(Result.data((Long) list.get(2).get(0), list.get(0)));
    }


    @Override
    public ResponseEntity<Result> updateWeChatIdById(String functionaryTag, String weChatId, String picTag) {
        this.functionaryDao.updateWeChatIdById(functionaryTag, weChatId, picTag);
        return ResponseEntity.ok(Result.successMsg());
    }
}
