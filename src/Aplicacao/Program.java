package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entidades.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Nº do Quarto:");
			int n = sc.nextInt();
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(n, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválida");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}
}
