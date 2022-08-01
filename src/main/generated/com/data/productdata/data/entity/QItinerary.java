package com.data.productdata.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItinerary is a Querydsl query type for Itinerary
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItinerary extends EntityPathBase<Itinerary> {

    private static final long serialVersionUID = -1605745896L;

    public static final QItinerary itinerary = new QItinerary("itinerary");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<com.data.productdata.data.entity.embeddable.SiteInfo, com.data.productdata.data.entity.embeddable.QSiteInfo> sites = this.<com.data.productdata.data.entity.embeddable.SiteInfo, com.data.productdata.data.entity.embeddable.QSiteInfo>createList("sites", com.data.productdata.data.entity.embeddable.SiteInfo.class, com.data.productdata.data.entity.embeddable.QSiteInfo.class, PathInits.DIRECT2);

    public QItinerary(String variable) {
        super(Itinerary.class, forVariable(variable));
    }

    public QItinerary(Path<? extends Itinerary> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItinerary(PathMetadata metadata) {
        super(Itinerary.class, metadata);
    }

}

