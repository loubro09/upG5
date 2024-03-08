package Server;

import Entity.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class UserController {

    private HashMap<User, ServerNetworkBoundary.ClientHandler> clients = new HashMap<>();



}
