package cn.shianxian.supervise.sys.pojo;


import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "t_supervise")
public class SupervisePic extends Supervise {

    /**
     *  截图
     */
    @Column(name = "picTag")
    private String picTag;
}
