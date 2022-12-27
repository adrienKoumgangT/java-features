package com.github.adrienKoumgangT.appUtility.database;

/**
 * Cette énumération permet de lister les possibles types
 * contenu dans MySQL. (liste non exhaustive).
 * Pour plus de détails en ce qui concerne les types de données
 * en MySQL, voir <a href="https://dev.mysql.com/doc/refman/8.0/en/data-types.html">MySQL Data Types</a>.
 *
 * @author Adrien Koumgang Tegantchouang
 * @version December 2022
 * @since MySQL 8.0
 */
public enum DBDataType {
    // NUMERIC DATA TYPES

    /**
     * <h3>BIT[(M)] :</h3>
     * <p>
     * A bit-value type.
     * _M_ indicates the number of bits per value, from 1 to 64.
     * The default is 1 if _M_ is omitted.
     * </p>
     */
    BIT ("BIT"),
    /**
     * <h3>TINYINT [(M)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * A very small integer. The signed range is -128 to 127.
     * The unsigned range is 0 to 255.
     * </p>
     */
    TINYINT ("TINYINT"),
    /**
     * <h3>BOOL, BOOLEAN :</h3>
     * <p>
     * These types are synonyms for "TINYINT(1)".
     * A value of zero is considered false.
     * Nonzero values are considered true.
     * However, the values TRUE and FALSE are merely
     * aliases for 1 and 0, respectively.
     * </p>
     */
    BOOL ("BOOL"),
    BOOLEAN ("BOOLEAN"),
    /**
     * <h3>SMALLINT [(M)] [UNSIGNED} [ZEROFILL] :</h3>
     * <p>
     * A small integer. The signed range is -32768 to 32767.
     * The unsigned range is 0 to 16777215.
     * </p>
     */
    SMALLINT ("SMALLINT"),
    /**
     * <h3>MEDIUMINT [(M)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * A medium-sized integer. The signed range is -8388608 to 8388607.
     * The unsigned range is 0 to 16777215.
     * </p>
     */
    MEDIUMINT ("MEDIUMINT"),
    /**
     * <h3>INT [(M)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * A normal-size integer.
     * The signed range is -2147483648 to 2147483647.
     * The unsigned range is 0 to 4294967295.
     * </p>
     */
    INT ("INT"),
    /**
     * <h3>INTEGER [(M)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * This type is synonym for "INT".
     * </p>
     */
    INTEGER ("INTEGER"),
    /**
     * <h3>BIGINT [(M)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * A large integer.
     * The signed range is -9223372036854775808 to 9223372036854775807.
     * The unsigned range is 0 to 18446744073709551615.
     * </p>
     */
    BIGINT ("BIGINT"),
    /**
     * <h3>DECIMAL [(M[, D])] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * A packet "exact" fixed-point number. _M_ is the total number
     * of digits (the precision) and _D_ is the number of digits after
     * the decimal point (the scale).
     * </p>
     */
    DECIMAL ("DECIMAL"),
    /**
     * <h3>DEC [(M[, D])] [UNSIGNED] [ZEROFILL],
     * NUMERIC [(M[, D])] [UNSIGNED] [ZEROFILL],
     * FIXED [(M[, D])] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     * These types are synonyms for "DECIMAL".
     * The FIXED synonym is available
     * for compatibility with other database systems.
     * </p>
     */
    DEC ("DEC"),
    NUMERIC ("NUMERIC"),
    FIXED ("FIXED"),
    /**
     * <h3>FLOAT [(M, D)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     *  A small (single-precision) floating-pont number.
     * Permissible values are -3.402823466E+38 to -1.175494351E-38,
     * 0, and 1.17549351E-38 to 3.402823466E+38.
     * These are the theoretical limits, based on the IEEE standard.
     * The actual range might be slightly smaller depending on your hardware
     * or operating system.
     * </p>
     * <p>
     *     _M_ is the total number of digits and _D_ is the number of digits
     *     following the decimal point.
     *     If _M_ and _D_ are omitted, values are stored to the limits permitted
     *     by the hardware. A single-precision floating-point number
     *     is accurate to approximately 7 decimal places.
     * </p>
     */
    FLOAT ("FLOAT"),
    /**
     * <h3> DOUBLE [(M, D)] [UNSIGNED] [ZEROFILL] : </h3>
     * <p>
     *     A normal-size (double-precision) floating-point number.
     *     Permissible values are -1.7976931348623157E+308 to -2..2250738585072014E-308,
     *     0, and 2.225073858507201E-308 to 1.7976931348623157E+308.
     *     These are the theoretical limits, based on the IEEE standard.
     *     The actual range might be slightly smaller depending on your hardware
     *     or operating system.
     * </p>
     * <p>
     *     _M_ is the total number of digits and _D_ is the number of digits following
     *     the decimal point. If _M_ and _D_ are omitted, values are stored to the
     *     limits permitted by the hardware. A double-precision floating-point number is
     *     accurate to approximately 15 decimal places.
     * </p>
     */
    DOUBLE ("DOUBLE"),
    /**
     * <h3>DOUBLE PRECISION [(M, D)] [UNSIGNED] [ZEROFILL] :</h3>
     * <h3>REAL [(M, D)] [UNSIGNED] [ZEROFILL] :</h3>
     * <p>
     *     These types are synonyms for DOUBLE.
     *     Exception: If the REAL_AS_FLOAT SQL mode is enabled,
     *     REAL is a synonym for FLOAT rather than DOUBLE.
     * </p>
     */
    DOUBLE_PRECISION ("DOUBLE PRECISION"),
    REAL ("REAL"),

