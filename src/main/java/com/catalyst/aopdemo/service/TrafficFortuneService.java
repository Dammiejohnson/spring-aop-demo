package com.catalyst.aopdemo.service;

import org.springframework.stereotype.Service;


public interface TrafficFortuneService {
    String getFortune();

    String getFortune(boolean tripWire);
}
