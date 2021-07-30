package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProgram_File is a Querydsl query type for Program_File
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgram_File extends EntityPathBase<Program_File> {

    private static final long serialVersionUID = -2080383175L;

    public static final QProgram_File program_File = new QProgram_File("program_File");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath originfile = createString("originfile");

    public final StringPath savefile = createString("savefile");

    public final StringPath savefolder = createString("savefolder");

    public QProgram_File(String variable) {
        super(Program_File.class, forVariable(variable));
    }

    public QProgram_File(Path<? extends Program_File> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgram_File(PathMetadata metadata) {
        super(Program_File.class, metadata);
    }

}

