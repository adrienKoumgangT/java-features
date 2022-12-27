package com.github.adrienKoumgangT.appUtility.database;


import java.util.List;

public class DBTable {
    private String name;
    private String comment = null;
    private String engine = "InnoDB";
    private String collation = "utf8mb4";
    private String partitionMethod = null;
    private String partitionExpression = null;
    private String subPartitionExpression = null;

    private List<DBColumn> columns;
}
