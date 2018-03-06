package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	   public static void main(String[] args) throws IOException {
	     ServerSocket servidor = new ServerSocket(8081);
	     System.out.println(servidor.getLocalPort());
	     
	     Socket cliente = servidor.accept();
	     System.out.println("Nova conexão com o cliente " +   
	       cliente.getInetAddress().getHostAddress()
	     );
	     
	     Scanner s = new Scanner(cliente.getInputStream());
	     PrintStream returno = new PrintStream(cliente.getOutputStream());
	     while (s.hasNextLine()) {
	    	 returno.println("Bom dia(a)"+s.nextLine());
	       //System.out.println(s.nextLine());
	     }
	     
	     s.close();
	     servidor.close();
	     cliente.close();
	   }
	 }