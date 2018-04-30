<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<s:url value="/resources/css" var="css" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" scope="application"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="apple-touch-icon" sizes="76x76" href="${images}/icon.PNG" />
<link rel="icon" type="image/png" href="${images}/icons/icon.PNG" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<title>CryptoCoin- ${title}</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Bootstrap core CSS     -->
<link href="${css}/bootstrap.min.css" rel="stylesheet" />

<link href="${css}/landing-page.css" rel="stylesheet" />

<!--     Fonts and icons     -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons"
	rel='stylesheet'>
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">



<style type="text/css">
html {
	
}

body {
	margin: 0;
	padding: 0;
	background: #e7ecf0;
}

* {
	margin: 0;
	padding: 0;
}

p {
	font-size: 12px;
	color: #373737;
	line-height: 18px;
}

p a {
	color: #218bdc;
	font-size: 12px;
	text-decoration: none;
}

a {
	outline: none;
}

.f-left {
	float: left;
}

.f-right {
	float: right;
}

.clear {
	clear: both;
	overflow: hidden;
}

#block_error {
	height: 550px;
	border: 1px solid #cccccc;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
	background: #fff url(http://www.ebpaidrev.com/systemerror/block.gif)
		no-repeat 0 51px;
}

#block_error div {
	padding: 100px 40px 0 186px;
}

@media screen and (max-width:500px) {
	#block_error div {
		padding: 100px 40px 0 10px;
	}
}

#block_error div h2 {
	color: #218bdc;
	font-size: 24px;
	display: block;
	padding: 0 0 14px 0;
	border-bottom: 1px solid #cccccc;
	margin-bottom: 12px;
	font-weight: normal;
}

@import url(http://fonts.googleapis.com/css?family=Open+Sans:700);
<
li
 
class
 
='
active
'
>
<
a
 
href
 
='${
pageContext
 
.request
.contextPath

	

}
/'><
span
>
Home


</
span
>
</
a
>
</
li
>
</style>

<title>${title}</title>
</head>
<body marginwidth="0" marginheight="0">
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
	<div class="container topnav" style="margin: 0; padding: 0;">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand topnav" style="padding: 0"
				href="${pageContext.request.contextPath}/"><img alt=""
				height="100%" width="150vh" style="margin-left: 6px"
				src="${images}/logo-1.PNG"></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAnonymous()">
					<li><a href="${ contextRoot}/login">Sign Up/ Login</a></li>

				</sec:authorize>
				<sec:authorize access="isAuthenticated()">

					<li><a href="${ contextRoot}/dashboard">DashBoard</a></li>
				</sec:authorize>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>
	<div id="block_error" class="">
		<div>
			<h2 id='error_heading'>Error 404. &nbspOops you've have
				encountered an error</h2>
			<p>
				It apperrs that Either something went wrong or the page doesn't
				exist anymore..<br /> This website is temporarily unable to service
				your request as it has exceeded it’s resource limit. Please check
				back shortly.
			</p>
			<p>If you are the owner of the account and are regularly seeing
				this error, please read more about it in our knowledgebase. If you
				have any questions, please contact our Technical Support department.
			</p>
		</div>
	</div>
</body>
</html>