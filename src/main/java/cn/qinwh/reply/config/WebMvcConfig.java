package cn.qinwh.reply.config;

import cn.qinwh.reply.controller.converter.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: reply
 * @description: MVC配置类
 * @author: qinwh
 * @create: 2020-04-27 05:59
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置全局日期转换器
     */
    @Bean
    @Autowired
    public ConversionService getConversionService(DateConverter dateConverter){
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(dateConverter);
        factoryBean.setConverters(converters);
        return factoryBean.getObject();
    }
}
