package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle_Like is a Querydsl query type for Article_Like
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticle_Like extends EntityPathBase<Article_Like> {

    private static final long serialVersionUID = 547234338L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle_Like article_Like = new QArticle_Like("article_Like");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCommunity_Article article;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QUser user;

    public QArticle_Like(String variable) {
        this(Article_Like.class, forVariable(variable), INITS);
    }

    public QArticle_Like(Path<? extends Article_Like> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticle_Like(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticle_Like(PathMetadata metadata, PathInits inits) {
        this(Article_Like.class, metadata, inits);
    }

    public QArticle_Like(Class<? extends Article_Like> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QCommunity_Article(forProperty("article"), inits.get("article")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

