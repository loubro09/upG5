package Server;

import Entity.User;

public class MainS {
    public void main (String[] args) {
        ServerNetworkBoundary snb = new ServerNetworkBoundary(2343);
        UserController uc = new UserController(snb);
    }
}
