<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sorting Application</title>
</head>
<body>
<h1>Sorting Application</h1>
<form action="sort" method="post">
    <label for="algorithm">Select Sorting Algorithm:</label>
    <select id="algorithm" name="algorithm">
        <option value="heap">Heap Sort</option>
        <option value="quick">Quick Sort</option>
        <option value="merge">Merge Sort</option>
        <option value="radix">Radix Sort</option>
        <option value="bucket">Bucket Sort</option>
    </select>
    <br>
    <label for="data">Enter Data (comma separated):</label>
    <input type="text" id="data" name="data">
    <br>
    <button type="submit">Sort</button>
</form>
<c:if test="${not empty result}">
    <h2>Sorted Data:</h2>
    <p>${result}</p>
</c:if>
</body>
</html>
