package course.jdbc;

import course.jdbc.dao.CityDAO;
import course.jdbc.dao.CityDAOImpl;
import course.jdbc.dao.EmployeeDAO;
import course.jdbc.dao.EmployeeDAOImpl;
import course.jdbc.model.City;
import course.jdbc.model.Employee;

import java.sql.*;


public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city1 = new City("Rostov");
        cityDAO.create(city1);

        Employee employee1 = new Employee("Irina", "Klimova", "F", 35);

        City city2 = cityDAO.getById(7);

        employee1.setCity(city2);

        employeeDAO.create(employee1);

        cityDAO.delete(city2);


       /* EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee(23, "Irina", "Klimova", "F", 35, 6);

         employeeDAO.create(employee1);

        System.out.println(employeeDAO.getById(5));

        List<Employee> list = employeeDAO.getAllEmployees();

        for (Employee employee : list){
            System.out.println(employee);
        }

        Employee employee2 = new Employee(8, "Oleg", "Savinov", "M", 25, 1);

        employeeDAO.update(employee2);

        employeeDAO.delete(employee1);*/


    }
}



























     /*   // Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String pass = "asx4478/";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        //Создаем соединение с базой с помощью Connection
        //Формируем запрос к базе с помощью PreparedStatement

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT  * FROM employee WHERE employee_id = (?)");
            {
                //Подставляем значение вместо wildcard
                statement.setInt(1, 7);

                // Делаем запрос к базе и результат кладем в ResultSet
                final ResultSet resultSet = statement.executeQuery();

                // Методом next проверяем есть ли следующий элемент в resultSet
                // и одновременно переходим к нему, если таковой есть
                while (resultSet.next()) {

                    // С помощью методов getInt и getString получаем данные из resultSet
                    String first_name = "First_name: " + resultSet.getString("first_name");
                    String last_name = "Last_name: " + resultSet.getString("last_name");
                    String gender = "Gender: " + resultSet.getString("gender");
                    int age = resultSet.getInt(5);


                    // Выводим данные в консоль
                    System.out.println(first_name);
                    System.out.println(last_name);
                    System.out.println(gender);
                    System.out.println(age);
                }*/
/*
                //Создаем объект класса EmployeeDAOImpl
                EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

                City city = new City(6, " Kaluga");
                Employee employee1 = new Employee(8, "Oleg", "Savin", "M", 52, 6);

                //Вызываем метод добавления объекта
                employeeDAO.create(employee1);

                //Создаем список, наполняя его объектами, которые получем путем
                //вызова метода получения всех элементов таблицы
                List<Employee> employees = new ArrayList<>(employeeDAO.getAllEmployees());

                //Выводим список в консоль
                for (Employee employee : employees) {
                    System.out.println(employee);
                }

                //Вызываем метод обновления данных в базе
                employeeDAO.updateById(7, 51);

                //Вызываем метод удаления данных из базы
                employeeDAO.deleteById(20);*/

















