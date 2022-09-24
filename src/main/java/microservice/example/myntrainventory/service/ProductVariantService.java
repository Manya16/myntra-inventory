package microservice.example.myntrainventory.service;

import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductVariantRequestVo;
import microservice.example.myntrainventory.service.vo.response.GenderResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductVariantResponseVo;
import microservice.example.myntrainventory.service.vo.response.SizeResponseVo;

import java.util.List;

public interface ProductVariantService {




    List<ProductVariantResponseVo> create(String itemCode, List<ProductVariantRequestVo> requestList) throws MyntraException;

    List<ProductVariantResponseVo> get(String itemCode) throws MyntraException;

}
