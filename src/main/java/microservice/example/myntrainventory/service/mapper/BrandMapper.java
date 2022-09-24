package microservice.example.myntrainventory.service.mapper;

import microservice.example.myntrainventory.dao.model.Brand;
import microservice.example.myntrainventory.dao.model.Category;
import microservice.example.myntrainventory.service.vo.request.BrandRequestVo;
import microservice.example.myntrainventory.service.vo.request.CategoryRequestVo;
import microservice.example.myntrainventory.service.vo.response.BrandResponseVo;
import microservice.example.myntrainventory.service.vo.response.CategoryResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {

    BrandMapper MAPPER = Mappers.getMapper(BrandMapper.class);

    Brand toModel(BrandRequestVo request);

    BrandResponseVo toVo(Brand brand);

    List<BrandResponseVo> toVoList(List<Brand> requestList);
}
