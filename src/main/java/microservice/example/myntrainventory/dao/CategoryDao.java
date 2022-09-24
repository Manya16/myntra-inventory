package microservice.example.myntrainventory.dao;

import microservice.example.myntrainventory.dao.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category,Integer> {

    Category findByIdAndActive(Integer categoryId, boolean b);

  Category findByName(String categoryName);
}
