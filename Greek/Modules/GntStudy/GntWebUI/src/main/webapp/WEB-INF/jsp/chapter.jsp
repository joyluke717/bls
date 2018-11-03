<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Book ${chapter.bookName} Chapter ${chapter.bookName}</caption>
			<thead>
				<tr>
					<th>Verse</th>
					<th>Text</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${chapter.verseList}" var="verse">
					<tr>
						<td>${verse.verseNumber}</td>
						<td>${verse.verseText}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@ include file="common/footer.jspf" %>