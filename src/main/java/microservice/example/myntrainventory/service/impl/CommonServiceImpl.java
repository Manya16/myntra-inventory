package microservice.example.myntrainventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import microservice.example.myntrainventory.service.CommonService;
import microservice.example.myntrainventory.service.enums.Gender;
import microservice.example.myntrainventory.service.enums.Size;
import microservice.example.myntrainventory.service.exception.MyntraException;
import microservice.example.myntrainventory.service.vo.request.ProductRequestVo;
import microservice.example.myntrainventory.service.vo.response.GenderResponseVo;
import microservice.example.myntrainventory.service.vo.response.ProductResponseVo;
import microservice.example.myntrainventory.service.vo.response.SizeResponseVo;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {


  @Override
  public List<GenderResponseVo> getGenders() {
    List<GenderResponseVo> responseList = new ArrayList<>();
    for (Gender gender: Gender.values()){
      responseList.add(new GenderResponseVo(gender.getCode(),gender.getLabel()));
    }

    return responseList;
  }

  @Override
  public List<SizeResponseVo> getSizes() {
    List<SizeResponseVo> responseList = new ArrayList<>();
    for (Size size : Size.values()) {
      responseList.add(new SizeResponseVo(size.getCode(), size.getLabel()));
    }
    return responseList;
  }
}
