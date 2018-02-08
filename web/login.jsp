<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login Page</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
    <%--<link href="css/signin.css" rel="stylesheet">--%>
</head>

<body class="text-center">
<form class="form-signin" action="/login" method="post">
    <img class="mb-4" src="https://semaine-production.s3.amazonaws.com/products/product/image/4875/medium_Shazam_Masterbrand_Logo.jpg" alt="" width="144" height="144">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="username" class="sr-only">Email address</label>
    <input type="text" id="username" class="form-control" placeholder="User Name" required="" autofocus="" name="username">
    <label for="Password" class="sr-only">Password</label>
    <input type="password" id="Password" class="form-control" placeholder="Password" required="" name="password">    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</form>
</body>
</html>