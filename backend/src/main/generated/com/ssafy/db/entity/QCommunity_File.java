package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommunity_File is a Querydsl query type for Community_File
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommunity_File extends EntityPathBase<Community_File> {

    private static final long serialVersionUID = 533642356L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommunity_File community_File = new QCommunity_File("community_File");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCommunity_Article communityarticle;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath originfile = createString("originfile");

    public final StringPath savefile = createString("savefile");

    public final StringPath savefolder = createString("savefolder");

    public QCommunity_File(String variable) {
        this(Community_File.class, forVariable(variable), INITS);
    }

    public QCommunity_File(Path<? extends Community_File> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommunity_File(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommunity_File(PathMetadata metadata, PathInits inits) {
        this(Community_File.class, metadata, inits);
    }

    public QCommunity_File(Class<? extends Community_File> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.communityarticle = inits.isInitialized("communityarticle") ? new QCommunity_Article(forProperty("communityarticle"), inits.get("communityarticle")) : null;
    }

}

