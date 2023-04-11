package com.example.FeedbackProject.Repository;

import com.example.FeedbackProject.Entity.Employee;
import com.example.FeedbackProject.Entity.SearchBarResult;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    Optional<Employee> findByName(String name);

    //List<Employee> findByNameContaining(String var);

    @Query("SELECT emp.name FROM Employee emp " +
            "WHERE lower(emp.name) LIKE lower(CONCAT('%', :var, '%')) " +
            "OR lower(emp.name) LIKE lower(CONCAT('%', :var)) " +
            "OR lower(emp.name) LIKE lower(CONCAT(:var, '%'))")
    List<Object[]> getEmpByName(String var);

}
