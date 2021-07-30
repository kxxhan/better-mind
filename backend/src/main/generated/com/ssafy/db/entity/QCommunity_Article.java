package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommunity_Article is a Querydsl query type for Community_Article
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommunity_Article extends EntityPathBase<Community_Article> {

    private static final long serialVersionUID = -2106785026L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommunity_Article community_Article = new QCommunity_Article("community_Article");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<Community_Comment, QCommunity_Comment> comment = this.<Community_Comment, QCommunity_Comment>createList("comment", Community_Comment.class, QCommunity_Comment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    public final ListPath<Community_File, QCommunity_File> file = this.<Community_File, QCommunity_File>createList("file", Community_File.class, QCommunity_File.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public final QUser user;

    public QCommunity_Article(String variable) {
        this(Community_Article.class, forVariable(variable), INITS);
    }

    public QCommunity_Article(Path<? extends Community_Article> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommunity_Article(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommunity_Article(PathMetadata metadata, PathInits inits) {
        this(Community_Article.class, metadata, inits);
    }

    public QCommunity_Article(Class<? extends Community_Article> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

