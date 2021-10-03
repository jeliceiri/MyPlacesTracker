<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Trip Info</h1>
<div class="">
    <form action="/tripInfo" class="" method="post">
        <table class="table">
            <thead>
            <!--
            <tr>
                <th scope="">Trip Name</th>
            </tr>
            -->
            </thead>
            <tbody>

                <tr>
                    <td>${tripInfo.getName()}</td>
                    <td>${tripInfo.getDestinationSet()}</td>


                </tr>

            </tbody>
        </table>
    </form>
</div>
<div>
    <a href="addTrip.jsp">Add Trip</a>
</div>
</body>
</html>
