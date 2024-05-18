package com.fitBeat.Controller;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitBeat.Commons.ProductMSConstants;
import com.fitBeat.Commons.StatusConstants;
import com.fitBeat.DTO.ProductRequestDTO;
import com.fitBeat.DTO.ProductResponseDTO;
import com.fitBeat.DTO.ProductWrapperResponseDTO;
import com.fitBeat.DTO.ResponseDTO;
import com.fitBeat.Database.ProductRepository;
import com.fitBeat.Service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/core/product/" + ProductMSConstants.productMSVersion, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product-catalog")
	public ResponseEntity<ResponseDTO> createProduct(@ModelAttribute ProductRequestDTO productRequestDTO) {

		ResponseDTO responseDTO = null;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		try {
			responseDTO = new ResponseDTO();
			responseDTO = productService.createProduct(productRequestDTO);
			status = HttpStatus.CREATED;

		} catch (Exception e) {
			e.printStackTrace();
			responseDTO = new ResponseDTO();
			responseDTO.setData(StatusConstants.PRODUCT_INTERNAL_SERVER_MSG);
			responseDTO.setMessage(e.getMessage());
			responseDTO.setStatus(StatusConstants.PRODUCT_INTERNAL_SERVER_CODE);

		}
		return ResponseEntity.status(status).body(responseDTO);

	}

	@GetMapping("/product-catalog")
	public ResponseEntity<ProductWrapperResponseDTO> getProductList(@RequestParam(required = false) String categoryName,
			@RequestParam(required = false) String productName, @RequestParam(required = false) BigDecimal price,
			@RequestParam(required = false) Integer size, @RequestParam(required = false) String sortBy,
			@RequestParam(required = false) String order) {

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ProductWrapperResponseDTO productWrapperResponseDTO = new ProductWrapperResponseDTO();
		ResponseDTO responseDTO = new ResponseDTO();

		try {
			productWrapperResponseDTO = productService.getProductList(categoryName, productName, price, size, sortBy,
					order);
			status = HttpStatus.OK;
			responseDTO.setStatus(StatusConstants.PRODUCT_RESPONSE_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_RESPONSE_MSG);
			responseDTO.setData(StatusConstants.PRODUCT_RESPONSE_DATA);
			productWrapperResponseDTO.setResponseDTO(responseDTO);

		} catch (Exception e) {
			responseDTO.setData(StatusConstants.PRODUCT_INTERNAL_SERVER_MSG);
			responseDTO.setMessage(e.getMessage());
			responseDTO.setStatus(StatusConstants.PRODUCT_INTERNAL_SERVER_CODE);
			status = HttpStatus.NOT_FOUND;
			productWrapperResponseDTO.setResponseDTO(responseDTO);
			e.printStackTrace();
		}

		return ResponseEntity.status(status).body(productWrapperResponseDTO);

	}

	@GetMapping(value = "/product-catalog/{id}")
	public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") ObjectId id) {
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		ResponseDTO responseDTO = new ResponseDTO();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			productResponseDTO = productService.getProductById(id);
			responseDTO.setStatus(StatusConstants.PRODUCT_RESPONSE_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_RESPONSE_MSG);
			responseDTO.setData(StatusConstants.PRODUCT_RESPONSE_DATA);
			productResponseDTO.setResponse(responseDTO);
			status = HttpStatus.OK;

		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setData(StatusConstants.PRODUCT_INTERNAL_SERVER_MSG);
			responseDTO.setMessage(e.getMessage());
			responseDTO.setStatus(StatusConstants.PRODUCT_INTERNAL_SERVER_CODE);
			status = HttpStatus.NOT_FOUND;
			productResponseDTO.setResponse(responseDTO);
		}

		return ResponseEntity.status(status).body(productResponseDTO);

	}

	@PutMapping(value = "/product-catalog/{id}")
	public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") ObjectId id,
			@ModelAttribute ProductRequestDTO productRequestDTO) {
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		ResponseDTO responseDTO = new ResponseDTO();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			productResponseDTO = productService.updateProduct(productRequestDTO, id);
			responseDTO.setStatus(StatusConstants.PRODUCT_UPDATION_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_UPDATION_MSG);
			responseDTO.setData(StatusConstants.PRODUCT_UPDATION_DATA);
			productResponseDTO.setResponse(responseDTO);
			status = HttpStatus.OK;
		} catch (Exception e) {
			responseDTO.setData(StatusConstants.PRODUCT_INTERNAL_SERVER_MSG);
			responseDTO.setMessage(e.getMessage());
			responseDTO.setStatus(StatusConstants.PRODUCT_INTERNAL_SERVER_CODE);
			e.printStackTrace();
			status = HttpStatus.NOT_FOUND;
			productResponseDTO.setResponse(responseDTO);

		}

		return ResponseEntity.status(status).body(productResponseDTO);

	}

	@DeleteMapping(value = "/product-catalog/{id}")
	public ResponseEntity<ResponseDTO> deleteProductById(@PathVariable("id") ObjectId id) {
		ResponseDTO responseDTO = new ResponseDTO();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			responseDTO = productService.deleteProductById(id);
			status = HttpStatus.OK;

		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setStatus(StatusConstants.PRODUCT_DELETION_FAIL_CODE);
			responseDTO.setMessage(StatusConstants.PRODUCT_DELETION_FAIL_MSG);
			responseDTO.setData(StatusConstants.PRODUCT_DELETION_FAIL_DATA);
			status = HttpStatus.NOT_FOUND;

		}

		return ResponseEntity.status(status).body(responseDTO);

	}



}
