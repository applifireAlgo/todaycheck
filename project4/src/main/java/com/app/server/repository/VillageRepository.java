package com.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "rushikesh.jeware@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for Village Master table Entity", complexity = Complexity.LOW)
public interface VillageRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public List<T> findByCountryId(String countryId) throws Exception, SpartanPersistenceException;

    public List<T> findByStateId(String stateId) throws Exception, SpartanPersistenceException;

    public List<T> findByRegionId(String regionId) throws Exception, SpartanPersistenceException;

    public List<T> findByDistrictId(String districtId) throws Exception, SpartanPersistenceException;

    public List<T> findByTalukaaId(String talukaaId) throws Exception, SpartanPersistenceException;

    public T findById(String villageId) throws Exception, SpartanPersistenceException;
}
