package microservice.example.myntrainventory.service.vo.request;

import microservice.example.myntrainventory.dao.model.Product;

import javax.validation.constraints.NotNull;

public class ProductVariantRequestVo {

    private Integer id;

    @NotNull(message = " size is mandatory")
    private String size;

    @NotNull(message = " quantity is mandatory")
    private Integer quantity;

    public ProductVariantRequestVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
