package com.data.productdata.data.entity.embeddable;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSiteInfo is a Querydsl query type for SiteInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSiteInfo extends BeanPath<SiteInfo> {

    private static final long serialVersionUID = -1970748949L;

    public static final QSiteInfo siteInfo = new QSiteInfo("siteInfo");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath site = createString("site");

    public QSiteInfo(String variable) {
        super(SiteInfo.class, forVariable(variable));
    }

    public QSiteInfo(Path<? extends SiteInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSiteInfo(PathMetadata metadata) {
        super(SiteInfo.class, metadata);
    }

}

