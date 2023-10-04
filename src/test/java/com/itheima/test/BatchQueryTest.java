package com.itheima.test;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 *
 * @author zhaoYI 2023-07-10 20:16
 * @version 0.1
 * @date 2023-07-10（注：最后更新日期）
 * Modification History:
 * Date         Author       Version     Description
 * ****************************************************
 * 2023-07-10   zhaoYI       0.1         初始开发
 **/

@SpringBootTest(classes=BatchQueryTest.class)
public class BatchQueryTest {

//    @Autowired
//    private AddressBookService addressBookService;
//
//    @Test
//    public void batchQuery(){
//
//        List<AddressBook> list = new ArrayList<AddressBook>();
//
//        for (int i = 0; i < 100; i++) {
//            AddressBook addressBook = new AddressBook();
//            addressBook.setUserId(111L);
//            addressBook.setDetail("detail");
//            list.add(addressBook);
//        }
//
//        boolean b = addressBookService.saveBatch(list);
//        System.out.println(b);
//        list.forEach(System.out::println);
//    }
}
