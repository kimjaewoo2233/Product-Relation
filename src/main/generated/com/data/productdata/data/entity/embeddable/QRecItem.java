package com.data.productdata.data.entity.embeddable;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecItem is a Querydsl query type for RecItem
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QRecItem extends BeanPath<RecItem> {

    private static final long serialVersionUID = 1411766189L;

    public static final QRecItem recItem = new QRecItem("recItem");

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public QRecItem(String variable) {
        super(RecItem.class, forVariable(variable));
    }

    public QRecItem(Path<? extends RecItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecItem(PathMetadata metadata) {
        super(RecItem.class, metadata);
    }

}

