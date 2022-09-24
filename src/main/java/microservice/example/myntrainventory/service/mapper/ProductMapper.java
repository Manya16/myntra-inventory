package microservice.example.myntrainventory.service.mapper;

import java.util.List;
import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toModel(ProductRequestVo request);

    @Mapping(source = "category", target = "categoryVo")
    @Mapping(source = "brand", target = "brandVo")
    ProductResponseVo toVo(Product product);

    List<ProductResponseVo> toVoList(List<Product> products);
}
