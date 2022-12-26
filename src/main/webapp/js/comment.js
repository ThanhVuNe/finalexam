$(document).ready(function() {
	$(document).on('click', 'a[data-role=edit]', function() {
		var id = $(this).data("id");
		var content = $('p[data-target=content'+id+']').text();
		console.log(id)
		console.log(content)
		$('#content').val(content);
		$('#ModalEdit').modal('toggle');
	});

	$('#save').click(function() {
		var id = $('a[data-role=edit]').data("id");
		var content = $('#content').val();
		console.log(id + content);
		$.ajax({
			url: 'EditCommentServlet',
			method: 'post',
			data: {
				id: id,
				content: content
			},
			success: function(res) {
				$('p[data-target=content'+id+']').text(content);
				$('#ModalEdit').modal('toggle');
			}
		})
	})

	
});
