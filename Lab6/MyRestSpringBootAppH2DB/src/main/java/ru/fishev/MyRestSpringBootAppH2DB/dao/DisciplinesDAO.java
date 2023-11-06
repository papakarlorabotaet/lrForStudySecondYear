package ru.fishev.MyRestSpringBootAppH2DB.dao;

import org.springframework.stereotype.Repository;
import ru.fishev.MyRestSpringBootAppH2DB.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplinesDAO {
    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline disciplines);
    Discipline getDiscipline(int id);
    void deleteDiscipline(int id);
}
