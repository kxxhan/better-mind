package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConference_History is a Querydsl query type for Conference_History
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConference_History extends EntityPathBase<Conference_History> {

    private static final long serialVersionUID = 529128339L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QConference_History conference_History = new QConference_History("conference_History");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Short> action = createNumber("action", Short.class);

    public final QConference conference;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.util.Date> inserted_time = createDateTime("inserted_time", java.util.Date.class);

    public final QUser user;

    public QConference_History(String variable) {
        this(Conference_History.class, forVariable(variable), INITS);
    }

    public QConference_History(Path<? extends Conference_History> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QConference_History(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QConference_History(PathMetadata metadata, PathInits inits) {
        this(Conference_History.class, metadata, inits);
    }

    public QConference_History(Class<? extends Conference_History> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.conference = inits.isInitialized("conference") ? new QConference(forProperty("conference")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

