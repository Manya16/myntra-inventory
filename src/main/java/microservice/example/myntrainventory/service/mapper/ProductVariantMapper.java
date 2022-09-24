package microservice.example.myntrainventory.service.mapper;

import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.dao.model.ProductVariant;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.request.ProductVariantRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductVariantResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductVariantMapper {
    
    ProductVariantMapper MAPPER = Mappers.getMapper(ProductVariantMapper.class);

    ProductVariant toModel(ProductVariantRequestVo request);

    @Mapping(source = "product.itemCode", target = "itemCode")
    ProductVariantResponseVo toVo(ProductVariant variant);

    List<ProductVariantResponseVo> toVoList(List<ProductVariant> requestList);
}
