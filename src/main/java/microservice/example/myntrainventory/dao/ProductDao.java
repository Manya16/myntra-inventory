package microservice.example.myntrainventory.dao;

import java.util.List;
import microservice.example.myntrainventory.dao.model.Brand;
import microservice.example.myntrainventory.dao.model.Category;
import microservice.example.myntrainventory.dao.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {

    @Query("select prd from Product prd where prd.id=?1")
    Product fetchById(Integer productId);

    @Query("select MAX(id) from Product")
    Integer findMaxId();

    Product findByItemCode(String itemCode);

    List<Product> findAllByCategoryAndBrandAndGender(Category category, Brand brand, String gender);

    List<Product> findAllByCategoryAndBrand(Category category, Brand brand);

    List<Product> findByCategoryAndGender(Category category, String gender);

    List<Product> findByCategory(Category category);

    List<Product> findByBrand(Brand brand);

    List<Product> findByGender(String gender);


    List<Product> findByBrandAndGender(Brand brand, String gender);

    @Query("select prd from Product prd where prd.category.name=?1 and prd.brand.name=?2 and prd.gender=?3")
    List<Product> fetchAllByCategoryAndBrandAndGender(String category, List<String> brand, String gender);

    @Query("select prd from Product prd where prd.gender= :gender and prd.category.name in (:categories) and prd.brand.name in (:brands)")
    List<Product> fetchAllByGenderAndCategoriesAndBrands(@Param("gender") String gender,@Param("categories") List<String> categories, @Param("brands") List<String> brands);

    @Query("select prd from Product prd where prd.category.name in (:categories) and prd.brand.name in (:brands)")
    List<Product> fetchByCategoriesAndBrands(@Param("categories") List<String> categories,@Param("brands") List<String> brands);

    @Query("select prd from Product prd where prd.category.name in (:categories) and prd.gender = :gender")
    List<Product> fetchByCategoriesAndGender(@Param("categories") List<String> categories,@Param("gender") String gender);

    @Query("select prd from Product prd where prd.category.name in (:categories)")
    List<Product> fetchByCategories(@Param("categories") List<String> categories);

    @Query("select prd from Product prd where prd.brand.name in (:brands)")
    List<Product> fetchByBrands(@Param("brands") List<String> brands);

    @Query("select prd from Product prd where prd.gender = :gender")
    List<Product> fetchByGender(@Param("gender") String gender);

    @Query("select prd from Product prd where prd.brand.name in (:brands) and prd.gender= :gender")
    List<Product> fetchByBrandsAndGender(@Param("brands") List<String> brands,@Param("gender") String gender);
}
