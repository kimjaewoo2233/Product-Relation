package com.data.productdata.data.entity.school;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAcademy is a Querydsl query type for Academy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAcademy extends EntityPathBase<Academy> {

    private static final long serialVersionUID = 1607495749L;

    public static final QAcademy academy = new QAcademy("academy");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Subject, QSubject> subjectList = this.<Subject, QSubject>createList("subjectList", Subject.class, QSubject.class, PathInits.DIRECT2);

    public QAcademy(String variable) {
        super(Academy.class, forVariable(variable));
    }

    public QAcademy(Path<? extends Academy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAcademy(PathMetadata metadata) {
        super(Academy.class, metadata);
    }

}

