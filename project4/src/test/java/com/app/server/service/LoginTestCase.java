package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(9);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("PqK3DhX0FwVs71wgzG3Lo0dC9O02Fq40b2f8LJBLLpv2CrgWrf");
            corecontacts.setFirstName("sQD6xgUMszOMnlv3GB6DSqKsTtoOt4XrwplgOGdimDbwuO80M1");
            Gender gender = new Gender();
            gender.setGender("IwSrLBHOYxTsauLoIFGtCfJMIbHv04yHkxPI2ixOSpTQEQCmYq");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Ym");
            language.setAlpha3("M3w");
            language.setAlpha4("X7wN");
            language.setAlpha4parentid(10);
            language.setLanguage("KpH6pqVm1EYQ3VBSxqL2F3V66R9Qa4kIfZq1vxRLUZtC3ocxZs");
            language.setLanguageDescription("WUGpNX1XgSkhOIlwgTOU5rCX2IgmYyaH5BOEy2uQTGbfvw83Ev");
            language.setLanguageIcon("3HVErFEs9qqJYfXpqfIyWlxy6h3x9VnNUJK1i9NG366iSkMp9k");
            language.setLanguageType("pq4v3bELXCrijCYGcxx2kdC8nm3ATxIP");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("kewfebLEkPRPfhT9CEOtbMCVvnpLobGMjmtKbwEJZbX0WZPhDx");
            timezone.setCountry("nEfmzYFohBOjNA1VQPwhdl7AyT9up2nuPfsHXaJ2gXTyTe0tSg");
            timezone.setGmtLabel("xAsKboRE9EJQ5W2o4FJI0PIxvSKYDPHMJV8CNb7KewHeThpCNG");
            timezone.setTimeZoneLabel("D4W2mkYMiSVyadPOBi1c1tyiVuko0wVhmhI0MKfMzqeEELbkOd");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("ufhvcuUoaq9dCCIUW8ijiauLRAC3E8v5Lg2O9NOd49lq1xmk0z");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(33);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("xbf6XbNCrBCYp0nrbJfM40NcCVuBh19sU38tXbjs3OPfMJEtPP");
            corecontacts.setFirstName("SMBJ11rtzuMDcC7oNcnXSE4ZcQ9ARnbqbew6GWqYNlCgCm5NlQ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("ovFlVrrBA6Mn8XYvtW3UuYxpRWFL9wa1xuLcBK04eMztMYDl4O");
            corecontacts.setMiddleName("sOKcnPaE5nEIIUaHr2SAtBWQF0CiklodY7SswC5dECRcLDPENc");
            corecontacts.setNativeFirstName("aSt6iR61ccWJB2bJWBivrfaxFYjvtLEUFwVCTP8OdXu7V0kCAf");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("b0vkNH3J5uyMOWqs5OA15VIxXBVm4Dk9ET6VvE7swWQJXDSM3k");
            corecontacts.setNativeMiddleName("oKl4xtXe9AcfiWaworSaIecbIQSo8w6EsmRWWzBgUqFChyfGOt");
            corecontacts.setNativeTitle("iRhGThDrZD4QCQPMU4K7PwIpMCGq3IELtjPebDxIVmvXdv1Jx0");
            corecontacts.setPhoneNumber("lbdCnmuTxoWiYjkn0ULo");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("1aHBjXWGhYTTbz57kEd7LsUWJcbntPuF7qU5S67ERK1JR12UrY");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2448);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("e77l0LlCboBi6TGplWs1yA83CIVrEr61aELNC6bZWUH6ZpbrdR");
            useraccessdomain.setDomainHelp("4nJ7iQrSLSeU9v4EEIt1fTR2jNJ8l52Q112B2lylwqaNI6CnGX");
            useraccessdomain.setDomainIcon("75fl3js1SIW26x0ZjaaVlLkTzLL3WR4PYmoNxOOeMuWRsfEooT");
            useraccessdomain.setDomainName("lhl0CJfpmkqQ0EFwbgBhfoflVknZxM2W23xLkmrm4UbCzdmneN");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("OQ6WaL9NNXJH33jO7epwcCnKdPTedjQLNbWqAUcV1cFxLD16hz");
            useraccesslevel.setLevelHelp("0WstEsP7BPTPXNKJ86r6tqlTlGGYOGi8aUZXJWa4QuXbkERSE4");
            useraccesslevel.setLevelIcon("nHtfgMbESmNq5xgAbSA30Gx4bOPSLGR4h8SvtcAPHusA5gr3NP");
            useraccesslevel.setLevelName("Gl6d5vdylafivtTFjgAgiScYcrMDsNe1rzfABKQtcvVl3Wzykb");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("hJJwhDHOAet1VYu3eMo9D3wJZVihm7nyefyesv3Sf8EMrBkihl");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1635);
            user.setUserAccessCode(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("3DPrEl0njI6nztMlSgLxwcFS4lSjoatha01JjDl2ImL33Sla0b");
            login.setServerAuthImage("GgyVHiJvqaOmC4N5TSWue7iSiJZN50wG");
            login.setServerAuthText("YcfIEv8o9UWHKjiI");
            user.setUserId(null);
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
            login.setFailedLoginAttempts(5);
            login.setLoginId("OJuRtY934WKmkY8wFxaMHt4zAMvn2uTfPbjOEp7aAKIKv2f8ac");
            login.setServerAuthImage("IkmIFQcOEvPbVxp4mcyb63DZlVVpfApo");
            login.setServerAuthText("4j9jFHONTnwJ8wFa");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
