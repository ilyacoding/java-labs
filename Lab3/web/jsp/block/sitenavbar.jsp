
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String ruOption ="";
    String engOption ="";
    if(((String)session.getAttribute("locale")).equals("ru")) {
        ruOption = "selected='selected'";
        engOption = "";
    }else{
        engOption = "selected='selected'";
        ruOption = "";
    }
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=utf-8");
%>

<div class="container">
    <div class="col-12">
        <div class="row">
            <div class="col-6">
                <form action="/servicehotels" id="locale_form">
                    <input type="text" name="command" value="localization" hidden="hidden"/>
                    <div >
                        <select name="locale" onchange="$('#locale_form').submit();">
                            <option id="ru_option" value="ru" <%=ruOption%>>RU</option>
                            <option id="eng_option" value="eng" <%=engOption%>>ENG</option>
                        </select>
                    </div>
                </form>
            </div>

            <div class="col-6">
                <form class="form-group" action="/servicehotels">
                    <input type="text" name="command" value="logout" hidden="hidden">
                    <button type="submit" class="btn btn-danger" style="float: right;">${locale_btn_logout} </button>
                </form>
            </div>
        </div>
    </div>
</div>
<br/>
<br/>
<br/>
