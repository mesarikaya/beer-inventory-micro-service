package com.mes.beerinventorymicroservice.services;

import com.mes.brewery.model.BeerOrderDto;

/**
 * Created by mesar on 2/28/2020
 */
public interface AllocationService {

    boolean allocateOrder(BeerOrderDto beerOrderDto);
}
