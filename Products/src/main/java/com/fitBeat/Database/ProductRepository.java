package com.fitBeat.Database;

import java.math.BigDecimal;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<ProductEntity, ObjectId> {
	
	@Query("{_id:'?0'}")
	ProductEntity findProductById(ObjectId id);
	
	ProductEntity saveProducts(ProductEntity products);
	
	
	List<ProductEntity> findProductsByCustomCriteria(String categoryName,String productName,BigDecimal price,Integer size,String sortBy,String order);
	
	

} 
