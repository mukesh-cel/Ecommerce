package com.Ecommerce.demo.Services;


import com.Ecommerce.demo.Componenet.FakestoreComponent;
import com.Ecommerce.demo.DTO.FakeStoreResponseDTO;
import com.Ecommerce.demo.DTO.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreAPIService")
public class FakeStoreAPIService implements ProductService{

    private FakestoreComponent fakestoreComponent;


    @Autowired
    public FakeStoreAPIService(FakestoreComponent fakestoreComponent){
        this.fakestoreComponent=fakestoreComponent;

    }
    public ProductResponseDTO converttoProductrespnsedto(FakeStoreResponseDTO fakeStoreResponseDTO) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(fakeStoreResponseDTO.getId());
        productResponseDTO.setTitle(fakeStoreResponseDTO.getTitle());
        productResponseDTO.setCategory(fakeStoreResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreResponseDTO.getDescription());
        productResponseDTO.setPrice(fakeStoreResponseDTO.getPrice());
        productResponseDTO.setImage(fakeStoreResponseDTO.getImage());


        return productResponseDTO;
    }
    @Override
    public ProductResponseDTO getproductbyId(Long id) {
        FakeStoreResponseDTO fakeStoreResponseDTO=fakestoreComponent.getproductbyId(id);
        return converttoProductrespnsedto(fakeStoreResponseDTO);
    }

    @Override
    public List<ProductResponseDTO> getallproducts() {
        List<FakeStoreResponseDTO> fakeStoreResponseDTO= fakestoreComponent.getallproducts();
        List<ProductResponseDTO> productResponseDTOS= new ArrayList<>();
        for(FakeStoreResponseDTO f:fakeStoreResponseDTO){
            productResponseDTOS.add(converttoProductrespnsedto(f));
        }
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO addnewproduct(ProductResponseDTO productResponseDTO) {
        FakeStoreResponseDTO fakeStoreResponseDTO=fakestoreComponent.addnewproduct(productResponseDTO);

        return converttoProductrespnsedto(fakeStoreResponseDTO);
    }

    @Override
    public ProductResponseDTO updateaproduct(Long id,ProductResponseDTO productResponseDTO) {
        FakeStoreResponseDTO fakeStoreResponseDTO=fakestoreComponent.updateaproduct(id,productResponseDTO);
        return converttoProductrespnsedto(fakeStoreResponseDTO);


    }

    @Override
    public ProductResponseDTO deleteprductbyid(Long id) {
        FakeStoreResponseDTO fakeStoreResponseDTO= fakestoreComponent.deleteprductbyid(id);
        return converttoProductrespnsedto(fakeStoreResponseDTO);
    }

    @Override
    public List<ProductResponseDTO> paginationproducts(Long pagenumber, Long pagesize) {

        return null;
    }
}
