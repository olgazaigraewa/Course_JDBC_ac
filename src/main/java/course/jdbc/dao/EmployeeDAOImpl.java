package course.jdbc.dao;

import course.jdbc.config.HibernateSessionFactoryUtil;
import course.jdbc.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override

    public void create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

        }
    }

    @Override
    public Employee getById(int id) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(" FROM Employee").list();
        }

    }

    @Override
    public void update(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }

    }

    @Override
    public void delete(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }

    }
}




  /*  private final Connection connection;
    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {


        // Формируем запрос к базе с помощью PreparedStatement
        try(PreparedStatement statement = connection.prepareStatement(Queries.INSERT.query)){
            // Подставляем значение вместо wildcard
            // первым параметром указываем порядковый номер wildcard
            // вторым параметром передаем значение
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity_id());

            //С помощью метода executeQuery() отправляем запрос к базе
            statement.executeQuery();

        } catch (SQLException ignored) {

        }
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET.query)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                employee.setEmployee_id(resultSet.getInt("employee_id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity_id(resultSet.getInt("city_id"));


            }


        } catch (SQLException ignored) {
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        // Создаем список, в который будем укладывать объекты
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL.query)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                {
                     int employee_id = resultSet.getInt("employee_id");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String gender = resultSet.getString("gender");
                    int age = resultSet.getInt("age");
                    int city_id = resultSet.getInt("city_id");

                    employees.add(new Employee(employee_id, first_name, last_name, gender, age, city_id));

                }
            }

        } catch (SQLException ignored) {

        }


        return employees;
    }

    @Override
    public void updateById(int id, int age) {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE.query)){

            statement.setInt(1, age);
            statement.setInt(2, id);

            statement.executeQuery();

        } catch (SQLException ignored) {

        }

    }

    @Override
    public void deleteById(int id) {

        try (PreparedStatement statement = connection.prepareStatement(Queries.DELETE.query)){

            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException ignored) {

        }


    }
}

    enum Queries {

        GET("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id AND employee_id=(?)"),
        GET_ALL("SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id  ORDER BY employee_id" ),
        INSERT("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))"),
        UPDATE("UPDATE employee SET age = (?) WHERE employee_id=(?)"),
        DELETE("DELETE FROM employee WHERE employee_id=(?)");

        final String query;


        Queries(String query) {
            this.query = query;
        }

    }

*/

