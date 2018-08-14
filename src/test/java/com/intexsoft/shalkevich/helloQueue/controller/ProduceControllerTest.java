package com.intexsoft.shalkevich.helloQueue.controller;

import com.intexsoft.shalkevich.helloQueue.service.IProduceService;
import com.intexsoft.shalkevich.helloQueue.service.ProduceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

/**
 * Tests produce controller
 */
@RunWith(MockitoJUnitRunner.class)
public class ProduceControllerTest {
    @Mock
    ProduceService produceService;
    @InjectMocks
    ProduceController produceController;

    private String msg = "test msg";

    /**
     * Checks sendMsg method of controller
     */
    @Test
    public void ProduceControllerTest(){
        produceController.sendMsg(msg);
        Mockito.verify(produceService, Mockito.times(1)).produceMsg(any(String.class));
    }
}
