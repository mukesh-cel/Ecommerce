package com.Ecommerce.demo.DTO;

import com.Ecommerce.demo.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDTO {
    private Long id;
    private String title;
    private Double price;
    private String Description;
    private String category;
    private String image;
}
