package com.aycode.eshop.service;

import com.aycode.eshop.dto.ProductDto;
import com.aycode.eshop.model.Produit;

import java.util.List;

public interface ProductService {

    public List<Produit> getProductList();
    public ProductDto showAddProductPage();
    public Produit saveProduct(ProductDto productDto);


}
