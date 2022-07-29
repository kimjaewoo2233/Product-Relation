package com.data.productdata.data.dto;

import lombok.Data;

@Data
public class ProductStatus {
    private int code;
    private String description;

    private boolean displayed;

    public boolean isDisplayed(){
        return code==200;
    }
    public ProductStatus(int code){
        this.code = code;
        this.description = parseDescription(code);
    }
    private String parseDescription(int code){
        switch (code){
            case 100:
                return "판매종료";
            case 200:
                return "판매중";
            case 300:
                return "판매완료";
            default:
                return "미지정";
        }
    }
}
