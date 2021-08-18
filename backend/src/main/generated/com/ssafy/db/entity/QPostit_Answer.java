package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostit_Answer is a Querydsl query type for Postit_Answer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPostit_Answer extends EntityPathBase<Postit_Answer> {

    private static final long serialVersionUID = 166907984L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostit_Answer postit_Answer = new QPostit_Answer("postit_Answer");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QPostit_Question postitquestion;

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public final QUser user;

    public QPostit_Answer(String variable) {
        this(Postit_Answer.class, forVariable(variable), INITS);
    }

    public QPostit_Answer(Path<? extends Postit_Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostit_Answer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostit_Answer(PathMetadata metadata, PathInits inits) {
        this(Postit_Answer.class, metadata, inits);
    }

    public QPostit_Answer(Class<? extends Postit_Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.postitquestion = inits.isInitialized("postitquestion") ? new QPostit_Question(forProperty("postitquestion")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

