package com.Ecommerce.demo.Componenet;

import com.Ecommerce.demo.DTO.FakeStoreResponseDTO;
import com.Ecommerce.demo.DTO.ProductResponseDTO;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FakestoreComponent {
    private RestTemplateBuilder restTemplateBuilder;

    private String producturl ="https://fakestoreapi.com/products";
    @Autowired
    public FakestoreComponent(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public FakeStoreResponseDTO getproductbyId(Long id) {
        String getproducturl= producturl+"/{id}";
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO> responseEntity = restTemplate.
                                       getForEntity(getproducturl, FakeStoreResponseDTO.class,id);
        FakeStoreResponseDTO fakeStoreResponseDTO= responseEntity.getBody();
        return fakeStoreResponseDTO;
    }


    public List<FakeStoreResponseDTO> getallproducts(){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO[]> responseEntity= restTemplate.
                getForEntity(producturl, FakeStoreResponseDTO[].class);
        FakeStoreResponseDTO[] fakeStoreResponseDTO=responseEntity.getBody();

        return Arrays.asList(fakeStoreResponseDTO);
    }

    public FakeStoreResponseDTO addnewproduct(ProductResponseDTO productResponseDTO){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO> responseEntity=restTemplate.
                postForEntity(producturl,productResponseDTO, FakeStoreResponseDTO.class);

        FakeStoreResponseDTO fakeStoreResponseDTO=responseEntity.getBody();

        return  fakeStoreResponseDTO;
    }
    public FakeStoreResponseDTO updateaproduct(Long id, ProductResponseDTO productResponseDTO){
        RestTemplate restTemplate=restTemplateBuilder.build();
        String postproducturl = producturl + "/{id}";



        ResponseEntity<FakeStoreResponseDTO> responseEntity=restTemplate.
                exchange(postproducturl, HttpMethod.PUT,null,
                 FakeStoreResponseDTO.class,id);
        FakeStoreResponseDTO fakeStoreResponseDTO=responseEntity.getBody();
        return fakeStoreResponseDTO;
    }
    public FakeStoreResponseDTO deleteprductbyid(Long id) {
        String deleteproducturl = producturl + "/{id}";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO> responseEntity=restTemplate.
                  exchange(deleteproducturl,HttpMethod.DELETE,null, FakeStoreResponseDTO.class,id);
        FakeStoreResponseDTO fakeStoreResponseDTO=responseEntity.getBody();
        return fakeStoreResponseDTO;
    }
    public List<ProductResponseDTO> paginationproducts(Integer pagenumber, Integer pagesize) {
        String url ="https://fakestoreapi.com/products?sort=desc";
        Pageable pageable= PageRequest.of(pagenumber,pagesize, Sort.Direction.DESC,"id");
        RestTemplate restTemplate=restTemplateBuilder.build();
        //restTemplate.exchange()
        return null;
    }

}
