package com.fitBeat.DTO;

import java.util.List;

public class ProductWrapperResponseDTO {
	
	private List<ProductResponseDTO> productListResponseDTO;
	private ResponseDTO responseDTO;
	
	public List<ProductResponseDTO> getProductListResponseDTO() {
		return productListResponseDTO;
	}
	public void setProductListResponseDTO(List<ProductResponseDTO> productListResponseDTO) {
		this.productListResponseDTO = productListResponseDTO;
	}
	public ResponseDTO getResponseDTO() {
		return responseDTO;
	}
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.responseDTO = responseDTO;
	}

	
	

}
