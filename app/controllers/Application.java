package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void ioAsset() {
        redirect("http://localhost:1337/socket.io/socket.io.js");
    }

}
