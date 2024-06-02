package com.Ecommerce.demo.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends  BaseModel{
    private String title;
    private Double price;
    private String Description;
    private Category category;
    private String image;
}
