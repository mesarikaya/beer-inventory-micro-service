package com.mes.beerinventorymicroservice.web.mappers;

import com.mes.beerinventorymicroservice.config.web.model.BeerInventoryDto;
import com.mes.beerinventorymicroservice.domain.BeerInventory;
import org.mapstruct.Mapper;

/**
 * Created by mesar on 2/16/2020
 */
@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
