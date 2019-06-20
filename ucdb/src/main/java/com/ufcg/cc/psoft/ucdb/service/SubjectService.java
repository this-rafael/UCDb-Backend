package com.ufcg.cc.psoft.ucdb.service;

import com.ufcg.cc.psoft.ucdb.dao.SubjectDAO;
import com.ufcg.cc.psoft.ucdb.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectDAO subjectDAO;

    public SubjectService(SubjectDAO subjectDAO) {this.subjectDAO = subjectDAO; }

    public Subject create(Subject subject) { return subjectDAO.save(subject);}

    public void delete(long id) { subjectDAO.delete(id);}

    public Subject findById(long id) { return subjectDAO.findById(id); }

    public List findAll() { return subjectDAO.findAll(); }

    public List<Subject> findBySubstring(String substring) { return subjectDAO.findBySubstring(substring); }

    public void deleteAll() { subjectDAO.deleteAll();}


    // ...

}
