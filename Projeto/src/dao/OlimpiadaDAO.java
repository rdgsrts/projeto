package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Olimpiada;

public class OlimpiadaDAO {
	
	
	public void criar(Olimpiada olimpiada) throws SQLException{
		String sqlInsert = "insert into olimpiada (id, id_modalidade, id_pais, id_ano, ouro, prata, bronze) values (?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionFactory.obtemConexao(); PreparedStatement stm = con.prepareStatement(sqlInsert)){
			stm.setInt(1, olimpiada.getId());
			stm.setInt(2, olimpiada.getIdModalidade());
			stm.setInt(3, olimpiada.getIdPais());
			stm.setInt(4, olimpiada.getIdAno());
			stm.setInt(5, olimpiada.getOuro());
			stm.setInt(6, olimpiada.getPrata());
			stm.setInt(7, olimpiada.getBronze());
			
			stm.execute();
		}
	}
	
	public void atualizar(Olimpiada olimpiada) throws SQLException{
		String sqlUpdate = "update olimpiada set id_modalidade = ?, id_pais = ?, id_ano = ?, ouro = ?, prata = ?, bronze = ? where id = ?";
		
		try(Connection con = ConnectionFactory.obtemConexao(); PreparedStatement stm = con.prepareStatement(sqlUpdate)){
			stm.setInt(1, olimpiada.getIdModalidade());
			stm.setInt(2, olimpiada.getIdPais());
			stm.setInt(3, olimpiada.getIdAno());
			stm.setInt(4, olimpiada.getOuro());
			stm.setInt(5, olimpiada.getPrata());
			stm.setInt(6, olimpiada.getBronze());
			stm.setInt(7, olimpiada.getId());
			
			stm.execute();
		}
	}
	
	public void excluir (Olimpiada olimpiada) throws SQLException{
		String sqlDelete = "delete from olimpiada where id = ?";
		
		try(Connection con = ConnectionFactory.obtemConexao(); PreparedStatement stm = con.prepareStatement(sqlDelete)){
			stm.setInt(1, olimpiada.getId());
			
			stm.execute();
		}
	}
	
	public void carregar(Olimpiada olimpiada) {
		String sqlSelect = "SELECT * FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiada.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId(rs.getInt("id"));
					olimpiada.setIdModalidade(rs.getInt("id_modalidade"));
					olimpiada.setIdPais(rs.getInt("id_pais"));
					olimpiada.setIdAno(rs.getInt("id_ano"));
					olimpiada.setOuro(rs.getInt("ouro"));
					olimpiada.setPrata(rs.getInt("prata"));
					olimpiada.setBronze(rs.getInt("bronze"));
				} else {
					olimpiada.setId(-1);
					olimpiada.setIdModalidade(-1);
					olimpiada.setIdPais(-1);
					olimpiada.setIdAno(-1);
					olimpiada.setOuro(-1);
					olimpiada.setPrata(-1);
					olimpiada.setBronze(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	public int getTotalMedalhas(String nomePais, int idAno) {
		int total = 0;
		String sqlTotal = "select sum(o.ouro + o.prata + o.bronze) as Total from olimpiada o where (select id from pais where nome like ?) and ano = ?";
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlTotal)){
			stm.setString(1, nomePais);
			stm.setInt(2, idAno);
			
			try(ResultSet rs = stm.executeQuery()){
				if(rs.next()) {
					total = rs.getInt("Total");
				} else {
					total = 0;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
		
	}
	
	public List<Olimpiada> carregarMedalhasPorModalidade(String nomePais, int idAno) throws SQLException {
		List<Olimpiada> olimpiadas = new ArrayList<>();
		String sqlSelect = "select m.nome as Modalidade, o.ouro as Ouro, o.prata as Prata, o.bronze as Bronze from olimpiada o join modalidade m on o.id_modalidade = m.id where (select id from pais where nome like ?) and ano = ?";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setString(1, nomePais);
			stm.setInt(2, idAno);
			stm.execute();
			transformaResultadosEmColetores(olimpiadas, stm);
			return olimpiadas;
		}
	}

	private void transformaResultadosEmColetores(List<Olimpiada> olimpiadas, PreparedStatement stm) throws SQLException {

		try (ResultSet rs = stm.getResultSet()) {
			while (rs.next()) {
				String nomeModalidade = rs.getString("Modalidade");
				int ouro = rs.getInt("Ouro");
				int prata = rs.getInt("Prata");
				int bronze = rs.getInt("Bronze");

				Olimpiada olimpiada = new Olimpiada();
				olimpiada.setNomeModalidade(nomeModalidade);
				olimpiada.setOuro(ouro);
				olimpiada.setPrata(prata);
				olimpiada.setBronze(bronze);
				
				olimpiadas.add(olimpiada);

			}
		}
	}
	
}
