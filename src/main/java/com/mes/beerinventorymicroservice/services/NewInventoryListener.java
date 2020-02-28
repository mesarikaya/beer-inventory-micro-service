package com.mes.beerinventorymicroservice.services;

import com.mes.beerinventorymicroservice.config.JmsConfig;
import com.mes.beerinventorymicroservice.domain.BeerInventory;
import com.mes.beerinventorymicroservice.repositories.BeerInventoryRepository;
import com.mes.brewery.model.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by mesar on 2/28/2020
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){

        log.debug("Got Inventory: " + event.toString());

        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(String.valueOf(event.getBeerDto().getUpc()))
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build());
    }

}
