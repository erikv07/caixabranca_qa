package caixabranca;

public class codigo_slide {
	/**
	 * A classe cria metodos para conectar com o banco MySQL e verifica as credencias.
	 * E as o login e a senha 
	 */
	package login;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class User {
	    
	    /**
	     * Cria a conexão com o MySQL.
	     * @return objeto de conexão com o banco ou null se acontecer algum erro.
	     */
	    public Connection conectarBD() {
	        Connection conn = null;
	        try {
	            // Carrega os metodos do JDBC e cria a conexão com o banco.
	            Class.forName("com.mysql.Driver.Manager").newInstance();
	            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
	            conn = DriverManager.getConnection(url);
	        } catch (Exception e) {
	            // Executa caso aconteça algum erro porem esta incompleto.
	        }
	        return conn;
	    }

	    /**
	     *	Verifica se o usuario e senha batem  no Banco de Dados
	     * @param login O login do usuário.
	     * @param senha A senha do usuarioi.
	     * @return verdadeiro se o login e senha conhecidirem no banco de dados.
	     */
	    public boolean verificarUsuario(String login, String senha) {
	        System.out.print("Running here first -> b");
	        String sql = "";
	        Connection conn = conectarBD();

	        // SQL INSTRUÇÕES
	        sql += "SELECT nome FROM usuarios ";
	        sql += "WHERE login = '" + login + "'";
	        sql += "AND senha = '" + senha + "'";
	        try {
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            if (rs.next()) {
	                result = true;
	                nome = rs.getString("nome");
	            }
	        } catch (Exception e) {
	        	// Executa caso acontece algum erro porem esta incompleto .
	        }
	        return result;
	    }

	    // Instancia as variaveis 
	    public String nome = "";
	    public boolean result = false;
	}