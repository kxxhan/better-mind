package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser_Conference is a Querydsl query type for User_Conference
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser_Conference extends EntityPathBase<User_Conference> {

    private static final long serialVersionUID = -1154181586L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser_Conference user_Conference = new QUser_Conference("user_Conference");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QConference conference;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QUser user;

    public QUser_Conference(String variable) {
        this(User_Conference.class, forVariable(variable), INITS);
    }

    public QUser_Conference(Path<? extends User_Conference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser_Conference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser_Conference(PathMetadata metadata, PathInits inits) {
        this(User_Conference.class, metadata, inits);
    }

    public QUser_Conference(Class<? extends User_Conference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.conference = inits.isInitialized("conference") ? new QConference(forProperty("conference"), inits.get("conference")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

