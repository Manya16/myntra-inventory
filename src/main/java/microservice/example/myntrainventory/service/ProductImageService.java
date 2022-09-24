package microservice.example.myntrainventory.service;

import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductImageRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductImageResponseVo;


public interface ProductImageService {
    ProductImageResponseVo upload(ProductImageRequestVo request) throws MyntraException;
}
