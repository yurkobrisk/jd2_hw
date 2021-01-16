<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${expenses}" var="result">
    <table cellspacing="5" border="1">
      <tr>
        <td><c:out value="${result}"/></td>
      </tr>
    </table>
</c:forEach>
