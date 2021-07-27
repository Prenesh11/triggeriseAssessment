package com.triggerise.store.controller;

import com.triggerise.store.domain.StoreRequest;
import com.triggerise.store.domain.StoreResponse;
import com.triggerise.store.service.CalculateAmountDueService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * StoreController, this is the entry point of the service and the url is configured here
 *
 * @author  Prenesh Naidoo
 * @version 1.0
 * @since  2021
 */
@RestController
public class StoreController {


    @RequestMapping(value = "CalculateCheckoutAmount", produces = "application/json", method = RequestMethod.POST)
    public StoreResponse calculateIncomeTax(@RequestBody StoreRequest request) {
        CalculateAmountDueService amountDue = new CalculateAmountDueService();
        BigDecimal totalDue = amountDue.calculateAmountDue(request);
        totalDue = totalDue.setScale(2, RoundingMode.CEILING);
        StoreResponse response = new StoreResponse();
        response.setTotal(totalDue);
        return response;
    }
}
