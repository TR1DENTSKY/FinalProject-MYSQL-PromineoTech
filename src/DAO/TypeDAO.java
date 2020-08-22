package DAO;

import Entity.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO {

    private static Connection connection;
    private final String GET_TYPE_BY_GUN_ID_QUERY = "SELECT * FROM type WHERE gunId = ?";
    private final String GET_TYPE_QUERY = "SELECT * FROM type";
    private final String GET_TYPE_BY_TYPE_ID_QUERY = "SELECT * FROM type WHERE type_id = ?";
    private final static String CREATE_NEW_TYPE_QUERY = "INSERT INTO type(weapon_type, type_id) VALUES(?,?)";
    private final static String UPDATE_TYPE_BY_ID_QUERY = "UPDATE type SET type_id = ?, weapon_type = ?";
    private final static String DELETE_TYPE_BY_ID_QUERY = "DELETE FROM type WHERE type_id = ?";

    public TypeDAO () {
        connection = DBConnection.getConnection();

    }

    public List<Type> getTypeByGunId(int gunId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_TYPE_BY_GUN_ID_QUERY);
        ps.setInt(1, gunId);
        ResultSet rs = ps.executeQuery();
        List<Type> type = new ArrayList<Type>();

        while (rs.next()) {
            type.add(new Type(rs.getInt(1),rs.getString(2)));
        }
        return type;
    }

    public List<Type> Types() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_TYPE_QUERY).executeQuery();
        List<Type> types = new ArrayList<Type>();

        while (rs.next()) {
            types.add(populateMember(rs.getInt(1), rs.getString(2)));
        }
        return types;
    }

    public static void createNewType(int typeId, String weapon_type) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TYPE_QUERY);
        ps.setInt(1, typeId);
        ps.setString(2, weapon_type);
        ps.executeUpdate();
    }

    public Type getTypeByTypeId(int typeId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_TYPE_BY_TYPE_ID_QUERY);
        ps.setInt(1,  typeId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return populateMember(rs.getInt(1), rs.getString(2));
    }

    public static void updateType(int typeId, String weaponType) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_TYPE_BY_ID_QUERY);
        ps.setInt(1, typeId);
        ps.setString(2,weaponType);
        ps.executeUpdate();
    }

    public static void deleteTypeById(int typeId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_TYPE_BY_ID_QUERY);
        ps.setInt(1, typeId);
        ps.executeUpdate();
    }

    private Type populateMember(int typeId, String weaponType) throws SQLException {
        return new Type(typeId, weaponType);
    }
}
