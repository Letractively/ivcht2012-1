package edu.sstu.service;


import edu.sstu.model.Gruppa;
import edu.sstu.model.Student;

import java.util.List;

public interface GruppaService {

    public List<Gruppa> getAllGrupps();

    public void addGruppa(Gruppa gruppa);

   public Student editGruppa(Gruppa Gruppa);

    public Student showGruppa(int id);

    public void deleteGruppa(int id);

}
