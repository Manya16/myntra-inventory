package microservice.example.myntrainventory.service.vo.request;


import javax.validation.constraints.NotNull;

public class ProductRequestVo {

    private Integer id;

    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "MRP is mandatory")
    private Double mrp;

    @NotNull(message = "Category id is mandatory")
    private Integer categoryId;

    @NotNull(message = "Brand id is mandatory")
    private Integer brandId;

    @NotNull(message = "Gender is mandatory")
    private String gender;


    public ProductRequestVo() {
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

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
