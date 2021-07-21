package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConference_Category is a Querydsl query type for Conference_Category
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConference_Category extends EntityPathBase<Conference_Category> {

    private static final long serialVersionUID = 603432415L;

    public static final QConference_Category conference_Category = new QConference_Category("conference_Category");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QConference_Category(String variable) {
        super(Conference_Category.class, forVariable(variable));
    }

    public QConference_Category(Path<? extends Conference_Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConference_Category(PathMetadata metadata) {
        super(Conference_Category.class, metadata);
    }

}

