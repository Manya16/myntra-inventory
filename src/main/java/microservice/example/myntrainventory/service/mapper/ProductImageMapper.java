package microservice.example.myntrainventory.service.mapper;

import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.dao.model.ProductImage;
import microservice.example.myntrainventory.service.vo.request.ProductImageRequestVo;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductImageResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductImageMapper {
    
    ProductImageMapper MAPPER = Mappers.getMapper(ProductImageMapper.class);

    ProductImage toModel(ProductImageRequestVo request);

    @Mapping(source = "product.itemCode", target = "itemCode")
    ProductImageResponseVo toVo(ProductImage productImage);
}
