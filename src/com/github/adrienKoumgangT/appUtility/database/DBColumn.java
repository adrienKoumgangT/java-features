package com.github.adrienKoumgangT.appUtility.database;

public class DBColumn {

    private String name;
    private String comment;
    private DBDataType dataType;
    private Boolean notNull;
    private Long autoIncrement;

    private DBColumnKind columnKind;
    private String defaultExpression;
    private Boolean hidden;
    private String onUpdate;
    private String collation;

    public DBColumn(
            String name,
            String comment,
            DBDataType dataType,
            Boolean notNull,
            Long autoIncrement,
            DBColumnKind columnKind,
            String defaultExpression,
            Boolean hidden,
            String onUpdate,
            String collation
    ) {
        this.name               = name;
        this.comment            = comment;
        this.dataType           = dataType;
        this.notNull            = notNull;
        this.autoIncrement      = autoIncrement;
        this.columnKind         = columnKind;
        this.defaultExpression  = defaultExpression;
        this.hidden             = hidden;
        this.onUpdate           = onUpdate;
        this.collation          = collation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DBDataType getDataType() {
        return dataType;
    }

    public void setDataType(DBDataType dataType) {
        this.dataType = dataType;
    }
}
