package com.Ecommerce.demo.Controllers;

import com.Ecommerce.demo.DTO.CategoryResponseDTO;
import com.Ecommerce.demo.DTO.ProductResponseDTO;
import com.Ecommerce.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreAPIService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public ProductResponseDTO getproductbyId( @PathVariable("id") Long id){
        return productService.getproductbyId(id);
    }
    @GetMapping
    public List<ProductResponseDTO> getallproducts(){
        return productService.getallproducts();
    }

    @PostMapping
    public ProductResponseDTO addnewproduct(@RequestBody ProductResponseDTO productResponseDTO){
        return productService.addnewproduct(productResponseDTO);
    }
    @PutMapping("update/{id}")
    public ProductResponseDTO updateaproduct(@PathVariable("id") Long Id,@RequestBody ProductResponseDTO productResponseDTO){
        return  productService.updateaproduct(Id,productResponseDTO);
    }
    @DeleteMapping("/{id}")
    public ProductResponseDTO deleteprductbyid(@PathVariable("id")Long id){
        return  productService.deleteprductbyid(id);
    }
    @GetMapping("/pagingproducts/{pagenumber}/{pagesize}")
    public List<ProductResponseDTO> paginationproducts(@PathVariable("pagenumber") Long pagenumber,
                                                       @PathVariable("pagesize")  Long pagesize){

        return  productService.paginationproducts(pagenumber,pagesize);
    }
}
