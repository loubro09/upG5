package Client;

public class ClientMessageController {

    private ClientNetworkBoundary networkBoundary;

    public ClientMessageController(String ip, int port) {
        this.networkBoundary = new ClientNetworkBoundary(ip, port);



    }

}
