package com.Ecommerce.demo.Controllers;

import com.Ecommerce.demo.DTO.CategoryResponseDTO;
import com.Ecommerce.demo.Services.CatgeoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CatgeoryService catgeoryService;
    @Autowired
    public CategoryController(CatgeoryService catgeoryService){
        this.catgeoryService=catgeoryService;
    }
    @GetMapping("/Categories/{category}")
    public List<CategoryResponseDTO> getspecificcategoryproducts(@PathVariable("category") String category){
        return  catgeoryService.getspecificcategoryproducts(category);
    }

    @GetMapping("/Categories")
    public void getallcategories(){
        catgeoryService.getallcategories();
    }

}
