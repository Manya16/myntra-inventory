package microservice.example.myntrainventory.dao;

import microservice.example.myntrainventory.dao.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends CrudRepository<Brand, Integer> {
    Brand findByIdAndActive(Integer brandId, boolean b);

  Brand findByName(String brandName);
}
