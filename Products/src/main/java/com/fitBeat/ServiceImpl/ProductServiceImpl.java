package com.fitBeat.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitBeat.CommonServices.CommonService;
import com.fitBeat.CommonServices.CommonServiceImpl;
import com.fitBeat.Commons.ProductMSConstants;
import com.fitBeat.Commons.StatusConstants;
import com.fitBeat.DTO.ProductRequestDTO;
import com.fitBeat.DTO.ProductResponseDTO;
import com.fitBeat.DTO.ProductWrapperResponseDTO;
import com.fitBeat.DTO.ResponseDTO;
import com.fitBeat.Database.ProductEntity;
import com.fitBeat.Database.ProductRepository;
import com.fitBeat.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CommonService commonService;

	@Autowired
	private CommonServiceImpl commonServiceImpl;

	@Override
	public ResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		ProductEntity products = new ProductEntity();

		try {
			products = commonServiceImpl.DtoToEntity(productRequestDTO);

			productRepository.saveProducts(products);

			responseDTO.setStatus(StatusConstants.PRODUCT_CREATED_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_CREATED_MSG);

		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setStatus(StatusConstants.PRODUCT_CREATION_BAD_REQUEST_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_CREATION_BAD_REQUEST_MSG);
			responseDTO.setData(e.getMessage());
		}

		return responseDTO;
	}

	@Override
	public ProductWrapperResponseDTO getProductList(String categoryName, String productName, BigDecimal price,
			Integer size, String sortBy, String order) {

		List<ProductEntity> productList = null;
		List<ProductResponseDTO> productResponseDTOList = null;
		ProductWrapperResponseDTO productWrapperResponseDTO = new ProductWrapperResponseDTO();
		try {
			productList = new ArrayList<>();
			productResponseDTOList = new ArrayList<>();
			ProductResponseDTO productResponseDTO = null;
			productList = productRepository.findProductsByCustomCriteria(categoryName, productName, price, size, sortBy,
					order);

			for (ProductEntity product : productList) {
				productResponseDTO = new ProductResponseDTO();
				BeanUtils.copyProperties(product, productResponseDTO);

				productResponseDTOList.add(productResponseDTO);

			}
			productWrapperResponseDTO.setProductListResponseDTO(productResponseDTOList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productWrapperResponseDTO;
	}

	@Override
	public ProductResponseDTO getProductById(ObjectId id) {

		ProductResponseDTO productResponseDTO = null;

		try {
			ProductEntity productEntity = productRepository.findProductById(id);

			productResponseDTO = new ProductResponseDTO();
			BeanUtils.copyProperties(productEntity, productResponseDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productResponseDTO;
	}

	@Override
	public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, ObjectId id) {
		ProductResponseDTO productResponseDTO = null;
		ProductEntity products = new ProductEntity();

		try {

			products = productRepository.findProductById(id);

			products.setBlogLink(productRequestDTO.getBlogLink());
			products.setCategoryName(productRequestDTO.getCategoryName());
			products.setUpdatedBy(ProductMSConstants.SELLER);
			products.setUpdateTs(Long.valueOf(commonService.getTimestamp(new Date())));
			products.setProductDescription(productRequestDTO.getProductDescription());
			products.setProductImage(productRequestDTO.getProductImage().getBytes());
			products.setProductName(productRequestDTO.getProductName());
			products.setVideoLink(productRequestDTO.getVideoLink());
			products.setPrice(productRequestDTO.getPrice());
			products.setRate(productRequestDTO.getRate());
			products.setSize(productRequestDTO.getSize());

			productResponseDTO = new ProductResponseDTO();
			BeanUtils.copyProperties(products, productResponseDTO);

			productRepository.saveProducts(products);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productResponseDTO;
	}

	@Override
	public ResponseDTO deleteProductById(ObjectId id) {

		ResponseDTO responseDTO = new ResponseDTO();
		ProductEntity products = new ProductEntity();

		try {
			products = productRepository.findProductById(id);
			products.setProductIsActive(StatusConstants.NO);
			responseDTO.setStatus(StatusConstants.PRODUCT_DELETION_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_DELETION_MSG);
			responseDTO.setData(StatusConstants.PRODUCT_DELETION_DATA);
			productRepository.saveProducts(products);

		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setStatus(StatusConstants.PRODUCT_DELETION_FAIL_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_DELETION_FAIL_MSG);
			responseDTO.setData(StatusConstants.PRODUCT_DELETION_FAIL_DATA);
		}

		return responseDTO;
	}

}
