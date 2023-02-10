package course.jdbc.dao;

import course.jdbc.model.City;
import course.jdbc.model.Employee;

import java.util.List;

public interface CityDAO {

    // Добавление объекта
    void create(City city);

    // Получение объекта по id
    City getById(int id);

    // Получение всех объектов
    List<City> getAllCities();

    // Изменение объекта по id
    void update(City city);

    // Удаление объекта по id
    void delete(City city);

}
