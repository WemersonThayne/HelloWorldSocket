package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cliente = new Socket("127.0.0.1", 8081);
		System.out.println("O cliente se conectou ao servidor!");

		Scanner entrada = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		while (entrada.toString() !=  "exit") {
			saida.println(entrada.nextLine());
		}

		saida.close();
		entrada.close();
		cliente.close();
	}
}