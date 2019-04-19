package cn.shianxian.supervise.config.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 赵明明
 * @Date: 2018/11/2 10:13
 * @Description: springMVC配置
 */
@SpringBootConfiguration
@Slf4j
public class MySpringMVCConfig implements WebMvcConfigurer {


    /**
     * 请求参数时间格式化
     * @return
     */
    @Bean
    public Converter<String, Date> addNewConvert() {

        return new Converter<String, Date>() {

            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (ParseException e) {
                    log.error("字符串转时间格式化错误：{}", e.getMessage(), e);
                }
                return date;
            }
        };
    }

}
