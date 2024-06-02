package com.Ecommerce.demo.Componenet;

import com.Ecommerce.demo.DTO.CategoryResponseDTO;
import com.Ecommerce.demo.DTO.FakeStoreResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreCategoryComponent {

    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeStoreCategoryComponent(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    private String categoryurl="https://fakestoreapi.com/products/category";
    public List<FakeStoreResponseDTO> getspecificcategoryproducts(String category){
        String url=categoryurl+"/{category}";
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO[]> responseEntity= restTemplate.
                              getForEntity(url,FakeStoreResponseDTO[].class,category);
        FakeStoreResponseDTO[] fakeStoreResponseDTO=responseEntity.getBody();
        return  Arrays.asList(fakeStoreResponseDTO);
    }

    public List<CategoryResponseDTO> getallcategories(){
        String url="https://fakestoreapi.com/products/categories";

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<CategoryResponseDTO[]> responseEntity=restTemplate.
                                              getForEntity(url, CategoryResponseDTO[].class);
        CategoryResponseDTO categoryResponseDTO[]= responseEntity.getBody();
        return Arrays.asList(categoryResponseDTO);
    }
}
