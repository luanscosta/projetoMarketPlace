import java.util.Date;
import java.util.List;

import opet.marketplace.vo.*;
import opet.marketplace.dao.jdbc.*;


public class MainTeste {

	public static void main(String[] args) {
		
		
				
		// Testes de ReplyJdbcDAO
		

		
		//Teste de pesquisa por user
		//ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//List<Reply> list = teste.searchByTopic(4);
		//for (Reply temp : list) {
		//	System.out.println(temp.getReplyContent());
		//}
		
		//Teste de pesquisa por user
		//ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//List<Reply> list = teste.searchByUser(1);
		//for (Reply temp : list) {
		//	System.out.println(temp.getReplyContent());
		//}
		
		//Teste de pesquisa por assunto
		//		ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//		List<Reply> list = teste.searchByContent("lu");
		//		for (Reply temp : list) {
		//			System.out.println(temp.getReplyContent());
		//		}
		
		// Teste de pesquisa de todos os topics
		//		ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//		List<Reply> list = teste.search();
		//		for (Reply temp : list) {
		//			System.out.println(temp.getReplyId());
		//		}
		
		// Teste de delecao de topico
		//		ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//		 if(teste.delete(1)){
		//				 System.out.println("DELETADO");
		//				 }
		
		//Teste de alterar reply
		//		ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//		Date date = new Date();
		//		Reply reply = new Reply(1, "xuxu", date, 4, 1);
		//		Reply retorno = teste.update(reply);
		//		System.out.println(retorno.getReplyContent());

		//Teste de recuperacao de reposta
		//		ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//		Reply retorno = teste.recovery(1);
		//		System.out.println(retorno.getReplyContent());
				
		//Teste de insert reply
		//ReplyJdbcDAO teste = new ReplyJdbcDAO();
		//Date date = new Date();
		//Reply reply = new Reply(1, "blurb", date, 4, 1);
		//Reply retorno = teste.create(reply);
		//System.out.println(retorno.getReplyContent());
		
		
		
		
		// Testes de TopicJdbcDAO
		

		//Teste de pesquisa por categoria
		//TopicJdbcDAO teste = new TopicJdbcDAO();
		//List<Topic> list = teste.searchByCategory(Categories.FINANCEIRO);
		//for (Topic temp : list) {
		//	System.out.println(temp.getTopicSubject());
		//}
		
		
		//Teste de pesquisa por user
		//TopicJdbcDAO teste = new TopicJdbcDAO();
		//List<Topic> list = teste.searchByUser(1);
		//for (Topic temp : list) {
		//	System.out.println(temp.getTopicSubject());
		//}
		
		//Teste de pesquisa por assunto
		//TopicJdbcDAO teste = new TopicJdbcDAO();
		//List<Topic> list = teste.searchBySubject("xa");
		//for (Topic temp : list) {
		//	System.out.println(temp.getTopicSubject());
		//}
		
		// Teste de pesquisa de todos os topics
		//		TopicJdbcDAO teste = new TopicJdbcDAO();
		//		List<Topic> list = teste.search();
		//		for (Topic temp : list) {
		//			System.out.println(temp.getTopicId());
		//		}
		
		
		// Teste de delecao de topico
		// TopicJdbcDAO teste = new TopicJdbcDAO();
		// if(teste.delete(1)){
		//		 System.out.println("DELETADO");
		//		 }
			
		//Teste de altercao de tópico
		//TopicJdbcDAO teste = new TopicJdbcDAO();
		//Date date = new Date();
		//Topic topico = new Topic(4, "xaxa", "TO COM FOME", date, Categories.JURIDICO, 1);
		//Topic retorno = teste.update(topico);
		//System.out.println(retorno.getTopicMessage());
			
		//Teste de recuperacao de tópico
		//TopicJdbcDAO teste = new TopicJdbcDAO();
		//Topic retorno = teste.recovery(1);
		//System.out.println(retorno.getTopicMessage());
		//System.out.println(retorno.getTopicCategory());
				
		//Teste de inserção de tópico
		//TopicJdbcDAO teste = new TopicJdbcDAO();
		//Date date = new Date();
		//Topic topico = new Topic(1, "xaxa", "QUERO LEITE", date, Categories.JURIDICO, 1);
		//Topic retorno = teste.create(topico);
		//System.out.println(retorno.getTopicMessage());
		
		// Testes de UserJdbcDAO
		
		// Teste de inserção de usuário
		// UserJdbcDAO teste = new UserJdbcDAO();
		// Date date = new Date();
		// User joao = new Lawyer(1, "joao", "123", "joao@professor.com", date);
		// User joaoId = teste.create(joao);

		// Teste de alteracao de usuário
		// Date date = new Date();
		// User joao = new Lawyer(1, "joao", "123", "joao@alterado.com", date);
		// UserJdbcDAO teste = new UserJdbcDAO();
		// User retrieved = teste.update(joao);
		// System.out.println(retrieved.getUserEmail());
		// System.out.println(retrieved.getUserId());
		// System.out.println(retrieved.getUserId());
		// System.out.println(retrieved.getUserName());
		// System.out.println(retrieved.getUserPass());

		// Teste de recuperacao de usuário
		// UserJdbcDAO teste = new UserJdbcDAO();
		// User retrieved = teste.recovery(1);
		// User retrieved = teste.recovery(1);
		// System.out.println(retrieved.getUserEmail());
		// System.out.println(retrieved.getUserId());
		// System.out.println(retrieved.getUserId());
		// System.out.println(retrieved.getUserName());
		// System.out.println(retrieved.getUserPass());
		
		// Teste de delecao de usuário
		// UserJdbcDAO teste = new UserJdbcDAO();
		// if(teste.delete(9)){
				// System.out.println("DELETADO");
				// }
		
		// Teste de pesquisa de todos os users
		//UserJdbcDAO teste = new UserJdbcDAO();
		//List<User> list = teste.search();
		//for (User temp : list) {
		//	System.out.println(temp.getUserId());
		//}
		
		//Teste de pesquisa por email
		//UserJdbcDAO teste = new UserJdbcDAO();
		//List<User> list = teste.searchByEmail("professor");
		//for (User temp : list) {
		//	System.out.println(temp.getUserId());
		//}

		//teste de pesquisa por nome
		//UserJdbcDAO teste = new UserJdbcDAO();
		//List<User> list = teste.searchByName("joao");
		//for (User temp : list) {
		//	System.out.println(temp.getUserId());
		//}

	}

}
