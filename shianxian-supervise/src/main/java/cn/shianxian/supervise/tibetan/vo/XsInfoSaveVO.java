package cn.shianxian.supervise.tibetan.vo;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class XsInfoSaveVO implements Serializable {

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

    /**
     * 销售上家编码
     */
    private String xssjdm;
}
