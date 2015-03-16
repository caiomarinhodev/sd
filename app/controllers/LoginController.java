package controllers;

import models.LoginFacebook;
import models.Usuario;
import models.UsuarioFacebook;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.io.IOException;

public class LoginController extends Controller {

    /**
     * This method render login
     *
     * @return
     */
    //private static GenericDAO dao = new GenericDAO();
    private static LoginFacebook loginFacebook = new LoginFacebook();

    @Transactional
    public static Result login() {
        return ok();
    }

    /**
     * This method render register page
     *
     * @return
     */
    // @Transactional
    // public static Result auth() {
    //     DynamicForm requestData = Form.form().bindFromRequest();
    //     final String email, senha;
    //     email = requestData.get("email");
    //     senha = requestData.get("senha");
    //     Usuario u = Portal.recuperaUsuario(email);
    //     if (u != null) {
    //         session().clear();
    //         session("email", email);
    //         return app(u);
    //     }
    //     return ok(login.render("Usuario nao existe"));
    // }

    /**
     * This method render a Dashboard Application
     *
     * @return
     */
    // @Transactional
    // private static Result app(Usuario usuario) {
    //     return ok(dashboard.render(Portal.getListaDisciplinas(), usuario));
    // }


    /**
     * Método que chama URL do facebook onde o usuário poderá autorizar a aplicação
     * a acessar seus recursos privados.
     *
     * @return
     */
    //@RequestMapping("/loginfb")
    public static Result logarComFacebook() {
        return redirect(loginFacebook.getLoginRedirectURL());
    }

    /**
     * Executado quando o Servidor de Autorização fizer o redirect.
     *
     * @param code
     * @return
     * @throws IOException
     */
    //@RequestMapping("/loginfbresponse")
    @Transactional
    public static Result logarComFace(String code) throws IOException {

        Logger.info("CODE:" + code);
        UsuarioFacebook ufb = loginFacebook.obterUsuarioFacebook(code);
        Usuario us = new Usuario(ufb.getEmail(),"12345", ufb.getName());
        // if(us==null){
        //     us = new Usuario(ufb.getEmail(),"12345", ufb.getName());
        //     Portal.salvaUsuario(us);
        // }
        // if (us!=null) {
        //     session().clear();
        //     session("email", us.getEmail());
        //     return ok(dashboard.render(Portal.getListaDisciplinas(),us));
        // } else {
        //     return ok(login.render(""));
        // }
        return ok(home.render(code, us));
    }


}