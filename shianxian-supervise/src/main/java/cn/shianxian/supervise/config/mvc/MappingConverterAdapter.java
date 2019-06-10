package cn.shianxian.supervise.config.mvc;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 转换解析器
 *
 * @author wangqingguo 2017/9/25
 */
@SpringBootConfiguration
@Slf4j
public class MappingConverterAdapter {

    /**
     * 接收前端datetime参数
     *
     * @return
     */
    @Bean
    public Converter<String, LocalDateTime> LocalDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                LocalDateTime date = null;
                DateTimeFormatter df = null;
                if (source.indexOf(":") != -1) {
                    df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    try {
                        date = LocalDateTime.parse(source, df);
                    } catch (Exception e) {
                        log.error("LocalDateTime时间参数格式化错误，{}，信息：{}", e, e.getMessage());
                    }
                } else {
                    df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    try {
                        LocalDate localDate = LocalDate.parse(source, df);
                        date = localDate.atStartOfDay();
                    } catch (Exception e) {
                        log.error("localDate时间参数格式化错误，{}，信息：{}", e, e.getMessage());
                    }
                }
                return date;
            }
        };
    }


    /**
     * 返回LocalDateTime值（去掉LocalDateTime中的T）
     */
    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String pattern;


    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
    }

}