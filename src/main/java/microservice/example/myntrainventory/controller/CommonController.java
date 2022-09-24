package microservice.example.myntrainventory.controller;

import java.util.List;
import microservice.example.myntrainventory.service.CommonService;
import microservice.example.myntrainventory.service.vo.response.GenderResponseVo;
import microservice.example.myntrainventory.service.vo.response.SizeResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

  @Autowired
  CommonService commonService;

  @GetMapping("/sizes")
  public ResponseEntity getAllSizes() {
    List<SizeResponseVo> responseList = commonService.getSizes();
    return new ResponseEntity(responseList, HttpStatus.OK);
  }

  @GetMapping("/genders")
  public ResponseEntity getAllGenders(){
    List<GenderResponseVo> responseList =  commonService.getGenders();
    return new ResponseEntity(responseList, HttpStatus.OK);
  }

}
