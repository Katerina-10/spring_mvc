<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Employee, enter your details</h2>

<br>
<br>

<form:form action ="showDetailsForm" modelAttribute="employee">
    Name <form:input path ="name"/>
    <br><br>
    Surname <form:input path ="surname"/>
    <br><br>
    Salsry <form:input path ="salary"/>
    <br><br>


    Department <form:select path="department">
<%--        <form:option value="Information Technology" label="IT"/>--%>
<%--        <form:option value="Human Resources" label="HR"/>--%>
<%--        <form:option value="Sales" label="Sales"/>--%>
        <form:options items="${employee.departments}"/>
    </form:select>
    <br><br>
    Why car?
<%--    BMW <form:radiobutton path="carBrand" value="BMW"/>--%>
<%--    Audi <form:radiobutton path="carBrand" value="Audi"/>--%>
<%--    MB <form:radiobutton path="carBrand" value="Mersedes-Benz"/>--%>
        <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>

    <br><br>
        Foreign language(s)
<%--        EN <form:checkbox path="languages" value="English"/>--%>
<%--        DE <form:checkbox path="languages" value="Deutch"/>--%>
<%--        FR <form:checkbox path="languages" value="French"/>--%>
        <form:checkboxes path="languages" items="${employee.languageMap}"/>


    <br><br>

    <input type="submit" value="ok"/>

</form:form>

</body>
</html>