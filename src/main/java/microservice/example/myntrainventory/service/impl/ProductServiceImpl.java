package microservice.example.myntrainventory.service.impl;

import java.util.List;
import microservice.example.myntrainventory.dao.BrandDao;
import microservice.example.myntrainventory.dao.CategoryDao;
import microservice.example.myntrainventory.dao.ProductDao;
import microservice.example.myntrainventory.dao.model.Brand;
import microservice.example.myntrainventory.dao.model.Category;
import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.service.ProductService;
import microservice.example.myntrainventory.service.common.MyntraUtils;
import microservice.example.myntrainventory.service.enums.Gender;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.mapper.ProductMapper;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductDao productDao;
  @Autowired
  private CategoryDao categoryDao;
  @Autowired
  private BrandDao brandDao;

  @Override
  public ProductResponseVo create(ProductRequestVo request) throws MyntraException {
    Product product = ProductMapper.MAPPER.toModel(request);

    Category category = categoryDao.findByIdAndActive(request.getCategoryId(), true);
    if (category == null) throw new MyntraException("Category not found", "1000");

    product.setCategory(category);

    Brand brand = brandDao.findByIdAndActive(request.getBrandId(), true);
    if (brand == null) throw new MyntraException("Brand not found", "1001");

    product.setBrand(brand);

    Integer maxId = productDao.findMaxId();
    product.setItemCode(MyntraUtils.getItemCode(maxId + 1));

    Gender gender = Gender.search(product.getGender());
    if (gender == null) throw new MyntraException("Gender not present", "1002");


    product = productDao.save(product);
    return ProductMapper.MAPPER.toVo(product);
  }

  @Override
  public List<ProductResponseVo> get(List<String> categories, List<String> brands, String gender)
      throws MyntraException {
    List<Product> products = null;

    if (categories != null && brands != null && gender != null) {
      products = productDao.fetchAllByGenderAndCategoriesAndBrands(gender,categories,brands);
    } else if (categories != null && brands != null && gender == null) {
      products = productDao.fetchByCategoriesAndBrands(categories, brands);
    } else if (categories != null && brands == null && gender != null) {
      products = productDao.fetchByCategoriesAndGender(categories, gender);
    } else if (categories != null && brands == null && gender == null) {
      products = productDao.fetchByCategories(categories);
    } else if (categories == null && brands != null && gender == null) {
      products = productDao.fetchByBrands(brands);
    } else if (categories == null && brands == null && gender != null) {
      products = productDao.fetchByGender(gender);
    } else if (categories == null && brands != null && gender != null) {
      products = productDao.fetchByBrandsAndGender(brands,gender);
    } else {
      products = (List<Product>) productDao.findAll();
    }

    List<ProductResponseVo> responseList = ProductMapper.MAPPER.toVoList(products);
    return responseList;
  }
}
