package com.data.productdata.data.entity.convertor;

import com.data.productdata.data.dto.ProductStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductStatusConvertor implements AttributeConverter<ProductStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {

        return attribute.getCode();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        return dbData != null ? new ProductStatus(dbData) : null;
    }   //null이 있을 수 있어서 처리를 해줘야한다.
}
