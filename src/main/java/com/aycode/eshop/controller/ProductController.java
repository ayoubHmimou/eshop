package com.aycode.eshop.controller;

import com.aycode.eshop.dto.ProductDto;
import com.aycode.eshop.mapper.ProductMapper;
import com.aycode.eshop.model.Produit;
import com.aycode.eshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String showProductList(Model model){
        List<Produit> products = productService.getProductList();
        model.addAttribute("products", products);

        return "admin/product/product-list";
    }

    @GetMapping("/add")
    public String showAddPage(Model model){
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

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam Long id){
        try{
           Produit product = productService.showEditPage(id);
           model.addAttribute("product", product);

           ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(product);

           if(productDto != null &&
                   productDto.getDesignation().equals(product.getDesignation()) &&
                   productDto.getDescription().equals(product.getDescription()) &&
                   productDto.getQte() == product.getQte() &&
                   productDto.getPrix().equals(product.getPrix())&&
                   productDto.getCategorieId().equals(product.getCategorie().getId())
            ){
               model.addAttribute("productDto", productDto);
           }else{
               System.out.println("mapping Error");
           }
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/products";
        }
        return "admin/product/edit-product";
    }
    @PostMapping("/edit")
    public String updateProduct(Model model, @RequestParam Long id,@Valid @ModelAttribute ProductDto productDto, BindingResult result){
        try{
            productService.updateProduct(id, productDto);
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id){
        try {
            productService.deleteProduct(id);
        }catch (Exception e){
            System.out.println("Exception");
        }
        return "redirect:/products";
    }
}
