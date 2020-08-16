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

    <div id="content" role="main">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card-body">
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
    </div>
</body>
</html>
