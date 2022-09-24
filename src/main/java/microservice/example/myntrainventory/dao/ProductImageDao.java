package microservice.example.myntrainventory.dao;

import microservice.example.myntrainventory.dao.model.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageDao extends CrudRepository<ProductImage, Integer> {
}
