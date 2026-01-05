package com.main.payment_adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@SpringBootApplication
@EnableWs
public class PaymentAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentAdapterApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		System.out.println("Test String on Servlet Registration Bean!!!!!!!!!!!!");
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		
		ServletRegistrationBean<MessageDispatcherServlet> registration = 
			new ServletRegistrationBean<>(servlet, "/ws/*");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean(name = "payment_adapter") // This creates /ws/payment_adapter.wsdl
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema paymentAdapterSchema) {
		DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
		wsdl.setPortTypeName("PaymentAdapterPort");
		wsdl.setLocationUri("/ws");
		wsdl.setTargetNamespace("http://api/soap/hello");
		wsdl.setSchema(paymentAdapterSchema);
		return wsdl;
	}

	@Bean
	public XsdSchema paymentAdapterSchema() {
		return new SimpleXsdSchema(new ClassPathResource("soap-contracts/hello.xsd"));
	}
}