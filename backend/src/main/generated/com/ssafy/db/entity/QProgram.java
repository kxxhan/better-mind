package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProgram is a Querydsl query type for Program
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgram extends EntityPathBase<Program> {

    private static final long serialVersionUID = -863189886L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgram program = new QProgram("program");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ComparablePath<Enum<CategoryEnum>> category = createComparable("category", Enum.class);

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath report = createString("report");

    public final StringPath time = createString("time");

    public final QUser user;

    public QProgram(String variable) {
        this(Program.class, forVariable(variable), INITS);
    }

    public QProgram(Path<? extends Program> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProgram(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProgram(PathMetadata metadata, PathInits inits) {
        this(Program.class, metadata, inits);
    }

    public QProgram(Class<? extends Program> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

