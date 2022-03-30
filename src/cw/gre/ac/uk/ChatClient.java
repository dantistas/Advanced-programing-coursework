package cw.gre.ac.uk;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils; //lang 3 library

//Chat client API
public class ChatClient {

    private final String serverIp;
    private final int serverPort;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private static BufferedReader reader;

    String serverResponse;
    String[] splitServerResponse;
    Boolean isConnectedToTheServer;
    String user;

    public ChatClient(String Ip, int port) {
        this.serverIp =  Ip;
        this.serverPort = port;
    }

    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient("localhost", 1111);
//        chatClient.addNotificationListener();
        if(!chatClient.connect()){
            System.err.println("Error");
        } else{
            System.out.println("succes");
        }


//        if(chatClient.isConnectedToTheServer == true){
//            System.out.println("Connected successfully");
////            ChatClientGUI chatClientGUI = new ChatClientGUI(chatClient);
//
//        }else{
//            System.err.println("Connection failed");
//        }
//
////        if(!chatClient.connect()){
////            System.err.println("Connection failed");
////        }else{
////            System.out.println("Connected successfully");
////            LoginGUI loginGUI = new LoginGUI(chatClient);
////            loginGUI.setNotification(chatClient.serverResponse);
////            chatClient.login("Rytis");
//////            if true else false statenmentsfor login.
////            chatClient.readServerResponse();
////        }

    }

    public boolean login(String username) throws IOException {
        String usernameToSend = "login " + username + "\n";
        outputStream.write(usernameToSend.getBytes());
        readServerResponse();
//        this.serverResponse = reader.readLine();
//        return true;
        System.out.println("kas cioa ? "+usernameToSend);
        if(splitServerResponse[0].equalsIgnoreCase("welcome")){
            System.out.println("pavyko");
            //start message reader here.
            return true;
        }else{
            System.out.println("nepavyko");
            return false;
        }
//        System.out.println("loginas aPI");
//        return true;
    }

    private void quit() throws IOException {
        String command = "quit\n";
        outputStream.write(command.getBytes());
        this.serverResponse = reader.readLine();
//        this.splitServerResponse = StringUtils.split(serverResponse);
        System.out.println(serverResponse);
    }

    public boolean connect() {
        try {
            this.socket = new Socket(serverIp, serverPort);
            this.outputStream = socket.getOutputStream();
            this.inputStream = socket.getInputStream();
            this.reader = new BufferedReader(new InputStreamReader(inputStream));
            readServerResponse();
            return true;
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;

//        try{
//            System.out.println("blet1");
//            System.out.println(isConnectedToTheServer);
//            this.socket = new Socket(serverIp, serverPort);
//            this.inputStream = socket.getInputStream();
//            this.outputStream = socket.getOutputStream();
//            this.reader = new BufferedReader(new InputStreamReader(inputStream));
//            this.isConnectedToTheServer = true;
//            System.out.println("blet2");
//            System.out.println(isConnectedToTheServer);
//            readServerResponse();
//            return true;
//        }catch(IOException e){
//            System.out.println("blet3");
//            e.printStackTrace();
//            isConnectedToTheServer = false;
//            readServerResponse();
//        }
//        return false;
    }

    private void readServerResponse() throws IOException {
//        this.serverResponse = reader.readLine();
//        this.splitServerResponse = StringUtils.split(serverResponse);
        while((this.serverResponse = reader.readLine()) != null ){
            System.out.println("SERVER: " +serverResponse);                        //cia problema xDDDD jeigu ka
//            this.serverResponse = reader.readLine();
        }
        this.reader.close();
//        serverResponses.add(serverResponse);
//        this.currentLength = serverResponses.size();
//        this.previousLength = serverResponses.size();
//
//        for(int i = 0; i <= previousLength; i++)
//        System.out.println("SERVER: " +serverResponse);
    }

    private void sendToserver (){
        System.out.println("bl");
    }



}

