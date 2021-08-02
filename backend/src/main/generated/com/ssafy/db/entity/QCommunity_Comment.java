package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommunity_Comment is a Querydsl query type for Community_Comment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommunity_Comment extends EntityPathBase<Community_Comment> {

    private static final long serialVersionUID = -424008601L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommunity_Comment community_Comment = new QCommunity_Comment("community_Comment");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCommunity_Article community_article;

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public final QUser user;

    public QCommunity_Comment(String variable) {
        this(Community_Comment.class, forVariable(variable), INITS);
    }

    public QCommunity_Comment(Path<? extends Community_Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommunity_Comment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommunity_Comment(PathMetadata metadata, PathInits inits) {
        this(Community_Comment.class, metadata, inits);
    }

    public QCommunity_Comment(Class<? extends Community_Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.community_article = inits.isInitialized("community_article") ? new QCommunity_Article(forProperty("community_article"), inits.get("community_article")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

