package microservice.example.myntrainventory.service.vo.response;

public class ProductImageResponseVo {

    private Integer id;
    private String itemCode;
    private String path;

    public ProductImageResponseVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
