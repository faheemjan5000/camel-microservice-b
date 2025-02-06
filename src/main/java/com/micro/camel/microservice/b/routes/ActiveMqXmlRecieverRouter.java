package com.micro.camel.microservice.b.routes;


import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;

@Component
public class ActiveMqXmlRecieverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
   log.info("ActiveMqXmlRecieverRouter.configure() method is called....");
        from("activemq:my-activemq-xml-queue")
                .to("log:received-message-from-active-mq");
    }
}
