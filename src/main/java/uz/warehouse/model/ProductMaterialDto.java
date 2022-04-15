package uz.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductMaterialDto {


    @JsonProperty("warehouse_id")
    private Long warehouseId;

    @JsonProperty("material_name")
    private String materialName;

    @JsonProperty("qty")
    private double quantity;

    @JsonProperty("price")
    private Long price;

}
