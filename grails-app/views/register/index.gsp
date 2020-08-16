<html>
<head>
	<meta name="layout" content="${gspLayout ?: 'main'}"/>
	<title>Register</title>
</head>

<body>
	<div class="row">
    <div class="col-sm-9 col-md-7 col-lg-6 mx-auto">
      <div class="card card-signin my-5">
        <div class="card-body">
          <h5 class="card-title text-center">Register Here</h5>
					<g:if test='${flash.message}'>
						<div class="alert alert-danger" role="alert">${flash.message}</div>
					</g:if>
		      <form class="form-signin" action="register" method="POST" id="loginForm" autocomplete="off">
					  <div class="form-group">
					  	<label for="role">Role</label>
                          <g:select class="form-control" name="role.id"
		                        from="${demoapp.Role.list()}"
		                        optionKey="id" id="role.id" />
                      </div>
                <div class="form-group">
                      <label for="firstname">First Name</label>
                      <input type="text" placeholder="Your first name" class="form-control" name="firstname" id="firstname" autocapitalize="yes"/>
                </div>

                <div class="form-group">
                      <label for="lastname">Last Name</label>
                      <input type="text" placeholder="Your last name" class="form-control" name="lastname" id="lastname" autocapitalize="yes"/>
                </div>

                <div class="form-group">
                      <label for="address">Address</label>
                      <input type="text" placeholder="Your address" class="form-control" name="address" id="address" autocapitalize="none"/>
                </div>

                <div class="form-group">
                      <label for="phone">Phone</label>
                      <input type="text" placeholder="Your phone number" class="form-control" name="phone" id="phone" autocapitalize="none"/>
                </div>

                <div class="form-group">
                      <label for="username">Email</label>
                      <input type="email" placeholder="Your email" class="form-control" name="username" id="username" autocapitalize="none"/>
                </div>

                <div class="form-group">
                      <h2>Birthdate</h2>
                    <label for="daybirthdate">Day</label><input type="number" placeholder="Day" class="form-control" name="daybirthdate" id="daybirthdate" autocapitalize="none"/>
                    <label for="monthbirthdate">Month</label>  <input type="number" placeholder="Month" class="form-control" name="monthbirthdate" id="monthbirthdate" autocapitalize="none"/>
                    <label for="yearbirthdate">Year</label> <input type="number" placeholder="Year" class="form-control" name="yearbirthdate" id="yearbirthdate" autocapitalize="none"/>

                </div>

                <div class="form-group">
					  	<label for="password">Password</label>
                        <input type="password" placeholder="Your password" class="form-control" name="password" id="password"/>
                </div>

                <div class="form-group">
					  	<label for="password">Re-Enter Password</label>
                        <input type="password" placeholder="Re-enter password" class="form-control" name="repassword" id="repassword"/>
                </div>


            <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
            <hr class="my-4">
            <p>Already have an account? <g:link controller="login" action="auth">Login</g:link></p>
          </form>
        </div>
      </div>
    </div>
  </div>
	<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function(event) {
			document.forms['loginForm'].elements['role.id'].focus();
		});
	</script>
</body>
</html>
