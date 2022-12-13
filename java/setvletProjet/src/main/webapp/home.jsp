<%@ page import="java.util.List" %>
<%@ page import="com.edugroupe.servletprojet.models.Utilisateur" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fadeil
  Date: 07/12/2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Project</title>
</head>
<body>
<h3>Home page </h3>
<%
    List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    utilisateurs.add(new Utilisateur());
    utilisateurs.add(new Utilisateur());
    utilisateurs.add(new Utilisateur());
    utilisateurs.add(new Utilisateur());
%>
<%
utilisateurs.stream().map((utilisateur) -> {
    System.out.println("User: " + utilisateur);
    return utilisateur;
});
%>

</body>
</html>
