package com.hcl.coe.api.cms.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.hcl.coe.api.cms.model.ObjectFactory;

@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {
	
	@Bean
	public ObjectFactory objectFactory() {
		return new ObjectFactory();
	}
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soapws/*");
	}
	
	@Bean(name = "content")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema contentSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ContentPort");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://www.cms.api.coe.hcl.com/content-ws");
		wsdl11Definition.setSchema(contentSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema contentSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schema/content.xsd"));
	}
}