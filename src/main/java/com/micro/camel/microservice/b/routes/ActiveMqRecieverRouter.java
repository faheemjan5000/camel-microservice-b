package com.micro.camel.microservice.b.routes;

import com.micro.camel.microservice.b.model.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqRecieverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //reading from queue and print it
       // from("activemq:my-activemq-queue")
                //.to("log:received-message-from-active-mq");

        //read from the activemq the json file and convert it to a java model class
         from("activemq:my-activemq-queue")
                 .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
        .to("log:received-message-from-active-mq");
    }
}
