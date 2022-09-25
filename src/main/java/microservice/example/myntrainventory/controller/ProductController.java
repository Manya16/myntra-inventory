package microservice.example.myntrainventory.controller;

import java.util.List;
import microservice.example.myntrainventory.service.ProductService;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @PostMapping("/products")
  public ResponseEntity create(@RequestBody ProductRequestVo request) throws MyntraException {
    ProductResponseVo response = productService.create(request);
    return new ResponseEntity(response, HttpStatus.OK);
  }

  @GetMapping("/products")
  public ResponseEntity get(@RequestParam(name = "categories", required = false) List<String> categories,
      @RequestParam(name = "brands", required = false) List<String> brands,
      @RequestParam(name = "gender", required = false) String gender) throws MyntraException {
    List<ProductResponseVo> responseVoList = productService.get(categories,brands,gender);
    return new ResponseEntity(responseVoList, HttpStatus.OK);
  }

  @GetMapping("/products/{item_code}")
  public ResponseEntity getByItemCode(@PathVariable("item_code") String itemCode)
      throws MyntraException {
    ProductResponseVo response = productService.getByItemCode(itemCode);
    return new ResponseEntity(response, HttpStatus.OK);
  }
}
