package com.triggerise.store.service;

import com.triggerise.store.domain.ProductEnum;
import com.triggerise.store.domain.StoreRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * CalculateAmountDue, this service contains all the business knowledge of the calculator.
 *
 * @author  Prenesh Naidoo
 * @version 1.0
 * @since  2021
 */
public class CalculateAmountDueService {

    /**
     * This method calculates the total amount due to the store from the customer.
     * it uses a list of string items and determines the amount payable.
     *
     * @param storeRequest
     * @return the total amount due for the storeRequest
     */
    public BigDecimal calculateAmountDue(StoreRequest storeRequest) {

        double total = 0.00;
        int noOfMugs = 0;
        int noOfTShirts = 0;
        int noOfUsbKeys = 0;

        List<String> upperCaseProductList = storeRequest.getProductList().stream()
                .map(String::toUpperCase).collect(Collectors.toList());

        noOfMugs = Collections.frequency(upperCaseProductList, "MUG");
        noOfTShirts = Collections.frequency(upperCaseProductList, "TSHIRT");
        noOfUsbKeys = Collections.frequency(upperCaseProductList, "USBKEY");

        total += CalculateCostOfMugs(noOfMugs);
        total += CalculateCostOfTShirts(noOfTShirts);
        total += CalculateCostOfUsbKey(noOfUsbKeys);
        return BigDecimal.valueOf(total).setScale(2, RoundingMode.CEILING);

    }

    /**
     * This method is used to calculate the cost of all the usbkeys in the request
     *
     * @param noOfUsbKeys
     * @return the total cost of all the usbkeys
     */
    private double CalculateCostOfUsbKey(int noOfUsbKeys) {

        double total = 0.00;
        total = noOfUsbKeys * ProductEnum.USBKEY.getCost();
        return total;
    }

    /**
     * This method is used to calculate the cost of all the t-shirts in the request
     *
     * @param noOfTShirts
     * @return the total cost of all the t-shirts
     */
    private double CalculateCostOfTShirts(int noOfTShirts) {

        double total = 0.00;
        if (noOfTShirts > 2) {
            total = noOfTShirts * ProductEnum.TSHIRT.getCost() * 0.7;
            return total;
        }

        total = noOfTShirts * ProductEnum.TSHIRT.getCost();
        return total;
    }

    /**
     * This method is used to calculate the cost of all the mugs in the request
     *
     * @param noOfMugs
     * @return the total cost of all the mugs
     */
    private double CalculateCostOfMugs(int noOfMugs) {

        double total = 0.00;
        total += (noOfMugs / 2) * ProductEnum.MUG.getCost();
        total += (noOfMugs % 2) * ProductEnum.MUG.getCost();
        return total;
    }
}
