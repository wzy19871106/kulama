package cn.shianxian.supersive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.shianxian.supervise.*.dao"})
@ComponentScan(basePackages = {"cn.shianxian"})
public class SuperviseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuperviseApplication.class, args);
    }
}
