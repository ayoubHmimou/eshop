package com.aycode.eshop.mapper;

import com.aycode.eshop.dto.ProductDto;
import com.aycode.eshop.model.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "categorie.id", target = "categorieId")
    ProductDto productToProductDto(Produit produit);
    @Mapping(source = "categorieId", target = "categorie.id")
    Produit productDtoToProduct(ProductDto productDto);
}
