package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConference is a Querydsl query type for Conference
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConference extends EntityPathBase<Conference> {

    private static final long serialVersionUID = -625543586L;

    public static final QConference conference = new QConference("conference");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.util.Date> call_end_time = createDateTime("call_end_time", java.util.Date.class);

    public final DateTimePath<java.util.Date> call_start_time = createDateTime("call_start_time", java.util.Date.class);

    public final ListPath<Category, QCategory> category = this.<Category, QCategory>createList("category", Category.class, QCategory.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath is_active = createBoolean("is_active");

    public final StringPath thumbnail_url = createString("thumbnail_url");

    public final StringPath title = createString("title");

    public final ListPath<User_Conference, QUser_Conference> user = this.<User_Conference, QUser_Conference>createList("user", User_Conference.class, QUser_Conference.class, PathInits.DIRECT2);

    public QConference(String variable) {
        super(Conference.class, forVariable(variable));
    }

    public QConference(Path<? extends Conference> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConference(PathMetadata metadata) {
        super(Conference.class, metadata);
    }

}

