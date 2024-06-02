package com.Ecommerce.demo.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products extends BaseModel{
    private String name;
    private Double price;
    private String Description;
    private Category category;
    private String image;
}
