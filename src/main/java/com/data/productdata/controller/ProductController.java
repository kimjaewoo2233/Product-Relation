package com.data.productdata.controller;

import com.data.productdata.data.dto.ChangeProductNameDto;
import com.data.productdata.data.dto.ProductDto;
import com.data.productdata.data.dto.ProductResponseDto;
import com.data.productdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{number}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long number){
        ProductResponseDto dto =service.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestBody ProductDto dto
    ){
        ProductResponseDto responseDto = service.saveProduct(dto);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto dto
    ) throws Exception{
        ProductResponseDto responseDto = service.changeProductName(
                dto.getNumber(),
                dto.getName()
        );
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);

    }


    @DeleteMapping("{number}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long number) throws Exception{
        service.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다");

    }

}
