package microservice.example.myntrainventory.service;

import microservice.example.myntrainventory.dao.BrandDao;
import microservice.example.myntrainventory.service.vo.request.BrandRequestVo;
import microservice.example.myntrainventory.service.vo.response.BrandResponseVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface BrandService {

    BrandResponseVo create(BrandRequestVo brandRequestVo);

    List<BrandResponseVo> get();
}
