package com.larscheng.www;

import com.larscheng.www.jooq.tables.pojos.Celebrity;
import com.larscheng.www.service.CelebrityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Part13SpringbootJooqApplicationTests {

    @Autowired
    private CelebrityService celebrityService;

    @Test
    void contextLoads() {
    }

    @Test
    void addTest() {
        Celebrity celebrity = new Celebrity(1, "张", "三", LocalDate.of(2001, 1, 1), "CN");
        Celebrity celebrity1 = new Celebrity(2, "张", "四", LocalDate.of(2002, 1, 1), "CN");
        Celebrity celebrity2 = new Celebrity(3, "张", "五", LocalDate.of(2003, 1, 1), "CN");
        List<Celebrity> list = new ArrayList<Celebrity>() {
            {
                add(celebrity);
                add(celebrity1);
                add(celebrity2);
            }
        };
        list.forEach(c->{
            System.out.println(celebrityService.create(c));
        });
    }

    @Test
    void find() {
        Optional.ofNullable(celebrityService.find()).ifPresent(c->{
            c.forEach(System.out::println);
        });
    }


    @Test
    void update() {
        Celebrity celebrity = new Celebrity();
        celebrity.setId(1);
        celebrity.setFirstName("张三");
        System.out.println(celebrityService.update(celebrity));
    }

    @Test
    void delete() {
        System.out.println(celebrityService.delete(3));
    }
}
