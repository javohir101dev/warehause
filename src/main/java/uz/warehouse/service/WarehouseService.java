package uz.warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.warehouse.entity.Product;
import uz.warehouse.entity.ProductMaterials;
import uz.warehouse.entity.Warehouse;
import uz.warehouse.model.ProductMaterialDto;
import uz.warehouse.model.RequestDto;
import uz.warehouse.model.ResponseDto;
import uz.warehouse.repository.ProductMaterialRepo;
import uz.warehouse.repository.ProductRepo;
import uz.warehouse.repository.WarehouseRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final ProductRepo productRepo;
    private final ProductMaterialRepo productMaterialRepo;
    private final WarehouseRepo warehouseRepo;


    public List<ResponseDto> getWarehouseResult(List<RequestDto> requestDtoList) {

        List<Warehouse> warehouseList = warehouseRepo.findAll();

        List<ResponseDto> responseDtoList = new ArrayList<>();

        // requestdan kelgan har bir productni alylanib chiqadi
        for (RequestDto requestDto : requestDtoList) {

            Long productId = requestDto.getProductId();
            Integer quantity = requestDto.getQuantity();
            Optional<Product> optionalProduct = productRepo.findById(productId);
            if (!optionalProduct.isPresent()){
                throw new RuntimeException("Product in not found with id: " + productId);
            }
            Product product = optionalProduct.get();

            List<ProductMaterials> productMaterialRepoAllByProductNeed = productMaterialRepo.getAllByProduct(product);

//            product tayyorlash uchun kerak bo`ladigan materiallarnig umumiy miqdori hisoblanadi
            for (ProductMaterials materials : productMaterialRepoAllByProductNeed) {
                materials.setQuantity(materials.getQuantity() * quantity);
            }

            //            har bir material uchun alohida response dot
            ResponseDto responseDto = new ResponseDto();
            responseDto.setProductName(product.getName());
            responseDto.setProductQty(quantity);

//            productga kerak bo`ladigan har bir materialni olish uchun warehause boyicha aylanib chiqadi
            for (ProductMaterials totalMaterial : productMaterialRepoAllByProductNeed) {
                ProductMaterialDto productMaterialDto = new ProductMaterialDto();
                productMaterialDto.setMaterialName(totalMaterial.getMaterial().getName());

                for (int i = 0; i < warehouseList.size(); i++) {
                    Warehouse warehouse = warehouseList.get(i);
                    boolean isTheSameMaterial = warehouse.getMaterial().getId().equals(totalMaterial.getMaterial().getId());
                         productMaterialDto = new ProductMaterialDto();
                        productMaterialDto.setMaterialName(totalMaterial.getMaterial().getName());

//                        warehausdagi maretiallar yetali bo'lganida
                        if (warehouse.getRemainder() >= totalMaterial.getQuantity() && isTheSameMaterial){

                            productMaterialDto.setQuantity(totalMaterial.getQuantity());
                            productMaterialDto.setWarehouseId(warehouse.getId());
                            productMaterialDto.setPrice(warehouse.getPrice());

                            warehouse.setRemainder(warehouse.getRemainder() - totalMaterial.getQuantity());
                            totalMaterial.setQuantity(0);

                            List<ProductMaterialDto> productMaterials = responseDto.getProductMaterials();
                            productMaterials.add(productMaterialDto);
                            responseDto.setProductMaterials(productMaterials);
                            break;
//                            warehausdagi maretiallar yetali bo'lmaganda i-- siklni qayta aylanadi oxirgi material uchun
                        }else if (totalMaterial.getQuantity() > 0 && warehouse.getRemainder() > 0
                                && isTheSameMaterial){

                            productMaterialDto.setQuantity(warehouse.getRemainder());
                            productMaterialDto.setWarehouseId(warehouse.getId());
                            productMaterialDto.setPrice(warehouse.getPrice());

                            totalMaterial.setQuantity(totalMaterial.getQuantity() - warehouse.getRemainder());
                            warehouse.setRemainder(0);
                            List<ProductMaterialDto> productMaterials = responseDto.getProductMaterials();
                            productMaterials.add(productMaterialDto);
                            responseDto.setProductMaterials(productMaterials);
                            i--;
//                            material warehausda qolmagan holat sikl ohiri
                        }else if (i ==  (warehouseList.size() -1)){

                                productMaterialDto.setQuantity(totalMaterial.getQuantity());
                                productMaterialDto.setWarehouseId(null);

                                totalMaterial.setQuantity(0);

                                List<ProductMaterialDto> productMaterials = responseDto.getProductMaterials();
                                productMaterials.add(productMaterialDto);
                                responseDto.setProductMaterials(productMaterials);
                        }
                }
            }
            responseDtoList.add(responseDto);
        }
        return responseDtoList;
    }
}
