package com.fitBeat.Service;

import java.math.BigDecimal;

import org.bson.types.ObjectId;

import com.fitBeat.DTO.ProductRequestDTO;
import com.fitBeat.DTO.ProductResponseDTO;
import com.fitBeat.DTO.ProductWrapperResponseDTO;
import com.fitBeat.DTO.ResponseDTO;

public interface ProductService {
	
	ResponseDTO createProduct(ProductRequestDTO productRequestDTO);
	ProductWrapperResponseDTO getProductList(String categoryName,String productName,BigDecimal price,Integer size,String sortBy,String order);
	ProductResponseDTO getProductById(ObjectId id);
	ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO,ObjectId id);
	ResponseDTO deleteProductById(ObjectId id);

}
