package org.hackers.test;

import org.hackers.app.config.AppConfig;
import org.hackers.app.config.TestAppConfig;
import org.hackers.domain.config.DomainConfig;
import org.hackers.web.config.WebConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, TestAppConfig.class, DomainConfig.class})
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public abstract class AbstractApplicationTest {
}
