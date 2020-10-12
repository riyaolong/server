package com.xlzhou.server.config;

import com.xlzhou.server.service.IService;
import com.xlzhou.server.service.impl.MyService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author 世界和平
 * @data2019-12-17 13:34
 **/
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean disServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/bywz/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public IService myService() {
        return new MyService();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), myService());//绑定要发布的服务
        endpoint.publish("/iserver"); //显示要发布的名称
        return endpoint;
    }


}
