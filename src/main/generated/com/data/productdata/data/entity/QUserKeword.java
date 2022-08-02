package com.data.productdata.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserKeword is a Querydsl query type for UserKeword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserKeword extends EntityPathBase<UserKeword> {

    private static final long serialVersionUID = 1328806562L;

    public static final QUserKeword userKeword = new QUserKeword("userKeword");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final SetPath<String, StringPath> keywords = this.<String, StringPath>createSet("keywords", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QUserKeword(String variable) {
        super(UserKeword.class, forVariable(variable));
    }

    public QUserKeword(Path<? extends UserKeword> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserKeword(PathMetadata metadata) {
        super(UserKeword.class, metadata);
    }

}

