package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
            addresstype.setAddressType("DicqhhlkMPJKiMaCeLceJhXO4Q0Bo4mf5BWbYoP9Hp3RRJDF0H");
            addresstype.setAddressTypeDesc("LQkC7YuNc4Q1tqaU3rUO74rkoeTz23JI9PHwkolgkiLJI8L4r2");
            addresstype.setAddressTypeIcon("bVCAeXAuStSeryeUAmQcnxmPVWYPLNM1GeBfKbs1mGmMpSYCmL");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("Cp6r4s31i5EUEUsaHvTvvmS4jtRsRFE3");
            city.setCityDescription("sGhbUiHPj1muLBWRjcamrbT4dahyjGv3BRhthtkm0FfY9nMo3d");
            city.setCityFlag("c1tKXNrFWLqG5yEzMl9kT5YeU8Squ2IcjU61GpPgRLIicUwvYx");
            city.setCityLatitude(8);
            city.setCityLongitude(2);
            city.setCityName("pjMOGrymM5oYCoUVeSdxIvgKDvbtkztnrcxybzGuw4xEQ2HV7e");
            Country country = new Country();
            country.setCapital("saGNh0C7fdMWOEtkobCUCLE9SCR9D9Z3");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(11);
            country.setCountryCode1("1QL");
            country.setCountryCode2("Msc");
            country.setCountryFlag("4pw9PvqrKfv8P1cJdmBVnbk6b8keYNQseweaC4zV3GOBhIPfwM");
            country.setCountryName("TFY4C1ieibmiIXcx9JbVAc2mjXtTa15EfhhLmDG6yEvc9UOOOD");
            country.setCurrencyCode("KrH");
            country.setCurrencyName("uWyZFtkBpOEeOX5LdWogK1au4jtBWGsCknr5jokBjMAUdcBeha");
            country.setCurrencySymbol("s6IhhHA7zYHQ6EqLYMe1jtF9LZjzfNft");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("YyFo9vm5ur3EPN7t3DvYh2jMZvmH6uQYvMNbkyTJI6NS281E6q");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("f19fouqq7YJ2lJpjLmT55TlBCuWzSA7t");
            state.setStateCodeChar3("b34h8zZcfakSLMyahLOkOCCK4Q8BvbyI");
            state.setStateDescription("nZIxV5gnj2AqnbbHZJDGyaP3kUSGz8wgI1uMM0FDSzoCZ9uPfn");
            state.setStateFlag("MzHq2m3ppBUBdMxmbHZNX2HX0fGtKNobjCeR0rCzcvpbv4FZcy");
            state.setStateName("lfAAWhNAENXVLruDXXJ2mh3fggxH3kgOhuUbK5C6zzHYJyDvqq");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("DvSQlNbJ32ZVQ0dvtYU8lNqHWnUhCcSP");
            city.setCityDescription("Ec0iaq8vhjoX6t2E7RiNknj5uep4CGSeZFS1w1mknWhRZIwsha");
            city.setCityFlag("OIkOvUE5eLh8pkxnCRcdkLtLleeI6tAZxnel5lqV0DMkViUvXy");
            city.setCityLatitude(5);
            city.setCityLongitude(10);
            city.setCityName("ggO9mIWEfM8uwiPcHMzsWjOORMmPn5aKfwJRHxF5y7kSkkpDAb");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("LUub4mCE1f3IshsQUNgBJwrwrEMkOLEicKk9Kb01CM7OxfGok1");
            address.setAddress2("LZxCbKqtnezBhKSBrbac7N3i6aAi6LuICn4J54NILhUXvoDulY");
            address.setAddress3("i66jfnIlnVGKeGV9hbmFNIILKxVBnVW81rAcdHDrSrjaIt2i8O");
            address.setAddressLabel("21D6TryuHif");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("7bgIpZWg37bzj7T0liYOhbm7sMT1q9HeVr9oT7xkosWbPWXSEv");
            address.setLongitude("yF9i1oW74HJq0MBATOA3iayGd3Zpc6BPg4BTgXWxT2eLANBXg3");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("idO7fB");
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
            address.setAddress1("HfMxUqYUXDrdrCysYotYrBGlYzj05AIEF6RudhGdzBgI89T2ui");
            address.setAddress2("mtjwKkk8vVP7jn40dvlivQn3lNttZXoD1bKPppkHrzhSGd2nuE");
            address.setAddress3("27lHIznx0XsP79KQo6rB1XZRZP1Nk7hcYWNcL8y5wpxCiu4oZr");
            address.setAddressLabel("Jwc4fSTPiH6");
            address.setLatitude("uQgBG390Ep0L5Ic3A5QElfqMgSqnn640qcXgolg20PdJhJzJXd");
            address.setLongitude("QLVDD46VIr5yyUR4gTAkvVzgFoSAhPvRfmtSXnT3DZdZfNfY3I");
            address.setVersionId(1);
            address.setZipcode("cygzHd");
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
