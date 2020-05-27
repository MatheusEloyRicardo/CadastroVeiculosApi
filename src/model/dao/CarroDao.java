package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.CarroBean;

public class CarroDao {
	/**
	 * Busca dados dos veículos
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<CarroBean> retornaCarros(Connection con) throws SQLException {
        List<CarroBean> carros = new ArrayList<CarroBean>();

        // cria um preparedStatement
        String selectSQL = "SELECT * FROM RentCar;";

        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            CarroBean car = new CarroBean();

            car.setID(rs.getInt("id"));
            car.setVeiculo(rs.getString("veiculo"));
            car.setMarca(rs.getString("marca"));
            car.setAno(rs.getInt("ano"));
            car.setDescricao(rs.getString("descricao"));
            car.setVendido(rs.getBoolean("vendido"));

            carros.add(car);
        }

        return (ArrayList<CarroBean>) carros;
    }

	/**
	 * retorna dados de um carro selecionado
	 * @param carro
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static CarroBean retornaCarro(CarroBean carro, Connection con) throws SQLException {
        // cria um preparedStatement
        String selectSQL = "SELECT * FROM RentCar WHERE id = ?;";

        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        preparedStatement.setInt(1, carro.getID());
        ResultSet rs = preparedStatement.executeQuery();

        CarroBean car = new CarroBean(
    	    rs.getInt("id"),
	        rs.getString("veiculo"),
	        rs.getString("marca"),
	        rs.getInt("ano"),
	        rs.getString("descricao"),
	        rs.getBoolean("vendido")
        );

        return car;
    }

	/**
	 * insere veículo
	 * @param carro
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static boolean insertCarro(CarroBean carro, Connection con) throws SQLException {
		Calendar c = Calendar.getInstance();
		String updated = c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);

        // cria um Prepared Statement
        PreparedStatement stmt = con.prepareStatement("INSERT INTO RentCar(veiculo, marca, ano, descricao, vendido, created) VALUES (?, ?, ?, ?, ?, ?);");

        // preenche os valores
        stmt.setString(1, carro.getVeiculo());
        stmt.setString(2, carro.getMarca());
        stmt.setInt(3, carro.getAno());
        stmt.setString(4, carro.getDescricao());
        stmt.setBoolean(5, carro.isVendido());
        stmt.setString(6, updated);

        // executa
        stmt.execute();
        stmt.close();
        return true;
    }

	/**
	 * Atualiza um Veículo 
	 * @param carro
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateCarro(CarroBean carro, Connection con) throws SQLException {
		 Calendar c = Calendar.getInstance();
		 String updated = c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);

	    // cria um Prepared Statement
	    PreparedStatement stmt = con.prepareStatement("UPDATE RentCar SET"
	    		+ " veiculo = ?"
	    		+ " marca = ?"
	    		+ " ano = ?"
	    		+ " descricao = ?"
	    		+ " vendido = ?"
	    		+ " updated = ?"
	    		+ " WHERE id = ?");
	
	    // set the preparedstatement parameters
	    stmt.setString(1, carro.getVeiculo());
        stmt.setString(2, carro.getMarca());
        stmt.setInt(3, carro.getAno());
        stmt.setString(4, carro.getDescricao());
        stmt.setBoolean(5, carro.isVendido());
        stmt.setString(6, updated);
        stmt.setInt(7, carro.getID());

	    // call executeUpdate to execute our sql update statement
	    stmt.executeUpdate();
	    stmt.close();
	    return true;
	}
	 
	 /**
	  * Deleta Veiculo
	  * @param carro
	  * @param con
	  * @return
	  * @throws SQLException
	  */
	 public static boolean deleteCarro(CarroBean carro, Connection con) throws SQLException {
        // cria um Prepared Statement
        PreparedStatement stmt = con.prepareStatement("DELETE FROM RentCar WHERE id = ?;");

        // preenche os valores
        stmt.setInt(1, carro.getID());

        // executa
        stmt.execute();
        stmt.close();
        return true;
    }
}
