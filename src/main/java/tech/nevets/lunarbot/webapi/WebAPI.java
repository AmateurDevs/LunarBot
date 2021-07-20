package tech.nevets.lunarbot.webapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebAPI {
        public static void main(String args[]) {
            WebServer ws = new WebServer();
            ws.start();
        }
    }

    class WebServer {


        protected void start() {
            ServerSocket s;

            System.out.println("Webserver starting up on port 80");
            System.out.println("(press ctrl-c to exit)");
            try {
                // create the main server socket
                s = new ServerSocket(80);
            } catch (Exception e) {
                System.out.println("Error: " + e);
                return;
            }

            System.out.println("Waiting for connection");
            for (;;) {
                try {

                    Socket remote = s.accept();

                    System.out.println("Connection, sending data.");
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            remote.getInputStream()));
                    PrintWriter out = new PrintWriter(remote.getOutputStream());

                    String str = ".";
                    while (!str.equals(""))
                        str = in.readLine();

                    out.println("HTTP/1.0 200 OK");
                    out.println("Content-Type: text/html");
                    out.println("Server: Bot");
                    out.println("");
                    out.println("<H1>WebAPI is running</H2>");
                    out.flush();
                    remote.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
        }

    }




























/**    static final File WEB_ROOT = new File("/WebAPI");
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
                File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
                int fileLength = file.length();
                String conetentMimeType = "ext/html";
                byte[] fileData = readFileData(file, fileLength)
                private byte[] readFileData(File file, int fileLength) {
                    FileInputStream fileIn = null;
                    byte[] fileData = new byte[fileLength];
                    fileIn = new FileInputStream(file);
                    fileIn.read(fileData);
                }
            }
            else{

            }
            } catch(IOException e){
                e.printStackTrace();
            }

        }
}
**/