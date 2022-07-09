<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Login Page</h3>
        <form action="/login" method="post">
            <p>
                <input type="text" name="login">
            </p>
            <p>
                <input type="password" name="password">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
</@layout.header>