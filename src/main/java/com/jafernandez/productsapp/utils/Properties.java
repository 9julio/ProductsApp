package com.jafernandez.productsapp.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${providers.timeout}")
    private int providersTimeOutInSegs;

    public int getProvidersTimeOutInSegs() {
        return providersTimeOutInSegs;
    }

    public void setProvidersTimeOutInSegs(int providersTimeOutInSegs) {
        this.providersTimeOutInSegs = providersTimeOutInSegs;
    }

}
