package com.micro.camel.microservice.b.bean;

import com.micro.camel.microservice.b.model.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCurrencyExchangeProcessorBean {//process is used when not to change the input but just to process it

    public void processMessage(CurrencyExchange currencyExchange) {
    log.info("MyCurrencyExchangeProcessorBean.processMessage() method is called.....");
    log.info("processing the currency exchange : {} ",currencyExchange);

    }

}
