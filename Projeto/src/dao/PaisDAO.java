package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDAO {

	public void criar(Pais pais)  {
		String sqlInsert = "insert into pais (id, nome) values (?,?)";
		try (Connection con = ConnectionFactory.obtemConexao(); PreparedStatement stm = con.prepareStatement(sqlInsert)) {
			stm.setInt(1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Pais pais) {
		String sqlUpdate = "update pais set nome=? where id = ?";
		try (Connection con = ConnectionFactory.obtemConexao(); PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setString(1, pais.getNome());
			stm.setInt(2, pais.getId());
			stm.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Pais pais) {
		String sqlDelete = "delete from pais where id = ?";

		try (Connection con = ConnectionFactory.obtemConexao(); PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, pais.getId());

			stm.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void carregar(Pais pais) {
		String sqlSelect = "SELECT nome, id FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
				} else {
					pais.setId(-1);
					pais.setNome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

	}
	
	public String getNome(int id) {
		String nome = null;
		String sqlSelectNome = "select nome from pais where id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelectNome)) {
			stm.setInt(1, id);

			stm.execute();
			try (ResultSet rs = stm.getResultSet()) {
				while (rs.next()) {
					nome = rs.getString("nome");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return nome;
	}
}
