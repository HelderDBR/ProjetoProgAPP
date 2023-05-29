package ex1;

import java.io.*;
import java.util.*;
import java.net.*;

import com.google.gson.*;

public class Cliente {
    public static void main(String[] args) throws IOException {

    	//InetAddress localAddress = InetAddress.getLocalHost();
        String serverHostname = new String ("127.0.0.1");
        int port = 10007;
        
        if (args.length > 0)
           serverHostname = args[0];
        
        System.out.println ("Tentando conectar ao host " +
		serverHostname + " na porta " + port);
        
        Socket socket = null;
        PrintWriter clientMessage = null;
        BufferedReader serverMessage = null;

        try {
            socket = new Socket(serverHostname, port);
            clientMessage = new PrintWriter(socket.getOutputStream(), true);
            serverMessage = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host não encontrado: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Não foi possível pegar o I/O "
                               + "da conexão com: " + serverHostname);
            System.exit(1);
        }

		BufferedReader stdIn = new BufferedReader(
	                                   new InputStreamReader(System.in));
		
		String userInput;
		
		String menu = "-----Menu-----\n1 - Cadastrar\n3 - Logar\n9 - Sair\n0 - Desconectar";
	
		System.out.println(menu);
		
		Gson gson = new Gson();
		
		boolean flagLogado = false;
		String temp, data, rodovia;
		Mensagem msg;
		Usuario usuarioLogado = null;
		Integer km, tipo_incidente;
		Scanner num = new Scanner(System.in);
		
