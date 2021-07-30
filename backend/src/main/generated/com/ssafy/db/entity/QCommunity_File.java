package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommunity_File is a Querydsl query type for Community_File
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommunity_File extends EntityPathBase<Community_File> {

    private static final long serialVersionUID = 533642356L;

    public static final QCommunity_File community_File = new QCommunity_File("community_File");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath originfile = createString("originfile");

    public final StringPath savefile = createString("savefile");

    public final StringPath savefolder = createString("savefolder");

    public QCommunity_File(String variable) {
        super(Community_File.class, forVariable(variable));
    }

    public QCommunity_File(Path<? extends Community_File> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommunity_File(PathMetadata metadata) {
        super(Community_File.class, metadata);
    }

}

