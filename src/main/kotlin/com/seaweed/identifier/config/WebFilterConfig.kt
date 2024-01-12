package com.seaweed.identifier.config

import jakarta.servlet.Filter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebFilterConfig {

    @Bean
    fun loginFilter() : FilterRegistrationBean<Filter> {
        var filterRegistrationBean = FilterRegistrationBean<Filter>()
        filterRegistrationBean.filter = AuthFilter()
        filterRegistrationBean.order = 1;
        filterRegistrationBean.addUrlPatterns("/*")
        return filterRegistrationBean
    }
}