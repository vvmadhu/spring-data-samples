package com.hcl.coe.api.cms.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.CommonsHttpMessageSender;

import com.hcl.coe.api.cms.stub.ObjectFactory;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(value = "com.hcl.coe.api.cms.*")
@SpringBootApplication
public class ContentManagementApplication {

    Logger logger = LoggerFactory.getLogger(ContentManagementApplication.class);
    
    @Value("${external.service.url}")
	private String wsdlURL;
	
	@Value("${external.service.call.timeout}")
	private int externalServiceCallTimeout;
	
	@Bean
	public WebServiceTemplate contentWebServiceTemplate() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(soapMessageFactory());
		webServiceTemplate.setMarshaller(contentMarshaller());
		webServiceTemplate.setUnmarshaller(contentMarshaller());
		webServiceTemplate.setDefaultUri(wsdlURL);
		webServiceTemplate.setMessageSender(messageSender());
		
		return webServiceTemplate;
	}
	
	@Bean
	public ObjectFactory contentObjectFactory() {
		ObjectFactory objectFactory = new ObjectFactory();
		return objectFactory;
	}
	
	@Bean
	public Jaxb2Marshaller contentMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.hcl.coe.api.cms.stub");
		return jaxb2Marshaller;
	}
	
	@Bean
	public SaajSoapMessageFactory soapMessageFactory() {
		SaajSoapMessageFactory factory = new SaajSoapMessageFactory();
		factory.setSoapVersion(SoapVersion.SOAP_11);
		return factory;
	}

	@Bean
	public CommonsHttpMessageSender messageSender() {
		CommonsHttpMessageSender httpComponentsMessageSender = new CommonsHttpMessageSender();
		httpComponentsMessageSender.setConnectionTimeout(externalServiceCallTimeout);
		httpComponentsMessageSender.setReadTimeout(externalServiceCallTimeout);
		return httpComponentsMessageSender;
	}
    public static void main(String[] args) {
        SpringApplication.run(ContentManagementApplication.class, args);
    }    
  	
	@Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hcl.coe.api.cms.controller"))
                .build();
    }
	
}