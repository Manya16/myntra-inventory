package microservice.example.myntrainventory.service.impl;

import microservice.example.myntrainventory.dao.ProductDao;
import microservice.example.myntrainventory.dao.ProductImageDao;
import microservice.example.myntrainventory.dao.model.Product;
import microservice.example.myntrainventory.dao.model.ProductImage;
import microservice.example.myntrainventory.service.ProductImageService;
import microservice.example.myntrainventory.service.ProductService;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.mapper.ProductImageMapper;
import microservice.example.myntrainventory.service.vo.request.ProductImageRequestVo;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.ProductImageResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.util.Date;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired private ProductImageDao productImageDao;

    @Autowired private ProductDao productDao;

    @Override
    public ProductImageResponseVo upload(ProductImageRequestVo request) throws MyntraException {
        long timestamp = System.currentTimeMillis();

        String basePath = "C:\\Users\\man7\\Desktop\\Personal Project\\MyntraProductImages\\";
        String fileName = "PROD_"+timestamp+".jpg";
        String completePath = basePath+fileName;

        File targetFile = new File(completePath);
        copyInputStreamToFileJava9(request.getFile(), targetFile);

        ProductImage productImage = new ProductImage();
        productImage.setPath(completePath);

        Product product = productDao.findByItemCode(request.getItemCode());
        if(product==null) throw new MyntraException("Product not found");
        productImage.setProduct(product);

        productImage = productImageDao.save(productImage);
        return ProductImageMapper.MAPPER.toVo(productImage);
    }

    private void copyInputStreamToFileJava9(MultipartFile input, File file) throws MyntraException {
        try {
            InputStream inputStream = input.getInputStream();
            OutputStream output = new FileOutputStream(file, false);
            inputStream.transferTo(output);
        } catch (Exception e) {
            throw new MyntraException("Error Creating File");
        }
    }
}