    // DATE AND TIME DATA TYPES

    /**
     * <h3>DATE:</h3>
     * <p>
     *     A date. The supported range is '1000-01-01' to '9999-12-31'.
     *     MySQL displays DATE values in 'YYYY-MM-DD' format, but permits
     *     assignment of values to DATE columns using either strings or numbers.
     * </p>
     */
    DATE ("DATE"),
    /**
     * <h3>DATETIME [(fsp)]</h3>
     * <p>
     *     A date and time combination. The supported range is
     *     '1000-01-01 00:00:00.000000' to '9999-12-31 23:59:59.999999'.
     *     MySQL displays DATETIME values in 'YYYY-MM-DD hh:mm:ss[.fraction]' format,
     *     but permits assignment of values to DATETIME columns using either strings or numbers.
     * </p>
     * <p>
     *     An optional _fsp_ value in the range from 0 to 6 may be given to specify fractional
     *     seconds precision. A value of 0 signifies that there is no fractional part.
     *     If omitted, the default precision is 0.
     * </p>
     */
    DATETIME ("DATETIME"),
    /**
     * <h3>TIMESTAMP [(fsp)]</h3>
     * <p>
     *     A timestamp. The range is '1970-01-01 00:00:01.000000' UTC
     *     to '2038-01-19 03:14:07.999999' UTC.
     *     TIMESTAMP values are stored as the number of seconds since
     *     the epoch ('1970-01-01 00:00:00' UTC).
     *     A TIMESTAMP cannot represent the value '1970-01-01 00:00:00'
     *     because that is equivalent to 0 seconds from the epoch
     *     and the value 0 is reserved for representing '0000-00-00 00:00:00',
     *     the "zero" TIMESTAMP value.
     * </p>
     * <p>
     *     An optional _fsp_ value in the range from 0 to 6 may be given to
     *     specify fractional seconds precision. A value of 0 signifies that there
     *     is no fractional part. If omitted, the default precision is 0.
     * </p>
     */
    TIMESTAMP ("TIMESTAMP"),
    /**
     * <h3>TIME [(fsp)] :</h3>
     * <p>
     *     A time. The range is '-838:59:59.000000' to '838:59:59.000000'.
     *     MySQL displays TIME values in 'hh:mm:ss[.fraction]' format,
     *     buts permits assignment of values to TIME columns using either strings
     *     or numbers.
     * </p>
     * <p>
     *     An optional _fsp_ value in the range from 0 to 6 may be given to
     *     specify fractional seconds precision. A value of 0 signifies that there
     *     is no fractional part. If omitted, the default precision is 0.
     * </p>
     */
    TIME ("TIME"),
    /**
     * <h3>YEAR [(4)]</h3>
     * <p>
     *     A year in 4-digit format. MySQL displays YEAR values in 'YYYY' format,
     *     but permits assignment of values to YEAR columns using either strings or numbers.
     *     Values display as 1901 to 2155, or 0000.
     * </p>
     */
    YEAR ("YEAR"),

