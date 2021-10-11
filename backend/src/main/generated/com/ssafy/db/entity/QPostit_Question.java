package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostit_Question is a Querydsl query type for Postit_Question
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPostit_Question extends EntityPathBase<Postit_Question> {

    private static final long serialVersionUID = 818475000L;

    public static final QPostit_Question postit_Question = new QPostit_Question("postit_Question");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> created_at = createDateTime("created_at", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.util.Date> updated_at = createDateTime("updated_at", java.util.Date.class);

    public QPostit_Question(String variable) {
        super(Postit_Question.class, forVariable(variable));
    }

    public QPostit_Question(Path<? extends Postit_Question> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostit_Question(PathMetadata metadata) {
        super(Postit_Question.class, metadata);
    }

}

