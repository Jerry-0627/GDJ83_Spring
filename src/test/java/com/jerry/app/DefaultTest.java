package com.jerry.app;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
// 상속받으면 위의 RunWith, Contextconfiguration도 받아올 수 있음.
public abstract class DefaultTest {

}
