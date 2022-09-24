package microservice.example.myntrainventory.service.impl;

import microservice.example.myntrainventory.dao.CategoryDao;
import microservice.example.myntrainventory.dao.model.Category;
import microservice.example.myntrainventory.service.CategoryService;
import microservice.example.myntrainventory.service.mapper.CategoryMapper;
import microservice.example.myntrainventory.service.vo.request.CategoryRequestVo;
import microservice.example.myntrainventory.service.vo.response.CategoryResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryResponseVo create(CategoryRequestVo categoryRequestVo) {
        Date currDate = new Date();

        // CONVERT REQUEST VO TO MODEL
        Category category = CategoryMapper.MAPPER.toModel(categoryRequestVo);
        category.setCreatedAt(currDate);
        category.setUpdatedAt(currDate);

        // SAVE MODEL IN DATABASE
        category = categoryDao.save(category);

        //CONVERT MODEL TO RESPONSE VO
        CategoryResponseVo categoryResponseVo =CategoryMapper.MAPPER.toVo(category);

        //RETURN RESPONSE VO
        return categoryResponseVo;
    }

    @Override
    public List<CategoryResponseVo> get() {
         List<Category> categories = (List<Category>) categoryDao.findAll();
        return CategoryMapper.MAPPER.toVoList(categories);
    }
}
