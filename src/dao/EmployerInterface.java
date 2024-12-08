package dao;

import java.util.List;
import model.Employer;

public interface EmployerInterface {
    boolean addEmployer(Employer employer);
    boolean updateEmployer(Employer employer);
    boolean deleteEmployer(int id);
    List<Employer> getAllEmployers();
}
