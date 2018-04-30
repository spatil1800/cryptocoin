<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%--  <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav" style="margin: 0;padding: 0;">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" style="padding: 0" href="${contextRoot}/"><img alt="" height="100%" width="150vh" style="margin-left: 6px" src="${images}/logo-1.PNG"></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${contextRoot}/about">About</a>
                    </li>
                    <li>
                        <a href="${contextRoot}/dashboard">Search Coin</a>
                    </li>
                    <li>
                        <a href="${contextRoot}/signup">Sign Up/ Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav> --%>
    
    
    <nav class="cd-nav">
			<ul class="cd-top-nav">
				<li><a href="${contextRoot}/about">About Us</a></li>
				<sec:authorize access="isAnonymous()">
				<li><a href="${contextRoot}/login">Sign Up/Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				<li><a href="${contextRoot}/dashboard">DashBoard</a></li>
				<li class="has-children account">
					<a href="#0">
						<img src="${images}/cd-avatar.png" alt="avatar">
						Account
					</a>

					<ul>

						<li><a href="${contextRoot}/myprofile">My Account</a></li>
						<li><a href="${contextRoot}/logout">Logout</a></li>
					</ul>
				</li>
				</sec:authorize>
			</ul>
		</nav>
	</header> <!-- .cd-main-header -->