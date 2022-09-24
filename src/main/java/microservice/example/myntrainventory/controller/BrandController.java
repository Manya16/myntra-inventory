package microservice.example.myntrainventory.controller;

import microservice.example.myntrainventory.service.BrandService;
import microservice.example.myntrainventory.service.vo.request.BrandRequestVo;
import microservice.example.myntrainventory.service.vo.response.BrandResponseVo;
import microservice.example.myntrainventory.service.vo.response.CategoryResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping("/brands")
    public ResponseEntity create(@Valid @RequestBody BrandRequestVo brandRequestVo){
        BrandResponseVo brandResponseVo = brandService.create(brandRequestVo);
        return new ResponseEntity(brandResponseVo, HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity get(){
        List<BrandResponseVo> responseList = brandService.get();
        return new ResponseEntity(responseList, HttpStatus.OK);
    }

}
