package microservice.example.myntrainventory.service;

import java.util.List;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.GenderResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import microservice.example.myntrainventory.service.vo.response.SizeResponseVo;


public interface CommonService {


    List<GenderResponseVo> getGenders();

    List<SizeResponseVo> getSizes();
}
