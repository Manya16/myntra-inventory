package microservice.example.myntrainventory.controller;

import microservice.example.myntrainventory.service.ProductImageService;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductImageRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductImageResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @PostMapping(value = "/product-images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity upload(@RequestPart("item_code") String itemCode,
                                 @RequestPart("file") MultipartFile file) throws MyntraException {
        ProductImageRequestVo request = new ProductImageRequestVo();
        request.setItemCode(itemCode);
        request.setFile(file);
        ProductImageResponseVo response= productImageService.upload(request);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
