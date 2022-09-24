package microservice.example.myntrainventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import microservice.example.myntrainventory.dao.ProductDao;
import microservice.example.myntrainventory.dao.ProductVariantDao;
import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.dao.model.ProductVariant;
import microservice.example.myntrainventory.service.ProductVariantService;
import microservice.example.myntrainventory.service.enums.Gender;
import microservice.example.myntrainventory.service.enums.Size;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.mapper.ProductVariantMapper;
import microservice.example.myntrainventory.service.vo.request.ProductVariantRequestVo;
import microservice.example.myntrainventory.service.vo.response.GenderResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductVariantResponseVo;
import microservice.example.myntrainventory.service.vo.response.SizeResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

  @Autowired
  private ProductDao productDao;

  @Autowired
  private ProductVariantDao productVariantDao;

  @Override
  public List<ProductVariantResponseVo> create(String itemCode,
      List<ProductVariantRequestVo> requestList) throws MyntraException {
    List<ProductVariant> variants = new ArrayList<>(requestList.size());

    Product product = productDao.findByItemCode(itemCode);
    if (product == null) {
      throw new MyntraException("Product not found");
    }

    for (ProductVariantRequestVo request : requestList) {
      ProductVariant variant = ProductVariantMapper.MAPPER.toModel(request);
      variant.setProduct(product);

      Size size = Size.search(variant.getSize());
      if (size == null) {
        throw new MyntraException("Size not found");
      }

      variants.add(variant);
    }

    variants = (List<ProductVariant>) productVariantDao.saveAll(variants);

    List<ProductVariantResponseVo> responseList = ProductVariantMapper.MAPPER.toVoList(variants);
    return responseList;
  }

  @Override
  public List<ProductVariantResponseVo> get(String itemCode) throws MyntraException {
    List<ProductVariant> variants = null;

    if (itemCode != null) {
      Product product = productDao.findByItemCode(itemCode);
      if (product == null) {
        throw new MyntraException("Product not found", "0000");
      }
      variants = productVariantDao.findAllByProduct(product);
    } else {
      variants = (List<ProductVariant>) productVariantDao.findAll();
    }

    List<ProductVariantResponseVo> responseList = ProductVariantMapper.MAPPER.toVoList(variants);
    return responseList;
  }


}

