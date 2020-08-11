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
    <title>User Profile</title>
</head>
<body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}">User Prfoile</a></li>
            <li><g:link class="create" action="edit">Change Password</g:link></li>
        </ul>
    </div>
    <div id="content" role="main">
        <h5 class="card-title text-center">User Profile</h5>

        <section class="row colset-6-its">
            <sec:ifLoggedIn>
                <br>First Name :   <sec:loggedInUserInfo field='firstname'/></br>
                <br>Last Name  :   <sec:loggedInUserInfo field='lastname'/></br>
                <br>Address    :   <sec:loggedInUserInfo field='address'/></br>
                <br>Phone      :   <sec:loggedInUserInfo field='phone'/></br>
                <br>Email      :   <sec:loggedInUserInfo field='email'/></br>
                <br>Birthdate  :   <sec:loggedInUserInfo field='birthdate'/></br>

            </sec:ifLoggedIn>
        </section>
    </div>
</body>
</html>
