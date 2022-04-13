package uz.warehause.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.warehause.model.RequestDto;
import uz.warehause.model.ResponseDto;
import uz.warehause.service.WarehouseService;

import java.util.List;

@RestController("/api/v1/")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping("/getResult")
    public List<ResponseDto> getWarehouseMaterials(@RequestBody List<RequestDto> requestDtoList){
        return warehouseService.getWarehouseResult(requestDtoList);
    }

}
