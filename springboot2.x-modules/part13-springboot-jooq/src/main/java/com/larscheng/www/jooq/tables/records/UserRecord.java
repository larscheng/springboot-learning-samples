/*
 * This file is generated by jOOQ.
 */
package com.larscheng.www.jooq.tables.records;


import com.larscheng.www.jooq.tables.User;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record4<Integer, String, Integer, LocalDateTime> {

    private static final long serialVersionUID = 481139473;

    /**
     * Setter for <code>students.user.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>students.user.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>students.user.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>students.user.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>students.user.age</code>.
     */
    public void setAge(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>students.user.age</code>.
     */
    public Integer getAge() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>students.user.create_date</code>.
     */
    public void setCreateDate(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>students.user.create_date</code>.
     */
    public LocalDateTime getCreateDate() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Integer, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return User.USER.AGE;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return User.USER.CREATE_DATE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer component3() {
        return getAge();
    }

    @Override
    public LocalDateTime component4() {
        return getCreateDate();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Integer value3() {
        return getAge();
    }

    @Override
    public LocalDateTime value4() {
        return getCreateDate();
    }

    @Override
    public UserRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UserRecord value3(Integer value) {
        setAge(value);
        return this;
    }

    @Override
    public UserRecord value4(LocalDateTime value) {
        setCreateDate(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, Integer value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer id, String name, Integer age, LocalDateTime createDate) {
        super(User.USER);

        set(0, id);
        set(1, name);
        set(2, age);
        set(3, createDate);
    }
}
