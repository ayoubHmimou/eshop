package com.aycode.eshop.controller;

import com.aycode.eshop.dto.ProductDto;
import com.aycode.eshop.model.Produit;
import com.aycode.eshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.sampled.Port;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping({"", "/"})
    public String showProductList(Model model){
        List<Produit> products = productService.getProductList();
        model.addAttribute("products", products);

        return "admin/product/product-list";
    }

    @GetMapping("/add")
    public String showAddProductPage(Model model){
        ProductDto productDto = productService.showAddProductPage();
        model.addAttribute("productDto", productDto);

        return "admin/product/add-product";
    }

    @PostMapping("/add")
    public String savePorduct(@Valid @ModelAttribute ProductDto productDto, BindingResult result){
        productService.saveProduct(productDto);

        if(result.hasErrors()){
            return "redirect:/add";
        }

        return "redirect:/products";
    }


}