    // STRING DATA TYPE

    /**
     * <h3>[NATIONAL] CHAR [(M)] [CHARACTER SET charset_name] [COLLATE collation_name] :</h3>
     * <p>
     *     A fixed-length string that is always right-padded with spaces
     *     to the specified length when stored. _M_ represents the column length in characters.
     *     The range of _M_ is 0 to 255.
     *     If _M_ is omitted, the length is 1.
     * </p>
     * <p>
     *     CHAR is shorthand for CHARACTER.
     *     NATIONAL CHAR (or its equivalent short form, NCHAR) is
     *     standard SQL way to define that a CHAR column should use
     *     some predefined character set. MySQL uses utf8mb3 as this predefined
     *     character set.
     * </p>
     * <p>
     *     The CHAR BYTE data type is an alias for the BINARY data type.
     *     This is a compatibility feature.
     * </p>
     */
    CHAR ("CHAR"),
    /**
     * <h3>[NATIONAL] VARCHAR (M) [CHARACTER SET charset_name] [COLLATE collation_name]</h3>
     * <p>
     *     A variable-length string. _M_ represents the maximum column length in characters.
     *     The range of _M_ is 0 to 65,535. The effective maximum length of a VARCHAR
     *     is subject to the maximum row size (65,535 bytes, which is shared among all columns)
     *     and the character set used.
     *     For example, utf8mb3 characters can require up to three bytes per character,
     *     so a VARCHAR column that uses the utf8mb3 character set can be declared
     *     to be a maximum of 21,844 characters.
     * </p>
     *<p>
     *     VARCHAR is shorthand for CHARACTER VARYING.
     *     NATIONAL VARCHAR is the standard SQL way to define that
     *     a VARCHAR column should use some predefined character set.
     *     MySQL uses utf8mb3 as this predefined character set.
     *     NVARCHAR is shorthand for NATIONAL VARCHAR.
     *</p>
     */
    VARCHAR ("VARCHAR"),
    /**
     * <h3>BINARY [(M)]</h3>
     * <p>
     *     The BINARY type is similar to the CHAR type, but stores binary strings rather than
     *     nonbinary character strings. An optional length _M_ represents the comlumn
     *     length in bytes. If omitted, _M_ defaults to 1.
     * </p>
     */
    BINARY ("BINARY"),
    /**
     * <h3>VARBINARY (M)</h3>
     * <p>
     *     The VARBINARY type is similar to the VARCHAR type, but stores
     *     binary strings rather than nonbinary character strings.
     *     _M_ represents the maximum column length in bytes.
     * </p>
     */
    VARBINARY ("VARBINARY"),
    /**
     * <h3>TINYBLOB</h3>
     * <p>
     *     A BLOB column with a maximum length of 255 (2^8 - 1) byes.
     *     Each TINYBLOB value is stored using a 1-byte length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     */
    TINYBLOB ("TINYBLOB"),
    /**
     * <h3>TINYTEXT [CHARACTER SET charset_name] [COLLATE collation_name]</h3>
     * <p>
     *     A TEXT column with a maximum length of 255 (2^8 - 1) characters.
     *     Each TINYTEXT value is stored using a 1-byte length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     */
    TINYTEXT ("TINYTEXT"),
    /**
     * <h3>BLOB [(M)]</h3>
     * <p>
     *     A BLOB column wih a maximum length of 65,535 (2^16 - 1) bytes.
     *     Each BLOB value is stored using a 2-byte length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     * <p>
     *     An optional length _M_ can be given for this type.
     *     If this is done, MySQL creates the column as the smallest
     *     BLOB type large enough to hold values _M_ bytes long.
     * </p>
     */
    BLOB ("BLOB"),
    /**
     * <h3>TEXT [(M)] [CHARACTER SET charset_name] [COLLATE collation_name]</h3>
     * <p>
     *     A TEXT column with a maximum length of 65,535 (2^16 - 1) characters.
     *     The effective maximum length is less if the value contains multibyte characters.
     *     Each TEXT value is stored using a 2-byte length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     * <p>
     *     An optional length _M_ can be given for this type. If this done,
     *     MySQL creates the column as the smallest TEXT type large enough
     *     to hold values _M_ characters long.
     * </p>
     */
    TEXT ("TEXT"),
    /**
     * <h3>MEDIUMBLOB</h3>
     * <p>
     *     A BLOB column with a maximum length of 16,777,215 (2^24 - 1) bytes.
     *     Each MEDIUMBLOB value is stored using a 3-bytes length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     */
    MEDIUMBLOB ("MEDIUMBLOB"),
    /**
     * <h3>MEDIUMTEXT [CHARACTER SET charset_name] [COLLATE collation_name]</h3>
     * <p>
     *     A TEXT column with a maximum length of 16,777,215 (2^24 - 1) characters.
     *     The effective maximum length is less if the value contains multibyte characters.
     *     Each MEDIUMTEXT value is stored using a 3-byte length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     */
    MEDIUMTEXT ("MEDIUMTEXT"),
    /**
     * <h3>LONGBLOB</h3>
     * <p>
     *     A BLOB column with a maximum length of 4,294,967,295 or 4GB (2^32 - 1) bytes.
     *     The effective maximum length of LONGBLOB columns depends on the configured
     *     maximum packet size in the client/server protocol and available memory.
     *     Each LONGBLOB value is stored using a 4-byte length prefix that indicates
     *     the number of bytes in the value.
     * </p>
     */
    LONGBLOB ("LONGBLOB"),
    /**
     * <h3>LONGTEXT [CHARACTER SET charset_name] [COLLATE collation_name]</h3>
     * <p>
     *     A TEXT column with a maximum length of 4,294,967,295 or 4GB (2^32 - 1) characters.
     *     The effective maximum length of LONGTEXT columns also depends on the configured
     *     maximum packet size in the client/server protocol and available memory.
     *     Each LONGTEXT value is stored using a 4-byte length prefix thant
     *     indicates number of bytes in the value.
     * </p>
     */
    LONGTEXT ("LONGTEXT"),
    /**
     * <h3>ENUM('value1','value2',...) [CHARACTER SET charset_name] (COLLATE collation_name]</h3>
     * <p>
     *     An enumeration. A string object that can have only one value,
     *     chosen from the list of value 'value1', 'value2', ..., NULL or
     *     the special '' error value.
     *     ENUM values are represented internally as integers.
     * </p>
     * <p>
     *     An ENUM column can have a maximum of 65,535 distinct elements.
     * </p>
     * <p>
     *     The maximum supported length of an individual ENUM element is M <= 255
     *     and (M x w) <= 1020, where _M_ is the element literal length and
     *     w is the number of bytes required for the maximum-length character
     *     in the character set.
     * </p>
     */
    ENUM ("ENUM"),
    /**
     * <h3>SET('value1,'value2',...) [CHARACTER SET charset_name] [COLLATE collation_name]</h3>
     * <p>
     *     A set. A String object that can have zero or more values, each of which must be
     *     chosen from the list of values 'value1','value2',... .
     *     SET values are represented internally as integers.
     * </p>
     * <p>
     *     A SET column can have a maximum of 64 distinct members.
     * </p>
     * <p>
     *     The maximum supported length of an individual SET element is M <= 255
     *     and (M x w) <= 1020, where _M_ is the element literal length and
     *     _w_ is the number of bytes required for the maximum-length character in the character set.
     * </p>
     */
    SET ("SET"),

    // SPATIAL DATA TYPES

    /// Some spatial data types hold single geometry values:

    /**
     * GEOMETRY can store geometry values of any type.
     * The other single-value types (POINT, LINESTRING, and POLYGON)
     * restrict their values to a particular geometry type.
     */
    GEOMERTY ("GEOMETRY"),
    POINT ("POINT"),
    LINESTRING ("LINESTRING"),
    POLYGON ("POLYGON"),

    /// The other spatial data types hold collections of values:
    MULTIPOINT ("MULTIPOINT"),
    MULTILINESTRING ("MULTILINESTRING"),
    MULTIPOLYGON ("MULTIPOLYGON"),
    /**
     * <p>
     *     GEOMETRYCOLLECTION can store a collection of objects of any type.
     *     The other collection (MULTIPOINT, MULTILINESTRING, and MULTIPOLYGON)
     *     restrict collection members to those having a particular geometry type.
     * </p>
     */
    GEOMETRYCOLLECTION ("GEOMETRYCOLLECTION"),

    // JSON DATA TYPE

    JSON ("JSON")
    ;

    private final String key;

    DBDataType(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
