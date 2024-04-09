package com.aycode.eshop.service;

import com.aycode.eshop.dto.ProductDto;
import com.aycode.eshop.model.Produit;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

    List<Produit> getProductList();
    ProductDto showAddProductPage();
    Produit saveProduct(ProductDto productDto);
    Produit showEditPage(@RequestParam Long id);
    Produit updateProduct(@RequestParam Long id, ProductDto productDto);

    void deleteProduct(@RequestParam Long id);





}
