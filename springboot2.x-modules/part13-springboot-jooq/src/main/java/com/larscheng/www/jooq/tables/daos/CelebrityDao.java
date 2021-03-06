/*
 * This file is generated by jOOQ.
 */
package com.larscheng.www.jooq.tables.daos;


import com.larscheng.www.jooq.tables.Celebrity;
import com.larscheng.www.jooq.tables.records.CelebrityRecord;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
@Repository
public class CelebrityDao extends DAOImpl<CelebrityRecord, com.larscheng.www.jooq.tables.pojos.Celebrity, Integer> {

    /**
     * Create a new CelebrityDao without any configuration
     */
    public CelebrityDao() {
        super(Celebrity.CELEBRITY, com.larscheng.www.jooq.tables.pojos.Celebrity.class);
    }

    /**
     * Create a new CelebrityDao with an attached configuration
     */
    @Autowired
    public CelebrityDao(Configuration configuration) {
        super(Celebrity.CELEBRITY, com.larscheng.www.jooq.tables.pojos.Celebrity.class, configuration);
    }

    @Override
    public Integer getId(com.larscheng.www.jooq.tables.pojos.Celebrity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Celebrity.CELEBRITY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchById(Integer... values) {
        return fetch(Celebrity.CELEBRITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.larscheng.www.jooq.tables.pojos.Celebrity fetchOneById(Integer value) {
        return fetchOne(Celebrity.CELEBRITY.ID, value);
    }

    /**
     * Fetch records that have <code>first_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchRangeOfFirstName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Celebrity.CELEBRITY.FIRST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>first_name IN (values)</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchByFirstName(String... values) {
        return fetch(Celebrity.CELEBRITY.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>last_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchRangeOfLastName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Celebrity.CELEBRITY.LAST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_name IN (values)</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchByLastName(String... values) {
        return fetch(Celebrity.CELEBRITY.LAST_NAME, values);
    }

    /**
     * Fetch records that have <code>date_of_birth BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchRangeOfDateOfBirth(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(Celebrity.CELEBRITY.DATE_OF_BIRTH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date_of_birth IN (values)</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchByDateOfBirth(LocalDate... values) {
        return fetch(Celebrity.CELEBRITY.DATE_OF_BIRTH, values);
    }

    /**
     * Fetch records that have <code>birth_place BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchRangeOfBirthPlace(String lowerInclusive, String upperInclusive) {
        return fetchRange(Celebrity.CELEBRITY.BIRTH_PLACE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>birth_place IN (values)</code>
     */
    public List<com.larscheng.www.jooq.tables.pojos.Celebrity> fetchByBirthPlace(String... values) {
        return fetch(Celebrity.CELEBRITY.BIRTH_PLACE, values);
    }
}
