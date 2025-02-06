package com.micro.camel.microservice.b.bean;


import com.micro.camel.microservice.b.model.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Slf4j
public class MyCurrencyExchangeTransformerBean {//transform is used when to change the input

    public CurrencyExchange transformMessage(CurrencyExchange currencyExchange) {
        log.info("MyCurrencyExchangeTransformerBean.transformMessage() method is called.....");
        log.info("transforming the currency exchange : {} ",currencyExchange);
        currencyExchange.setConversionMultiple(currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));
        log.info("Message transformed : {} ",currencyExchange);

        return currencyExchange;
    }
}
