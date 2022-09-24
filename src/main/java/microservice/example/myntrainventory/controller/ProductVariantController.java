package microservice.example.myntrainventory.controller;

import microservice.example.myntrainventory.service.ProductVariantService;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductVariantRequestVo;
import microservice.example.myntrainventory.service.vo.response.GenderResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductVariantResponseVo;
import microservice.example.myntrainventory.service.vo.response.SizeResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductVariantController {

    @Autowired
    ProductVariantService productVariantService;


    @PostMapping("/product-variants/{item_code}")
    public ResponseEntity create(@PathVariable("item_code") String itemCode, @RequestBody List<ProductVariantRequestVo> requestList) throws MyntraException {
        List<ProductVariantResponseVo> responseList = productVariantService.create(itemCode, requestList);
        return new ResponseEntity(responseList, HttpStatus.OK);
    }

    @GetMapping("/product-variants")
    public ResponseEntity get(@RequestParam(name = "item_code", required = false) String itemCode) throws MyntraException {
        List<ProductVariantResponseVo> responseList = productVariantService.get(itemCode);
        return new ResponseEntity(responseList,HttpStatus.OK);
    }

}
