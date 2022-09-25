package microservice.example.myntrainventory.service;

import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;

import java.util.List;


public interface ProductService {

    ProductResponseVo create(ProductRequestVo request) throws MyntraException;

  List<ProductResponseVo> get(List<String> categoryName, List<String> brandName, String gender)
      throws MyntraException;

  ProductResponseVo getByItemCode(String itemCode) throws MyntraException;
}
