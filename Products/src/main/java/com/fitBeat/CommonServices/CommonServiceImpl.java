package com.fitBeat.CommonServices;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.fitBeat.Commons.ProductMSConstants;
import com.fitBeat.Commons.StatusConstants;
import com.fitBeat.DTO.ProductRequestDTO;
import com.fitBeat.DTO.ProductResponseDTO;
import com.fitBeat.Database.ProductEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService
{

	@Override
	public ProductEntity DtoToEntity(ProductRequestDTO dto) {
		ProductEntity products = new ProductEntity();
		try {
			
			products.setBlogLink(dto.getBlogLink());
			products.setCategoryName(dto.getCategoryName());
			products.setCreatedBy(ProductMSConstants.SELLER);
			products.setCreateTs(Long.valueOf(getTimestamp(new Date())));
			products.setProductDescription(dto.getProductDescription());
			try {
				products.setProductImage(dto.getProductImage().getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			products.setProductName(dto.getProductName());
			products.setVideoLink(dto.getVideoLink());
			products.setPrice(dto.getPrice());
			products.setRate(dto.getRate());
			products.setSize(dto.getSize());
			products.setProductIsActive(StatusConstants.YES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public ProductResponseDTO EntityToDTO(ProductEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTimestamp(Date date) {
		 Long epochMilliseconds = date.getTime();
		return epochMilliseconds;
	}


  
}
