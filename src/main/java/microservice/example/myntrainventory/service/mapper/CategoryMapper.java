package microservice.example.myntrainventory.service.mapper;

import microservice.example.myntrainventory.dao.model.Category;
import microservice.example.myntrainventory.service.vo.request.CategoryRequestVo;
import microservice.example.myntrainventory.service.vo.response.CategoryResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

    Category toModel(CategoryRequestVo request);

    CategoryResponseVo toVo(Category category);

    List<CategoryResponseVo> toVoList(List<Category> requestList);
}
