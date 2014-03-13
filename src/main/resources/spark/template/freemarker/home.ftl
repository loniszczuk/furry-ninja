<html>
    <head>
        <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    </head>

    <body>
        <div>Login</div>

        <div>Sign up</div>

        <div>Usuarios</div>
        <ul id="users"></ul>



        <script>
        $.ajax({
            url: "/users",
            dataType: "json",
            success: function(users, status, jqXHR) {
                $(users).each(function(index, elem) {
                    var li = $("<li></li>");
                    li.html(elem.username);
                    $("#users").append(li);
                });
            }
        });

        </script>
    </body>
</html>