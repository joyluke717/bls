<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Word</th>
					<th>Meaning</th>
					<th>Frequency</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vocabularyList}" var="vocabulary">
					<tr>
						<td>${vocabulary.word}</td>
						<td>${vocabulary.briefMeaning}</td>
						<td>${vocabulary.frequency}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>