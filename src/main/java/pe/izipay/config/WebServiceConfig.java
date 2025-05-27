package pe.izipay.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import pe.izipay.model.dto.TransaccionRequest;
import pe.izipay.model.dto.TransaccionResponse;

@EnableWs
@Configuration
public class WebServiceConfig {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
      ApplicationContext context) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(context);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  @Bean(name = "transacciones")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema transaccionSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("TransaccionPort");
    wsdl11Definition.setLocationUri("/ws");
    wsdl11Definition.setTargetNamespace("http://izipay.pe/soap");
    wsdl11Definition.setSchema(transaccionSchema);
    return wsdl11Definition;
  }

  @Bean
  public XsdSchema transaccionSchema() {
    return new SimpleXsdSchema(new ClassPathResource("xsd/transaction.xsd"));
  }

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(TransaccionRequest.class, TransaccionResponse.class);
    return marshaller;

  }
}
