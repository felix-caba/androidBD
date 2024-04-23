package DAO;

import Objects.Persona;

public interface DAO {
    void insert(Persona persona);
    void update(Persona persona);
    void delete(Persona persona);

}
