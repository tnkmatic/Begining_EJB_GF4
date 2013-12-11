<%-- 
    Document   : login
    Created on : 2013/10/08, 19:15:41
    Author     : Eiichi Tanaka
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン</title>
    </head>
    <body>
        <h1>ログインページ</h1>
        <p>JavaEE6セキュリティ検証用です</p>
        
        <form method="post" action="j_security_check">
            <table border="0">
                <tr>
                    <th align="right">ユーザID：</th>
                    <td>
                        <input type="text" name="j_username" size="15" />
                    </td>
                </tr>
                <tr>
                    <th align="right">パスワード：</th>
                    <td>
                        <input type="text" name="j_password" size="15" />
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">
                        <input type="submit" value="ログイン" />
                        <input type="reset"  value="クリア" />
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
