package ru.fishev.MyRestSpringBootAppH2DB.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.fishev.MyRestSpringBootAppH2DB.entity.Discipline;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class DisciplinesDAOImpl implements DisciplinesDAO {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Discipline> getAllDisciplines() {

        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query.getResultList();
        log.info("getAllDisciplines" + allDisciplines);
        return allDisciplines;
    }

    @Override
    public Discipline saveDiscipline(Discipline disciplines) {
        return entityManager.merge(disciplines);
    }

    @Override
    public Discipline getDiscipline(int id) {
        return entityManager.find(Discipline.class,id);
    }

    @Override
    public void deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from EducationalDisciplines" +"where id =:educationalDisciplinesId");
        query.setParameter("educationalDisciplinesId", id);
        query.executeUpdate();
    }
}
