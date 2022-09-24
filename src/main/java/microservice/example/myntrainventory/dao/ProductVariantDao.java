package microservice.example.myntrainventory.dao;

import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.dao.model.ProductVariant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantDao extends CrudRepository<ProductVariant, Integer> {

    List<ProductVariant> findAllByProduct(Product product);
}
