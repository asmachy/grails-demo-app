<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/9/2020
  Time: 11:48 AM
--%>

<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Change Password</title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">User Prfoile</a></li>
                <li><g:link class="create" action="edit">Change Password</g:link></li>
            </ul>
        </div>
        <div id="edit-password" class="content scaffold-edit" role="main">
            <div class="row">

                <sec:ifLoggedIn>
                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">Change Password</h5>
                            <g:if test='${flash.message}'>
                                <div class="alert alert-danger" role="alert">${flash.message}</div>
                            </g:if>
                    <form class="form-signin" action="profile" method="PUT" id="changePasswordForm" autocomplete="off">
                        <div class="form-group">
                            <label for="currentpassword">Current Password</label>
                            <input type="password" placeholder="Enter your current password" class="form-control" name="currentpassword" id="currentpassword" autocapitalize="yes"/>
                        </div>

                        <div class="form-group">
                            <label for="newpassword">New Password</label>
                            <input type="password" placeholder="Enter new password" class="form-control" name="newpassword" id="newpassword" autocapitalize="yes"/>
                        </div>

                        <div class="form-group">
                            <label for="newrepassword">Confirm Password</label>
                            <input type="password" placeholder="Re-Enter new password" class="form-control" name="newrepassword" id="newrepassword" autocapitalize="none"/>
                        </div>
                        <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Change Password</button>
                        <hr class="my-4"/>
                    </form>
                        </div>
                    </div>
                    </div>
                </sec:ifLoggedIn>

        </div>
    </body>
</html>
