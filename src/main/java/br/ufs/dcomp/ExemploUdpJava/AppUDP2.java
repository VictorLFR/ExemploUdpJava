package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.*;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                byte[] buf = new byte[200];
                DatagramPacket pack = new DatagramPacket(buf, buf.length);
    
                System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
                socket.receive(pack);
                System.out.println("[OK] ]");
                
                byte[] received_data = pack.getData();
                String received_msg = new String(received_data); 
                InetAddress origin_address = pack.getAddress();
                int origin_port = pack.getPort();
                
                //System.out.println("  Mensagem:             "+ received_msg);
                //System.out.println("  Endereço de origem:   "+ origin_address.getHostAddress());
                //System.out.println("  Porta de origem:      "+ origin_port);
                System.out.println("[ Recebido: " + new String(received_msg));
                
                System.out.print("[ Digite a sua mensagem: ");
                String msg = scanner.nextLine();
                
                byte[] msg_buf = msg.getBytes();
                
                System.out.print("[ Montando datagrama UDP  ..................  ");
                DatagramPacket sended_pack = new DatagramPacket(msg_buf, msg_buf.length, origin_address, origin_port);
                System.out.println("[OK] ]");
                
                System.out.print("[ Enviando datagrama UDP  ..................  ");
                socket.send(sended_pack); 
                System.out.println("[OK] ]");
            }
            
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}