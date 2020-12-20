<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Music database</title>
    <link rel="stylesheet" href="/styles/styles.css">
</head>

<body>

<section class="header-section">

    <h1>Welcome to the artist list and album search</h1>
    <p>Below is a list of albums. You can search albums found in the database with a keyword. You can also remove artists from the database.</p>
    <section>
        <form action="/album-search" method="get">
            <label>Name of album: <input type="string" name="album" value=""><input type="submit" value="Submit"></label>
        </form>
    </section>
    <button onclick="location.href='/artist-new'">Go to add a new artist page</button>
    <ul>
    <c:forEach var="artist" items="${ allArtists }">
        <li id=artist-${artist.getId()}><c:out value="${ artist.getName() }"/> <button onclick="removeArtist(${artist.getId()},`${ artist.getName() }`)"> Remove artist</button></li>
    </c:forEach>
        <c:forEach var="album" items="${ allAlbums }">
            <li id=artist-${album.getId()}><c:out value="${ album.getArtistName() }"/>: <c:out value="${ album.getTitle() }"/> </li>
        </c:forEach>
    </ul>
</section>

<script src="app.js"></script>
</body>
</html>