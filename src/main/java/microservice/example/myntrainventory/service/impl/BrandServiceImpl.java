package microservice.example.myntrainventory.service.impl;

import microservice.example.myntrainventory.dao.BrandDao;
import microservice.example.myntrainventory.dao.model.Brand;
import microservice.example.myntrainventory.service.BrandService;
import microservice.example.myntrainventory.service.mapper.BrandMapper;
import microservice.example.myntrainventory.service.vo.request.BrandRequestVo;
import microservice.example.myntrainventory.service.vo.response.BrandResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired BrandDao brandDao;

    @Override
    public BrandResponseVo create(BrandRequestVo brandRequestVo) {
        Date currDate = new Date();

        // CONVERT REQUEST VO TO MODEL
        Brand brand = BrandMapper.MAPPER.toModel(brandRequestVo);
        brand.setCreatedAt(currDate);
        brand.setUpdatedAt(currDate);

        // SAVE MODEL
        brand = brandDao.save(brand);

        // CONVERT MODEL TO RESPONSE VO
        return BrandMapper.MAPPER.toVo(brand);
    }

    @Override
    public List<BrandResponseVo> get() {
        List<Brand> brands = (List<Brand>) brandDao.findAll();
        return BrandMapper.MAPPER.toVoList(brands);
    }
}
