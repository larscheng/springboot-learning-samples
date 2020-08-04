package com.larscheng.www.service;

import com.larscheng.www.jooq.tables.pojos.Celebrity;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelebrityService {
    private final DSLContext dslContext;

    @Autowired
    public CelebrityService(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public int create(Celebrity c){
        com.larscheng.www.jooq.tables.Celebrity cc = new com.larscheng.www.jooq.tables.Celebrity();
        return dslContext.insertInto(cc)
                .columns(cc.ID,cc.FIRST_NAME,cc.LAST_NAME,cc.BIRTH_PLACE,cc.DATE_OF_BIRTH)
                .values(c.getId(),c.getFirstName(),c.getLastName(),c.getBirthPlace(),c.getDateOfBirth())
                .execute();
    }
    public int update(Celebrity c){
        com.larscheng.www.jooq.tables.Celebrity cc = new com.larscheng.www.jooq.tables.Celebrity();
        return dslContext.update(cc)
                .set(cc.FIRST_NAME,c.getFirstName())
                .where(cc.ID.eq(c.getId()))
                .execute();
    }

    public List<Celebrity> find(){
        com.larscheng.www.jooq.tables.Celebrity cc = new com.larscheng.www.jooq.tables.Celebrity();
        return dslContext.select().from(cc).fetchInto(Celebrity.class);
    }

    public int delete(int id){
        com.larscheng.www.jooq.tables.Celebrity cc = new com.larscheng.www.jooq.tables.Celebrity();
        return dslContext.delete(cc).where(cc.ID.eq(id)).execute();
    }
}
