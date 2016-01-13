package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

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
            gender.setGender("6cv9Zewgu7Wr9nLYiE98ox1lLANixfcbl3UzxpoJgfEFOFEoGD");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("5Z");
            language.setAlpha3("r3k");
            language.setAlpha4("RifY");
            language.setAlpha4parentid(4);
            language.setLanguage("Ms9xT3k95DrOuQxDi4usNvnxxUc7GnQgzwU1bL4dZXv7z5NCcS");
            language.setLanguageDescription("AQN3aXxEzhZ9yvBv2QbXSDbLB6cPVj5cmcDZ1bIHqDEBApTGec");
            language.setLanguageIcon("z8GHuDyS2fMoH4ZSK94b5oV0Ub5Xf056LojVzex9HVc3YmRjiJ");
            language.setLanguageType("DMhK37ff0a0roBpfJCYRc4vvqIPGohBW");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("qqNNjszNSmuLvKeHvePRNqINTITVePrKXXCjAcYZgxImJeVeeI");
            timezone.setCountry("fwSwHu4DhiM5JNZGyCVDcOT4Iw0KuTe4Cy1mVVdHHdbUNqbTOc");
            timezone.setGmtLabel("iqYAQElA0P3hwDf8lLygvG8pauUjTaRWxHQrhmpj5tCg558vct");
            timezone.setTimeZoneLabel("TSpkX4ZXAFOut9ES3anQhRpa676ubR2s4bK7Bs1xVqhmUox4Nb");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("fwUa47jLI7xlQnFvNICGrJZ7Z0GisdCckbLfwYc6l5v5q5QOyn");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(59);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("v8xBodf0DnpMPr9k8dX4cIweBmsf3MeNPwamZdKvLVCTY3HaOc");
            corecontacts.setFirstName("5g0veWA9SleyHJQCaNq8fCsYsEumrk7cAL6qgPV8NAUhp2pXxk");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("pCNw02g1vFh6uRGK5HRZqvbjXZZSbc9bvudLBlRFCia8MBqVMM");
            corecontacts.setMiddleName("eJhginaOowfQhCoWUBw3pJ3UfppxvID1hDksD2aSqRer9tUQfQ");
            corecontacts.setNativeFirstName("XadPqYRs8ba0ASf5X5bdjqxI9y1MX5WWlEf4RrjDo53o7GtV03");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("YbRJK7DO6wIjbg7Ku9AjcnGSiFgY4FQNvubbiNwkYTIFPY9Olo");
            corecontacts.setNativeMiddleName("GuUhGrwkUGTh1i7QSCkSq4IOJK3ByDImKCzUxGaVHN17qls47Y");
            corecontacts.setNativeTitle("lpAkqClInSMdSkn8FKhHiUe5g4V8MgfTwSyQ7hLmwvhJ5sZnx2");
            corecontacts.setPhoneNumber("VrFg8LiGOy4FJahuh3RT");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("upD");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("B9oAQN5VtUEtj7HyO8R82kDkMjQyUuTPdPEhdmYRyZ717OMxwI");
            communicationgroup.setCommGroupName("uIcI58ifEEnPzuUBU0T8XMKZGl9tqDv27MQQReu1Qsyrn37AJo");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("mBGg6XMKmrxSqhrgEnKLDkijTb0mXQSOWMAn7Lxp9RDaXFD5eb");
            communicationtype.setCommTypeName("kBuob96qrJ3kO3gp7N0vzjCO8RQRh7LKJ4M7w0tovKeuY8c49d");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("0QQ");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("b8x0Er27qQpDJPZ9etoNJfLniWyQmX7Rbd0iriYpqkksWkdGdm");
            address.setAddress2("hh20vh0WSfEZzEcU9md75KcgC3rPiCs80vk41SbK3Q6Tx7UQRT");
            address.setAddress3("KPHi76hf91fajQ0vdFqzEm8VBxKMvzUMiaQkEidlWTWQJVxACT");
            address.setAddressLabel("WscNwJVcE8J");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("xdjKcJh9EYVQpeqymOYiJ1Tr9rOlBgkiwwAKn1ds0shttMTmqq");
            addresstype.setAddressTypeDesc("YF5S575C5LqscyImNWWrrdzBl7R8mP9XndToQpjludmJJiVbLZ");
            addresstype.setAddressTypeIcon("jRB0J62vGWzGyc5w3H7xoUzRcee5dqH20P4Lhjay45bZnNlYJP");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("lb1p1QiDoMJFTAUHcH17EFjk7vBAFyW2");
            city.setCityDescription("8dA7yJ9zgZDJCW55foB8i1kzgC6IAHiej3STC0jAAlNfrf71f7");
            city.setCityFlag("71CAFHxFF5v91iQBq01BatL8nCAZSyVFwpoFqgap55OchVTMqG");
            city.setCityLatitude(7);
            city.setCityLongitude(4);
            city.setCityName("rmcOC2pNRruSLkNjhgVSQKvn5953OIryl8jiMb9N1t60IDca7h");
            Country country = new Country();
            country.setCapital("2clk1RYqpJNP9g7GzWKE735HGYmcGN2u");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(10);
            country.setCountryCode1("fe1");
            country.setCountryCode2("xpi");
            country.setCountryFlag("xwWC9OS9xDmkUaIKLLxDCqfPpps6C3F705vlsh5UvaqOKAtLd8");
            country.setCountryName("MjwvucADhAG8Hhy3H8LNDqmwudleZd9bMxlGQ7IIkY1Gk233ac");
            country.setCurrencyCode("ccX");
            country.setCurrencyName("u6ZRW10R1xhZlR9SN8hcsVXDdKIFkDIqEMTx6vcLvguEfAzQH8");
            country.setCurrencySymbol("2t0LQxR039m66NcP5ym7Z8K9Chiba9xl");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("4pEzmPGZ74kwAVPPkHil3DSdEKR4JUfeEW6nR8xKNkqCd9unpV");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCodeChar2("6qLD0XuqA9uG35nyL4y8cI88JLUbp6MB");
            state.setStateCodeChar3("uKnpBhCTVFeWYL2JdwUcpzruz9FAgMk8");
            state.setStateDescription("Qf0qDeV0wqu0NRW5uDFFScjy4oFvScn2GFcWi7puuYoBNaApt2");
            state.setStateFlag("WefURkSCTRuFjaoJqiXCzfo2m4Y27bIRJWoasqhC5jKrZ0VVnh");
            state.setStateName("VbIXYMwygjwZny232A547vf53Dbgp9diUpT3qcO0GKNu4qN08z");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("Lu8pK5liULNA8Oj2gNe959plhA1diZig");
            city.setCityDescription("iUHyEKK3dvXLpNp2z38irOv6ypJw8rOq0dCtq94l8VYfrXn6Lw");
            city.setCityFlag("Zl6fMizBW0aExWg1AHOz9zk4TZxr7Po6uHIA64uJ7CluLy82OT");
            city.setCityLatitude(9);
            city.setCityLongitude(2);
            city.setCityName("fIxjI6VmQcNK6h7HHcknlsq1sWqXsAAMWUyLM6Ie8XYl83nHw7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("YaK4oGjKi1QvLHBhugW56lo7oQuksx41qYXMOV1Ec8x6LGg2RO");
            address.setAddress2("LmJG5WNgxmpGatd5PlGOjl2RxRly7rSzMHHZouirZ9cD66wcP2");
            address.setAddress3("WtDNLqiNwdeKSOPMsm2orQjUq0K9xsqaUEld0o7ydzVWVcs3qq");
            address.setAddressLabel("zVwtr7HPAQA");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("7Vd6lC6A5VKCD0XM1jQuGPh8HnTR0gmO2v7IbpzzEJycqt9gXR");
            address.setLongitude("fLuSm6Q8gNL2KXvQvQmBEs5gYlQyqV0DCRebZz946WIZ2L4KCp");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("BrED3U");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(59);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("v2ljoVdX72izQZEtH475Kv8BW0C50U99nPBseebDtzjzKrCjvI");
            corecontacts.setFirstName("6j6xLExkem2Qjv9cIVRonSCUTZagIhyLPFfasvhhA39TU09kDo");
            corecontacts.setLastName("fn8u2i3ImqZnRrm3z3CmElgHGXATnlfGlHmdCHTIushJBWRVPI");
            corecontacts.setMiddleName("URkdxXRF684b03POA7kbepxd6zCUmVgkFsF1B3uIV9jeZSAeyE");
            corecontacts.setNativeFirstName("zuQ4evRXLjFmUQq5yavioJ6iiJDe9fjDP8h2WHl3MC3OKA4jS0");
            corecontacts.setNativeLastName("vSU3tH3qQPEcHesQ2zJyozx00mx5yEstIpOkBzP53ImI7LJWZ8");
            corecontacts.setNativeMiddleName("Zk8SrNN9rIX0z2ehF0pkSZ6iD7VMDvPUb4CaWZhPkhgvYIPw9s");
            corecontacts.setNativeTitle("WIOavO7GTlml8Ci1P3hkOHnB039yLzkOOtOiav7hUoqWE5cl8j");
            corecontacts.setPhoneNumber("7UxEjppfTP6kUGrJfwUQ");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
