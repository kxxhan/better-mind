package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProgram_Review is a Querydsl query type for Program_Review
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgram_Review extends EntityPathBase<Program_Review> {

    private static final long serialVersionUID = -1748277803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgram_Review program_Review = new QProgram_Review("program_Review");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QUser user;

    public QProgram_Review(String variable) {
        this(Program_Review.class, forVariable(variable), INITS);
    }

    public QProgram_Review(Path<? extends Program_Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProgram_Review(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProgram_Review(PathMetadata metadata, PathInits inits) {
        this(Program_Review.class, metadata, inits);
    }

    public QProgram_Review(Class<? extends Program_Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

