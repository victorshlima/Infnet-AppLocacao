<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>AppLocacao</title>
</head>
<body>



<div class="container mt-3">
    <nav th:fragment="menu/menu.jsp :: navbar"> </nav>

    <h2>Login</h2>
<form action="/login" method="post">
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" id="email" placeholder="Entre com seu e-mail" name="email">
    </div>
    <div class="mb-3">
        <label for="senha" class="form-label">Password:</label>
        <input type="password" class="form-control" id="senha" placeholder="Entre com sua senha" name="senha">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

</body>
</html>