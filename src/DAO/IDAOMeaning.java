package DAO;

import entities.Meaning;

import java.util.List;

/**
 * Created by aliubivyi on 17.04.17.
 */
public interface IDAOMeaning {
    List<Meaning> findAll();
    Meaning findById(int id);
    Meaning findByWord(String word);

    void update(Meaning entity);
    void delete(String word);
    Meaning create(Meaning entity);

}
