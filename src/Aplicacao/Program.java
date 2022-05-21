package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Classes.Reserva;

public class Program {

	public static void main(String[] args, Integer roomNumber) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Nº do Quarto");
		int n = sc.nextInt();
		System.out.println("Data do Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data do check-out não pode ser maior que a data do check-in");
		}
		else {
			Reserva reserva = new Reserva(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("");
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			
			
		}
		
		sc.close();
	}
}
