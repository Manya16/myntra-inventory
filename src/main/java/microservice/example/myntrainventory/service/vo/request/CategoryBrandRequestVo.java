package microservice.example.myntrainventory.service.vo.request;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class CategoryBrandRequestVo {

    private Integer id;

    @NotNull(message = "category id is mandatory")
    private Integer categoryId;

    @NotNull(message = "brand id is mandatory")
    private Integer brandId;

    @NotNull(message = "active flag  is mandatory")
    private Boolean active;

    public CategoryBrandRequestVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