		while ((userInput = stdIn.readLine()) != null) {
			switch(userInput) {
				case "0": // Desconectar
					System.out.println("Desconectar >> Certeza que quer se desconectar? S/N");
					temp = stdIn.readLine();
					
					if(temp.equals("S")) {
						clientMessage.close();
						serverMessage.close();
						stdIn.close();
						socket.close();
						
						return;
					}
					
					System.out.println("Bem vindo de volta!");
					
					System.out.println(menu);
					
					break;
					
				case "1": // Cadastro
					System.out.println("Cadastro >> Nome:");
					String nome = stdIn.readLine();
					
					System.out.println("Cadastro >> Email:");
					String email = stdIn.readLine();
					
					System.out.println("Cadastro >> Senha:");
					String senha = stdIn.readLine();
					senha = hashed(senha);
					
					//criando e convertendo obj em json
					msg = new Mensagem(1, nome, email, senha);
					String msgJson = gson.toJson(msg);
					
					//mandando msg do cliente
					clientMessage.println(msgJson);
				    System.out.println("Enviado: " + msgJson);
					
				    //lendo e printando msg do servidor
				    String respostaJson = serverMessage.readLine();
				    System.out.println("Recebido: " + respostaJson);
				    
				break;
					
				//Atualizar Cadastro
				case "2":
					if(flagLogado) {
						System.out.println("Atualizar Cadastro >> Nome:");
						nome = stdIn.readLine();
						
						System.out.println("Atualizar Cadastro >> Email:");
						email = stdIn.readLine();
						
						System.out.println("Atualizar Cadastro >> Senha:");
						senha = stdIn.readLine();
						senha = hashed(senha);
						
						msg = new Mensagem(2, nome, email, senha, usuarioLogado.getToken(), usuarioLogado.getId_usuario());
						msgJson = gson.toJson(msg);
						
						clientMessage.println(msgJson);
						System.out.println("Enviado: " + msgJson);
						
						respostaJson = serverMessage.readLine();
					    System.out.println("Recebido: " + respostaJson);
					    
					    Confirmacao resposta = gson.fromJson(respostaJson, Confirmacao.class);
						
					    if(resposta.getCodigo() == 200){
							menu = "-----Menu-----\n9 - Sair\n0 - Desconectar";
							
							System.out.println(menu);
							System.out.println("Bem-vindo!");
							
							flagLogado = true;
							usuarioLogado = new Usuario(1, "Nome", email, senha);
							usuarioLogado.setToken(resposta.getToken());
					    }else {
					    	System.out.println(resposta.getMensagem());
					    }
						
					}else {
						System.out.println("Você não está logado.");
					}
				break;
				
				case "3":
					if(flagLogado) {
						System.out.println("Você já está logado.");
						break;
					}
					
					System.out.println("Login >> Email:");
					email = stdIn.readLine();
					
					System.out.println("Login >> Senha:");
					senha = stdIn.readLine();
					senha = hashed(senha);
					
					msg = new Mensagem(3, email, senha);
					msgJson = gson.toJson(msg);
					
					clientMessage.println(msgJson);
					System.out.println("Enviado: " + msgJson);
					
					respostaJson = serverMessage.readLine();
				    System.out.println("Recebido: " + respostaJson);
				    
				    Confirmacao resposta = gson.fromJson(respostaJson, Confirmacao.class);
					
				    if(resposta.getCodigo() == 200){
						menu = "-----Menu-----\n9 - Sair\n0 - Desconectar";
						
						System.out.println(menu);
						System.out.println("Bem-vindo!");
						
						flagLogado = true;
						usuarioLogado = new Usuario(1, "Nome", email, senha);
						
				    }else {
				    	System.out.println(resposta.getMensagem());
				    }
				
				break;
				
				case "4":
					System.out.println("Reportar incidente >> Data:");
					data = stdIn.readLine();
					
					System.out.println("Reportar incidente >> Rodovia:");
					rodovia = stdIn.readLine();
					
					System.out.println("Reportar incidente >> Km:");
					km = num.nextInt();
					
					System.out.println("Reportar incidente >> Tipo do incidente:");
					tipo_incidente = num.nextInt();
					
					msg = new Mensagem(4, data, rodovia, km, tipo_incidente, usuarioLogado.getToken(), usuarioLogado.getId_usuario());
					msgJson = gson.toJson(msg);
					
					clientMessage.println(msgJson);
					System.out.println("Enviado: " + msgJson);
					
					respostaJson = serverMessage.readLine();
				    System.out.println("Recebido: " + respostaJson);
				    
				    resposta = gson.fromJson(respostaJson, Confirmacao.class);	
					
				break;
					
				case "9":
					if(flagLogado) {
						System.out.println("Logout >> Certeza que quer sair? S/N");
						temp = stdIn.readLine();
						
						if(temp.equals("S")) {
							msg = new Mensagem(9, null, "token", 1);
							msgJson = gson.toJson(msg);
							
							clientMessage.println(msgJson);
							System.out.println("Enviado: " + msgJson);
							
							respostaJson = serverMessage.readLine();
						    System.out.println("Recebido: " + respostaJson);
						    
						    resposta = gson.fromJson(respostaJson, Confirmacao.class);
							
						    if(resposta.getCodigo() == 200) {
								menu = "-----Menu-----\n1 - Cadastrar\n2 - Logar\n0 - Desconectar";
								System.out.println(menu);
								
								flagLogado = false;
								usuarioLogado = null;
								
								break;
						    }else if(resposta.getCodigo() == 500) {
						    	System.out.println(resposta.getMensagem());
						    }  	
					}
					
					System.out.println("Bem vindo de volta!");
					
					System.out.println(menu);
					
					}else {
						System.out.println("Você não está logado.");
					}
					
					break;
			}
		}
}
    
    public static String hashed(String pswd) {
    	
    	String hashed = "";
    	
        for (int i = 0; i < pswd.length(); i++) {
            char c = pswd.charAt(i);
            int asciiValue = (int) c;
            int novoAsciiValue = asciiValue + pswd.length();
            if (novoAsciiValue > 127) {
                novoAsciiValue = novoAsciiValue - 127 + 32;
            }
            char novoCaractere = (char) novoAsciiValue;
            hashed += novoCaractere;
        }
        return hashed;
    }
}