package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;
import java.util.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            Scanner scanner = new Scanner(System.in);
            
            
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000; 
            while(true) {
                String msg = scanner.nextLine();
                byte[] msg_buf = msg.getBytes();
                int msg_size = msg_buf.length;
            
                System.out.print("[ Montando datagrama UDP  ..................  ");
                DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
                System.out.println("[OK] ]");
                
                System.out.print("[ Enviando datagrama UDP  ..................  ");
                socket.send(pack);
                System.out.println("[OK] ]");
                
                byte[] buf = new byte[200]; 
                DatagramPacket recebe = new DatagramPacket(buf, buf.length);
                System.out.println("[ Aguardando recebimento de mensagem  ..................  ");
                socket.receive(recebe);
                System.out.println("[ Recebido: " + new String(recebe.getData()));
            }
            

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}