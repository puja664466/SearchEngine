<%@page import = "java.util.*"%>
<%@page import = "com.Accio.SearchResult"%>

<html>
<head>
    <link rel = "stylesheet" href = "style.css"/>
</head>
<body>
<h1>Search Engine</h1>
<form action = "Search">
    <input type = "text" name = "keyword"> </input>
    <button type = "submit">Search</button>
</form>
<form action = "History">
    <button type = "submit">History</button>
</form>
<table border = 2 class = "myTable">
    <tr>
        <th>Title</th>
        <th>Links</th>
    </tr>

        <%
        ArrayList<SearchResult> results = (ArrayList<SearchResult>)request.getAttribute("results");
        for(SearchResult result : results)
        {
    %>
    <tr>
        <td> <%out.println(result.getTitle());%> </td>
        <td><a href = "<%out.println(result.getLink());%>"><%out.println(result.getLink());%> </a> </td>
    </tr>
        <% } %>
</body>
</html>