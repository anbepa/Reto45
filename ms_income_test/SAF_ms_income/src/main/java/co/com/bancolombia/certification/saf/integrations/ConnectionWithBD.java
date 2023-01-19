package co.com.bancolombia.certification.saf.integrations;

import co.com.bancolombia.certification.saf.exceptions.ConstantsExceptions;
import co.com.bancolombia.certification.saf.interactions.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certification.saf.utils.Const.*;

public class ConnectionWithBD {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionWithBD.class);
    private boolean responseBoolean;
    private String responseString;
    private int responseInt;



    public ConnectionWithBD() {
        String userBD = System.getProperty("userBD");
        String passBD = System.getProperty("passBD");

      /*   String userBD = "qasaftest";
        String passBD = "1CHXXCk&#hV&";*/
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection("jdbc:postgresql://saf-writer-db-qa.apps.ambientesbc.lab:5432/SAFQCD",userBD,passBD);
            LOGGER.info("Conexion exitosa");
        } catch (SQLException throwables) {
            LOGGER.error("Ocurrio un error a la hora de conectarse al servidor SQL",throwables);
        }
    }

    public static ConnectionWithBD postgresql(){
        return new ConnectionWithBD();
    }

    public List<String> getInfoOfDataBase(Object[] parameters, String query){
        List<String> response = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int rowcount = rsmd.getColumnCount();
            if(rs.next())
                for(int i = 1; i <= rowcount; i++){
                    response.add(rs.getString(i));
                }


        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
        return response;
    }

    public String[][] getInfoOfDataBaseForRowsObligation(Object[] parameters, String query){
        String[][] response = new String[1000][1000];
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int rowcount = rsmd.getColumnCount();
            int  rt = 0;

            while (rs.next()  && rt <= 4){
                Wait.aTime(2000);
                for(int i = 1; i <= rowcount; i++){
                    response[rt][i] = rs.getString(i);

                }
                rt++;

            }


        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
        return response;
    }


    public   List<Map<String, Object>> convertToListOfMap(Object[] parameters, String query)  {
        List<Map<String, Object>> resultQueryOnMap = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);

            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int rowcount = rsmd.getColumnCount();
            int  rt = 0;

            Map<String, Object> row;

            while (rs.next() && rt <= 3){
                row = new HashMap<>(rowcount);
                for(int i = 1; i <= rowcount; i++){
                    row.put(rsmd.getColumnName(i), rs.getObject(i));

                }

                resultQueryOnMap.add(row);
                rt++;


            }

        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }

            return resultQueryOnMap;

    }


    public String[][] getInfoOfDataBaseForRows(Object[] parameters, String query){
        String[][] response = new String[1000][1000];
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int rowcount = rsmd.getColumnCount();
            int  rt = 0;

            while (rs.next()  && rt <= 3){
                for(int i = 1; i <= rowcount; i++){
                    response[rt][i] = rs.getString(i);


                }

                rt++;

            }

        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
        return response;
    }

    public Boolean getResponseBoolean(Object[] parameters, String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                responseBoolean = rs.getBoolean(1);

            connection.close();
        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
        return responseBoolean;
    }

    public String getResponseString(Object[] parameters, String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                responseString = rs.getString(1);

            connection.close();
        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
        return responseString;
    }

    public int getResponseInt(Object[] parameters, String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                responseInt = rs.getInt(1);

            connection.close();
        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
        return responseInt;
    }

    public void updateInformation(Object[] parameters, String query){
        try {
            preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < parameters.length; i++){
                switch (parameters[i].getClass().getSimpleName()) {
                    case INTEGER:
                        preparedStatement.setInt(i + 1, (Integer) parameters[i]);
                        break;
                    case STRING:
                        preparedStatement.setString(i + 1, (String) parameters[i]);
                        break;
                    case BOOLEAN:
                        preparedStatement.setBoolean(i + 1, (Boolean) parameters[i]);
                        break;
                    default: break;
                }
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            LOGGER.info(ConstantsExceptions.NO_INFORMATION_FROM_HELPMODULE, e);
        }
    }

}
