package microservice.example.myntrainventory.controller;

import microservice.example.myntrainventory.service.CategoryService;
import microservice.example.myntrainventory.service.vo.request.CategoryRequestVo;
import microservice.example.myntrainventory.service.vo.response.CategoryResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity create(@RequestBody CategoryRequestVo requestVo){
        CategoryResponseVo categoryResponseVo = categoryService.create(requestVo);
        return new ResponseEntity(categoryResponseVo, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity get(){
        List<CategoryResponseVo> responseList= categoryService.get();
        return new ResponseEntity(responseList,HttpStatus.OK);
    }

}
