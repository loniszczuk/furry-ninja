<html>
    <head>
        <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    </head>

    <body>
        <div>Login</div>


        <div>
            <span>Sign up</span>
            <label>username</label>: <input type="text" id="signup_username" name="username" >
            <label>email</label>: <input type="text" id="signup_email" name="email" >
            <label>password</label>: <input type="password" id="signup_pass" name="password" >
            <p id="signup_result"></p>
            <input type="button" id="signup_submit" value="signup">
        </div>

        <div>
            <span>Login</span>
            <label>email</label>: <input type="text" id="login_email" name="email" >
            <label>password</label>: <input type="password" id="login_pass" name="password" >
            <p id="login_result"></p>
            <input type="button" id="login_submit" value="login">
        </div>


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

            $("#signup_submit").click(function(){
                $.ajax({
                    url: "/users",
                    type: "POST",
                    dataType: "json",
                    contentType: "application/json; charset=UTF-8",
                    data: JSON.stringify({ username: $("#signup_username").val(), email:$("#signup_email").val(), password:$("#signup_pass").val() }),
                    success: function() {
                        $("#signup_result").html("OK");
                    },
                    error: function(){
                        $("#signup_result").html("ERROR");
                    }
                });

            });

            $("#login_submit").click(function(){
                $.ajax({
                    url: "/login",
                    type: "POST",
                    dataType: "json",
                    contentType: "application/json; charset=UTF-8",
                    data: JSON.stringify({ email:$("#login_email").val(), password:$("#login_pass").val() }),
                    success: function() {
                        $("#login_result").html("OK");
                    },
                    error: function(){
                        $("#login_result").html("ERROR");
                    }
                });

            });

        </script>
    </body>
</html>