package jp.co.aforce.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.LoginModel;


// 親クラスに HttpServlet を指定する
//これがないと waring がでる
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        // GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
        RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
        rDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        // 文字のエンコードを UTF-8 とする。これがないと文字化け。
        request.setCharacterEncoding("UTF-8");

        // ユーザによって入力された情報を取り出す
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 取り出した情報を loginBean に格納
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        // モデルをインスタンス化する
        LoginModel loginModel = new LoginModel();
        String forward_jsp = "/views/login.jsp";

        // 入力された情報がDBに存在するか調べる
        if (loginModel.loginCheck(username, password)) {


        	// ログインに成功した先の JSP を指定
            forward_jsp = "/views/success.jsp";

        // ログインが失敗したときの処理
        } else {
            // エラーメッセージを設定(loginBeanを使用してEmsg表示)
            loginBean.setEmsg("ユーザ名またはパスワードが違います");
            request.setAttribute("loginBean", loginBean);
        }
        // forwaed_jsp に設定されているJSPへディスパッチ
        RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
        rDispatcher.forward(request, response);
    }
}


