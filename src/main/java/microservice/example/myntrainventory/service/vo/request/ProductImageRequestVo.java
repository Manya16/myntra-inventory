package microservice.example.myntrainventory.service.vo.request;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class ProductImageRequestVo {

    private String itemCode;
    private MultipartFile file;

    public ProductImageRequestVo() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
