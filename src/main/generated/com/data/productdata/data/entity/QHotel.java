package com.data.productdata.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHotel is a Querydsl query type for Hotel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHotel extends EntityPathBase<Hotel> {

    private static final long serialVersionUID = 1731412545L;

    public static final QHotel hotel = new QHotel("hotel");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QHotel(String variable) {
        super(Hotel.class, forVariable(variable));
    }

    public QHotel(Path<? extends Hotel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHotel(PathMetadata metadata) {
        super(Hotel.class, metadata);
    }

}

