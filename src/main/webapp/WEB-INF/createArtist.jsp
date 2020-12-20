<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Music database</title>
	<link rel="stylesheet" href="/styles/styles.css">
</head>

<body>

<section class="header-section">

	<h1>Add artist and their album</h1>
	<section class="form">
		<form action="/artist-new" method="post">
			<label>Name of artist: <input type="string" name="artist" value=""></label>
			<input type="submit" value="Submit" />
		</form>
	</section>

	<c:if test = "${fn:length(addedArtist) > 1}">
	<p id="addedArtist">Added artist:  <c:out value = "${addedArtist}"/><p>
	</c:if>

	<button onclick="location.href='/'">See all artists</button>
</section>
<script src="app.js"></script>
</body>
</html>