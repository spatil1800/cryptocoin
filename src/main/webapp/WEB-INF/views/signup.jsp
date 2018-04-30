<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="wthree-dot" style="background: rgba(0, 0, 0, 0.56);margin-top: 50px;">

	<div class="profile">
		<div class="wrap">
			<div class="wthree-grids">

				<div class="content-main">
					<div class="w3ls-subscribe">
						<h4>Login to Crypto Coin</h4>
						<form action="login" method="post">
							<c:if test="${not empty error}">
								<div class="login-error">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="msg">${msg}</div>
							</c:if>
							<input type="email" name="username1" placeholder="Email"
								autocomplete="off" required /> <input type="password"
								name="password1" autocomplete="off" placeholder="Password"
								required><br> <input id="remember_me"
								name="remember-me" type="checkbox" /> <label for="remember_me"
								class="inline agile-signin"><h4>Remember me</h4></label> <input
								type="submit" value="Login" /> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}">

						</form>
						<br>
						<div class="agile-signin">
							<h4>
								Don't have an account? <a href="#signup"> Sign Up</a>
							</h4>
						</div>
						<br>
					</div>
				</div>
				<div class="content-main">
					<div class="w3ls-subscribe">
						<h4>New Customer?</h4>
						<sf:form action="signup" modelAttribute="users" method="post"
							id="signup">
							<sf:errors path="firstName" cssClass="signup-errors" />
							<sf:errors path="lastName" cssClass="signup-errors" />
							<sf:errors path="email" cssClass="signup-errors" />
							<sf:errors path="password" cssClass="signup-errors" />
							<sf:input type="text" path="firstName" placeholder="First Name" />

							<sf:input type="text" path="lastName" placeholder="Last Name" />

							<sf:input type="email" path="email" placeholder="Email" />

							<sf:input type="password" path="password" autocomplete="off"
								placeholder="Password" />

							<input type="password" name="cnfpassword"
								placeholder="Confirm Password">
							<input type="submit" value="Sign Up" />
						</sf:form>
					</div>
				</div>
				<div class="clear"></div>
			</div>

		</div>
	</div>
</div>
