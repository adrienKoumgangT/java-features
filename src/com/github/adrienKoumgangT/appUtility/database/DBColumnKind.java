package com.github.adrienKoumgangT.appUtility.database;

public enum DBColumnKind {
    NORMAL ("NORMAL"),
    GENERATED_VIRTUAL ("GENERATED_VIRTUAL"),
    GENERATED_STORED ("NORMAL")
    ;

    private final String key;

    DBColumnKind(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
