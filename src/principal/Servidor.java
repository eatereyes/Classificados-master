package principal;

import classe.*;
import colecoes.*;
import java.net.*;
import java.io.*;


public class Servidor  {

	public final static int DEFAULT_PORT = 1234;
	
	public static void main(String[] args) throws Exception {
	    int porta =  DEFAULT_PORT;
	
		ServerSocket servidor = new ServerSocket(porta,5);//Declara um ServerSocket
		System.out.println("----------------------------------------");
		System.out.println("Servidor criado na porta " + porta);
		Socket        conexao = null;
		int numero = 0; 
		
		
		while(true) {
			InetAddress endereco_remoto;
			int         porta_remota;
			
			System.out.println("Servidor esperando conexao na porta " + porta);
			conexao = servidor.accept( );//Espera um conexão
			numero++;
			ObjectInputStream entrada = new ObjectInputStream (conexao.getInputStream());//entrada para receber
			Thread.sleep(5000);
			
			
			//System.out.println("Servidor recebeu conexao. Numero da conexao: " + numero);
			
			endereco_remoto = conexao.getInetAddress();
			porta_remota    = conexao.getPort();
			
			//System.out.println("Nome da maquina remota: " + endereco_remoto.getHostName());
			//System.out.println("IP da maquina remota: " + endereco_remoto.getHostAddress());
			//System.out.println("Porta maquina remota: " + porta_remota);
			
			try {
				Anuncios a=(Anuncios) entrada.readObject();//recebe os dados e salva na coleção
				//System.out.println(a);
				a.salvaEmXML();//salva em Xml
				//System.out.println("Anuncios salvo com sucesso");
			    //System.out.println((String)entrada.readObject());
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				Pessoas a=(Pessoas) entrada.readObject();//recebe os dados e salva na coleção
				//System.out.println(a);
				a.salvaEmXML();//salva no XML
				//System.out.println("Pessoas salvas com sucesso");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
