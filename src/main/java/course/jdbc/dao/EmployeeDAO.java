package course.jdbc.dao;

import course.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Добавление объекта
    void create(Employee employee);

    // Получение объекта по id
    Employee getById(int id);

    // Получение всех объектов
    List<Employee> getAllEmployees();

    // Изменение объекта по id
    void updateById(int id, int age);

    // Удаление объекта по id
    void deleteById(int id);


}
