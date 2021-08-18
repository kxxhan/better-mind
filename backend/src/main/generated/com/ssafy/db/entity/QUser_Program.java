package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser_Program is a Querydsl query type for User_Program
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser_Program extends EntityPathBase<User_Program> {

    private static final long serialVersionUID = -471353678L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser_Program user_Program = new QUser_Program("user_Program");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QProgram program;

    public final QUser user;

    public QUser_Program(String variable) {
        this(User_Program.class, forVariable(variable), INITS);
    }

    public QUser_Program(Path<? extends User_Program> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser_Program(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser_Program(PathMetadata metadata, PathInits inits) {
        this(User_Program.class, metadata, inits);
    }

    public QUser_Program(Class<? extends User_Program> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.program = inits.isInitialized("program") ? new QProgram(forProperty("program"), inits.get("program")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

