package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.LoginRepository;
import salesdemo.app.shared.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import salesdemo.app.shared.contacts.CoreContacts;
import salesdemo.app.server.repository.CoreContactsRepository;
import salesdemo.app.shared.contacts.Gender;
import salesdemo.app.server.repository.GenderRepository;
import salesdemo.app.shared.location.Language;
import salesdemo.app.server.repository.LanguageRepository;
import salesdemo.app.shared.location.Timezone;
import salesdemo.app.server.repository.TimezoneRepository;
import salesdemo.app.shared.contacts.Title;
import salesdemo.app.server.repository.TitleRepository;
import salesdemo.app.shared.authentication.User;
import salesdemo.app.server.repository.UserRepository;
import salesdemo.app.shared.authentication.UserAccessDomain;
import salesdemo.app.server.repository.UserAccessDomainRepository;
import salesdemo.app.shared.authentication.UserAccessLevel;
import salesdemo.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(70);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("eyvUqIEv55r5dfiz1ntVMY0sP5PKKroGg871lkfvPh7GZHTzks");
            corecontacts.setFirstName("GnxzjyCni2x3n3hCzELQlmVMTt09OHijmv02nnxEXrAyI0n8jo");
            Gender gender = new Gender();
            gender.setGender("UylE0BxIDZvaCev5mtmtFZhlp2VntzAHyZN1iPcH4pfHe83BAv");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ze");
            language.setAlpha3("2IM");
            language.setAlpha4("LkJO");
            language.setAlpha4parentid(3);
            language.setLanguage("JPO1e3TOKyxgcS3XxmD9cIul1dwOR1oieFSNg4y6lsy79Phc9A");
            language.setLanguageDescription("I1q8QmUhwT2w4rCaXp13JH5BzSvBG7RLJC2QFwZ6x3i5XASchf");
            language.setLanguageIcon("230858ZNyRXDIvQF89fUW2mOo2qLXWRW62hI9RBM8PqtXdUoLX");
            language.setLanguageType("IsJJm4Y0TN0TXtNC9fgj6NzbAb1O1VaD");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("EJpX42IwIWNcHd50nQOTvHu498NfmZ2bDg812NoNc6GG7OIUOc");
            timezone.setCountry("wv6wlqSqJDee16unCDfGn6pxeIGuGBgMwdi5YMGC4ggprlp24b");
            timezone.setGmtLabel("TR5aqGI0QXLJmDRhdivU0B9AjoSzpLkoqFqYyvSC01TSEg0d7Z");
            timezone.setTimeZoneLabel("cwqmjpHS6l1dTBbB0hJ61qyXm9rATFVNVLb5j1AhdENUsV2sT5");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("9AuWptIQVfKzul4IcoEnZXcVNcCl7JhxveFXRvmQAA6Ywx9Z14");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(62);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("jHdJdVAyxh20KIwNgrso9xfKD6Eb91Q89bl2QTAYUZJw7KT0JS");
            corecontacts.setFirstName("KDUSvEjL83YVlUZGnvF4oLq5OYdUSclEPnhTw8r0UajDv8deBm");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("pCD0GWEYtkB5EYB7LbouDrZSoEYwNZudUxBXMfDrgYHbJXquc3");
            corecontacts.setMiddleName("hbkwbEd2UmKiCUTZrYxyX2VJmpGoRVr0dXs8EU3Sc5shDSSKy1");
            corecontacts.setNativeFirstName("BTriiCEtvDkpwLvz4XPrEjC4NUJLdhqD6oEFgFZOssMTyphCSH");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("9qlnVRBUPrJt3RySmQM3b2SzPUkVIOJzSUkRYAnWKSEdpdXIhn");
            corecontacts.setNativeMiddleName("Hhzneuv5qJVRwPIijbnZsqElsaNHoQIkw0vTW82jnGRhwn3fB1");
            corecontacts.setNativeTitle("4CNmNaemWQCDOvQlc3HxgJBx8ef5UXW0o5tkbCqEy6t7Vu2LHe");
            corecontacts.setPhoneNumber("UGNjIAiwFGVLrXdOEl0E");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("uFBfWlW56y44kQPt8593mgB4zMEHXJDugVGundjo5RRX44skAu");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1394);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("arVf3MlqC9uIy3H1IAYuJC4jADyNizesPsmZG33nCswf1yoM5j");
            useraccessdomain.setDomainHelp("WAV9lJvhOU5Ceqkh68oeXszNaD2EV4jURM2YKdjUK1YJwd3hFn");
            useraccessdomain.setDomainIcon("r1DC5Nx6W7XGZCi2Lm8INvx0MhCxuo0MnjVVH56cgrZaTguJWZ");
            useraccessdomain.setDomainName("fyyR6RF6bJAbh8TIh5cB673zfc3AWjVHXeM9wAVYOlMaRJIXBv");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("U0Pj2iNx4kjovj2N3bYH0mPqRWe5GS5XQF0yEaddnUgeS3kmy6");
            useraccesslevel.setLevelHelp("V8ag5Bjq3SXNR4280oKzUFUba70djCofoYXOvtCA2WGghulkkk");
            useraccesslevel.setLevelIcon("Ab3Zw5KL0EPipEA5R2Lo3qgUrl7eOkiSXAWslY4PzKRNwElv6a");
            useraccesslevel.setLevelName("oZbiwGaPHZfqmENrMPIf5l7T0dV0o6s3MICgZWOjJLp33AGwdu");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("dDkbikDItvUGre6cWbCdDHz3f3PF2fKNNfzAkozxkwAuT7JiAF");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1372);
            user.setUserAccessCode(10);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(11);
            login.setIsAuthenticated(true);
            login.setLoginId("ABHIFu42B3ObhsNXCt6bmmqItwYqYf76QR0ILIBRLed3iIceui");
            login.setServerAuthImage("8OldLBHpMzfRql8REc0ysYb0UeKixNnt");
            login.setServerAuthText("5TB4hoBLGrOwXCNz");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(11);
            login.setLoginId("mfpZmrE8pKJixoWLxi6iC9RXugOzjYRKNDHoN72MJL3sFRmgBc");
            login.setServerAuthImage("iIiFM62lQtf5OGSm7TA1wcFQwo1c56T8");
            login.setServerAuthText("Cv0Vkfaf8iY9UpXC");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
