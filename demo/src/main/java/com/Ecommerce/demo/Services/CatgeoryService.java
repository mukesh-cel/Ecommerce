package com.Ecommerce.demo.Services;

import com.Ecommerce.demo.Componenet.FakeStoreCategoryComponent;
import com.Ecommerce.demo.DTO.CategoryResponseDTO;
import com.Ecommerce.demo.DTO.FakeStoreResponseDTO;
import com.Ecommerce.demo.DTO.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatgeoryService {

    private FakeStoreCategoryComponent fakeStoreCategoryComponent;
    @Autowired
    public CatgeoryService(FakeStoreCategoryComponent fakeStoreCategoryComponent){
        this.fakeStoreCategoryComponent=fakeStoreCategoryComponent;
    }
    public CategoryResponseDTO converttoCategryrespnsedto(FakeStoreResponseDTO fakeStoreResponseDTO) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setId(fakeStoreResponseDTO.getId());
        categoryResponseDTO.setTitle(fakeStoreResponseDTO.getTitle());
        categoryResponseDTO.setCategory(fakeStoreResponseDTO.getCategory());
        categoryResponseDTO.setDescription(fakeStoreResponseDTO.getDescription());
        categoryResponseDTO.setPrice(fakeStoreResponseDTO.getPrice());
        categoryResponseDTO.setImage(fakeStoreResponseDTO.getImage());


        return categoryResponseDTO;
    }
    public List<CategoryResponseDTO> getspecificcategoryproducts(String category){
        List<FakeStoreResponseDTO> fakeStoreResponseDTO=fakeStoreCategoryComponent.
                                   getspecificcategoryproducts(category);
        List<CategoryResponseDTO> categoryResponseDTOS= new ArrayList<>();
        for(FakeStoreResponseDTO f:fakeStoreResponseDTO){
            categoryResponseDTOS.add(converttoCategryrespnsedto(f));
        }
        return categoryResponseDTOS;
    }

    public void getallcategories(){
        List<CategoryResponseDTO> categoryResponseDTOS=fakeStoreCategoryComponent.getallcategories();
        for(CategoryResponseDTO c:categoryResponseDTOS){
            System.out.println(c.getCategory());
        }
    }
}

