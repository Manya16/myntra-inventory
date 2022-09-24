package microservice.example.myntrainventory.service.enums;

public enum Size {
    X_SMALL("XS", "X-Small"),
    SMALL("S", "Small"),
    MEDIUM("M", "Medium"),
    LARGE("L", "Large"),
    X_LARGE("XL", "X-Large"),
    XX_LARGE("XXL", "2X-Large");

    private String code;
    private String label;

    Size(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static Size search(String code){
        for (Size size:Size.values()){
            if(size.getCode().equals(code)){
                return size;
            }
        }
        return null;
    }
}
