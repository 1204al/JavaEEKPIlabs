package DAO;

import datasource.ConnectionSource;
import entities.Meaning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliubivyi on 17.04.17.
 */
public class MySQLDAOMeaning implements IDAOMeaning {
    private static String READ_ALL_QUERY = "SELECT * FROM meanings";
    private static String FIND_BY_ID = "SELECT * FROM meanings where meanings.idMeaning=?";
    private static String FIND_BY_WORD = "SELECT * FROM meanings where meanings.word=?";
    private static String CREATE_QUERY = "INSERT INTO meanings(word,meaning) VALUES(?,?)";
    private static String UPDATE_BY_WORD = "UPDATE meanings SET meaning=? where word=?";
    private static String DELETE_BY_WORD = "DELETE FROM meanings where word=?";

    @Override
    public List<Meaning> findAll() {
        List<Meaning> list = new ArrayList<>();

        try (Connection connection = ConnectionSource.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Meaning course = meaningFromResultSet(resultSet);
                list.add(course);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);

        }
        return list;
    }


    @Override
    public Meaning findById(int id) {
        Meaning meaning = new Meaning();
        try (Connection connection = ConnectionSource.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                meaning=meaningFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);

        }
        return meaning;
    }

    @Override
    public Meaning findByWord(String word) {

        Meaning meaning = new Meaning();
        try (Connection connection = ConnectionSource.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_WORD);
            preparedStatement.setString(1, word);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                meaning=meaningFromResultSet(resultSet);
                return meaning;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);

        }
        return null;
    }

    @Override
    public void update(Meaning entity) {
        Meaning meaning = new Meaning();
        try (Connection connection = ConnectionSource.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_WORD);
            preparedStatement.setString(1, entity.getMeaning());
            preparedStatement.setString(2, entity.getWord());
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(String word) {
        try (Connection connection = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_WORD);
            preparedStatement.setString(1, word);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);

        }
        return;


    }

    @Override
    public Meaning create(Meaning entity) {

        try (Connection connection = ConnectionSource.getInstance().getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, entity.getWord());
            preparedStatement.setString(2, entity.getMeaning());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);

        }
        return entity;
    }


    private Meaning meaningFromResultSet(ResultSet resultSet) throws SQLException {
        Meaning meaning = new Meaning();
        meaning.setIdMeaning(resultSet.getInt("idMeaning"));
        meaning.setWord(resultSet.getString("word"));
        meaning.setMeaning(resultSet.getString("meaning"));
        return meaning;
    }


}
