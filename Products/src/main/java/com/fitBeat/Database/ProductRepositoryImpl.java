package com.fitBeat.Database;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	 @Autowired
	    private MongoTemplate mongoTemplate;

	@Override
	public <S extends ProductEntity> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findAllById(Iterable<ObjectId> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> S save(S entity) {
		
		return null;
	}

	@Override
	public Optional<ProductEntity> findById(ObjectId id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(ObjectId id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(ObjectId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends ObjectId> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ProductEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ProductEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ProductEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends ProductEntity, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity findProductById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findProductsByCustomCriteria(String categoryName, String productName, BigDecimal price,
			Integer size,String sortBy,String order) {
		
		 Query query = new Query();
		 
		 if (categoryName != null && !categoryName.isEmpty() ) {
	            query.addCriteria(Criteria.where("categoryName").regex(categoryName, "i"));
	        }
	        if (productName != null && !productName.isEmpty()) {
	        	query.addCriteria(Criteria.where("productName").regex(productName, "i"));
	        }
	        if (price != null ) {
	        	query.addCriteria(Criteria.where("price").is(price));
	        }
	        if (size != null ) {
	            query.addCriteria(Criteria.where("size").is(size));
	        }
	        if (sortBy != null && !sortBy.isEmpty()) {
	            Sort.Direction direction = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
	            query.with(Sort.by(direction, sortBy));
	        }
	        
	        
		  return mongoTemplate.find(query, ProductEntity.class);

	}

	@Override
	public ProductEntity saveProducts(ProductEntity products) {
		
		return mongoTemplate.save(products);
	}

}
