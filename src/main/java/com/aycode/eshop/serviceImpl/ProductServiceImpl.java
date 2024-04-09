package com.aycode.eshop.serviceImpl;

import com.aycode.eshop.dto.ProductDto;
import com.aycode.eshop.mapper.ProductMapper;
import com.aycode.eshop.model.Categorie;
import com.aycode.eshop.model.Produit;
import com.aycode.eshop.repositroy.CategoryRepository;
import com.aycode.eshop.repositroy.ProductRepository;
import com.aycode.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Produit> getProductList() {
        return productRepository.findAllByOrderByPrixAsc();
    }

    @Override
    public ProductDto showAddProductPage() {
        return new ProductDto();
    }

    @Override
    public Produit saveProduct(ProductDto productDto) {
        Produit produit = new Produit();
        Categorie categorie = categoryRepository.findCategorieById(productDto.getCategorieId());

        produit.setDesignation(productDto.getDesignation());
        produit.setDescription(productDto.getDescription());
        produit.setPrix(productDto.getPrix());
        produit.setQte(productDto.getQte());
        produit.setCategorie(categorie);
        produit.setLigneCommandes(null);

        return productRepository.save(produit);
    }

    @Override
    public Produit showEditPage(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Produit updateProduct(Long id, ProductDto productDto) {
        Produit product = productRepository.findById(id).get();
        Categorie categorie = categoryRepository.findCategorieById(productDto.getCategorieId());

        product.setDesignation(productDto.getDesignation());
        product.setDescription(productDto.getDescription());
        product.setQte(productDto.getQte());
        product.setPrix(productDto.getPrix());
        product.setCategorie(categorie);
        product.setLigneCommandes(null);


        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Produit product = productRepository.findById(id).get();
        productRepository.delete(product);

    }


}
