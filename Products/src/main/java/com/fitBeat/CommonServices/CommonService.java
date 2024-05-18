package com.fitBeat.CommonServices;

import java.util.Date;

import com.fitBeat.DTO.ProductRequestDTO;
import com.fitBeat.DTO.ProductResponseDTO;
import com.fitBeat.Database.ProductEntity;

public interface CommonService
{
    public ProductEntity DtoToEntity(ProductRequestDTO dto);

    public ProductResponseDTO EntityToDTO(ProductEntity entity);

    public Long getTimestamp(Date date);

}
