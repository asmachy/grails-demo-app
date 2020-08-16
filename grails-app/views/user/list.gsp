<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/14/2020
  Time: 12:34 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>User List</title>
    </head>

    <body>
        <div id="content" role="main">
            <div class="col-sm-2 col-md-auto col-lg-auto mx-auto">
                <div class="card-body">
                    <div class="flex">
                        <h5 class="card-title text-center">User List</h5>
                        <g:form class="float-lg-right" style="padding-bottom: 5px" action="searchlist" method="post" id="searchform">
                             <g:textField name="search" id="search" class="search-field" placeholder="search" value="${params.search?:''}"/>
                            <button id="submit-values" class="btn btn-small btn-primary" type="submit" >
                                 <i class="icon-ok"></i>
                                Search
                            </button>
                        </g:form>
                    </div>

                    <table style="width:100%">
                        <tr>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Phone</th>
                        </tr>
                        <g:each in="${userList}" var="user" status="i">
                            <tr>
                                <td> ${user.fullname}</td>
                                <td> ${ user.age}</td>
                                <td> ${user.email}</td>
                                <td> ${user.phone}</td>
                            </tr>
                        </g:each>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

