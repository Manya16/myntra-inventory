package microservice.example.myntrainventory.service.vo.response;

public class GenderResponseVo {

  private String code;
  private String label;

  public GenderResponseVo(String code, String label) {
    this.code = code;
    this.label = label;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
