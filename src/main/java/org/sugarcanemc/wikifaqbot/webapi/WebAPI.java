package org.sugarcanemc.wikifaqbot.webapi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;


public class WebAPI implements Runnable {

    static final File WEB_ROOT = new File("/WebAPI");
    static final String DEFAULT_File = "index.html";
    static final String FILE_NOT_FOUND = "404.html";
    static final String METHOD_NOT_SUPPORTED = "mns.html"; // (file not supported)

    // port
    static final int PORT = 80;
    // port

    static final boolean verbose = true;

    private Socket connect;

    public void webapi(Socket c) {
        connect = c;
    }

        public static void main(String[] args){
            try {
                ServerSocket serverConnect = new ServerSocket(PORT);
                System.out.println("[WebAPI] WebAPI Started on " + "IP" + PORT);
                //TODO Make sys.out read IP
                while(true) {
                    WebAPI server = new WebAPI();
                    if (verbose) {
                        System.out.println("[WebAPI] Connection Open.");
                    }

                    Thread thread = new Thread(server);
                    thread.start();

                }
            } catch (IOException e) {
                System.err.println("[WebAPI] Server Connection error");
                e.printStackTrace();
            }

        }


        @Override
        public void run() {
            BufferedReader in = null; PrintWriter out = null; BufferedOutputStream dataOut = null;
            String fileRequested = null;

            try{
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            out = new PrintWriter(connect.getOutputStream());
            dataOut = new BufferedOutputStream(connect.getOutputStream());
            String input = in.readLine();
            StringTokenizer parse = new StringTokenizer(input);
            String method = parse.nextToken().toUpperCase();
            fileRequested = parse.nextToken().toLowerCase();
            if(!method.equals("GET") && !method.equals("HEAD")) {
                if (verbose) {
                    System.out.println("501 Not Implemeted: " + method + "method.");
                }
            }
            else{

            }
            } catch(IOException e){
                e.printStackTrace();
            }

        }
}
