package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Filme;
import model.Genero;

public class FilmeDAO {
	
	public int inserirFilme(Filme filme) throws IOException {
		int id = -1;
		String sql = "insert into FILME (titulo, descricao, diretor, posterpath, "
				+ "popularidade, data_lancamento, id_genero) values (?,?,?,?,?,?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, filme.getTitulo());
			pst.setString(2, filme.getDescricao());
			pst.setString(3, filme.getDiretor());
			pst.setString(4, filme.getPosterPath());
			pst.setDouble(5, filme.getPopularidade());
			pst.setDate(6, new java.sql.Date(filme.getDataLancamento().getTime()));
			pst.setInt(7, filme.getGenero().getId());			
			pst.execute();
			
			//obter o id criado
			String query = "select LAST_INSERT_ID()";
			try(PreparedStatement pst1 = conn.prepareStatement(query);
				ResultSet rs = pst1.executeQuery();){

				if (rs.next()) 
				{
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return id;
	}

	/*public Filme buscarFilme(int id) throws IOException{
		// TODO Auto-generated method stub
		return null;
	}*/

    public Filme buscarFilme(int id) throws IOException 
    {
		String sql = "select id, titulo, descricao,"+
		"diretor, popularidade, "+ 
		"id_genero from FILME where id = "+id;

		//String sql = "select * from FILME where id="id;
		
		//String txt = new String[]
		Filme filme = new Filme();
		Genero genero = new Genero();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);)
		{
			try (ResultSet rs = pst.executeQuery();) 
			{
				if (rs.next())
				{
					filme.setId(rs.getInt("id"));
					filme.setTitulo(rs.getString("titulo"));
					filme.setDescricao(rs.getString("descricao"));
					filme.setDiretor(rs.getString("diretor"));
					filme.setPopularidade(rs.getDouble("popularidade"));
					genero.setId(rs.getInt("id_genero"));
					filme.setGenero(genero);			
				}
			} 
			catch (SQLException a) 
			{
				a.printStackTrace();
				System.out.println("Erro ao carregar tabela.");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return filme;
	}

}
