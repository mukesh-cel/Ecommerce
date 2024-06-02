package com.Ecommerce.demo.Services;

import com.Ecommerce.demo.DTO.ProductResponseDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Primary
@Service
public interface ProductService {
    public ProductResponseDTO getproductbyId(Long id);
    public List<ProductResponseDTO> getallproducts();
    public ProductResponseDTO addnewproduct(ProductResponseDTO productResponseDTO);

    public ProductResponseDTO updateaproduct( Long id,ProductResponseDTO productResponseDTO);
    public ProductResponseDTO deleteprductbyid(Long id);
    public List<ProductResponseDTO> paginationproducts( Long pagenumber, Long pagesize);
}
