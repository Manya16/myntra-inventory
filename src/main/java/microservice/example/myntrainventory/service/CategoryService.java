package microservice.example.myntrainventory.service;

import microservice.example.myntrainventory.service.vo.request.CategoryRequestVo;
import microservice.example.myntrainventory.service.vo.response.CategoryResponseVo;

import java.util.List;

public interface CategoryService {
    CategoryResponseVo create(CategoryRequestVo requestVo);

    List<CategoryResponseVo> get();
}
