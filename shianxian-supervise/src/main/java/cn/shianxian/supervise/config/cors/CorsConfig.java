package cn.shianxian.supervise.config.cors;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;


/**
 * 跨域设置
 */
@SpringBootConfiguration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        // 允许cookies跨域
        config.setAllowCredentials(true);
        // 允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        List<String> list = new ArrayList<>();
        // 本地测试
//        list.add("http://127.0.0.1:8083");
//        list.add("http://127.0.0.1:9998/");
//        list.add("http://139.224.118.134:9998/");
//        list.add("https://supervise.dev.shianxian.cn");
//        list.add("http://supervise.dev.shianxian.cn");
//        list.add("https://supervise.test.shianxian.cn");
//        list.add("http://supervise.test.shianxian.cn");
//        config.setAllowedOrigins(list);
        config.addAllowedOrigin("*");
        // 允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        // 允许提交请求的方法，*表示全部允许
        config.addAllowedMethod("*");
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(18000L);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}