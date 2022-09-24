package microservice.example.myntrainventory.service.vo.response;

import java.util.Date;

public class CategoryVo {

    private Integer id;
    private String name;

    public CategoryVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
