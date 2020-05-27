package facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.CarroBean;
import model.dao.CarroDao;
import model.dao.Conexao;

public class CarroFacade {
	/**
	 * adiciona carro
	 * @param carro
	 * @return retorno = true;
	 */
	public Boolean adicionarCarro(CarroBean carro) {
        Connection con = null;
        Boolean retorno = false;

        try {
            con = Conexao.getConexao();
            if (CarroDao.insertCarro(carro, con)) {
            	retorno = true;
                con.commit();
            }

        } catch (SQLException ex) {
            try {
                con.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;
    }

	/**
	 * atualiza carro
	 * @param carro
//	 * @return true/false
	 */
	public boolean alterarCarro(CarroBean carro) {
        Connection con = null;
        Boolean retorno = false;

        try {
            con = Conexao.getConexao();
            if(CarroDao.updateCarro(carro, con)) {
                retorno = true;
                con.commit();
            }

        } catch (SQLException ex) {
            try {
                con.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;
    }

	/**
	 * retorna dados de um veiculo
	 * @param carro
	 * @return
	 */
	public CarroBean buscarCarro(CarroBean carro) {
        Connection con = null;
        CarroBean car = new CarroBean();

        try {
            con = Conexao.getConexao();
            car = CarroDao.retornaCarro(carro, con);
            con.commit();

        } catch (SQLException ex) {
            try {
                con.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return car;
    }

	/**
	 * Listagem de Carros
	 * @return
	 */
	public static ArrayList<CarroBean> listagemCarros() {
        Connection con = null;
        List<CarroBean> carros = new ArrayList<CarroBean>();

        try {
            con = Conexao.getConexao();
            carros = CarroDao.retornaCarros(con);
            con.commit();

        } catch (SQLException ex) {
            try {
                con.rollback();

            } catch (SQLException ex1) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(CarroFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return (ArrayList<CarroBean>) carros;
    }
}
