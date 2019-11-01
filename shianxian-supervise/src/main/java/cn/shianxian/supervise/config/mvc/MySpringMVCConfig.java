package cn.shianxian.supervise.config.mvc;

import cn.shianxian.supervise.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: 赵明明
 * @Date: 2018/11/2 10:13
 * @Description: springMVC配置
 */
@SpringBootConfiguration
@Slf4j
public class MySpringMVCConfig implements WebMvcConfigurer {


    @Autowired
    private LoginInterceptor loginInterceptor;


    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/druid/**")
                .excludePathPatterns("/app/login")
                .excludePathPatterns("/login")
                .excludePathPatterns("/upload/img")
                .excludePathPatterns("/upload/imgs")
                .excludePathPatterns("/version/selectAppVersionById")
                .excludePathPatterns("/version/selectAppPadVersion")
                .excludePathPatterns("/app/KhSelect/selectCustomerInfoByNameAndPass")
                .excludePathPatterns("/app/JhSelect/selectPurchaseDmByjhkhdm")
                .excludePathPatterns("/app/JhSelect/selectPurchaseInfoByjhdm")
                .excludePathPatterns("/app/XsInfo/XsInsert")
                .excludePathPatterns("/app/XsInfo/XsSelect")
                .excludePathPatterns("/app/XsInfo/XsUpdate")
                .excludePathPatterns("/app/XsInfo/XsCheck")
                .excludePathPatterns("/app/XsInfo/XsSelectIfExist")
                .excludePathPatterns("/app/XsInfo/XsGoodsSelect")
                .excludePathPatterns("/app/XsInfo/XCSelect")
                // swagger2页面
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/error/");
    }

}
