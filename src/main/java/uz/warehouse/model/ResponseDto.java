package uz.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseDto {

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_qty")
    private long productQty;

    @JsonProperty("product_materials")
    private List<ProductMaterialDto> productMaterials = new ArrayList<>();

}
