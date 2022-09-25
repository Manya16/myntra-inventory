package microservice.example.myntrainventory.service.cache.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MyntraCacheManager {

  @Bean
  public CacheManager cacheManager() {
    List<String> caches = new ArrayList<>();

    ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();

    caches.add(CacheNames.CATEGORIES_CACHE);
    caches.add(CacheNames.PRODUCT_ITEM_CODE_CACHE);

    cacheManager.setCacheNames(caches);
    return cacheManager;
  }
}
