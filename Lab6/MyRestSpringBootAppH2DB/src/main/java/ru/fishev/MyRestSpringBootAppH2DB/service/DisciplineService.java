package ru.fishev.MyRestSpringBootAppH2DB.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fishev.MyRestSpringBootAppH2DB.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline getDiscipline(int id);
    Discipline saveDiscipline(Discipline disciplines);
    void deleteDisciplines(int id);

}
