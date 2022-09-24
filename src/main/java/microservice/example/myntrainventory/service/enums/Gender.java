package microservice.example.myntrainventory.service.enums;

public enum Gender {

  FEMALE("F", "Female"),
  MALE("M", "Male");


  private String code;
  private String label;

  Gender(String code, String label) {
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

  public static Gender search(String code){
    for (Gender gender:Gender.values()){
      if (gender.getCode().equals(code)){
        return gender;
      }
    }
    return null;
  }
}
