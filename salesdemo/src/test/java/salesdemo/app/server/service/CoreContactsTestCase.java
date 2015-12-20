package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.CoreContactsRepository;
import salesdemo.app.shared.contacts.CoreContacts;
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
import salesdemo.app.shared.contacts.Gender;
import salesdemo.app.server.repository.GenderRepository;
import salesdemo.app.shared.location.Language;
import salesdemo.app.server.repository.LanguageRepository;
import salesdemo.app.shared.location.Timezone;
import salesdemo.app.server.repository.TimezoneRepository;
import salesdemo.app.shared.contacts.Title;
import salesdemo.app.server.repository.TitleRepository;
import salesdemo.app.shared.location.Address;
import salesdemo.app.server.repository.AddressRepository;
import salesdemo.app.shared.location.AddressType;
import salesdemo.app.server.repository.AddressTypeRepository;
import salesdemo.app.shared.location.City;
import salesdemo.app.server.repository.CityRepository;
import salesdemo.app.shared.location.Country;
import salesdemo.app.server.repository.CountryRepository;
import salesdemo.app.shared.location.State;
import salesdemo.app.server.repository.StateRepository;
import salesdemo.app.shared.contacts.CommunicationData;
import salesdemo.app.shared.contacts.CommunicationGroup;
import salesdemo.app.server.repository.CommunicationGroupRepository;
import salesdemo.app.shared.contacts.CommunicationType;
import salesdemo.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("foQ8CsW4KwtzcFfmMTFjmRJvMnEbVdadZyOX4Ww67q95nDA8rk");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("fD");
            language.setAlpha3("YcG");
            language.setAlpha4("Ojen");
            language.setAlpha4parentid(3);
            language.setLanguage("dKUoYDGhtcTBtwp7HDOOpCZL6UhpjPJPweIZYv0iT7RLEGYoyd");
            language.setLanguageDescription("TVAGHR49u5UrtzXXLuqtZfHZSf8fqXKxNqumRnMkEJ3nEB54X2");
            language.setLanguageIcon("guneFvtSXk5uSCyUIZhZlKvFIWThOuaAMXr2MIJim52xfZGypd");
            language.setLanguageType("ZVTjsppEjNSfXri1OPj4iu0erQCUY8GE");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("c3dUxDzIWJZojEwLLIcP7JJTnxtbnhcGtAVkp8TSeAoWXVkUlH");
            timezone.setCountry("htBlYlz2BITAZ1JU9vRrRE7FUfEw4f62GmpEiJwBvlxO8ugS8A");
            timezone.setGmtLabel("TtPhbgoegxdzGSkOHwxp8DEyNDd5UOmDfx5BncjnkJ82tKz4Bl");
            timezone.setTimeZoneLabel("o34QthZCxTyFV7CJW9OYN5XxTizKKNn8dIq8FfAnIUyUEqBTxU");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("MGqQhKcpHB6wgK4Ai0yVyNK0v9MBQiDAKlIjlRVibCXiIxc6wV");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(1);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("BEyaeEFtvYi17590cej7yRMBYl4yXVx4gm2B6IDuFuCzWFgxh6");
            corecontacts.setFirstName("vgbn4gPhPsPe1V9NJk1wycqxt58f42JC9yhclHaFMJRjhGT1h8");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("MemHSklqLkWpBF5wTW6WDZnMf78fam4UjMLctLwFw2UFsDU1Jg");
            corecontacts.setMiddleName("uEzsQxT8DAjaQAIMsUmu7WQewJysCDEBRHQoci4xB8qHRmG0Vp");
            corecontacts.setNativeFirstName("Sho7fd2hapc7uV8lxEwOXI5LCiAfeaHFuVXfsY7vm1E8X7Ai9U");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("0sXpoCTVjlxfbiWLAFwqSBdSVbqWmn3AAsA5yD2eXPcBO2TOpM");
            corecontacts.setNativeMiddleName("PjRoubwYco8XZYrQHqqlUyFraGRsH1R69Xfw9JGWkiCDuxBilk");
            corecontacts.setNativeTitle("3MrFn4rGv5aZgJUSZeJJYs5utX6lZwYceV5lfX3V7ieAp7ChOP");
            corecontacts.setPhoneNumber("MMIWaRucF0Ho1mXhRncK");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("27XBqJghoksE8eGRw9ZpIn4BcvhphOs81ZBZ2dj3dKBXw80Guh");
            address.setAddress2("K3wddMElXIvThZemudA2BjjAfu5mOJ6xCqzU9ssXqlEvbmJTvV");
            address.setAddress3("iGzn9pfC08MJBbINX7VKKJQnjy364342M102aqLD905W8S1knq");
            address.setAddressLabel("DsIeiCXKwya");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("nKSNnYHwQabsMJ6cM4uGC8HcbtBwW0EiJYBXsyU8yMgE5iIXjr");
            addresstype.setAddressTypeDesc("6M2yV7I6GmRmUy5FFhY7bXNVRkpF7ZkgFDdXNF6LbNgCLdip5R");
            addresstype.setAddressTypeIcon("ZA8pjfTJSw4ubpiuLguX6N9QOVc4GITMOCXP7oAPdecZpNI1w3");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("1QWJfPrBzqkrxFtNKdH0314eVfOMvSXo");
            city.setCityDescription("ysDrT353ORIYp4CvVacAWCsI0VmenlWKKlGfzUtwY1xiiLaKaf");
            city.setCityFlag("dDjEBwIR8WngKYSgZOFVBUrJjfWMF8SxptgyosUZN6xFo8lygU");
            city.setCityLatitude(2);
            city.setCityLongitude(0);
            city.setCityName("Hi4nFTV933NV7zrC7LIQqCFJUAaZJMq4O52yM9Wj4C90LYtF1B");
            Country country = new Country();
            country.setCapital("Lg4hSH7aU9X6mv71yhHG0d96Xrtn9SXY");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(10);
            country.setCountryCode1("JQW");
            country.setCountryCode2("4Ch");
            country.setCountryFlag("RJydAnjZodMvDPjb0vYuIESgiOp8NKBdPlkuJfG61BiZfI4R1P");
            country.setCountryName("xXJe68SgPtu3DOpVqFJaeDzmuC0rJSERWcrHDVp2uX95F2QJU2");
            country.setCurrencyCode("l50");
            country.setCurrencyName("Q4xIkVNWHiuHA9SNELj8gbE8POLVSi92IRA0z2bbZvUiviMH8A");
            country.setCurrencySymbol("aTqfW3EJimNoiVjIN8D2FKT3fQUV6iMY");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("DMrNJzZD74KexwaUBXaghCRS37kzMYAmAtD6U2KW8W1Rpwqllf");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("aVy0OOB8z0G42vxYsLX7AgB10XsqqKTo");
            state.setStateCodeChar3("9I5mQhcBerpUd33oiV1JEnJuPZ6wv0DZ");
            state.setStateDescription("l9OPoWGk4riXzp3bXrXCR2xUCM0yKvVUUzstqRAUNEKab4XHxE");
            state.setStateFlag("Pao59AVLiPgVCAmHmzROmPJjbaji7BgJemyCRQOlXqK9BVAAOe");
            state.setStateName("rx8H4EpUiuPHOMewsECqZZI0NLQBufaxVUxMC7HmIYm3WUL0gk");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("tUrGPukb7h74naEmnc2QAUpbe8vtk31S");
            city.setCityDescription("qnMRVZtGca9D745vN9t2VGOhAE2t0apIwiR5CYM8mQYpGdaQjA");
            city.setCityFlag("3Sl70nHFGbda5tyxX0ENt0851D8XgZpbHJQgPBwSOo35D9jcH5");
            city.setCityLatitude(2);
            city.setCityLongitude(0);
            city.setCityName("SdoOZj4hTBK42t0SrbRQvMJ1L6JwhDTghKRR8XTwMyKdxr7XGi");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("Whv9zN76mcfyOXRDrVYNUENKGUrfnpxcboKEQjoKUh2KiB7TJY");
            address.setAddress2("0Wx1qdksaZ5pBHvBtEGZzAVxZlWaCfJ3zux7N70NVmMcM350UF");
            address.setAddress3("CfJFWxHF2hZWxCGNMf8Ot4p9ANzDxi4tuYzUO5CcQdej3XKKhg");
            address.setAddressLabel("otRlkOvXya0");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("wYmu9H0F1XTYzgFmdcK1jA8hT7KctWsQbivMNSidxYx6wC4FlS");
            address.setLongitude("5nATHiGAxquSf9802uOIZZOPDWPQRt5TzBr4kAPViRKmJ75Y0H");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("1F0Nmn");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("7Pf");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("Z7FhyoAFR7LLaYqRGfjWZgZJr3KcOj7y4EZze4UOpQnFRUzFRv");
            communicationgroup.setCommGroupName("eUekdMBCXRDuOc3OEq76n3z4THYmEqWQWtYSWwGQsBJVfyALi9");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("qL6kfrJ35uuX55xAGQvlsljdSxyQPCimQMIXvaVWUUuiv06gDp");
            communicationtype.setCommTypeName("jSSyCSJh92VTybNP5Ec2fEGozDsJiEhAzJxvdNsPHsm6Cy100Y");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("uvk");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(53);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("9uj1Rx07If7Pp9Q5g1etXkOV9Usk9gdr4dXcuIUuIQqRKE1YUs");
            corecontacts.setFirstName("XBv1UjszIcc1hVbYxMcJC3OSG1sU7F8e4TjtQIz2AsizMODeir");
            corecontacts.setLastName("zZHkocaUx1hFwyhYpEegvFwkqCNcHshpYI4HSittwxAicszdu3");
            corecontacts.setMiddleName("1NdIIrYeiSLt8vvzeiOQxZuW3ZFKbYFTYbt2KV1dmcpH8Xpj2Y");
            corecontacts.setNativeFirstName("wXaf5ub5eihCYomozsGx2d3cLY8t2N9QU3uxIZDgnsMNengrox");
            corecontacts.setNativeLastName("YY5ecc8JgsXYOaaoGoLjQMg1uhhhvaS4cyNmi4ZE5AVaxy2o5D");
            corecontacts.setNativeMiddleName("viyO0UB9ZmYFbot2ejiCQGbGS5jkOGFANNeuf3Nicb4B0Ihr2j");
            corecontacts.setNativeTitle("V77lCcPS9ywyPBtGuXpOHESd8kko9WglgjHj0x4KKpTytlYzCl");
            corecontacts.setPhoneNumber("lhtqXiX27kA8LhEOorRG");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
