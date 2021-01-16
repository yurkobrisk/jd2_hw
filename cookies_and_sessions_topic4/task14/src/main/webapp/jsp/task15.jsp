
<h2><%
    String expense = "expenses :";
    if (expense != null && !expense.isEmpty()) {
            out.println("<li>" + expense + "</li>");
    }
%></h2>

<h4><%= request.getAttribute("expenses") %></h4>
