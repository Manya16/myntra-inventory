package microservice.example.myntrainventory.service.vo.request;


import javax.validation.constraints.NotNull;

public class CategoryRequestVo {

    private Integer id;

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "active flag is mandatory")
    private  Boolean active;

    public CategoryRequestVo() {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
