package com.data.productdata.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberShip is a Querydsl query type for MemberShip
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberShip extends EntityPathBase<MemberShip> {

    private static final long serialVersionUID = -1361785975L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberShip memberShip = new QMemberShip("memberShip");

    public final EnumPath<Grade> grade = createEnum("grade", Grade.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QMemberShip(String variable) {
        this(MemberShip.class, forVariable(variable), INITS);
    }

    public QMemberShip(Path<? extends MemberShip> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberShip(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberShip(PathMetadata metadata, PathInits inits) {
        this(MemberShip.class, metadata, inits);
    }

    public QMemberShip(Class<? extends MemberShip> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

