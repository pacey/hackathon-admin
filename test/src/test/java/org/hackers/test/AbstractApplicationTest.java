package org.hackers.test;

import org.hackers.app.config.AppConfig;
import org.hackers.app.config.TestAppConfig;
import org.hackers.domain.config.DomainConfig;
import org.hackers.web.config.WebConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, TestAppConfig.class, DomainConfig.class})
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public abstract class AbstractApplicationTest extends AbstractTestNGSpringContextTests {
}
