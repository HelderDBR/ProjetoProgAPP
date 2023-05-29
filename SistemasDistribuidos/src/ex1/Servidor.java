package ex1;

import java.net.*;
import com.google.gson.Gson;
import java.io.*; 
import java.util.*;

public class Servidor { 
 public static void main(String[] args) throws IOException 
   { 
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(10007); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Não foi possível ouvir na porta: 10007."); 
         System.exit(1);
        }

    Socket clientSocket = null; 
    System.out.println ("Esperando por conexão...");

    try { 
         clientSocket = serverSocket.accept(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Conexão não aceita."); 
         System.exit(1); 
        } 
    
    PrintWriter serverMessage = new PrintWriter(clientSocket.getOutputStream(), 
                                      true);
    
    BufferedReader clientMessage = new BufferedReader( 
            new InputStreamReader(clientSocket.getInputStream())); 

    String inputLine;
    
    Gson gson = new Gson();
    
    //preparando msg de confirmacao p/ cliente
    Confirmacao confirmCode = new Confirmacao();
    String confirmMessage = gson.toJson(confirmCode);
    
    Confirmacao erro = new Confirmacao("Erro.");
    String erroJson;
    
    //Usuarios cadastrados
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    usuarios.add(new Usuario(1, "Alice", "alicealice@gmail.com", "lalala123"));
    usuarios.add(new Usuario(2, "Otávio", "otaviootavio@gmail.com", "lalala123"));
    usuarios.add(new Usuario(3, "Jussara", "jussarajussara@gmail.com", "lalala123"));
    usuarios.add(new Usuario(4, "Bento", "bentobento@gmail.com", "lalala123"));
    usuarios.add(new Usuario(5, "Henrique", "henriquehenrique@gmail.com", "lalala123"));
    
    System.out.println ("Conexão estabelecida ");
    Mensagem msg;
    String msgJson;
    Usuario usuario = null;
    
    Servidor servidor = new Servidor();

    while ((inputLine = clientMessage.readLine()) != null) 
        {
         //lendo e printando msg do cliente
		 System.out.println("Recebido: " + inputLine);
		 
		 //transformar msg do cliente para objeto
		 msg = gson.fromJson(inputLine, Mensagem.class);
		 
		 int id = msg.getId_operacao();
		 
		 switch(id) {
		 	case 1: //cadastro
		 		usuario = new Usuario(usuarios.get(usuarios.size()).getId_usuario()+1, msg.getNome(), msg.getEmail(), msg.getSenha());
		 		boolean validacao = servidor.validarCadastro(usuario.getNome(), usuario.getEmail(), usuario.getSenha());

		 		if(validacao) {
		 			for(int i=0; i<usuarios.size(); i++) {
			 			String emailAtual = usuarios.get(i).getEmail();
			 			
			        	if(emailAtual.equals(usuario.getEmail())) {
			        		erro.setMensagem("O email já está cadastrado.");
				 			erroJson = gson.toJson(erro);
				 			
				 			serverMessage.println(erroJson);
				 			System.out.println("Enviado: " + erroJson);
					 	    break;
			        	}
			        }
		 			
		 			usuarios.add(usuario);
		 			
		 	        serverMessage.println(confirmMessage);
		 	        System.out.println("Enviado: " + confirmMessage);
		 		
		 		}else {
		 			erro.setMensagem("Erro ao realizar cadastro.");
		 			erroJson = gson.toJson(erro);
		 			
		 			serverMessage.println(erroJson);
		 			System.out.println("Enviado: " + erroJson);
		 		}
		 		
		 		break;
		 		
		 	case 2: //atualizar cadastro
		 		validacao = servidor.validarCadastro(msg.getNome() , msg.getEmail(), msg.getSenha());
		 		
		 		if(validacao) {
			 		//se o email n foi mudado
			 		if(msg.getEmail().equals(usuarios.get(msg.getId_usuario()).getEmail())) {
			 			usuarios.get(msg.getId_usuario()).setSenha(msg.getSenha());
			 			usuarios.get(msg.getId_usuario()).setNome(msg.getNome());
			 		}else {
			 			for(int i=0; i<usuarios.size(); i++) {
			 				if(usuarios.get(i).getEmail().equals(usuarios.get(msg.getId_usuario()).getEmail())) {
			 					erro.setMensagem("Erro ao atualizar cadastro.");
					 			erroJson = gson.toJson(erro);
					 			
					 			serverMessage.println(erroJson);
					 			System.out.println("Enviado: " + erroJson);
					 			break;
			 				}
			 			}
			 			usuarios.get(msg.getId_usuario()).setNome(msg.getNome());
			 			usuarios.get(msg.getId_usuario()).setEmail(msg.getEmail());
			 			usuarios.get(msg.getId_usuario()).setSenha(msg.getSenha());
			 		}
		 		}else {
		 			erro.setMensagem("Erro ao atualizar cadastro.");
		 			erroJson = gson.toJson(erro);
		 			
		 			serverMessage.println(erroJson);
		 			System.out.println("Enviado: " + erroJson);
		 		}
		 		
		 		
		 	break;
		 		
		 	case 3: //login
		 		for(int i=1; i<=usuarios.size(); i++) {
		 			String emailAtual = usuarios.get(i).getEmail();
		 			String senhaAtual = usuarios.get(i).getSenha();
		 			
		        	if(emailAtual.equals(msg.getEmail()) && senhaAtual.equals(msg.getSenha())) {
		        			String token = "token";
		        			usuarios.get(i).setToken(token);
		        			
		        			msg = new Mensagem(null, 200, usuarios.get(i).getToken(), usuarios.get(i).getId_usuario());
		        			msgJson = gson.toJson(msg);
		        			
				 			serverMessage.println(msgJson);
				 	        System.out.println("Enviado: " + msgJson);
				 	        break;
		        		
		        	}else {
		        		erro.setMensagem("Erro ao logar.");
			 			erroJson = gson.toJson(erro);
			 			
			 			serverMessage.println(erroJson);
			 			System.out.println("Enviado: " + erroJson);
		        	}
		        }
		 	break;
		 	
		 	case 4:
		 		
		 	break;
		 		
		 	case 9: //logout
		 		if(msg.getToken().equals(usuarios.get(msg.getId_usuario()).getToken())) {
		 			serverMessage.println(confirmMessage);
		 	        System.out.println("Enviado: " + confirmMessage);
		 		}else {
		 			erro.setMensagem("Erro ao sair.");
		 			erroJson = gson.toJson(erro);
		 			
		 			serverMessage.println(erroJson);
		 			System.out.println("Enviado: " + erroJson);
		 		}
		 	break;
		 }
        }

    serverMessage.close(); 
    clientMessage.close(); 
    clientSocket.close(); 
    serverSocket.close(); 
   }
 
 public boolean validarCadastro(String nome, String email, String senha) {
		if(nome.isBlank() || email.isBlank() || senha.isBlank()) {
			return false;
		}
		// verificando tam. nome e se n tem numero
		if(nome.length() < 3 || nome.length() > 32 || nome.matches(".*\\d.*")) {
			return false;
		}
		  
		// verificando tam. email
		if(email.length() < 16 || email.length() > 50 || !email.matches(".*@.*")) {
			return false;
		}
		  
		if(senha.length() < 8 || senha.length() > 32) {
		  return false;
		}
		
		return true;
	}
}