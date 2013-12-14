<%-- 
    Document   : orderEntry440
    Created on : 2013/12/14, 14:58:53
    Author     : Eiichi Tanaka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="begining.gf4.web.common.ConstantValueWeb"%>

<!DOCTYPE html>
<html>
    <script type="text/javascript">
    <!--
    /***************************************************************************
     * 数値のみ入力
     **************************************************************************/
    function numOnly() {
        m = String.fromCharCode(event.keyCode);
        if ("0123456789\b\r\t".indexOf(m, 0) < 0) {
            return false;
        }
    }
    //-->    
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Entry 440</title>
    </head>
    <body>
        <h1>注文情報を入力してください</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/SenderOrderQueue440" 
              method="post">
            <table>
                <tr>
                    <td>注文ID</td>
                    <td><input name="<%=ConstantValueWeb.PARAM_SENDER_ORDER_QUEUE_440_ORDER_ID%>"
                               type="text" width="20"
                               style="ime-mode:disabled;"
                               onkeydown="return numOnly()" />
                    </td>
                </tr>
                <tr>
                    <td>顧客名</td>
                    <td><input name="<%=ConstantValueWeb.PARAM_SENDER_ORDER_QUEUE_440_CUSTOMER_NAME%>"
                               type="text" width="20" />
                    </td>
                </tr>
                <tr>
                    <td>合計金額</td>
                    <td><input name="<%=ConstantValueWeb.PARAM_SENDER_ORDER_QUEUE_440_TOTAL_AMOUNT%>"
                               type="text" width="20"
                               style="ime-mode: disabled; text-align: right;"
                               onkeydown="return numOnly()" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="キュー送信" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
