package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Employer;
import enums.Role;
import enums.Poste;

public class EmployerDAO implements EmployerInterface {

    private final Connection connection;

    public EmployerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.", connectionException);
        }
    }

    @Override
    public boolean addEmployer(Employer employer) {
        String query = "INSERT INTO employers (first_name, last_name, email, phone, salary, role, poste) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement addStatement = connection.prepareStatement(query)) {

            setEmployerData(addStatement, employer);
            return addStatement.executeUpdate() > 0;

        } catch (SQLException addException) {
            addException.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployer(Employer employer) {
        String query = "UPDATE employers SET first_name = ?, last_name = ?, email = ?, phone = ?, salary = ?, role = ?, poste = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(query)) {

            setEmployerData(updateStatement, employer);
            updateStatement.setInt(8, employer.getId());
            return updateStatement.executeUpdate() > 0;

        } catch (SQLException updateException) {
            updateException.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployer(int id) {
        String query = "DELETE FROM employers WHERE id = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(query)) {

            deleteStatement.setInt(1, id);
            return deleteStatement.executeUpdate() > 0;

        } catch (SQLException deleteException) {
            deleteException.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employer> getAllEmployers() {
        List<Employer> employers = new ArrayList<>();
        String query = "SELECT * FROM employers";
        try (PreparedStatement getStatement = connection.prepareStatement(query);
             ResultSet getResult = getStatement.executeQuery()) {

            while (getResult.next()) {
                employers.add(mapResultSetToEmployer(getResult));
            }

        } catch (SQLException getException) {
            getException.printStackTrace();
        }
        return employers;
    }

    /**
     * Helper method to set data for Employer in PreparedStatement.
     */
    private void setEmployerData(PreparedStatement statement, Employer employer) throws SQLException {
        statement.setString(1, employer.getFirstName());
        statement.setString(2, employer.getLastName());
        statement.setString(3, employer.getEmail());
        statement.setInt(4, employer.getPhoneNumber());
        statement.setDouble(5, employer.getSalary());
        statement.setString(6, employer.getRole().name());
        statement.setString(7, employer.getPoste().name());
    }

    /**
     * Helper method to map a ResultSet row to an Employer object.
     */
    private Employer mapResultSetToEmployer(ResultSet resultSet) throws SQLException {
        return new Employer(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getInt("phone"),
                resultSet.getDouble("salary"),
                Role.valueOf(resultSet.getString("role")),
                Poste.valueOf(resultSet.getString("poste"))
        );
    }
}
