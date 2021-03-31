/*
 * This file is generated by jOOQ.
 */
package com.larscheng.www.jooq;


import com.larscheng.www.jooq.tables.Celebrity;
import com.larscheng.www.jooq.tables.User;
import com.larscheng.www.jooq.tables.records.CelebrityRecord;
import com.larscheng.www.jooq.tables.records.UserRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>students</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CelebrityRecord> KEY_CELEBRITY_PRIMARY = UniqueKeys0.KEY_CELEBRITY_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<CelebrityRecord> KEY_CELEBRITY_PRIMARY = Internal.createUniqueKey(Celebrity.CELEBRITY, "KEY_celebrity_PRIMARY", Celebrity.CELEBRITY.ID);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.ID);
    }
}