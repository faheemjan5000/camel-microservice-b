package com.micro.camel.microservice.b.routes;

import com.micro.camel.microservice.b.bean.MyCurrencyExchangeProcessorBean;
import com.micro.camel.microservice.b.bean.MyCurrencyExchangeTransformerBean;
import com.micro.camel.microservice.b.model.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;

//@Component   ############## REMOVE THE COMMENT WHEN TO USE IT ####################
public class ActiveMqJsonRecieverRouter extends RouteBuilder {

    @Autowired
    private MyCurrencyExchangeProcessorBean myCurrencyExchangeProcessorBean;
  @Autowired
    private MyCurrencyExchangeTransformerBean myCurrencyExchangeTransformerBean;
    @Override
    public void configure() throws Exception {
        //reading from queue and print it
       // from("activemq:my-activemq-queue")
                //.to("log:received-message-from-active-mq");

        //read from the activemq the json file and convert it to a java model class
         from("activemq:my-activemq-queue")
                 .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                 .bean(myCurrencyExchangeProcessorBean,"processMessage")
                 .bean(myCurrencyExchangeTransformerBean)
                 .to("log:received-message-from-active-mq");
    }


}
