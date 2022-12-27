package com.github.adrienKoumgangT.appUtility.database;

public class DBColumnBuilder {

    private String name = null;
    private String comment = null;
    private DBDataType dataType = DBDataType.INT;
    private Boolean notNull = false;
    private Long autoIncrement = null;

    private DBColumnKind columnKind = DBColumnKind.NORMAL;
    private String defaultExpression = null;
    private Boolean hidden = false;
    private String onUpdate = null;
    private String collation = null;


}
