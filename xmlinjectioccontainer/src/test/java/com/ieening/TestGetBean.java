package com.ieening;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring.xml");
    }

    /**
     * ! 1、通过类获取 bean，注意需要唯一，否则报错
     */
    @Test
    public void testGetBeanByClass() {
        CustomBean customBean = classPathXmlApplicationContext.getBean(CustomBean.class);
        assertTrue(customBean instanceof CustomBean);
    }

    /**
     * ! 2、通过 xml 配置文件中配置的 Id 获取 Bean
     */
    @Test
    public void testGetBeanById() {
        Object normalBean = classPathXmlApplicationContext.getBean("testGetBeanNormalBeanId");
        assertTrue(normalBean instanceof NormalBean);
    }

    /**
     * ! 3、通过 xml 配置文件中配置的 name 获取 Bean
     */
    @Test
    public void testGetBeanByName() {
        Object normalBean = classPathXmlApplicationContext.getBean("testGetBeanNormalBeanName");
        assertTrue(normalBean instanceof NormalBean);
    }

    /**
     * ! 4、通过 xml 配置文件中配置的 name 和类获取 Bean
     */
    @Test
    public void testGetBeanByNameAndClass() {
        Object normalBean = classPathXmlApplicationContext.getBean("testGetBeanNormalBeanName", NormalBean.class);
        assertTrue(normalBean instanceof NormalBean);
    }

    /**
     * ! 5、通过 xml 配置文件中配置的别名获取 Bean
     */
    @Test
    public void testGetBeanByAlias() {
        Object normalBean = classPathXmlApplicationContext.getBean("testGetBeanNormalBeanNameAlias");
        assertTrue(normalBean instanceof NormalBean);
    }

    @After
    public void tearDown() {
        if (classPathXmlApplicationContext != null) {
            classPathXmlApplicationContext.close();
        }
    }
}
