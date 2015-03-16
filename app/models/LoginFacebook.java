package models;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LoginFacebook {

    private static final String client_secret = "36120d86dffb1965040a106fa6fe27bb";
    private static final String client_id = "332680510258805";
    private static final String redirect_uri = "https://sd-project.herokuapp.com/loginfbresponse";

    public UsuarioFacebook obterUsuarioFacebook(String code)
            throws IOException {

        String retorno = readURL(new URL(this.getAuthURL(code)));

        String accessToken = null;
        @SuppressWarnings("unused")
        Integer expires = null;
        String[] pairs = retorno.split("&");
        for (String pair : pairs) {
            String[] kv = pair.split("=");
            if (kv.length != 2) {
                throw new RuntimeException("Resposta auth inesperada.");
            } else {
                if (kv[0].equals("access_token")) {
                    accessToken = kv[1];
                }
                if (kv[0].equals("expires")) {
                    expires = Integer.valueOf(kv[1]);
                }
            }
        }

        JsonNode resp = Json.parse(readURL(new URL(
                "https://graph.facebook.com/me?access_token=" + accessToken)));

//        JSONObject resp = new JSONObject(readURL(new URL(
//                "https://graph.facebook.com/me?access_token=" + accessToken)));

        UsuarioFacebook usuarioFacebook = new UsuarioFacebook(resp);
        System.out.println(usuarioFacebook.toString());
        return usuarioFacebook;

    }

    private String readURL(URL url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = url.openStream();
        int r;
        while ((r = is.read()) != -1) {
            baos.write(r);
        }
        return new String(baos.toByteArray());
    }

    public String getLoginRedirectURL() {
        return "https://graph.facebook.com/oauth/authorize?client_id="
                + client_id + "&display=page&redirect_uri=" + redirect_uri
                + "&scope=email,publish_actions";

//        return "http://www.facebook.com/dialog/oauth?" + "client_id="
//                + client_id + "&redirect_uri="
//                +redirect_uri
//                + "&scope=email";
    }

    public String getAuthURL(String authCode) {
        return "https://graph.facebook.com/oauth/access_token?client_id="
                + client_id + "&redirect_uri=" + redirect_uri
                + "&client_secret=" + client_secret + "&code=" + authCode;
    }

}