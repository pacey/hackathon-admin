package org.hackers;

import org.hackers.app.config.AppConfig;
import org.hackers.app.config.TestAppConfig;
import org.hackers.domain.config.DomainConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(classes = {AppConfig.class, TestAppConfig.class, DomainConfig.class}, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("test")
public abstract class AbstractApplicationTest {
}
