package com.data.productdata.data.entity.embeddable;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RecItem {

    private String name;
    private String type;


}
