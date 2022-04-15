package uz.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.warehouse.model.RequestDto;
import uz.warehouse.model.ResponseDto;
import uz.warehouse.service.WarehouseService;

import java.util.List;

@RestController("/api/v1/")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping("/getResult")
    public List<ResponseDto> getWarehouseMaterials(@RequestBody List<RequestDto> requestDtoList){
        return warehouseService.getWarehouseResult(requestDtoList);
    }

}
