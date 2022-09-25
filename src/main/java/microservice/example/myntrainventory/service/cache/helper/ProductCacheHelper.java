package microservice.example.myntrainventory.service.cache.helper;

import microservice.example.myntrainventory.dao.ProductDao;
import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.service.cache.config.CacheNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductCacheHelper {

  @Autowired private ProductDao productDao;

  @Cacheable(cacheNames = {CacheNames.PRODUCT_ITEM_CODE_CACHE}, key = "{#itemCode}", unless = "{#result==null}")
  public Product getByItemCode(String itemCode) {
    return productDao.findByItemCode(itemCode);
  }

  @CacheEvict(cacheNames = {CacheNames.PRODUCT_ITEM_CODE_CACHE}, key = "{#itemCode}")
  public void evictSingleCacheEntry(String itemCode) {}

  @CacheEvict(cacheNames = {CacheNames.PRODUCT_ITEM_CODE_CACHE}, allEntries = true)
  public void evictAllEntries() {}

}
