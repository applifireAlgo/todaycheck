package salesdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesdemo.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesdemo.app.server.repository.AddressRepository;
import salesdemo.app.shared.location.Address;
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
import salesdemo.app.shared.location.AddressType;
import salesdemo.app.server.repository.AddressTypeRepository;
import salesdemo.app.shared.location.City;
import salesdemo.app.server.repository.CityRepository;
import salesdemo.app.shared.location.Country;
import salesdemo.app.server.repository.CountryRepository;
import salesdemo.app.shared.location.State;
import salesdemo.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("norAPxYojxnQiFYm1HnsD9ygBXMgQKlKH9SooDOTVHXndl3s9M");
            addresstype.setAddressTypeDesc("omfa2ZbVNIhSfJq1vDHEKERYYdWENAQlRrEkFOTp2XBnzE9Dbo");
            addresstype.setAddressTypeIcon("HeKmgw1JzUBeH8GWkAUPD3DUc6e8QbQQEVhR0e8NkamTM5L81O");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("Sld0jB0Y265TX19B52PAAGYbDQ3WpOmd");
            city.setCityDescription("s8j8ylzlSqdmS07qJzMwrUEbftzR2Ni8bKIHUZZ7uZWiaz4D4y");
            city.setCityFlag("gCZ2CZBbD7vsMRHTjyxJeJvLIPhedqDFLBuG8m4mRaH2s9RxMR");
            city.setCityLatitude(10);
            city.setCityLongitude(6);
            city.setCityName("zElKYOUdqsO1C5lU0g1aZ1xb6lqRBHEiOVorqX7wZmsfzCzolh");
            Country country = new Country();
            country.setCapital("V97ZHWeVzOy3Drv1rLlyrBvCq2034L3B");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(4);
            country.setCountryCode1("5Fb");
            country.setCountryCode2("nhy");
            country.setCountryFlag("r9TCrQeSSDlWYVMXtmwktiVcJHMxMWPjNFZCm2j8jUwGP43YoB");
            country.setCountryName("idR7vYXBXGBAm9tpPJ82TZ7auBmLDj6cz35XSF88gVxyMLblbI");
            country.setCurrencyCode("Rbz");
            country.setCurrencyName("fCJ8yI97GJaCKo0Zkc6Lbed6OUMdJgkUywLKeTdWVXatzxjih0");
            country.setCurrencySymbol("N3Aaj1i4K6r00rFi8zIOszKU5ZHgXqlE");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("QSPi347rzp9vFNIDffJmXJBqCfSrworsuLRv0VLciscFkHX3tP");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(4);
            state.setStateCode(2);
            state.setStateCodeChar2("vngruFwLibJxSfmFPtvOwTgbfz0NBKR3");
            state.setStateCodeChar3("JzwKDekp9GjtfOUqOpMOlNt45qxS5yxh");
            state.setStateDescription("ohu8x9ua43YosjZOiGGCyjMDFm9gx2F19wQICO0p2vx5uCuNEO");
            state.setStateFlag("CrJKmr50p8gnhlPabwsOMyBSXPDChV79WiMPEV6wXsYbA3vGUP");
            state.setStateName("MhkJVp7knJBoGkLQQ3KPd7LNxkBlN4RnYFfm2a4cEJfMYKki7e");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("O66mQ0wIlKcPboELin04fX6S4R30Zvvv");
            city.setCityDescription("tFiSeR96ckdrRrDZAGLwodFBwQ3B0o2H9UN2xRNdSyLtvJFucp");
            city.setCityFlag("qEhu8UE0MvKGLDz1Gci2g4TD0xz7vXxLOLgqNs9jNHhbSLbgny");
            city.setCityLatitude(6);
            city.setCityLongitude(4);
            city.setCityName("Qa0bVXhGcvFWNYsyvdS4avmYUjwAfLxRr7VI9nTmPLgSSjdxFl");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("2tXX440RDCACZmxg3eZ7gIhbAKFN0NV63CeXDbNgr1hwWJArxg");
            address.setAddress2("NOJ1tLSvg7IairBVEMrofXZac66lYnE9jDgE1NVfWghybUeNsG");
            address.setAddress3("JPANys3JYuSTPj5CIXnb8ez7HnVK6dGVUaqC4zIgXi3TO4vJXh");
            address.setAddressLabel("skBivgh7UZH");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("WueYNdkzT3OLFD5Z30Rsye7rYjjVjo0mmDi1MKB64hVQtUdUm7");
            address.setLongitude("J7X30em3oUBkA3Pm9LVrY7oVgz9XmLFEiUkoRC3PQ1pt0ZJaj4");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("rOLdvi");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("xneFsV4XgWaJiHdxYjzJd6EDSCar4hPQxkzr4Ycnsdyvbwr2BN");
            address.setAddress2("eFbwlFsjRgbhb2SUCA0ybq42yGr66ySV39LiukMf7pK52kZKEp");
            address.setAddress3("33zW31JtaidGg9ec3YhW0M3TgwzpBZsrhZLBAAW2YV2EliWEnK");
            address.setAddressLabel("URjxpiTNC9C");
            address.setLatitude("Kc32frrDazgNaCgetMuRHqRYJ7Glq1fbZxSlNpEFCdkL9wv04v");
            address.setLongitude("ZwmQSK5J6M5yma0o6EdbwVDpNSIQ15Ug48PRIm7frjDmmZi6ch");
            address.setVersionId(1);
            address.setZipcode("c7pK7e");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
