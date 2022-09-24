package microservice.example.myntrainventory.service.vo.response;

public class ProductResponseVo {

    private Integer id;
    private String name;
    private Double mrp;
    private CategoryVo categoryVo;
    private BrandVo brandVo;

    private String gender;

    public ProductResponseVo() {
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

    public CategoryVo getCategoryVo() {
        return categoryVo;
    }

    public void setCategoryVo(CategoryVo categoryVo) {
        this.categoryVo = categoryVo;
    }

    public BrandVo getBrandVo() {
        return brandVo;
    }

    public void setBrandVo(BrandVo brandVo) {
        this.brandVo = brandVo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
