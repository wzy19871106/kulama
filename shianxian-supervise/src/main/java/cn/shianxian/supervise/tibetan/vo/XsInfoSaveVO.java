package cn.shianxian.supervise.tibetan.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class XsInfoSaveVO {

    /**
     * 销售信息
     */
    private List<XsInfoVO> xsInfoVO;

    /**
     * 支付方式编码
     */
    private String xspaydm;

    /**
     * 支付方式
     */
    private String xspaymc;
}
