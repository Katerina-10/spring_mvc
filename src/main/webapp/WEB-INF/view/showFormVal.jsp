<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h2>Employee, welcome</h2>

<br>
<br>


Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your salary: ${employee.department}
<br>
Your car: ${employee.carBrand}

<br>
language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">
    <li> ${lang} </li>
    </c:forEach>
</ul>

<br>
Your phoneNumber: ${employee.phoneNumber}

<br>
Your email: ${employee.email}

</body>
</html>