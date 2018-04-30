<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<s:url value="/resources/css" var="css" />
<s:url value="/resources/scss" var="scss" />
<s:url value="/resources/js" var="js" />
<s:url value="/resources/images" scope="application" var="images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"
	scope="application" />
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="${images}/icons/icon.PNG" />
<script src="${js}/jquery-3.2.1.min.js" type="text/javascript"></script>
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

<link rel="stylesheet" href="${css }/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="${css }/style.css">
<!-- Resource style -->
<script src="${js }/modernizr.js"></script>
<!-- Modernizr -->
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${css}/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${css}/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${css}/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${css}/util.css">
<link rel="stylesheet" type="text/css" href="${css}/main.css">
<!--===============================================================================================-->
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

<c:if test="${isSignup eq true or isLogin eq true}">
	<link href="${css}/signup-style.css" rel="stylesheet" />
	<!--Google Fonts-->
	<link
		href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
		rel="stylesheet">

</c:if>


</head>

<body>

	<header class="cd-main-header">
		<a class="navbar-brand topnav" style="padding: 0"
			href="${contextRoot}/"><img alt="" width="150vh"
			src="${images}/logo-1.PNG"></a>
		<!-- 
		<div class="cd-search is-hidden">
			<form action="#0">
				<input type="search" placeholder="Search...">
			</form>
		</div> -->


		<a href="#0" class="cd-nav-trigger">Menu<span></span></a>

		<c:import url="shared/navbar.jsp"></c:import>


		<main class="cd-main-content"> <c:import
			url="shared/sidebar.jsp"></c:import>

		<div class="content-wrapper">
			<div class="main-panel" style="margin-left: 45px; margin-top: 10px;">

				<c:choose>

					<c:when test="${clicksHomepage eq true }">
						<c:import url="dashboard-content.jsp"></c:import>
					</c:when>

					<c:when test="${clicksSearchCoin eq true }">

						<c:import url="search.jsp"></c:import>
					</c:when>
				</c:choose>

			</div>




		</div>
		<!-- .content-wrapper --> </main>
		<!-- .cd-main-content -->
</body>
<!--   Core JS Files   -->
<script src="${js}/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${js}/bootstrap.min.js" type="text/javascript"></script>

<script src="${js }/jquery.menu-aim.js"></script>
<script src="${js }/main.js"></script>
<!-- Resource jQuery -->

<script type="text/javascript" src="${js}/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${js}/bootbox.min.js"></script>
<script src="${js }/select2.min.js"></script>
<script src="${js}/perfect-scrollbar.min.js"></script>
<script>
	$('.js-pscroll').each(function() {
		var ps = new PerfectScrollbar(this);

		$(window).on('resize', function() {
			ps.update();
		})
	});
</script>
<!--===============================================================================================-->
<script src="${js}/main22.js"></script>


<script type="text/javascript" src="${js }/search.js"></script>
</html>
