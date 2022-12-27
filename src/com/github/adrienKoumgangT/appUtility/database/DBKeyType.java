package com.github.adrienKoumgangT.appUtility.database;

public enum DBKeyType {
    PRIMARY_KEY ("PRIMARY KEY"),
    SUPER_KEY ("SUPER KEY"),
    CANDIDATE_KEY ("CANDIDATE KEY"),
    ALTERNATE_KEY ("ALTERNATE_KEY"),
    FOREIGN_KEY ("FOREIGN KEY"),
    COMPOSITE_KEY ("COMPOSITE KEY"),
    UNIQUE_KEY ("UNIQUE KEY")
    ;

    private final String key;

    DBKeyType(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
