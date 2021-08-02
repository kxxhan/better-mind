package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProgram_File is a Querydsl query type for Program_File
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgram_File extends EntityPathBase<Program_File> {

    private static final long serialVersionUID = -2080383175L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgram_File program_File = new QProgram_File("program_File");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath originfile = createString("originfile");

    public final QProgram program;

    public final StringPath savefile = createString("savefile");

    public final StringPath savefolder = createString("savefolder");

    public QProgram_File(String variable) {
        this(Program_File.class, forVariable(variable), INITS);
    }

    public QProgram_File(Path<? extends Program_File> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProgram_File(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProgram_File(PathMetadata metadata, PathInits inits) {
        this(Program_File.class, metadata, inits);
    }

    public QProgram_File(Class<? extends Program_File> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.program = inits.isInitialized("program") ? new QProgram(forProperty("program"), inits.get("program")) : null;
    }

}

